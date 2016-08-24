package com.common.modular.wechat.entity;

/**
 * Created by zhang.peng on 2016/8/19.
 * 需要给对方发送回去的openid，课程id，危险等级，唯一标识码
 */
public class Course {
    private String uniqueCode;
    private String openId;
    private Integer riskLevel;
    private String courseId;

    public Course(String uniqueCode, String openId, Integer riskLevel, String courseId) {
        this.uniqueCode = uniqueCode;
        this.openId = openId;
        this.riskLevel = riskLevel;
        this.courseId = courseId;
    }

    public Course() {
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
