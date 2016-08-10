package com.common.model.auto;

import java.util.Date;

public class AdminEntity {
    /**
     * <pre>
     * 
     * 表字段 : admin.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 
     * 表字段 : admin.nickname
     * </pre>
     */
    private String nickname;

    /**
     * <pre>
     * 
     * 表字段 : admin.password
     * </pre>
     */
    private String password;

    /**
     * <pre>
     * 0-正常，1-禁用
     * 表字段 : admin.status
     * </pre>
     */
    private Integer status;

    /**
     * <pre>
     * 
     * 表字段 : admin.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 0-普通管理员，1-超级管理员（可以删除|创建管理员）
     * 表字段 : admin.power
     * </pre>
     */
    private Integer power;

    /**
     * <pre>
     * 获取：
     * 表字段：admin.id
     * </pre>
     *
     * @return admin.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：admin.id
     * </pre>
     *
     * @param id
     *            admin.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：admin.nickname
     * </pre>
     *
     * @return admin.nickname：
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：admin.nickname
     * </pre>
     *
     * @param nickname
     *            admin.nickname：
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：admin.password
     * </pre>
     *
     * @return admin.password：
     */
    public String getPassword() {
        return password;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：admin.password
     * </pre>
     *
     * @param password
     *            admin.password：
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * <pre>
     * 获取：0-正常，1-禁用
     * 表字段：admin.status
     * </pre>
     *
     * @return admin.status：0-正常，1-禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：0-正常，1-禁用
     * 表字段：admin.status
     * </pre>
     *
     * @param status
     *            admin.status：0-正常，1-禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：admin.create_date
     * </pre>
     *
     * @return admin.create_date：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：admin.create_date
     * </pre>
     *
     * @param createDate
     *            admin.create_date：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：0-普通管理员，1-超级管理员（可以删除|创建管理员）
     * 表字段：admin.power
     * </pre>
     *
     * @return admin.power：0-普通管理员，1-超级管理员（可以删除|创建管理员）
     */
    public Integer getPower() {
        return power;
    }

    /**
     * <pre>
     * 设置：0-普通管理员，1-超级管理员（可以删除|创建管理员）
     * 表字段：admin.power
     * </pre>
     *
     * @param power
     *            admin.power：0-普通管理员，1-超级管理员（可以删除|创建管理员）
     */
    public void setPower(Integer power) {
        this.power = power;
    }
}