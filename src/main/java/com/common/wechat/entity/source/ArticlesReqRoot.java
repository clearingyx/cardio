package com.common.wechat.entity.source;

import java.util.List;

/**
 * Created by admin on 2016/8/1.
 * 永久素材的总类，微信服务器的格式有要求，这样封装方便生成json
 * 好像有数量限制，是10个，如果有数量限制，这里需要加一个参数来限定
 */
public class ArticlesReqRoot {
    private List<ArticlesReq> articles;

    public ArticlesReqRoot(List<ArticlesReq> articles) {
        this.articles = articles;
    }

    public List<ArticlesReq> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesReq> articles) {
        this.articles = articles;
    }
}
