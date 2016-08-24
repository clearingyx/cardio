package com.common.controller;

import com.common.component.annotation.ApiRequest;
import com.common.component.resp.RspCodeMsg;
import com.common.dao.auto.BrowserDao;
import com.common.dao.auto.CollectionDao;
import com.common.dao.auto.NewsDao;
import com.common.dao.biz.CollectionBizDao;
import com.common.dao.biz.NewsBizDao;
import com.common.model.auto.*;
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
import java.util.List;

/**
 * Created by zhang.peng on 2016/8/22.
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController{
    @Autowired
    NewsDao newsDao;
    @Autowired
    NewsBizDao newsBizDao;
    @Autowired
    BrowserDao browserDao;
    @Autowired
    CollectionDao collectionDao;
    @Autowired
    CollectionBizDao collectionBizDao;

    /**
     * 资讯详情，增加浏览记录
     * @param newsId
     * @param openId
     * @param model
     * @return
     */
    @RequestMapping("newsById")
    public String getNewsById(BrowserEntity browser,Integer type, Model model){
        //增加浏览记录
        browser.setCreateDate(new Date());
        int temp = browserDao.insert(browser);
        if(temp != 1){
            throw new RspRuntimeException(RspCodeMsg.FAIL,"增加浏览记录失败");
        }

        //查看是否收藏
        CollectionExample example = new CollectionExample();
        CollectionExample.Criteria criteria = example.createCriteria();
        criteria.andOpenIdEqualTo(browser.getOpenId());
        criteria.andNewsIdEqualTo(browser.getNewsId());
        List<CollectionEntity> collectionList = collectionDao.selectByExample(example);
        if(collectionList.size() > 0) {
            model.addAttribute("collectionId", collectionList.get(0).getId());
        } else {
            model.addAttribute("collectionId", 0);
        }

        NewsEntity newsEntity = newsDao.selectByPrimaryKey(browser.getNewsId());
        if (newsEntity.getContent().contains("")) {

        }

        model.addAttribute("openId", browser.getOpenId());
        model.addAttribute("news", newsEntity);
        if(type == 2){
            //视频详情
            return "weixin/page-tv1/page-tv1.jsp";
        } else {
            //资讯详情
            return "weixin/page-collect/page-collect.jsp";
        }
    }

    /**
     * 资讯列表
     * @param newsReq
     * @param model
     * @return
     */
    @RequestMapping("newsList")
    public String newsList(NewsReq newsReq, Model model){
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();

        // 分页参数
        RowBounds rowBounds = PageUtil.initRowBounds(newsReq);
        criteria.andTypeEqualTo(newsReq.getType());
        if(newsReq.getRiskLevel() !=null ) {
            criteria.andRiskLevelEqualTo(newsReq.getRiskLevel());
        }
        example.setOrderByClause("create_date desc");

        // 读取数据条数
        int rowCount = newsDao.countByExample(example);
        int pageCount = PageUtil.calculatePageCount(rowCount, newsReq.getPageSize());
        //分页查询
        List<NewsEntity> list = newsDao.selectByExampleWithRowbounds(example,rowBounds);

        model.addAttribute("news", newsReq);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("rowCount", rowCount);
        model.addAttribute("list", list);

//        if(newsReq.getType() != 2){
//            //知识页面\资讯页面
//            return "weixin/cx/zx.jsp";
//        } else {
//            //视频页面
//            return "weixin/science/science.jsp";
//        }
        return "weixin/video/video.jsp";
    }

    /**
     * 收藏资讯
     * @param collection
     * @return
     */
    @ApiRequest
    @RequestMapping("collection")
    @ResponseBody
    public Object collection(CollectionEntity collection){
        int temp;
        if (collection.getId() == null) {
            collection.setCreateDate(new Date());
            temp = collectionDao.insert(collection);
        } else {
            temp = collectionDao.deleteByPrimaryKey(collection.getId());
        }
        if (temp != 1) {
            if (collection.getId() == null ) {
                throw new RspRuntimeException(RspCodeMsg.FAIL, "新增收藏失败");
            } else {
                throw new RspRuntimeException(RspCodeMsg.FAIL, "取消收藏失败");
            }
        } else {
            return SUCCESS;
        }
    }

    /**
     * 取消收藏
     * @param id
     * @return
     */
    @ApiRequest
    @RequestMapping("delCollection")
    @ResponseBody
    public Object delConllection(Integer id){
        int temp = collectionDao.deleteByPrimaryKey(id);
        if (temp != 1) {
            throw new RspRuntimeException(RspCodeMsg.FAIL,"取消收藏失败");
        } else {
            return SUCCESS;
        }
    }

    /**
     * 用户收藏列表
     * @return
     */
    @RequestMapping("userCollectionList")
    public String userCollectionList(NewsReq newsReq, Model model){
        // 分页参数
        RowBounds rowBounds = PageUtil.initRowBounds(newsReq);

        // 读取数据条数
        int rowCount = newsBizDao.countNewsByCollection(newsReq);
        int pageCount = PageUtil.calculatePageCount(rowCount, newsReq.getPageSize());
        //分页查询
        List<NewsEntity> list = newsBizDao.selectNewsByCollectionWithRowbounds(newsReq,rowBounds);

        model.addAttribute("news", newsReq);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("rowCount", rowCount);
        model.addAttribute("list", list);

//        if(newsReq.getType() != 2){
//            //知识页面\资讯页面
//            return "weixin/cx/zx.jsp";
//        } else {
//            //视频页面
//            return "weixin/science/science.jsp";
//        }
        return "weixin/video/video.jsp";

    }

}
