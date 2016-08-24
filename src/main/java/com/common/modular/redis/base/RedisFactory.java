package com.common.modular.redis.base;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/8/10.
 */
@Component
public class RedisFactory {
    private Jedis jedis;

    @Resource(name = "JedisConnectionFactory")
    private JedisConnectionFactory jedisConnectionFactory;

    /*
    //为了安全，单例实现
    */
    public Jedis getJedis(){
        if(jedis == null){
            return jedisConnectionFactory.getShardInfo().createResource();
        }
        return jedis;
    }

    /*
    //各种方法，jedis里面已经包含了redis的各种命令，不用强记，知道是什么作用，能看懂
    */
    public Object sadd(){
        return this.getJedis().sadd("set", "z");
    }
}