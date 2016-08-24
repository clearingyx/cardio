package com.common.dao.auto;

import com.common.model.auto.RandomQuestionEntity;
import com.common.model.auto.RandomQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RandomQuestionDao {
    /**
     *
     * @param example
     */
    int countByExample(RandomQuestionExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(RandomQuestionExample example);

    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(RandomQuestionEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(RandomQuestionEntity record);

    /**
     *
     * @param example
     */
    List<RandomQuestionEntity> selectByExampleWithRowbounds(RandomQuestionExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<RandomQuestionEntity> selectByExample(RandomQuestionExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    RandomQuestionEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") RandomQuestionEntity record, @Param("example") RandomQuestionExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") RandomQuestionEntity record, @Param("example") RandomQuestionExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(RandomQuestionEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(RandomQuestionEntity record);
}