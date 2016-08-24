package com.common.modular.wechat.entity.qrcode;

/**
 * Created by zhang.peng on 2016/8/18.
 * 返回给第三方的对象，对方要求
 */
public class QRcodeThird {
    private String ticket;
    //url为二维码图片内url,通过微信的扫一扫功能扫描此二维码,可以进入关注微信公众号环节;
    private String url;

    public void setTicket(String ticket){
        this.ticket = ticket;
    }
    public String getTicket(){
        return this.ticket;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }

    public QRcodeThird(String ticket, String url) {
        this.ticket = ticket;
        this.url = url;
    }

    public QRcodeThird() {
    }
}
