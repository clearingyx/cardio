package com.common.wechat.entity.req;

import com.common.wechat.entity.BaseReq;

import java.util.Map;

/**
 * 用户发送文本信息
 */
public class TextReq extends BaseReq {

    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public TextReq(Map<String,String> map) {
        super(map);
        this.setContent(map.get("Content"));
    }
}