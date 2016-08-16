package com.common.dao.biz;

import com.common.model.auto.PersonEntity;

public interface PersonBizDao {
    /**
     * 根据openid和use_status
     */
    PersonEntity selectPersonByOpenid(String openid);

    /**
     * 根据openid增加用户电话
     * @param personEntity
     * @return
     */
    int updatePersonByOpenid(PersonEntity personEntity);

    /**
     * 根据openid修改用户状态
     * @param personEntity
     * @return
     */
    int updatePersonStatusByOpenid(PersonEntity personEntity);

    /**
     * 根据openid修改用户危险等级
     * @param personEntity
     * @return
     */
    int updateRiskLevelByOpenid(PersonEntity personEntity);
}