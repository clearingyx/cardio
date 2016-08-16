package com.common.model.auto;

import java.util.Date;

public class PersonEntity {
    /**
     * <pre>
     * 主键ID
     * 表字段 : person.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 注册电话
     * 表字段 : person.phone
     * </pre>
     */
    private String phone;

    /**
     * <pre>
     * 评估级别：0-轻；1-中；2-重；3-极重
     * 表字段 : person.risk_level
     * </pre>
     */
    private Integer riskLevel;

    /**
     * <pre>
     * 微信昵称
     * 表字段 : person.nickname
     * </pre>
     */
    private String nickname;

    /**
     * <pre>
     * 微信id
     * 表字段 : person.open_id
     * </pre>
     */
    private String openId;

    /**
     * <pre>
     * 微信头像路径
     * 表字段 : person.headimgurl
     * </pre>
     */
    private String headimgurl;

    /**
     * <pre>
     * 0-女，1-男，答题的时候会修改这里
     * 表字段 : person.sex
     * </pre>
     */
    private Integer sex;

    /**
     * <pre>
     * 
     * 表字段 : person.city
     * </pre>
     */
    private String city;

    /**
     * <pre>
     * 
     * 表字段 : person.province
     * </pre>
     */
    private String province;

    /**
     * <pre>
     * 
     * 表字段 : person.country
     * </pre>
     */
    private String country;

    /**
     * <pre>
     * -1未注册，0-已注册未评估，1正常，2-取消关注
     * 表字段 : person.use_status
     * </pre>
     */
    private Integer useStatus;

    /**
     * <pre>
     * 
     * 表字段 : person.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 0-微信直接点击关注；其他的数字是扫医生码关注的医生的id
     * 表字段 : person.source
     * </pre>
     */
    private Integer source;

    /**
     * <pre>
     * 获取：主键ID
     * 表字段：person.id
     * </pre>
     *
     * @return person.id：主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：主键ID
     * 表字段：person.id
     * </pre>
     *
     * @param id
     *            person.id：主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：注册电话
     * 表字段：person.phone
     * </pre>
     *
     * @return person.phone：注册电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * <pre>
     * 设置：注册电话
     * 表字段：person.phone
     * </pre>
     *
     * @param phone
     *            person.phone：注册电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * <pre>
     * 获取：评估级别：0-轻；1-中；2-重；3-极重
     * 表字段：person.risk_level
     * </pre>
     *
     * @return person.risk_level：评估级别：0-轻；1-中；2-重；3-极重
     */
    public Integer getRiskLevel() {
        return riskLevel;
    }

    /**
     * <pre>
     * 设置：评估级别：0-轻；1-中；2-重；3-极重
     * 表字段：person.risk_level
     * </pre>
     *
     * @param riskLevel
     *            person.risk_level：评估级别：0-轻；1-中；2-重；3-极重
     */
    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    /**
     * <pre>
     * 获取：微信昵称
     * 表字段：person.nickname
     * </pre>
     *
     * @return person.nickname：微信昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * <pre>
     * 设置：微信昵称
     * 表字段：person.nickname
     * </pre>
     *
     * @param nickname
     *            person.nickname：微信昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * <pre>
     * 获取：微信id
     * 表字段：person.open_id
     * </pre>
     *
     * @return person.open_id：微信id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * <pre>
     * 设置：微信id
     * 表字段：person.open_id
     * </pre>
     *
     * @param openId
     *            person.open_id：微信id
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * <pre>
     * 获取：微信头像路径
     * 表字段：person.headimgurl
     * </pre>
     *
     * @return person.headimgurl：微信头像路径
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * <pre>
     * 设置：微信头像路径
     * 表字段：person.headimgurl
     * </pre>
     *
     * @param headimgurl
     *            person.headimgurl：微信头像路径
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    /**
     * <pre>
     * 获取：0-女，1-男，答题的时候会修改这里
     * 表字段：person.sex
     * </pre>
     *
     * @return person.sex：0-女，1-男，答题的时候会修改这里
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * <pre>
     * 设置：0-女，1-男，答题的时候会修改这里
     * 表字段：person.sex
     * </pre>
     *
     * @param sex
     *            person.sex：0-女，1-男，答题的时候会修改这里
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：person.city
     * </pre>
     *
     * @return person.city：
     */
    public String getCity() {
        return city;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：person.city
     * </pre>
     *
     * @param city
     *            person.city：
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：person.province
     * </pre>
     *
     * @return person.province：
     */
    public String getProvince() {
        return province;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：person.province
     * </pre>
     *
     * @param province
     *            person.province：
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：person.country
     * </pre>
     *
     * @return person.country：
     */
    public String getCountry() {
        return country;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：person.country
     * </pre>
     *
     * @param country
     *            person.country：
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * <pre>
     * 获取：-1未注册，0-已注册未评估，1正常，2-取消关注
     * 表字段：person.use_status
     * </pre>
     *
     * @return person.use_status：-1未注册，0-已注册未评估，1正常，2-取消关注
     */
    public Integer getUseStatus() {
        return useStatus;
    }

    /**
     * <pre>
     * 设置：-1未注册，0-已注册未评估，1正常，2-取消关注
     * 表字段：person.use_status
     * </pre>
     *
     * @param useStatus
     *            person.use_status：-1未注册，0-已注册未评估，1正常，2-取消关注
     */
    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：person.create_date
     * </pre>
     *
     * @return person.create_date：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：person.create_date
     * </pre>
     *
     * @param createDate
     *            person.create_date：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：0-微信直接点击关注；其他的数字是扫医生码关注的医生的id
     * 表字段：person.source
     * </pre>
     *
     * @return person.source：0-微信直接点击关注；其他的数字是扫医生码关注的医生的id
     */
    public Integer getSource() {
        return source;
    }

    /**
     * <pre>
     * 设置：0-微信直接点击关注；其他的数字是扫医生码关注的医生的id
     * 表字段：person.source
     * </pre>
     *
     * @param source
     *            person.source：0-微信直接点击关注；其他的数字是扫医生码关注的医生的id
     */
    public void setSource(Integer source) {
        this.source = source;
    }
}