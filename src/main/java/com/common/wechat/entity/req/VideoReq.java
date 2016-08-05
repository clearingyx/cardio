package com.common.wechat.entity.req;

import com.common.wechat.entity.BaseReq;

import java.util.Map;

/**
* 请求消息之视频消息
 */
public class VideoReq extends BaseReq {

    // 媒体ID
    private String MediaId;
    // 语音格式
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
    public String getThumbMediaId() {
        return ThumbMediaId;
    }
    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public VideoReq(Map<String,String> map) {
        super(map);
        this.setMediaId(map.get("MediaId"));
        this.setThumbMediaId(map.get("ThumbMediaId"));
    }
    
}