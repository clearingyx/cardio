package com.common.model.biz;

import java.util.Date;

/**
 * Created by Administrator on 2016/8/8.
 */
public class SmsReq {
    private Integer id;

    /**
     * <pre>
     *
     * 表字段 : sms.sms
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
     * 0为成功，其他需要参考返回码
     * 表字段 : sms.result
     * </pre>
     */
    private Integer result;

    /**
     * <pre>
     * 返回值的简单描述
     * 表字段 : sms.result_desc
     * </pre>
     */
    private String resultDesc;

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
     * 表字段：sms.sms
     * </pre>
     *
     * @return sms.sms：
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sms.sms
     * </pre>
     *
     * @param mobile
     *            sms.sms：
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
     * 获取：0为成功，其他需要参考返回码
     * 表字段：sms.result
     * </pre>
     *
     * @return sms.result：0为成功，其他需要参考返回码
     */
    public Integer getResult() {
        return result;
    }

    /**
     * <pre>
     * 设置：0为成功，其他需要参考返回码
     * 表字段：sms.result
     * </pre>
     *
     * @param result
     *            sms.result：0为成功，其他需要参考返回码
     */
    public void setResult(Integer result) {
        this.result = result;
    }

    /**
     * <pre>
     * 获取：返回值的简单描述
     * 表字段：sms.result_desc
     * </pre>
     *
     * @return sms.result_desc：返回值的简单描述
     */
    public String getResultDesc() {
        return resultDesc;
    }

    /**
     * <pre>
     * 设置：返回值的简单描述
     * 表字段：sms.result_desc
     * </pre>
     *
     * @param resultDesc
     *            sms.result_desc：返回值的简单描述
     */
    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc == null ? null : resultDesc.trim();
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

    public SmsReq(String mobile, String content, Integer result,  String value, String resultDesc) {
        this.mobile = mobile;
        this.content = content;
        this.result = result;
        this.value = value;
        this.resultDesc = resultDesc;
    }

    public SmsReq() {
    }

    @Override
    public String toString() {
        return "SmsReq{" +
                "id=" + id +
                ", sms='" + mobile + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", result=" + result +
                ", resultDesc='" + resultDesc + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
