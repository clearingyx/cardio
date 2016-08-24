package com.common.dao.auto;

import com.common.model.auto.RandomQuestionRecordEntity;
import com.common.model.auto.RandomQuestionRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RandomQuestionRecordDao {
    /**
     *
     * @param example
     */
    int countByExample(RandomQuestionRecordExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(RandomQuestionRecordExample example);

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
    int insert(RandomQuestionRecordEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(RandomQuestionRecordEntity record);

    /**
     *
     * @param example
     */
    List<RandomQuestionRecordEntity> selectByExampleWithRowbounds(RandomQuestionRecordExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<RandomQuestionRecordEntity> selectByExample(RandomQuestionRecordExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    RandomQuestionRecordEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") RandomQuestionRecordEntity record, @Param("example") RandomQuestionRecordExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") RandomQuestionRecordEntity record, @Param("example") RandomQuestionRecordExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(RandomQuestionRecordEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(RandomQuestionRecordEntity record);
}