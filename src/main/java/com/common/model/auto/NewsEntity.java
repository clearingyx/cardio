package com.common.model.auto;

import java.util.Date;

public class NewsEntity {
    /**
     * <pre>
     * 
     * 表字段 : news.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 评估级别：0-轻；1-中；2-重；3-极重。（视频不分这个，默认-1）
     * 表字段 : news.risk_level
     * </pre>
     */
    private Integer riskLevel;

    /**
     * <pre>
     * 0-疾病知识，1-健康咨询,2-科普视频
     * 表字段 : news.type
     * </pre>
     */
    private Integer type;

    /**
     * <pre>
     * 视频地址，只有视频才有
     * 表字段 : news.video_url
     * </pre>
     */
    private String videoUrl;

    /**
     * <pre>
     * 创建时间
     * 表字段 : news.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 封面图
     * 表字段 : news.cover_img
     * </pre>
     */
    private String coverImg;

    /**
     * <pre>
     * 封面标题
     * 表字段 : news.cover_title
     * </pre>
     */
    private String coverTitle;

    /**
     * <pre>
     * 封面内容
     * 表字段 : news.cover_content
     * </pre>
     */
    private String coverContent;

    /**
     * <pre>
     * 0编辑中，1正常发布，2关闭
     * 表字段 : news.status
     * </pre>
     */
    private Integer status;

    /**
     * <pre>
     * 分享量
     * 表字段 : news.share
     * </pre>
     */
    private Integer share;

    /**
     * <pre>
     * 浏览量
     * 表字段 : news.browser
     * </pre>
     */
    private Integer browser;

    /**
     * <pre>
     * 详细内容，edit编辑
     * 表字段 : news.content
     * </pre>
     */
    private String content;

    /**
     * <pre>
     * 获取：
     * 表字段：news.id
     * </pre>
     *
     * @return news.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：news.id
     * </pre>
     *
     * @param id
     *            news.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：评估级别：0-轻；1-中；2-重；3-极重。（视频不分这个，默认-1）
     * 表字段：news.risk_level
     * </pre>
     *
     * @return news.risk_level：评估级别：0-轻；1-中；2-重；3-极重。（视频不分这个，默认-1）
     */
    public Integer getRiskLevel() {
        return riskLevel;
    }

    /**
     * <pre>
     * 设置：评估级别：0-轻；1-中；2-重；3-极重。（视频不分这个，默认-1）
     * 表字段：news.risk_level
     * </pre>
     *
     * @param riskLevel
     *            news.risk_level：评估级别：0-轻；1-中；2-重；3-极重。（视频不分这个，默认-1）
     */
    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    /**
     * <pre>
     * 获取：0-疾病知识，1-健康咨询,2-科普视频
     * 表字段：news.type
     * </pre>
     *
     * @return news.type：0-疾病知识，1-健康咨询,2-科普视频
     */
    public Integer getType() {
        return type;
    }

    /**
     * <pre>
     * 设置：0-疾病知识，1-健康咨询,2-科普视频
     * 表字段：news.type
     * </pre>
     *
     * @param type
     *            news.type：0-疾病知识，1-健康咨询,2-科普视频
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * <pre>
     * 获取：视频地址，只有视频才有
     * 表字段：news.video_url
     * </pre>
     *
     * @return news.video_url：视频地址，只有视频才有
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * <pre>
     * 设置：视频地址，只有视频才有
     * 表字段：news.video_url
     * </pre>
     *
     * @param videoUrl
     *            news.video_url：视频地址，只有视频才有
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：news.create_date
     * </pre>
     *
     * @return news.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：news.create_date
     * </pre>
     *
     * @param createDate
     *            news.create_date：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：封面图
     * 表字段：news.cover_img
     * </pre>
     *
     * @return news.cover_img：封面图
     */
    public String getCoverImg() {
        return coverImg;
    }

    /**
     * <pre>
     * 设置：封面图
     * 表字段：news.cover_img
     * </pre>
     *
     * @param coverImg
     *            news.cover_img：封面图
     */
    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg == null ? null : coverImg.trim();
    }

    /**
     * <pre>
     * 获取：封面标题
     * 表字段：news.cover_title
     * </pre>
     *
     * @return news.cover_title：封面标题
     */
    public String getCoverTitle() {
        return coverTitle;
    }

    /**
     * <pre>
     * 设置：封面标题
     * 表字段：news.cover_title
     * </pre>
     *
     * @param coverTitle
     *            news.cover_title：封面标题
     */
    public void setCoverTitle(String coverTitle) {
        this.coverTitle = coverTitle == null ? null : coverTitle.trim();
    }

    /**
     * <pre>
     * 获取：封面内容
     * 表字段：news.cover_content
     * </pre>
     *
     * @return news.cover_content：封面内容
     */
    public String getCoverContent() {
        return coverContent;
    }

    /**
     * <pre>
     * 设置：封面内容
     * 表字段：news.cover_content
     * </pre>
     *
     * @param coverContent
     *            news.cover_content：封面内容
     */
    public void setCoverContent(String coverContent) {
        this.coverContent = coverContent == null ? null : coverContent.trim();
    }

    /**
     * <pre>
     * 获取：0编辑中，1正常发布，2关闭
     * 表字段：news.status
     * </pre>
     *
     * @return news.status：0编辑中，1正常发布，2关闭
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：0编辑中，1正常发布，2关闭
     * 表字段：news.status
     * </pre>
     *
     * @param status
     *            news.status：0编辑中，1正常发布，2关闭
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：分享量
     * 表字段：news.share
     * </pre>
     *
     * @return news.share：分享量
     */
    public Integer getShare() {
        return share;
    }

    /**
     * <pre>
     * 设置：分享量
     * 表字段：news.share
     * </pre>
     *
     * @param share
     *            news.share：分享量
     */
    public void setShare(Integer share) {
        this.share = share;
    }

    /**
     * <pre>
     * 获取：浏览量
     * 表字段：news.browser
     * </pre>
     *
     * @return news.browser：浏览量
     */
    public Integer getBrowser() {
        return browser;
    }

    /**
     * <pre>
     * 设置：浏览量
     * 表字段：news.browser
     * </pre>
     *
     * @param browser
     *            news.browser：浏览量
     */
    public void setBrowser(Integer browser) {
        this.browser = browser;
    }

    /**
     * <pre>
     * 获取：详细内容，edit编辑
     * 表字段：news.content
     * </pre>
     *
     * @return news.content：详细内容，edit编辑
     */
    public String getContent() {
        return content;
    }

    /**
     * <pre>
     * 设置：详细内容，edit编辑
     * 表字段：news.content
     * </pre>
     *
     * @param content
     *            news.content：详细内容，edit编辑
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}