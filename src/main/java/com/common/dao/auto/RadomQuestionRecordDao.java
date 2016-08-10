package com.common.dao.auto;

import com.common.model.auto.RadomQuestionRecordEntity;
import com.common.model.auto.RadomQuestionRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RadomQuestionRecordDao {
    /**
     *
     * @param example
     */
    int countByExample(RadomQuestionRecordExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(RadomQuestionRecordExample example);

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
    int insert(RadomQuestionRecordEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(RadomQuestionRecordEntity record);

    /**
     *
     * @param example
     */
    List<RadomQuestionRecordEntity> selectByExampleWithRowbounds(RadomQuestionRecordExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<RadomQuestionRecordEntity> selectByExample(RadomQuestionRecordExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    RadomQuestionRecordEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") RadomQuestionRecordEntity record, @Param("example") RadomQuestionRecordExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") RadomQuestionRecordEntity record, @Param("example") RadomQuestionRecordExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(RadomQuestionRecordEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(RadomQuestionRecordEntity record);
}