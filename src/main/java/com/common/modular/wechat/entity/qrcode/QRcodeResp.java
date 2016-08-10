package com.common.modular.wechat.entity.qrcode;

/**
 * Created by admin on 2016/8/1.
 * 生成带参数的二维码，这里的参数是给微信发送的
 */
public class QRcodeResp {
    private int expire_seconds;

    private String action_name;

    private ActionInfo action_info;

    public void setExpire_seconds(int expire_seconds){
        this.expire_seconds = expire_seconds;
    }
    public int getExpire_seconds(){
        return this.expire_seconds;
    }
    public void setAction_name(String action_name){
        this.action_name = action_name;
    }
    public String getAction_name(){
        return this.action_name;
    }
    public void setAction_info(ActionInfo action_info){
        this.action_info = action_info;
    }
    public ActionInfo getAction_info(){
        return this.action_info;
    }

    public QRcodeResp(int expire_seconds, String action_name, ActionInfo action_info) {
        this.expire_seconds = expire_seconds;
        this.action_name = action_name;
        this.action_info = action_info;
    }

    public QRcodeResp() {
    }

    public QRcodeResp(String action_name, ActionInfo action_info) {
        this.action_name = action_name;
        this.action_info = action_info;
    }

    @Override
    public String toString() {
        return "QRcodeResp{" +
                "expire_seconds=" + expire_seconds +
                ", action_name='" + action_name + '\'' +
                ", action_info=" + action_info +
                '}';
    }
}
