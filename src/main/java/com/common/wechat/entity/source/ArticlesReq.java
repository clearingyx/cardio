package com.common.wechat.entity.source;

/**
 * Created by admin on 2016/8/1.
 * 向微信发送永久素材
 */
public class ArticlesReq {
    //标题
    private String title;
    //图文消息的封面图片素材id（必须是永久mediaID）
    private String thumb_media_id;
    //作者
    private String author;
    //图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
    private String digest;
    //是否显示封面，0为false，即不显示，1为true，即显示
    private int show_cover_pic;
    //图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
    private String content;
    //图文消息的原文地址，即点击“阅读原文”后的URL
    private String content_source_url;

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setThumb_media_id(String thumb_media_id){
        this.thumb_media_id = thumb_media_id;
    }
    public String getThumb_media_id(){
        return this.thumb_media_id;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setDigest(String digest){
        this.digest = digest;
    }
    public String getDigest(){
        return this.digest;
    }
    public void setShow_cover_pic(int show_cover_pic){
        this.show_cover_pic = show_cover_pic;
    }
    public int getShow_cover_pic(){
        return this.show_cover_pic;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public void setContent_source_url(String content_source_url){
        this.content_source_url = content_source_url;
    }
    public String getContent_source_url(){
        return this.content_source_url;
    }

    public ArticlesReq(String title, String thumb_media_id, String author, String digest, int show_cover_pic, String content, String content_source_url) {
        this.title = title;
        this.thumb_media_id = thumb_media_id;
        this.author = author;
        this.digest = digest;
        this.show_cover_pic = show_cover_pic;
        this.content = content;
        this.content_source_url = content_source_url;
    }

    public ArticlesReq() {
    }

    @Override
    public String toString() {
        return "ArticlesReq{" +
                "title='" + title + '\'' +
                ", thumb_media_id='" + thumb_media_id + '\'' +
                ", author='" + author + '\'' +
                ", digest='" + digest + '\'' +
                ", show_cover_pic=" + show_cover_pic +
                ", content='" + content + '\'' +
                ", content_source_url='" + content_source_url + '\'' +
                '}';
    }
}
