package com.common.dao.auto;

import com.common.model.auto.AboutmeEntity;
import com.common.model.auto.AboutmeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AboutmeDao {
    /**
     *
     * @param example
     */
    int countByExample(AboutmeExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(AboutmeExample example);

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
    int insert(AboutmeEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(AboutmeEntity record);

    /**
     *
     * @param example
     */
    List<AboutmeEntity> selectByExampleWithBLOBsWithRowbounds(AboutmeExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<AboutmeEntity> selectByExampleWithBLOBs(AboutmeExample example);

    /**
     *
     * @param example
     */
    List<AboutmeEntity> selectByExampleWithRowbounds(AboutmeExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<AboutmeEntity> selectByExample(AboutmeExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    AboutmeEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") AboutmeEntity record, @Param("example") AboutmeExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") AboutmeEntity record, @Param("example") AboutmeExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") AboutmeEntity record, @Param("example") AboutmeExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(AboutmeEntity record);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(AboutmeEntity record);
}