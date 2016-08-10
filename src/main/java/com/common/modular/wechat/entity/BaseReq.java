package com.common.modular.wechat.entity;

import java.util.Map;

/**
 * 用户触发事件，微信发回参数基类
 */
public class BaseReq {

    // 开发者微信号
    private String ToUserName;
    // 发送方帐号（一个OpenID）
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型（text/image/location/link）
    private String MsgType;
    // 消息id，64位整型
    private long MsgId;

    
    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }

    /**
     * 封装微信发送的信息为各种类
     * @return
     */
    public BaseReq(Map<String,String> map) {
        this.setToUserName(map.get("ToUserName"));
        this.setFromUserName(map.get("FromUserName"));
        this.setCreateTime(Long.valueOf(map.get("CreateTime")));
        this.setMsgType(map.get("MsgType"));
        this.setMsgId(Integer.valueOf(map.get("MsgId")));
    }
}