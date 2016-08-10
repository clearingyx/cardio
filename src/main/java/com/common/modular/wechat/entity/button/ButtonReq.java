package com.common.modular.wechat.entity.button;

import java.util.List;

/**
 * Created by zhang.peng on 2016/8/4.
 * 菜单类
 */
public class ButtonReq {
    //菜单的响应动作类型
    private String type;
    //菜单标题，不超过16个字节，子菜单不超过40个字节
    private String name;
    //菜单KEY值，用于消息接口推送，不超过128字节
    private String key;
    //网页链接，用户点击菜单可打开链接，不超过1024字节
    private String url;
    //调用新增永久素材接口返回的合法media_id
    private String media_id;
    //子菜单的个数，1-5个，不是必须的
    private int subButtonCount;
    //子菜单的集合
    private List<ButtonSubReq> buttonSubReqList ;

    public ButtonReq(String type, String name, String key, String url, String media_id, int subButtonCount, List<ButtonSubReq> buttonSubReqList) {
        this.type = type;
        this.name = name;
        this.key = key;
        this.url = url;
        this.media_id = media_id;
        this.subButtonCount = subButtonCount;
        this.buttonSubReqList = buttonSubReqList;
    }

    public ButtonReq() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public int getSubButtonCount() {
        return subButtonCount;
    }

    public void setSubButtonCount(int subButtonCount) {
        this.subButtonCount = subButtonCount;
    }

    public List<ButtonSubReq> getButtonSubReqList() {
        return buttonSubReqList;
    }

    public void setButtonSubReqList(List<ButtonSubReq> buttonSubReqList) {
        this.buttonSubReqList = buttonSubReqList;
    }

    @Override
    public String toString() {
        return "ButtonReq{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", url='" + url + '\'' +
                ", media_id='" + media_id + '\'' +
                ", subButtonCount=" + subButtonCount +
                ", buttonSubReqList=" + buttonSubReqList +
                '}';
    }
}
