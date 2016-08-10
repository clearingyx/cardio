package com.common.dao.auto;

import com.common.model.auto.AdminEntity;
import com.common.model.auto.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AdminDao {
    /**
     *
     * @param example
     */
    int countByExample(AdminExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(AdminExample example);

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
    int insert(AdminEntity record);

    /**
     *
     * @param record
     */
    int insertSelective(AdminEntity record);

    /**
     *
     * @param example
     */
    List<AdminEntity> selectByExampleWithRowbounds(AdminExample example, RowBounds rowBounds);

    /**
     *
     * @param example
     */
    List<AdminEntity> selectByExample(AdminExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    AdminEntity selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") AdminEntity record, @Param("example") AdminExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") AdminEntity record, @Param("example") AdminExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(AdminEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(AdminEntity record);
}