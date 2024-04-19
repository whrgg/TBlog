package com.traveller.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;


/**
 * Redis的序列化配置
 * @author traveller
 * @date 2024/04/15
 */
@Slf4j
@Configuration
public class RedisConfig  {


    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        log.info("Starting redisTemplate");
        RedisTemplate redisTemplate =new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);

        GenericJackson2JsonRedisSerializer jsonRedisSerializer =new GenericJackson2JsonRedisSerializer();

        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());


        redisTemplate.setValueSerializer(jsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);


        return redisTemplate;
    }
}
