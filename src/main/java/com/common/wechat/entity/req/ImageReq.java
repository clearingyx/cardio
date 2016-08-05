package com.common.wechat.entity.req;

import com.common.wechat.entity.BaseReq;

import java.util.Map;

/**
* 请求消息之图片消息
 */
public class ImageReq extends BaseReq {
    // 图片链接
    private String PicUrl;
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public ImageReq(Map<String,String> map) {
        super(map);
        this.setPicUrl(map.get("PicUrl"));
        this.setMediaId(map.get("MediaId"));
    }
}