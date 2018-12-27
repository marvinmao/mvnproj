package com.llnqdx.mvnproj.redis;

import com.llnqdx.mvnproj.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Auther: marvinmao
 * @Date: 2018-12-27
 */
public class RedisTestController {

    @Autowired
    RedisUtils redisUtils;

    /**
     * @param key, value
     * @return Object
     * @Description: 测试redis
     * @Author: zyj 2018/5/26 8:46
     */
    @RequestMapping("/testRedisAdd")
    @ResponseBody
    Object testRedisAdd(String key, String value) {
        redisUtils.set(key, value);
        return redisUtils.get(key);
    }
}
