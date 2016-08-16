package com.common.model.auto;

import java.util.Date;

public class ShareEntity {
    /**
     * <pre>
     * 
     * 表字段 : share.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 
     * 表字段 : share.open_id
     * </pre>
     */
    private String openId;

    /**
     * <pre>
     * 
     * 表字段 : share.news_id
     * </pre>
     */
    private Integer newsId;

    /**
     * <pre>
     * 
     * 表字段 : share.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 获取：
     * 表字段：share.id
     * </pre>
     *
     * @return share.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：share.id
     * </pre>
     *
     * @param id
     *            share.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：share.open_id
     * </pre>
     *
     * @return share.open_id：
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：share.open_id
     * </pre>
     *
     * @param openId
     *            share.open_id：
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：share.news_id
     * </pre>
     *
     * @return share.news_id：
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：share.news_id
     * </pre>
     *
     * @param newsId
     *            share.news_id：
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：share.create_date
     * </pre>
     *
     * @return share.create_date：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：share.create_date
     * </pre>
     *
     * @param createDate
     *            share.create_date：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}