package com.common.dao.biz;

import com.common.model.biz.UserReq;
import com.common.model.auto.User;

/**
 * 根据业务需求自定义的sql语句
 */
public interface UserBizMapper {

    /**
     * 根据主键id查找User对象
     * @param id
     * @return User
     */
    User selectByPrimaryKey(Integer id);

    /**
     * insert User对象，1插入成功，非1发生异常（0插入失败）
     * @param user
     * @return 0 or 1
     */
    int insert(UserReq user);
}