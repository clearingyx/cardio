package com.common.model.auto;

import java.util.Date;

public class CollectionEntity {
    /**
     * <pre>
     * 
     * 表字段 : collection.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 用户id
     * 表字段 : collection.person_id
     * </pre>
     */
    private Integer personId;

    /**
     * <pre>
     * 资讯id
     * 表字段 : collection.news_id
     * </pre>
     */
    private Integer newsId;

    /**
     * <pre>
     * 
     * 表字段 : collection.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 获取：
     * 表字段：collection.id
     * </pre>
     *
     * @return collection.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：collection.id
     * </pre>
     *
     * @param id
     *            collection.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：用户id
     * 表字段：collection.person_id
     * </pre>
     *
     * @return collection.person_id：用户id
     */
    public Integer getPersonId() {
        return personId;
    }

    /**
     * <pre>
     * 设置：用户id
     * 表字段：collection.person_id
     * </pre>
     *
     * @param personId
     *            collection.person_id：用户id
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /**
     * <pre>
     * 获取：资讯id
     * 表字段：collection.news_id
     * </pre>
     *
     * @return collection.news_id：资讯id
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * <pre>
     * 设置：资讯id
     * 表字段：collection.news_id
     * </pre>
     *
     * @param newsId
     *            collection.news_id：资讯id
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：collection.create_date
     * </pre>
     *
     * @return collection.create_date：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：collection.create_date
     * </pre>
     *
     * @param createDate
     *            collection.create_date：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}