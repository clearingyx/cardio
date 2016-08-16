package com.common.model.auto;

import java.util.Date;

public class LastingQrcodeEntity {
    /**
     * <pre>
     * 
     * 表字段 : lasting_qrcode.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 二维码描述
     * 表字段 : lasting_qrcode.remark
     * </pre>
     */
    private String remark;

    /**
     * <pre>
     * 二维码微信地址
     * 表字段 : lasting_qrcode.ticket
     * </pre>
     */
    private String ticket;

    /**
     * <pre>
     * 
     * 表字段 : lasting_qrcode.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 过期时间，如果空则说明是永久的
     * 表字段 : lasting_qrcode.over_date
     * </pre>
     */
    private Date overDate;

    /**
     * <pre>
     * 获取：
     * 表字段：lasting_qrcode.id
     * </pre>
     *
     * @return lasting_qrcode.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：lasting_qrcode.id
     * </pre>
     *
     * @param id
     *            lasting_qrcode.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：二维码描述
     * 表字段：lasting_qrcode.remark
     * </pre>
     *
     * @return lasting_qrcode.remark：二维码描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <pre>
     * 设置：二维码描述
     * 表字段：lasting_qrcode.remark
     * </pre>
     *
     * @param remark
     *            lasting_qrcode.remark：二维码描述
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * <pre>
     * 获取：二维码微信地址
     * 表字段：lasting_qrcode.ticket
     * </pre>
     *
     * @return lasting_qrcode.ticket：二维码微信地址
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * <pre>
     * 设置：二维码微信地址
     * 表字段：lasting_qrcode.ticket
     * </pre>
     *
     * @param ticket
     *            lasting_qrcode.ticket：二维码微信地址
     */
    public void setTicket(String ticket) {
        this.ticket = ticket == null ? null : ticket.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：lasting_qrcode.create_date
     * </pre>
     *
     * @return lasting_qrcode.create_date：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：lasting_qrcode.create_date
     * </pre>
     *
     * @param createDate
     *            lasting_qrcode.create_date：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：过期时间，如果空则说明是永久的
     * 表字段：lasting_qrcode.over_date
     * </pre>
     *
     * @return lasting_qrcode.over_date：过期时间，如果空则说明是永久的
     */
    public Date getOverDate() {
        return overDate;
    }

    /**
     * <pre>
     * 设置：过期时间，如果空则说明是永久的
     * 表字段：lasting_qrcode.over_date
     * </pre>
     *
     * @param overDate
     *            lasting_qrcode.over_date：过期时间，如果空则说明是永久的
     */
    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }
}