package com.traveller.utils;


import io.jsonwebtoken.*;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * Jwt工具类用来生成以及解析Token
 *
 * @author traveller
 * @date 2024/04/15
 */
public class JwtUtils {

    /**
     * @param secrety   密匙
     * @param ttlMillis 超时时间
     * @param claims    信息
     * @return Jwt字符串
     */
    public static String CreateJWT(String secrety, long ttlMillis, Map<String, Object> claims) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long expttlMillis = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expttlMillis);

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .signWith(signatureAlgorithm, secrety.getBytes(StandardCharsets.UTF_8))
                .setExpiration(exp);

        return builder.compact();
    }

    /**
     * @param secrekey 解析密匙
     * @param token    token值
     * @return 解析出来的token中携带的信息
     */
    public static Claims ParseJWT(String secrekey, String token) {

        Claims claims;

        //注意过期的时候抛出异常
        try {
            claims  =  Jwts.parser()
                    .setSigningKey(secrekey.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e){
             claims=null;
        }


        return claims;
    }
}
