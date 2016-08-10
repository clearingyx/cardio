package com.common.dao.auto;

import com.common.model.auto.NewsEntity;
import com.common.model.auto.NewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface NewsDao {
    /**
     *
     * @param example
     */
    int countByExample(NewsExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(NewsExample example);

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
    int insert(NewsEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(NewsEntity record);

    /**
     *
     * @param example
     */
    List<NewsEntity> selectByExampleWithBLOBsWithRowbounds(NewsExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<NewsEntity> selectByExampleWithBLOBs(NewsExample example);

    /**
     *
     * @param example
     */
    List<NewsEntity> selectByExampleWithRowbounds(NewsExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<NewsEntity> selectByExample(NewsExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    NewsEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") NewsEntity record, @Param("example") NewsExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") NewsEntity record, @Param("example") NewsExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") NewsEntity record, @Param("example") NewsExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(NewsEntity record);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(NewsEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(NewsEntity record);
}