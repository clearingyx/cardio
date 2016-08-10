package com.common.modular.wechat.entity.qrcode;

/**
 * Created by admin on 2016/8/1.
 */
public class Scene {
    private int scene_id;
    private String scene_str;

    public String getScene_str() {
        return scene_str;
    }

    public void setScene_str(String scene_str) {
        this.scene_str = scene_str;
    }

    public void setScene_id(int scene_id){
        this.scene_id = scene_id;
    }
    public int getScene_id(){
        return this.scene_id;
    }

    public Scene() {
    }

    public Scene(int scene_id) {

        this.scene_id = scene_id;
    }

    public Scene(String scene_str) {
        this.scene_str = scene_str;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "scene_str='" + scene_str + '\'' +
                ", scene_id=" + scene_id +
                '}';
    }
}
