package com.common.dao.auto;

import com.common.model.auto.LastingQrcodeEntity;
import com.common.model.auto.LastingQrcodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LastingQrcodeDao {
    /**
     *
     * @param example
     */
    int countByExample(LastingQrcodeExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(LastingQrcodeExample example);

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
    int insert(LastingQrcodeEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(LastingQrcodeEntity record);

    /**
     *
     * @param example
     */
    List<LastingQrcodeEntity> selectByExampleWithRowbounds(LastingQrcodeExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<LastingQrcodeEntity> selectByExample(LastingQrcodeExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    LastingQrcodeEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") LastingQrcodeEntity record, @Param("example") LastingQrcodeExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") LastingQrcodeEntity record, @Param("example") LastingQrcodeExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(LastingQrcodeEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(LastingQrcodeEntity record);
}