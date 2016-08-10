package com.common.dao.biz;

import com.common.model.auto.PersonQuestionEntity;
import com.common.model.auto.PersonQuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface PersonQuestionBizDao {

    PersonQuestionEntity selectByPersonId(Integer person_id);
}