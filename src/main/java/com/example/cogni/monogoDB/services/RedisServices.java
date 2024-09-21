package com.example.cogni.monogoDB.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class RedisServices {

    @Autowired
    RedisTemplate redisTemplate;

    public <T> T get(@NotNull String key, Class<T> entityClass) {
        try {
            Object object = redisTemplate.opsForValue().get(key);
            if (object == null) return null;
            else {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(object.toString(), entityClass);
            }
        } catch (JsonProcessingException jsonProcessingException) {
            log.error("Exception while parsing values from Redis " + jsonProcessingException.getMessage());
            return null;
        }
    }

    public void set(@NotNull String key, Object obj, Long timeToLive) {
        try {
            redisTemplate.opsForValue().set(key, obj.toString(), timeToLive);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void delete(@NotNull String key) {
        try {
            redisTemplate.opsForValue().getAndDelete(key);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
