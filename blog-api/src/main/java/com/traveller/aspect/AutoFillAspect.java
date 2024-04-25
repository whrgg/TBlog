package com.traveller.aspect;


import com.traveller.annotation.AutoFill;
import com.traveller.constant.AutoFillConstant;
import com.traveller.enums.AutoFillType;
import com.traveller.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Date;

@Aspect
@Slf4j
@Component
public class AutoFillAspect {

   //配置切入点
   //细腻度的控制
   @Pointcut("execution(* com.traveller..mapper.*.*(..)) && @annotation(com.traveller.annotation.AutoFill)")
   public void autoFiLLPointCut(){};


    @Before("autoFiLLPointCut()")
    public void setTime(JoinPoint join){
        MethodSignature signature = (MethodSignature) join.getSignature();
        AutoFill annotation = signature.getMethod().getAnnotation(AutoFill.class);
        AutoFillType operationvalue = annotation.value();
        Object[] args = join.getArgs();

        if(args==null||args.length==0){
            return;
        }
        Object entity = args[0];
        LocalDateTime now =LocalDateTime.now();
        Date date=new Date(System.currentTimeMillis());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(operationvalue== AutoFillType.UPDATE){
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME,Date.class);
                setUpdateTime.invoke(entity,date);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            try {
                log.info("开始填充字段");
                Method setCreateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, Date.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, Date.class);
                setCreateTime.invoke(entity,date);
                setUpdateTime.invoke(entity,date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
