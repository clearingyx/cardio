package com.common.dao.biz;

import com.common.model.auto.RandomQuestionEntity;

import java.util.List;

public interface RandomQuestionBizDao {
    /**
     * 随机取2条数据
     * @return
     */
    List<RandomQuestionEntity> selectTwoRandomQuestion(Integer md_id);

}