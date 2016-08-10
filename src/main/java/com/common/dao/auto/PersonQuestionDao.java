package com.common.dao.auto;

import com.common.model.auto.PersonQuestionEntity;
import com.common.model.auto.PersonQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PersonQuestionDao {
    /**
     *
     * @param example
     */
    int countByExample(PersonQuestionExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(PersonQuestionExample example);

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
    int insert(PersonQuestionEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(PersonQuestionEntity record);

    /**
     *
     * @param example
     */
    List<PersonQuestionEntity> selectByExampleWithRowbounds(PersonQuestionExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<PersonQuestionEntity> selectByExample(PersonQuestionExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    PersonQuestionEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") PersonQuestionEntity record, @Param("example") PersonQuestionExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") PersonQuestionEntity record, @Param("example") PersonQuestionExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(PersonQuestionEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(PersonQuestionEntity record);
}