package com.common.model.biz;

import com.common.component.param.AbstractPageParam;

public class LastingResourceReq extends AbstractPageParam {
    /**
     * <pre>
     * 
     * 表字段 : lasting_source.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 媒体文件上传后，获取时的唯一标识
     * 表字段 : lasting_source.media_id
     * </pre>
     */
    private String mediaId;

    /**
     * <pre>
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     * 表字段 : lasting_source.type
     * </pre>
     */
    private String type;

    /**
     * <pre>
     * 媒体文件地址
     * 表字段 : lasting_source.url
     * </pre>
     */
    private String url;

    /**
     * <pre>
     * 获取：
     * 表字段：lasting_source.id
     * </pre>
     *
     * @return lasting_source.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：lasting_source.id
     * </pre>
     *
     * @param id
     *            lasting_source.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：媒体文件上传后，获取时的唯一标识
     * 表字段：lasting_source.media_id
     * </pre>
     *
     * @return lasting_source.media_id：媒体文件上传后，获取时的唯一标识
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * <pre>
     * 设置：媒体文件上传后，获取时的唯一标识
     * 表字段：lasting_source.media_id
     * </pre>
     *
     * @param mediaId
     *            lasting_source.media_id：媒体文件上传后，获取时的唯一标识
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId == null ? null : mediaId.trim();
    }

    /**
     * <pre>
     * 获取：媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     * 表字段：lasting_source.type
     * </pre>
     *
     * @return lasting_source.type：媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     */
    public String getType() {
        return type;
    }

    /**
     * <pre>
     * 设置：媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     * 表字段：lasting_source.type
     * </pre>
     *
     * @param type
     *            lasting_source.type：媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * <pre>
     * 获取：媒体文件地址
     * 表字段：lasting_source.url
     * </pre>
     *
     * @return lasting_source.url：媒体文件地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * <pre>
     * 设置：媒体文件地址
     * 表字段：lasting_source.url
     * </pre>
     *
     * @param url
     *            lasting_source.url：媒体文件地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 验证前端参数
     */
    @Override
    public void paramCheck() {
    }
}