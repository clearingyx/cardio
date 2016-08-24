package com.common.modular.redis.biz;

import com.common.component.resp.RspCodeMsg;
import com.common.modular.redis.base.RedisFactory;
import com.common.modular.wechat.entity.Course;
import com.exception.base.RspRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhang.peng on 2016/8/19.
 */
@Component
public class CourseUrlWithRedis {
    @Autowired
    RedisFactory redisFactory;

    private static String COURSEID = "courseId";
    private static String RISKLEVEL = "riskLevel";
    private static String UNIQUECODE = "uniqueCode";


    /**
     * 保存对方发送的课程相关参数
     * @param course
     * @return
     */
    public void saveCourseByOpenid(Course course){
        Jedis redis = redisFactory.getJedis();

        Map<String, String> map = new HashMap();
        map.put(COURSEID, course.getCourseId());
        map.put(RISKLEVEL, course.getRiskLevel().toString());
        map.put(UNIQUECODE, course.getUniqueCode());

        String str = redis.hmset(course.getOpenId(), map);
        if(null == str || "".equals(str)){
            throw new RspRuntimeException(RspCodeMsg.FAIL,"看课URL参数存入缓存失败！");
        }
    }

    /**
     * 取出上面保存的数据
     * @param openid
     * @return
     */
    public Course takeOutCourseByOpenid(String openid){
        Jedis redis = redisFactory.getJedis();

        Integer riskLevel = Integer.valueOf(redis.hget(openid, RISKLEVEL));
        String courseId = redis.hget(openid, COURSEID);
        String uniqueCode = redis.hget(openid, UNIQUECODE);

        return new Course(uniqueCode, openid, riskLevel ,courseId);
    }
}
