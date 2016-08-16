package com.common.dao.biz;

import com.common.model.auto.RadomQuestionEntity;

import java.util.List;

public interface RadomQuestionBizDao {

    /**
     * 随机取2条数据
     * @return
     */
    List<RadomQuestionEntity> selectTwoRadomQuestion();
}