package com.traveller.utils;

public class LocalTeardUtils {
    private static ThreadLocal<Long> threadLocal=new ThreadLocal<Long>();

    public static Long getLocalTeard(){
        return threadLocal.get();
    }

    public static void setThreadLocal(Long id){
        threadLocal.set(id);
    }
}
