package com.common.model.auto;

import java.util.Date;

public class SmsEntity {
    /**
     * <pre>
     * 
     * 表字段 : sms.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 
     * 表字段 : sms.mobile
     * </pre>
     */
    private String mobile;

    /**
     * <pre>
     * 
     * 表字段 : sms.content
     * </pre>
     */
    private String content;

    /**
     * <pre>
     * 
     * 表字段 : sms.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 短信的批次编号，成功才有
     * 表字段 : sms.value
     * </pre>
     */
    private String value;

    /**
     * <pre>
     * 获取：
     * 表字段：sms.id
     * </pre>
     *
     * @return sms.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sms.id
     * </pre>
     *
     * @param id
     *            sms.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：sms.mobile
     * </pre>
     *
     * @return sms.mobile：
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sms.mobile
     * </pre>
     *
     * @param mobile
     *            sms.mobile：
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：sms.content
     * </pre>
     *
     * @return sms.content：
     */
    public String getContent() {
        return content;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sms.content
     * </pre>
     *
     * @param content
     *            sms.content：
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：sms.create_date
     * </pre>
     *
     * @return sms.create_date：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sms.create_date
     * </pre>
     *
     * @param createDate
     *            sms.create_date：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：短信的批次编号，成功才有
     * 表字段：sms.value
     * </pre>
     *
     * @return sms.value：短信的批次编号，成功才有
     */
    public String getValue() {
        return value;
    }

    /**
     * <pre>
     * 设置：短信的批次编号，成功才有
     * 表字段：sms.value
     * </pre>
     *
     * @param value
     *            sms.value：短信的批次编号，成功才有
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}