package com.common.dao.biz;

import com.common.model.auto.PersonQuestionEntity;

public interface PersonQuestionBizDao {

    PersonQuestionEntity selectByPersonId(Integer person_id);
}