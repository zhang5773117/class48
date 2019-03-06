package com.zb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void set(String key, Object val) {
        ValueOperations vo = redisTemplate.opsForValue();
        vo.set(key, val);
    }

    public Object get(String key) {
        ValueOperations vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    public boolean validate(String key) {
        ValueOperations vo = redisTemplate.opsForValue();
        return vo.get(key) != null ? true : false;
    }


}
