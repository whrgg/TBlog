package com.traveller.annotation;

import com.traveller.enums.AutoFillType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自动填充创建时间字段
 * @author traveller
 * @date 2024/04/22
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    AutoFillType value();
}
