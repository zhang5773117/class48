package com.zb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    //一个工具类
    @Bean
    public RedisTemplate<String, Object> create(RedisConnectionFactory f) {
        RedisTemplate rt = new RedisTemplate();
        rt.setConnectionFactory(f);
        rt.setKeySerializer(new StringRedisSerializer());
        rt.setValueSerializer(new StringRedisSerializer());
        return rt;
    }
}
