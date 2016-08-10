package com.common.dao.biz;

import com.common.model.auto.PersonEntity;
import com.common.model.auto.PersonExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

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
}