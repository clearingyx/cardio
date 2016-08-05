package com.common.wechat.emun;

/**
 * 用户触发事件类别
 */
public enum EventEmun {
    SUBSCRIBE("subscribe"),   //订阅|扫码未订阅
    UNSUBSCRIBE("unsubscribe"), //取消订阅
    SCAN("SCAN"),   //已经关注后的扫码
    LOCATION("LOCATION"), //上报地理位置
    CLICK("CLICK"), //自定义菜单事件
    VIEW("VIEW"); //链接事件

    private String value;

    public String getValue() {
        return value;
    }

    EventEmun(String value) {
        this.value = value;
    }
}
