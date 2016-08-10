package com.common.dao.auto;

import com.common.model.auto.RadomQuestionEntity;
import com.common.model.auto.RadomQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RadomQuestionDao {
    /**
     *
     * @param example
     */
    int countByExample(RadomQuestionExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(RadomQuestionExample example);

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
    int insert(RadomQuestionEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(RadomQuestionEntity record);

    /**
     *
     * @param example
     */
    List<RadomQuestionEntity> selectByExampleWithRowbounds(RadomQuestionExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<RadomQuestionEntity> selectByExample(RadomQuestionExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    RadomQuestionEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") RadomQuestionEntity record, @Param("example") RadomQuestionExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") RadomQuestionEntity record, @Param("example") RadomQuestionExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(RadomQuestionEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(RadomQuestionEntity record);
}