package com.common.model.biz;

import com.common.component.param.AbstractPageParam;

import java.util.Date;

public class LastingImageTextReq extends AbstractPageParam {
    /**
     * <pre>
     *
     * 表字段 : lasting_image_text_resource.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 标题
     * 表字段 : lasting_image_text_resource.title
     * </pre>
     */
    private String title;

    /**
     * <pre>
     * 图文消息的封面图片素材id（必须是永久mediaID）
     * 表字段 : lasting_image_text_resource.thumb_media_id
     * </pre>
     */
    private String thumbMediaId;

    /**
     * <pre>
     * 作者
     * 表字段 : lasting_image_text_resource.author
     * </pre>
     */
    private String author;

    /**
     * <pre>
     * 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     * 表字段 : lasting_image_text_resource.digest
     * </pre>
     */
    private String digest;

    /**
     * <pre>
     * 是否显示封面，0不显示，1显示
     * 表字段 : lasting_image_text_resource.show_cover_pic
     * </pre>
     */
    private Integer showCoverPic;

    /**
     * <pre>
     * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
     * 表字段 : lasting_image_text_resource.content
     * </pre>
     */
    private String content;

    /**
     * <pre>
     * 图文消息的原文地址，即点击“阅读原文”后的URL
     * 表字段 : lasting_image_text_resource.content_source_url
     * </pre>
     */
    private String contentSourceUrl;

    /**
     * <pre>
     *
     * 表字段 : lasting_image_text_resource.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 图文描述，方便选择
     * 表字段 : lasting_image_text_resource.desc
     * </pre>
     */
    private String desc;

    /**
     * <pre>
     * 图文素材唯一id，微信返回
     * 表字段 : lasting_image_text_resource.media_id
     * </pre>
     */
    private String mediaId;

    /**
     * <pre>
     * 获取：
     * 表字段：lasting_image_text_resource.id
     * </pre>
     *
     * @return lasting_image_text_resource.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：lasting_image_text_resource.id
     * </pre>
     *
     * @param id
     *            lasting_image_text_resource.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：标题
     * 表字段：lasting_image_text_resource.title
     * </pre>
     *
     * @return lasting_image_text_resource.title：标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * <pre>
     * 设置：标题
     * 表字段：lasting_image_text_resource.title
     * </pre>
     *
     * @param title
     *            lasting_image_text_resource.title：标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * <pre>
     * 获取：图文消息的封面图片素材id（必须是永久mediaID）
     * 表字段：lasting_image_text_resource.thumb_media_id
     * </pre>
     *
     * @return lasting_image_text_resource.thumb_media_id：图文消息的封面图片素材id（必须是永久mediaID）
     */
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    /**
     * <pre>
     * 设置：图文消息的封面图片素材id（必须是永久mediaID）
     * 表字段：lasting_image_text_resource.thumb_media_id
     * </pre>
     *
     * @param thumbMediaId
     *            lasting_image_text_resource.thumb_media_id：图文消息的封面图片素材id（必须是永久mediaID）
     */
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId == null ? null : thumbMediaId.trim();
    }

    /**
     * <pre>
     * 获取：作者
     * 表字段：lasting_image_text_resource.author
     * </pre>
     *
     * @return lasting_image_text_resource.author：作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * <pre>
     * 设置：作者
     * 表字段：lasting_image_text_resource.author
     * </pre>
     *
     * @param author
     *            lasting_image_text_resource.author：作者
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * <pre>
     * 获取：图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     * 表字段：lasting_image_text_resource.digest
     * </pre>
     *
     * @return lasting_image_text_resource.digest：图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     */
    public String getDigest() {
        return digest;
    }

    /**
     * <pre>
     * 设置：图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     * 表字段：lasting_image_text_resource.digest
     * </pre>
     *
     * @param digest
     *            lasting_image_text_resource.digest：图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     */
    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    /**
     * <pre>
     * 获取：是否显示封面，0不显示，1显示
     * 表字段：lasting_image_text_resource.show_cover_pic
     * </pre>
     *
     * @return lasting_image_text_resource.show_cover_pic：是否显示封面，0不显示，1显示
     */
    public Integer getShowCoverPic() {
        return showCoverPic;
    }

    /**
     * <pre>
     * 设置：是否显示封面，0不显示，1显示
     * 表字段：lasting_image_text_resource.show_cover_pic
     * </pre>
     *
     * @param showCoverPic
     *            lasting_image_text_resource.show_cover_pic：是否显示封面，0不显示，1显示
     */
    public void setShowCoverPic(Integer showCoverPic) {
        this.showCoverPic = showCoverPic;
    }

    /**
     * <pre>
     * 获取：图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
     * 表字段：lasting_image_text_resource.content
     * </pre>
     *
     * @return lasting_image_text_resource.content：图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
     */
    public String getContent() {
        return content;
    }

    /**
     * <pre>
     * 设置：图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
     * 表字段：lasting_image_text_resource.content
     * </pre>
     *
     * @param content
     *            lasting_image_text_resource.content：图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * <pre>
     * 获取：图文消息的原文地址，即点击“阅读原文”后的URL
     * 表字段：lasting_image_text_resource.content_source_url
     * </pre>
     *
     * @return lasting_image_text_resource.content_source_url：图文消息的原文地址，即点击“阅读原文”后的URL
     */
    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    /**
     * <pre>
     * 设置：图文消息的原文地址，即点击“阅读原文”后的URL
     * 表字段：lasting_image_text_resource.content_source_url
     * </pre>
     *
     * @param contentSourceUrl
     *            lasting_image_text_resource.content_source_url：图文消息的原文地址，即点击“阅读原文”后的URL
     */
    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl == null ? null : contentSourceUrl.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：lasting_image_text_resource.create_date
     * </pre>
     *
     * @return lasting_image_text_resource.create_date：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：lasting_image_text_resource.create_date
     * </pre>
     *
     * @param createDate
     *            lasting_image_text_resource.create_date：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：图文描述，方便选择
     * 表字段：lasting_image_text_resource.desc
     * </pre>
     *
     * @return lasting_image_text_resource.desc：图文描述，方便选择
     */
    public String getDesc() {
        return desc;
    }

    /**
     * <pre>
     * 设置：图文描述，方便选择
     * 表字段：lasting_image_text_resource.desc
     * </pre>
     *
     * @param desc
     *            lasting_image_text_resource.desc：图文描述，方便选择
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * <pre>
     * 获取：图文素材唯一id，微信返回
     * 表字段：lasting_image_text_resource.media_id
     * </pre>
     *
     * @return lasting_image_text_resource.media_id：图文素材唯一id，微信返回
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * <pre>
     * 设置：图文素材唯一id，微信返回
     * 表字段：lasting_image_text_resource.media_id
     * </pre>
     *
     * @param mediaId
     *            lasting_image_text_resource.media_id：图文素材唯一id，微信返回
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId == null ? null : mediaId.trim();
    }

    /**
     * 验证前端参数
     */
    @Override
    public void paramCheck() {
    }
}