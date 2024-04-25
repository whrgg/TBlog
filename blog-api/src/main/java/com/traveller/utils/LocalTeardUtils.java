package com.traveller.utils;

/**
 * 存放用户id
 * @author traveller
 * @date 2024/04/23
 */
public class LocalTeardUtils {
    private static ThreadLocal<Long> threadLocal=new ThreadLocal<Long>();

    public static Long getLocalTeard(){
        return threadLocal.get();
    }

    public static void setThreadLocal(Long id){
        threadLocal.set(id);
    }
}
