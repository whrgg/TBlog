package com.traveller.controller;

import com.traveller.constant.JwtClaimsConstant;
import com.traveller.constant.UserConstant;
import com.traveller.entity.User;
import com.traveller.exception.userException;
import com.traveller.properties.JwtProperties;
import com.traveller.service.UserService;
import com.traveller.utils.JwtUtils;
import com.traveller.utils.LocalTeardUtils;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Api(tags = "有关登陆的接口")
@Slf4j
@RestController
@RequestMapping("/admin")
public class LoginContorller {
    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    JwtProperties jwtProperties;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<String> login(@RequestBody User user){
        user=userService.selectUserByUsername(user.getUsername());
        if(Objects.isNull(user)){
            throw new userException(UserConstant.USER_NOT_FOUND);
        }
        Map claims=new HashMap();

        claims.put(UserConstant.USER,user.getId());


        String jwt = JwtUtils.CreateJWT(jwtProperties.getSecretKey(), jwtProperties.getTtl(), claims);
        redisTemplate.opsForValue().set(JwtClaimsConstant.EMP_ID +":"+ user.getId(),user, 72000000,TimeUnit.MILLISECONDS);
        //发放token
        return Result.success(jwt);
    }

    @ApiOperation("登出")
    @PostMapping("/logout")
    public Result<String> logout(){
        Long userId= LocalTeardUtils.getLocalTeard();
        redisTemplate.delete(JwtClaimsConstant.EMP_ID+":"+userId);
        return Result.success();
    }
}
