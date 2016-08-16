package com.common.dao.auto;

import com.common.model.auto.LastingImageTextResourceEntity;
import com.common.model.auto.LastingImageTextResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LastingImageTextResourceDao {
    /**
     *
     * @param example
     */
    int countByExample(LastingImageTextResourceExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(LastingImageTextResourceExample example);

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
    int insert(LastingImageTextResourceEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(LastingImageTextResourceEntity record);

    /**
     *
     * @param example
     */
    List<LastingImageTextResourceEntity> selectByExampleWithRowbounds(LastingImageTextResourceExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<LastingImageTextResourceEntity> selectByExample(LastingImageTextResourceExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    LastingImageTextResourceEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") LastingImageTextResourceEntity record, @Param("example") LastingImageTextResourceExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") LastingImageTextResourceEntity record, @Param("example") LastingImageTextResourceExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(LastingImageTextResourceEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(LastingImageTextResourceEntity record);
}