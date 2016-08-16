package com.common.controller;

import com.common.component.annotation.ApiRequest;
import com.common.component.resp.RspCodeMsg;
import com.common.dao.auto.CollectionDao;
import com.common.dao.biz.CollectionBizDao;
import com.common.dao.biz.NewsBizDao;
import com.common.model.auto.NewsEntity;
import com.common.model.biz.CollectionReq;
import com.common.model.biz.NewsReq;
import com.exception.base.RspRuntimeException;
import com.util.PageUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang.peng on 2016/8/15.
 */
@Controller
@RequestMapping("/collection")
public class CollectionController extends BaseController{
    @Autowired
    CollectionBizDao collectionBizDao;
    @Autowired
    CollectionDao collectionDao;
    @Autowired
    NewsBizDao newsBizDao;

    @ApiRequest
    @RequestMapping("collection")
    @ResponseBody
    public Object collection(CollectionReq collectionReq){
        int count = collectionBizDao.selectCollectionVerifyRepeat(collectionReq);
        if (count > 0) {
            throw new RspRuntimeException(RspCodeMsg.DATE_REPEAT_ERR,"已经收藏");
            //return REPEAT;
        } else {
            collectionReq.setCreateDate(new Date());
            int temp = collectionBizDao.insert(collectionReq);
            if (temp != 1) {
                throw new RspRuntimeException(RspCodeMsg.FAIL,"收藏新增失败");
            } else {
                return SUCCESS;
            }
        }
    }

    @RequestMapping("collectionList")
    public String collectionList(NewsReq newsReq, Model model){
        Map paramMap = new HashMap();
        paramMap.put("openid", newsReq.getOpenId());
        paramMap.put("type", newsReq.getType());
        paramMap.put("status", 1);//0编辑中，1正常发布，2关闭

        RowBounds rowBounds = PageUtil.initRowBounds(newsReq);
        int rowCount = newsBizDao.count(paramMap);
        int pageCount = PageUtil.calculatePageCount(rowCount, newsReq.getPageSize());

        List<NewsEntity> list = newsBizDao.selectNewsByCollectionWithRowbounds(newsReq, rowBounds);

        model.addAttribute("openId", newsReq.getOpenId());
        model.addAttribute("list", list);
        model.addAttribute("rowCount",rowCount);
        model.addAttribute("pageCount",pageCount);
        return "weixin/news.jsp";
    }
}
