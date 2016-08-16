package com.common.dao.auto;

import com.common.model.auto.LastingResourceEntity;
import com.common.model.auto.LastingResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LastingResourceDao {
    /**
     *
     * @param example
     */
    int countByExample(LastingResourceExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(LastingResourceExample example);

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
    int insert(LastingResourceEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(LastingResourceEntity record);

    /**
     *
     * @param example
     */
    List<LastingResourceEntity> selectByExampleWithRowbounds(LastingResourceExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<LastingResourceEntity> selectByExample(LastingResourceExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    LastingResourceEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") LastingResourceEntity record, @Param("example") LastingResourceExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") LastingResourceEntity record, @Param("example") LastingResourceExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(LastingResourceEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(LastingResourceEntity record);
}