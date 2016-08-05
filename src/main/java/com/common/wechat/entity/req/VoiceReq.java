package com.common.wechat.entity.req;

import com.common.wechat.entity.BaseReq;

import java.util.Map;

/**
* 请求消息之语音消息
 */
public class VoiceReq extends BaseReq {

    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public VoiceReq(Map<String,String> map) {
        super(map);
        this.setMediaId(map.get("MediaId"));
        this.setFormat(map.get("Format"));
    }
}