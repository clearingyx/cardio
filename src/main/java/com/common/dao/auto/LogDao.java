package com.common.dao.auto;

import com.common.model.auto.LogEntity;
import com.common.model.auto.LogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LogDao {
    /**
     *
     * @param example
     */
    int countByExample(LogExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(LogExample example);

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
    int insert(LogEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(LogEntity record);

    /**
     *
     * @param example
     */
    List<LogEntity> selectByExampleWithRowbounds(LogExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<LogEntity> selectByExample(LogExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    LogEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") LogEntity record, @Param("example") LogExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") LogEntity record, @Param("example") LogExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(LogEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(LogEntity record);
}