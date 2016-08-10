package com.common.modular.wechat.emun;

/**
 * Created by admin on 2016/8/1.
 * 二维码生成
 */
public enum QRcodeEmun {
    QR_SCENE("QR_SCENE"),   //临时二维码
    QR_LIMIT_STR_SCENE("QR_LIMIT_STR_SCENE"); //永久二维码，最多10万个

    private String value;

    public String getValue() {
        return value;
    }

    QRcodeEmun(String value) {
        this.value = value;
    }
}
