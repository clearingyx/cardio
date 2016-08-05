package com.common.wechat.entity.news;

import com.common.wechat.entity.BaseResp;

import java.util.List;

/**
 * Created by zhangpeng on 2016/8/3.
 * 回复图文消息
 */
public class NewsResp extends BaseResp {
    //图文消息个数，限制为10条以内
    private int ArticleCount;
    //图文详情
    private List<NewsArticle> Articles;

    public NewsResp(String toUserName, String fromUserName, String msgType, String type, int articleCount, List<NewsArticle> articles) {
        super(toUserName, fromUserName, msgType, type);
        ArticleCount = articleCount;
        Articles = articles;
    }

    public NewsResp() {
    }

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<NewsArticle> getArticles() {
        return Articles;
    }

    public void setArticles(List<NewsArticle> articles) {
        Articles = articles;
    }

    @Override
    public String toString() {
        return "NewsResp{" +
                "ArticleCount=" + ArticleCount +
                ", Articles=" + Articles +
                '}';
    }
}
