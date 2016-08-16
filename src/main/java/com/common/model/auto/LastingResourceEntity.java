package com.common.model.auto;

import java.util.Date;

public class LastingResourceEntity {
    /**
     * <pre>
     * 
     * 表字段 : lasting_resource.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 媒体文件上传后，获取时的唯一标识
     * 表字段 : lasting_resource.media_id
     * </pre>
     */
    private String mediaId;

    /**
     * <pre>
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     * 表字段 : lasting_resource.type
     * </pre>
     */
    private String type;

    /**
     * <pre>
     * 媒体文件地址
     * 表字段 : lasting_resource.url
     * </pre>
     */
    private String url;

    /**
     * <pre>
     * 
     * 表字段 : lasting_resource.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 素材描述，为了方便选择
     * 表字段 : lasting_resource.remark
     * </pre>
     */
    private String remark;

    /**
     * <pre>
     * 获取：
     * 表字段：lasting_resource.id
     * </pre>
     *
     * @return lasting_resource.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：lasting_resource.id
     * </pre>
     *
     * @param id
     *            lasting_resource.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：媒体文件上传后，获取时的唯一标识
     * 表字段：lasting_resource.media_id
     * </pre>
     *
     * @return lasting_resource.media_id：媒体文件上传后，获取时的唯一标识
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * <pre>
     * 设置：媒体文件上传后，获取时的唯一标识
     * 表字段：lasting_resource.media_id
     * </pre>
     *
     * @param mediaId
     *            lasting_resource.media_id：媒体文件上传后，获取时的唯一标识
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId == null ? null : mediaId.trim();
    }

    /**
     * <pre>
     * 获取：媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     * 表字段：lasting_resource.type
     * </pre>
     *
     * @return lasting_resource.type：媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     */
    public String getType() {
        return type;
    }

    /**
     * <pre>
     * 设置：媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     * 表字段：lasting_resource.type
     * </pre>
     *
     * @param type
     *            lasting_resource.type：媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * <pre>
     * 获取：媒体文件地址
     * 表字段：lasting_resource.url
     * </pre>
     *
     * @return lasting_resource.url：媒体文件地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * <pre>
     * 设置：媒体文件地址
     * 表字段：lasting_resource.url
     * </pre>
     *
     * @param url
     *            lasting_resource.url：媒体文件地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：lasting_resource.create_date
     * </pre>
     *
     * @return lasting_resource.create_date：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：lasting_resource.create_date
     * </pre>
     *
     * @param createDate
     *            lasting_resource.create_date：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：素材描述，为了方便选择
     * 表字段：lasting_resource.remark
     * </pre>
     *
     * @return lasting_resource.remark：素材描述，为了方便选择
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <pre>
     * 设置：素材描述，为了方便选择
     * 表字段：lasting_resource.remark
     * </pre>
     *
     * @param remark
     *            lasting_resource.remark：素材描述，为了方便选择
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}