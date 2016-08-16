package com.common.dao.biz;

import com.common.model.auto.NewsEntity;
import com.common.model.biz.NewsReq;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface NewsBizDao {
    /**
     * 根据条件得到资讯数量
     * @param map
     * @return
     */
    int count(Map map);

    /**
     * 根据openid和资讯类型查找收藏列表
     * @param newsReq
     * @return
     */
    List<NewsEntity> selectNewsByCollectionWithRowbounds(NewsReq newsReq, RowBounds rowBounds);
}