package com.common.model.auto;

import java.util.Date;

public class BrowserEntity {
    /**
     * <pre>
     * 
     * 表字段 : browser.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 
     * 表字段 : browser.open_id
     * </pre>
     */
    private String openId;

    /**
     * <pre>
     * 
     * 表字段 : browser.news_id
     * </pre>
     */
    private Integer newsId;

    /**
     * <pre>
     * 
     * 表字段 : browser.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 获取：
     * 表字段：browser.id
     * </pre>
     *
     * @return browser.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：browser.id
     * </pre>
     *
     * @param id
     *            browser.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：browser.open_id
     * </pre>
     *
     * @return browser.open_id：
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：browser.open_id
     * </pre>
     *
     * @param openId
     *            browser.open_id：
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：browser.news_id
     * </pre>
     *
     * @return browser.news_id：
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：browser.news_id
     * </pre>
     *
     * @param newsId
     *            browser.news_id：
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：browser.create_date
     * </pre>
     *
     * @return browser.create_date：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：browser.create_date
     * </pre>
     *
     * @param createDate
     *            browser.create_date：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}