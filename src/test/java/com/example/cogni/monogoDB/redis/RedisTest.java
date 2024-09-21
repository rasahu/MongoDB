package com.example.cogni.monogoDB.redis;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() {

        //redisTemplate.opsForValue().set("name1","rakesh");
        System.out.println(redisTemplate.opsForValue().get("name1"));
    }
}
