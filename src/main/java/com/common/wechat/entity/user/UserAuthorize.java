package com.common.wechat.entity.user;

/**
 * Created by zhangpeng on 2016/7/27.
 * 用户进入授权页面后，微信返回的参数
 */
public class UserAuthorize {
    //access_token是5分钟刷新的动态的
    private String access_token;
    private String openid;
    //语言
    private String lang;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
