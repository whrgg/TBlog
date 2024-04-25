package com.traveller.handler;

import com.traveller.utils.Result;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.UserException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author traveller
 * @date 2024/04/21
 * 仅仅只能处理mvc层中抛出的错误
 * 类似于JWTFilter这种Servlet层中抛出的错误是捕获不到的
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public Result<String> UserException(UserException ex){
        log.error(ex.getMessage());
        return Result.error(ex.getMessage());
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    public Result<String> UserException(UsernameNotFoundException ex){

        log.error(ex.getMessage());
        return Result.error(ex.getMessage());
    }


//    @ExceptionHandler(Exception.class)
//    public Result<String> ExceptionHandler(Exception ex){
//
//        log.error(ex.getMessage());
//        return Result.error(ex.getMessage());
//
//    }

}
