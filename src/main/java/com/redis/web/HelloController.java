package com.redis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: shangqj
 * @date: 2024/7/2
 * @version: 1.0
 */
@RestController
public class HelloController {


    @Autowired
    StringRedisTemplate redisTemplate;


    @GetMapping("/get/{key}")
    public String hi(@PathVariable String key){
        return redisTemplate.opsForValue().get(key);
    }

    @GetMapping("/set/{key}/{value}")
    public String hi(@PathVariable String key,@PathVariable String value){
        redisTemplate.opsForValue().set(key,value);
        return "success";
    }
}
