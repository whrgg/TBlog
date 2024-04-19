package com.traveller.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author traveller
 * @date 2024/04/17
 * 后端统一返回形式
 */
@Data
public class Result<T> implements Serializable {
    public Integer code;
    public String msg;
    public T data;

    public static <T> Result<T> sucessful(){
        Result<T> result = new Result<T>();
        result.code=200;
        return result;
    }

    public static <T> Result<T> sucessful(T data){
        Result<T> result = new Result<T>();
        result.data=data;
        result.code=200;
        return result;
    }
    public static <T> Result<T> sucessful(String msg){
        Result <T>result = new Result<T>();
        result.msg=msg;
        result.code=200;
        return result;
    }


}
