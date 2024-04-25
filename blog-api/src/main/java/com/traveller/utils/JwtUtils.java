package com.traveller.utils;


import com.traveller.annotation.AutoFill;
import com.traveller.properties.JwtProperties;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * Jwt工具类用来生成以及解析Token
 * @author traveller
 * @date 2024/04/15
 */
@Component
public class JwtUtils {


    /**
     * @param ttlMillis 超时时间
     * @param claims    信息
     * @return Jwt字符串
     */
    public static String CreateJWT(String secretKey, long ttlMillis, Map<String, Object> claims) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long expttlMillis = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expttlMillis);

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .signWith(signatureAlgorithm, secretKey.getBytes(StandardCharsets.UTF_8))
                .setExpiration(exp);

        return builder.compact();
    }

    /**
     * @param token token值
     * @return 解析出来的token中携带的信息
     */
    //出问题全往上抛
    public static Claims ParseJWT(String secretKey, String token) {

        Claims claims;

        //注意过期的时候抛出异常
        claims = Jwts.parser()
                .setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token).getBody();

        return claims;
    }
}
