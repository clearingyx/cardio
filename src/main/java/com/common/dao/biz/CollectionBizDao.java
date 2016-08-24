package com.common.dao.biz;

import com.common.model.auto.CollectionEntity;
import com.common.model.auto.NewsEntity;


public interface CollectionBizDao {
    /**
     * 验证重复
     * @param collection
     * @return
     */
    int selectCollectionVerifyRepeat(CollectionEntity collection);

    /**
     * 返回主键
     * @param record
     */
    int insertSelective(CollectionEntity collection);

}