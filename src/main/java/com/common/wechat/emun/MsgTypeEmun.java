package com.common.wechat.emun;

/**
 * 用户发送信息类别
 */
public enum MsgTypeEmun {
    TEXT("text"),   //文字
    IMAGE("image"), //图片
    VOICE("voice"), //音频
    VIDEO("video"), //视频
    SHORTVIDEO("shortvideo"),   //短视频
    LOCATION("location"),   //地理位置
    LINK("link"),   //链接消息
    EVENT("event"), //事件，还有菜单类EventMeun包括关注，点击等
    THUMB("thumb"),//缩略图
    NEWS("news");   //图文信息

    private String value;

    public String getValue() {
        return value;
    }

    MsgTypeEmun(String value) {
        this.value = value;
    }
}
