package com.traveller.Filter;

import com.alibaba.fastjson.JSON;
import com.traveller.constant.JwtClaimsConstant;
import com.traveller.constant.UserConstant;
import com.traveller.entity.User;
import com.traveller.exception.userException;
import com.traveller.properties.JwtProperties;
import com.traveller.utils.JwtUtils;
import com.traveller.utils.LocalTeardUtils;
import com.traveller.utils.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;


/**
 * 配置security过滤链最前端的过滤器
 * @author traveller
 * @date 2024/04/15
 */
@Slf4j
@Component //交给spring容器管理注入内容
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtProperties jwtProperties;

    @Autowired
    RedisTemplate redisTemplate;


    /**
     * 对前端请求中的token处理
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader(jwtProperties.getTokenName());
        // 如果值为空
        if(!StringUtils.isNotEmpty(token)){
            filterChain.doFilter(request,response);
            return;
        }
        Claims claims=null;
        try {
             claims = JwtUtils.ParseJWT(jwtProperties.getSecretKey(),token);
        }catch (Exception  e){
            log.error("身份验证过期"+e.getMessage());
            returnJson(response, JSON.toJSONString(Result.error("登录信息已失效,请重新登录")));
            return ;
        }

        Long userId= (Long) claims.get(UserConstant.USER);

        LocalTeardUtils.setThreadLocal(userId);

        User user = (User) redisTemplate.opsForValue().get(JwtClaimsConstant.EMP_ID+":"+ userId);


        //判读查询是否存在
        if(Objects.isNull(user)) {
            throw new userException(UserConstant.USER_NOT_FOUND);
        }
        //如果有信息则存入后续中
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        filterChain.doFilter(request,response);
    }

    //用来在过滤器中的返回
    private void returnJson(ServletResponse response, String json) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
            log.error("返回值写入错误", e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
