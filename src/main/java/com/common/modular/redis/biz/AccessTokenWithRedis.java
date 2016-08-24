package com.common.modular.redis.biz;

import com.common.component.resp.RspCodeMsg;
import com.common.modular.redis.base.RedisFactory;
import com.exception.base.RspRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;


/**
 * Created by zhang.peng on 2016/8/19.
 * 微信token存入redis，7200过期，保险起见设为7000过期
 */
@Component
public class AccessTokenWithRedis {
    @Autowired
    RedisFactory redisFactory;

    /**
     * 将微信的accesstoken存入redis
     * @param accessToken
     * @return
     */
    public void saveAccessToken(String accessToken){
        Jedis redis = redisFactory.getJedis();
        String str = redis.setex("accessToken", 7000, accessToken);
        if(null == str || "".equals(str)){
            throw new RspRuntimeException(RspCodeMsg.FAIL,"验证码存入redis失败！");
        }
    }

    /**
     * 判断是否存在，过期就消失了
     * @return
     */
    public String judgeExist(){
        Jedis redis = redisFactory.getJedis();
        return redis.get("accessToken");
    }
}
