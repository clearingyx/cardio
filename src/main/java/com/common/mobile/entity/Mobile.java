package com.common.mobile.entity;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/8/8.
 * 短信类
 */
public class Mobile {
    //账号（分配）
    private static String loginid;
    //密码（分配）
    private static String loginpwd;
    //短信内容（字数限制请联系客服）
    private String content;
    //短信签名（2-10个字符）
    private static String sign;
    //手机号之间用英文逗号分隔，单独一个不用
    private String mobiles;
    //定时时间，可选，空值或早于当前立即发送 格式“20140303134200”yyyyMMddHHmmss
    private String sendtime;

    private static Mobile mobile = null;

    public static Mobile getMobile(){
        if (mobile == null) {
            loginid = ResourceBundle.getBundle("spring/config").getString("sms_loginid");
            loginpwd = ResourceBundle.getBundle("spring/config").getString("sms_loginpwd");
            try {
                sign = new String(ResourceBundle.getBundle("spring/config").getString("sms_sign").getBytes("ISO-8859-1"),"GBK");
            }catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            mobile = new Mobile(loginid,loginpwd,sign);
        }
        return mobile;
    }

    public Mobile() {
    }

    public Mobile(String loginid, String loginpwd, String sign) {
        this.loginid = loginid;
        this.loginpwd = loginpwd;
        this.sign = sign;
    }

    public Mobile(String loginid, String loginpwd, String content, String sign, String mobiles, String sendtime) {
        this.loginid = loginid;
        this.loginpwd = loginpwd;
        this.content = content;
        this.sign = sign;
        this.mobiles = mobiles;
        this.sendtime = sendtime;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMobiles() {
        return mobiles;
    }

    public void setMobiles(String mobiles) {
        this.mobiles = mobiles;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "loginid='" + loginid + '\'' +
                ", loginpwd='" + loginpwd + '\'' +
                ", content='" + content + '\'' +
                ", sign='" + sign + '\'' +
                ", mobiles='" + mobiles + '\'' +
                ", sendtime='" + sendtime + '\'' +
                '}';
    }
}
