package com.common.modular.wechat.entity.req;

import com.common.modular.wechat.entity.BaseReq;

import java.util.Map;

/**
* 请求消息之链接消息
 */
public class LinkReq extends BaseReq {

    // 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public LinkReq(Map<String,String> map) {
        super(map);
        this.setTitle(map.get("Title"));
        this.setDescription(map.get("Description"));
        this.setUrl(map.get("Url"));
    }
}