package com.common.dao.biz;

import com.common.model.auto.PersonQuestionEntity;

import java.util.List;

public interface PersonQuestionBizDao {

    List<PersonQuestionEntity> selectByOpenId(String openId);

    PersonQuestionEntity selectLastQuestionByOpenId(String openId);
}