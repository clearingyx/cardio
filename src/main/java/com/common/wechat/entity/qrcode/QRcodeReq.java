package com.common.wechat.entity.qrcode;

/**
 * Created by admin on 2016/8/1.
 * 微信发送回来的内容，是要存入数据库的
 */
public class QRcodeReq {
    //获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码
    private String ticket;
    //该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
    private int expire_seconds;
    //二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
    private String url;

    public QRcodeReq() {
    }

    public QRcodeReq(String ticket, int expire_seconds, String url) {
        this.ticket = ticket;
        this.expire_seconds = expire_seconds;
        this.url = url;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(int expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
