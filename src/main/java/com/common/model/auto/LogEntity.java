package com.common.model.auto;

public class LogEntity {
    /**
     * <pre>
     * 
     * 表字段 : log.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 
     * 表字段 : log.admin_id
     * </pre>
     */
    private Integer adminId;

    /**
     * <pre>
     * 
     * 表字段 : log.desc
     * </pre>
     */
    private String desc;

    /**
     * <pre>
     * 获取：
     * 表字段：log.id
     * </pre>
     *
     * @return log.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：log.id
     * </pre>
     *
     * @param id
     *            log.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：log.admin_id
     * </pre>
     *
     * @return log.admin_id：
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：log.admin_id
     * </pre>
     *
     * @param adminId
     *            log.admin_id：
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：log.desc
     * </pre>
     *
     * @return log.desc：
     */
    public String getDesc() {
        return desc;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：log.desc
     * </pre>
     *
     * @param desc
     *            log.desc：
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}