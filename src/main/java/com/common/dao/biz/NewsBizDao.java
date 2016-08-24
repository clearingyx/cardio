package com.common.dao.biz;

import com.common.model.auto.NewsEntity;
import com.common.model.auto.NewsExample;
import com.common.model.biz.NewsReq;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface NewsBizDao {

    List<NewsEntity> selectNewsByCollectionWithRowbounds(NewsReq newsReq, RowBounds rowBounds);

    int countNewsByCollection(NewsReq newsReq);

}