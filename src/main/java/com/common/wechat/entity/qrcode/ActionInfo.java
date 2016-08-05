package com.common.wechat.entity.qrcode;

/**
 * Created by admin on 2016/8/1.
 */
public class ActionInfo {
    private Scene scene;

    public void setScene(Scene scene){
        this.scene = scene;
    }
    public Scene getScene(){
        return this.scene;
    }

    public ActionInfo(Scene scene) {
        this.scene = scene;
    }

    public ActionInfo() {
    }

    @Override
    public String toString() {
        return "ActionInfo{" +
                "scene=" + scene +
                '}';
    }
}
