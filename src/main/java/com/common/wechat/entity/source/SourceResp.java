package com.common.wechat.entity.source;

/**
 * Created by zhang.peng on 2016/8/3.
 * 上传素材后微信返回的数据封装
 */
public class SourceResp {
    //媒体文件上传后，获取时的唯一标识
    private String media_id;
    //媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
    private String type;
    //媒体文件上传时间戳（临时素材有这个）
    private String created_at;
    //媒体文件地址（永久素材有这个）
    private String url;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SourceResp{" +
                "media_id='" + media_id + '\'' +
                ", type='" + type + '\'' +
                ", created_at='" + created_at + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
