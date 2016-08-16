package com.common.model.biz;

import com.common.component.param.AbstractPageParam;
import com.google.common.base.Preconditions;

import java.util.Date;

/**
 * Created by zhang.peng on 2016/8/16.
 */
public class CollectionReq extends AbstractPageParam {
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
     * 表字段 : collection.open_id
     * </pre>
     */
    private String openId;

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
     * 表字段：collection.open_id
     * </pre>
     *
     * @return collection.open_id：用户id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * <pre>
     * 设置：用户id
     * 表字段：collection.open_id
     * </pre>
     *
     * @param openId
     *            collection.open_id：用户id
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
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

    @Override
    public void paramCheck() {
        Preconditions.checkNotNull(super.getOpenId(), "微信OpenID不能为空");
        Preconditions.checkNotNull(getNewsId(), "资讯ID不能为空");
    }
}
