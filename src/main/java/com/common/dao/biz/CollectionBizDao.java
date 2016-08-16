package com.common.dao.biz;

import com.common.model.biz.CollectionReq;


public interface CollectionBizDao {
    /**
     * 验证重复
     * @param collectionReq
     * @return
     */
    int selectCollectionVerifyRepeat(CollectionReq collectionReq);

    /**
     * insert
     * @param collectionReq
     * @return
     */
    int insert(CollectionReq collectionReq);

}