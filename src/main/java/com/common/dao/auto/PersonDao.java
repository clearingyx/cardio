package com.common.dao.auto;

import com.common.model.auto.PersonEntity;
import com.common.model.auto.PersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PersonDao {
    /**
     *
     * @param example
     */
    int countByExample(PersonExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(PersonExample example);

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
    int insert(PersonEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(PersonEntity record);

    /**
     *
     * @param example
     */
    List<PersonEntity> selectByExampleWithRowbounds(PersonExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<PersonEntity> selectByExample(PersonExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    PersonEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") PersonEntity record, @Param("example") PersonExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") PersonEntity record, @Param("example") PersonExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(PersonEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(PersonEntity record);
}