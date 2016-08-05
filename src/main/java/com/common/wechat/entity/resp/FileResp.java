package com.common.wechat.entity.resp;

/**
 * Created by zhang.peng on 2016/8/3.
 * 文件处理的时候需要得到向微信发送的文件的type和path信息以备后续处理
 */
public class FileResp {
    //多媒体文件的类型
    private String type;
    private String path;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public FileResp() {
    }

    public FileResp(String type, String path) {
        this.type = type;
        this.path = path;
    }

    @Override
    public String toString() {
        return "FileResp{" +
                "type='" + type + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
