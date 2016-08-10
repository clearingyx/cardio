package com.common.dao.auto;

import com.common.model.auto.CollectionEntity;
import com.common.model.auto.CollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CollectionDao {
    /**
     *
     * @param example
     */
    int countByExample(CollectionExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(CollectionExample example);

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
    int insert(CollectionEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(CollectionEntity record);

    /**
     *
     * @param example
     */
    List<CollectionEntity> selectByExampleWithRowbounds(CollectionExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<CollectionEntity> selectByExample(CollectionExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    CollectionEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") CollectionEntity record, @Param("example") CollectionExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") CollectionEntity record, @Param("example") CollectionExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(CollectionEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(CollectionEntity record);
}