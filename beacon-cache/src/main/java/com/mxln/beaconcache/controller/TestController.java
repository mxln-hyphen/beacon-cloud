package com.mxln.beaconcache.controller;

import com.msb.framework.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zjw
 * @description
 */
@RestController
public class TestController {

    @Autowired
    private RedisClient redisClient;

    // 写测试   hash结构
    @PostMapping("/test/set/{key}")
    public String set(@PathVariable String key, @RequestBody Map map){
        redisClient.putMap(key,map);
        return "ok";
    }
    // 读测试
    @GetMapping("/test/get/{key}")
    public Map get(@PathVariable String key){
        Map<String, Object> result = redisClient.getMap(key);
        return result;
    }
}