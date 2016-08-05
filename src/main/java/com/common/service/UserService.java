package com.common.service;

import com.common.dao.biz.UserBizMapper;
import com.common.model.biz.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务层，以insert、update、save、delete开头的方法进行事务控制
 * ps：service整合的方法一般是component内的方法
 */
@Service
public class UserService {
    @Autowired
    private UserBizMapper userBizMapper;

    /**
     * 测试事务是否生效
     * @param user
     * @return
     */
    public int insertUser(UserReq user){
        /*int temp =userBizMapper.insert(user);
        System.out.println(temp);
        return temp/0;*/
        return userBizMapper.insert(user);
    }
}
