package com.traveller.aspect;

import com.alibaba.fastjson.JSONObject;
import com.traveller.annotation.OperateLog;
import com.traveller.constant.JwtClaimsConstant;
import com.traveller.constant.UserConstant;
import com.traveller.entity.OperationLog;
import com.traveller.entity.User;
import com.traveller.properties.JwtProperties;
import com.traveller.service.OperationLogService;
import com.traveller.utils.AopUtils;
import com.traveller.utils.IpAddressUtils;
import com.traveller.utils.JwtUtils;
import com.traveller.utils.LocalTeardUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Aspect
@Slf4j
@Component
public class OperateAspect {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    OperationLogService operationLogService;
    @Autowired
    JwtProperties jwtProperties;

    ThreadLocal<Long> currentTime = new ThreadLocal<>();

    /**
     * 配置切入点
     */
    //细腻度的控制
    @Pointcut("execution(* com.traveller..controller..*.*(..))&&@annotation(operationLogger)")
    public void logPointcut(OperateLog operationLogger) {
    }

    /**
     * 配置环绕通知
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("logPointcut(operationLogger)")
    public Object logAround(ProceedingJoinPoint joinPoint, OperateLog operationLogger) throws Throwable {
        currentTime.set(System.currentTimeMillis());
        Object result = joinPoint.proceed();
        int times = (int) (System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        OperationLog operationLog = handleLog(joinPoint, operationLogger, times);
        operationLogService.saveOperationLog(operationLog);
        return result;
    }

    /**
     * 获取HttpServletRequest请求对象，并设置OperationLog对象属性
     *
     * @param operationLogger
     * @param times
     * @return
     */
    private OperationLog handleLog(ProceedingJoinPoint joinPoint, OperateLog operationLogger, int times) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String uri = request.getRequestURI();
        String method = request.getMethod();
        String description = operationLogger.value();
        String ip = IpAddressUtils.getIpAddress(request);
        String userAgent = request.getHeader("User-Agent");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        OperationLog log = new OperationLog(user.getUsername(), uri, method, description, ip, times, userAgent);
        Map<String, Object> requestParams = AopUtils.getRequestParams(joinPoint);
        log.setParam(StringUtils.substring(JSONObject.toJSONString(requestParams), 0, 2000));
        return log;
    }


}
