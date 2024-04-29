package com.traveller.controller;

import com.traveller.annotation.OperateLog;
import com.traveller.constant.JwtClaimsConstant;
import com.traveller.constant.UserConstant;
import com.traveller.entity.Tomail;
import com.traveller.entity.User;
import com.traveller.entity.vo.UserVo;
import com.traveller.exception.userException;
import com.traveller.properties.JwtProperties;
import com.traveller.service.UserService;
import com.traveller.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Api(tags = "有关登陆的接口")
@Slf4j
@RestController
@RequestMapping("/user")
public class LoginContorller {
    @Autowired
    MailUtils mailUtils;
    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    JwtProperties jwtProperties;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<String> login(@RequestBody UserVo userVo){
        User user=userService.selectUserByUsername(userVo.getUsername());
        Integer code =(Integer) redisTemplate.opsForValue().get(user.getUsername());
        if(!code.equals(userVo.getCode()) ){
            return Result.error("验证码错误");
        }
        Map claims=new HashMap();
        claims.put(UserConstant.USER,user.getId());
        String jwt = JwtUtils.CreateJWT( jwtProperties.getSecretKey(),jwtProperties.getTtl(), claims);
        redisTemplate.opsForValue().set(JwtClaimsConstant.EMP_ID +":"+ user.getId(),user, 72000000,TimeUnit.MILLISECONDS);
        //发放token
        log.info("{}",jwt);
        return Result.success(jwt);
    }

    @ApiOperation("登出")
    @PostMapping("/logout")
    public Result<String> logout(){
        Long userId= LocalTeardUtils.getLocalTeard();
        redisTemplate.delete(JwtClaimsConstant.EMP_ID+":"+userId);
        return Result.success();
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public Result<String> register(@RequestBody UserVo userVo){
        //判断用户名是否存在
        log.info("{}",userVo);
        User user=userService.selectUserByUsernameR(userVo.getUsername());
        if(!Objects.isNull(user)){
            return Result.error("账号已经存在");
        }
        String email=userVo.getEmail();
        String qq=email.substring(0,email.indexOf("@"));
        String avatar="https://q.qlogo.cn/g?b=qq&nk="+qq+"&s=640";
        String role="user";
        userVo.setAvatar(avatar);
        userVo.setRole(role);
        userVo.setCreateTime(new Date(System.currentTimeMillis()));
        userVo.setUpdateTime(new Date(System.currentTimeMillis()));
        userService.save(userVo);

        return Result.success();
    }

    @ApiOperation("获取验证码")
    @PostMapping("/getcode")
    public Result<Integer> getCode(@RequestBody User user){
        log.info("发送验证码");
        user=userService.selectUserByUsername(user.getUsername());
        log.info("{}",user.getEmail());
        Integer simpleCode = codeUtils.getSimpleCode();
        mailUtils.sendregisterMessage(new Tomail(new String[]{user.getEmail()},"欢迎你来小站游玩","希望能到你的喜欢"), simpleCode);
        redisTemplate.opsForValue().set(user.getUsername(),simpleCode,5,TimeUnit.MINUTES);
        return Result.success(simpleCode);
    }
}
