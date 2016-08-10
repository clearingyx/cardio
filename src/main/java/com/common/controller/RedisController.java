package com.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhang.peng on 2016/8/10.
 */
@Controller
public class RedisController {
    @Autowired
    RedisImpl redisImpl;

    @ResponseBody
    @RequestMapping("redisTest")
    public Object redisTest(){
        return redisImpl.sadd();
    }
}
