package com.common.modular.redis.biz;

import com.common.component.resp.RspCodeMsg;
import com.common.modular.redis.base.RedisFactory;
import com.exception.base.RspRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * Created by zhang.peng on 2016/8/10.
 * 将验证码存入redis中，5分钟过期
 */
@Component
public class MobilesWithRedis {
    @Autowired
    RedisFactory redisFactory;

    /**
     * 将验证码存入redis，5分钟失效
     * @param code
     * @return
     */
    public void saveMobiles(String mobiles, String code){
        Jedis redis = redisFactory.getJedis();
        String str = redis.setex(mobiles, 300, code);
        if(null == str || "".equals(str)){
            throw new RspRuntimeException(RspCodeMsg.FAIL,"验证码存入redis失败！");
        }
    }

    /**
     * 判断是否存在，过期就消失了
     * @return
     */
    public String judgeExist(String mobiles){
        Jedis redis = redisFactory.getJedis();
        return redis.get(mobiles);
    }

}
