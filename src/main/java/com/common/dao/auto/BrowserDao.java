package com.common.dao.auto;

import com.common.model.auto.BrowserEntity;
import com.common.model.auto.BrowserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BrowserDao {
    /**
     *
     * @param example
     */
    int countByExample(BrowserExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(BrowserExample example);

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
    int insert(BrowserEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(BrowserEntity record);

    /**
     *
     * @param example
     */
    List<BrowserEntity> selectByExampleWithRowbounds(BrowserExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<BrowserEntity> selectByExample(BrowserExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    BrowserEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") BrowserEntity record, @Param("example") BrowserExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") BrowserEntity record, @Param("example") BrowserExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(BrowserEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(BrowserEntity record);
}