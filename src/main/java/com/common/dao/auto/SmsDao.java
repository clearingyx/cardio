package com.common.dao.auto;

import com.common.model.auto.SmsEntity;
import com.common.model.auto.SmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SmsDao {
    /**
     *
     * @param example
     */
    int countByExample(SmsExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(SmsExample example);

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
    int insert(SmsEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(SmsEntity record);

    /**
     *
     * @param example
     */
    List<SmsEntity> selectByExampleWithRowbounds(SmsExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<SmsEntity> selectByExample(SmsExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    SmsEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") SmsEntity record, @Param("example") SmsExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") SmsEntity record, @Param("example") SmsExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(SmsEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(SmsEntity record);
}