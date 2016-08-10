package com.common.dao.auto;

import com.common.model.auto.ShareEntity;
import com.common.model.auto.ShareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ShareDao {
    /**
     *
     * @param example
     */
    int countByExample(ShareExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(ShareExample example);

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
    int insert(ShareEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(ShareEntity record);

    /**
     *
     * @param example
     */
    List<ShareEntity> selectByExampleWithRowbounds(ShareExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<ShareEntity> selectByExample(ShareExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    ShareEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") ShareEntity record, @Param("example") ShareExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") ShareEntity record, @Param("example") ShareExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ShareEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(ShareEntity record);
}