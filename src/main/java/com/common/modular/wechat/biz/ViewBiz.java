package com.common.modular.wechat.biz;

import com.common.component.resp.RspCodeMsg;
import com.common.dao.auto.NewsDao;
import com.common.dao.auto.PersonDao;
import com.common.dao.biz.PersonBizDao;
import com.common.model.auto.NewsEntity;
import com.common.model.auto.NewsExample;
import com.common.model.auto.PersonEntity;
import com.common.model.biz.NewsReq;
import com.common.modular.wechat.entity.user.UserAuthorize;
import com.exception.base.RspRuntimeException;
import com.util.GetHttp;
import com.util.JSONUtil;
import com.util.PageUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang.peng on 2016/8/3.
 */
@Controller
@RequestMapping("/viewBiz")
public class ViewBiz{
    @Autowired
    PersonBizDao personBizDao;
    @Autowired
    PersonDao personDao;
    @Autowired
    NewsDao newsDao;

    /**
     * 微信：我的信息按钮
     * 通过code得到用户的openid判断该用户是否注册（需要用户进入链接前对网页进行授权）
     * @param code
     * @throws IOException
     */
    @RequestMapping(value = "userInfo",method = RequestMethod.GET)
    public String userInfo(String code, Model model){
        UserAuthorize userAuthorize = getUserAuthorizeByCode(code);
        PersonEntity person = getUserInfoByUserAuthorize(userAuthorize);

        //电话为空，则说明没有注册，跳转到注册页面
        if (null == person.getPhone() || "".equals(person.getPhone())){
            model.addAttribute("openId", person.getOpenId());
            return "weixin/shouye/index.jsp";
        } else {
            //评估结果为-1，则跳转到答题页面
            if (-1 == person.getRiskLevel()) {
                //跳转到答题页面
                model.addAttribute("openid", person.getOpenId());
                return "weixin/page-test/test.jsp";
            } else {
                //跳转到信息页面
                model.addAttribute("person", person);
                return "weixin/page-my/page-my.jsp";
            }
        }
    }

    /**
     * 微信按钮：风险评估
     * 判断该用户是否已经注册（有电话则已经注册）
     * @param code
     * @param model
     * @return
     */
    @RequestMapping("reg")
    public String reg(String code, Model model, String openId){
        PersonEntity person;
        if(null != openId && !"".equals(openId)){
            person = personBizDao.selectPersonByOpenid(openId);
        } else {
            UserAuthorize userAuthorize = getUserAuthorizeByCode(code);
            person = getUserInfoByUserAuthorize(userAuthorize);
        }
        //电话为空，则说明没有注册，跳转到注册页面
        if (null == person.getPhone() || "".equals(person.getPhone())){
            model.addAttribute("openId",person.getOpenId());
            return "weixin/shouye/index.jsp";
        } else {
            //跳转到答题页面
            model.addAttribute("openId", person.getOpenId());
            return "weixin/page-test/test.jsp";
        }
    }

    /**
     * 通过code得到微信发送回来的base_info，这个不需要授权
     * @param code
     * @return
     */
    public UserAuthorize getUserAuthorizeByCode(String code){
        //固定url
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + BaseBiz.appid
                +"&secret=" + BaseBiz.secret
                +"&code=" + code
                +"&grant_type=authorization_code";

        //get发送url，得到的json转型成WeixinAuthorizeBack类
        String result = "";
        try {
            result = GetHttp.Get(url);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RspRuntimeException(RspCodeMsg.FAIL,"get方式连接微信链接失败");
        }
        UserAuthorize userAuthorize = JSONUtil.toBean(result,UserAuthorize.class);

        //这里的access_token和运营方的access_token不一样，这个是用户的随机码，5分钟刷新
        //ps：这里注意，最好是放到redis里面，设置5分钟获取一次
        return userAuthorize;
    }

    /**
     * 通过UserAuthorize里面的access_token和openid得到用户详情，封装person
     * @param userAuthorize
     * @return
     */
    public PersonEntity getUserInfoByUserAuthorize(UserAuthorize userAuthorize){
        String result;
        String url = "https://api.weixin.qq.com/sns/userinfo?"
                +"access_token="+ userAuthorize.getAccess_token()
                +"&openid="+ userAuthorize.getOpenid()
                +"&lang="+ userAuthorize.getLang();

        //get发送url，转型成Person对象，微信返回用户信息
        try {
            result = GetHttp.Get(url);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RspRuntimeException(RspCodeMsg.FAIL,"get方式连接微信链接失败");
        }
        PersonEntity person = JSONUtil.toBean(result,PersonEntity.class);
        //更新该用户的微信数据到数据库
        int temp = personBizDao.updatePersonByOpenid(person);
        if (temp != 1){
            throw new RspRuntimeException(RspCodeMsg.FAIL,"根据openid添加用户微信详情失败");
        }
        return personBizDao.selectPersonByOpenid(person.getOpenId());
    }

    /**
     * 知识、资讯、视频列表
     * @param newsReq
     * @param newsReq --> openId
     * @param model
     * @return
     */
    @RequestMapping("news")
    public String getNewsList(NewsReq newsReq, String code, Model model){
        //点击微信按钮，code不为null
        if(null != code) {
            //通过微信得到用户openid
            UserAuthorize userAuthorize = getUserAuthorizeByCode(code);
            newsReq.setOpenId(userAuthorize.getOpenid());

            //通过openid得到用户详情，需要判断跳转的参数
            PersonEntity personEntity = personBizDao.selectPersonByOpenid(newsReq.getOpenId());
            //没有电话，跳转到首页注册页
            if (null == personEntity.getPhone() || "".equals(personEntity.getPhone())){
                model.addAttribute("openId", personEntity.getOpenId());
                return "weixin/shouye/index.jsp";
            } else {
                //没有评估结果，则跳转到答题页面
                if (-1 == personEntity.getRiskLevel()) {
                    //跳转到答题页面
                    model.addAttribute("openid", personEntity.getOpenId());
                    return "weixin/page-test/test.jsp";
                }
            }
        }

        model.addAttribute("news", newsReq);
        //type=2是视频并且是微信点击按钮，code不为空。
        //视频不分危险等级
        if(newsReq.getType() == 2 && null != code){
            model = selectByExample(newsReq, model);
            return "weixin/video/video.jsp";
        } else {
            //是从色块页面跳转的
            if(null != newsReq.getRiskLevel()){
                model = selectByExample(newsReq, model);
                return "weixin/video/video.jsp";
            } else {
                //跳转到色块页面
                return "weixin/disease/disease.jsp";
            }
        }
    }


    private Model selectByExample(NewsReq newsReq, Model model){
        //页面展示，sql条件
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();

        //type 0-疾病知识，1-健康咨询,2-科普视频
        criteria.andTypeEqualTo(newsReq.getType());
        //视频不分等级
        if (newsReq.getType() != 2) {
            //评估级别：0-轻；1-中；2-重；3-极重
            criteria.andRiskLevelEqualTo(newsReq.getRiskLevel());
        }
        //按照时间倒叙
        example.setOrderByClause("create_date desc");

        // 分页参数
        RowBounds rowBounds = PageUtil.initRowBounds(newsReq);

        // 读取数据条数
        int rowCount = newsDao.countByExample(example);
        int pageCount = PageUtil.calculatePageCount(rowCount, newsReq.getPageSize());
        List<NewsEntity> list = newsDao.selectByExample(example);

        model.addAttribute("pageCount", rowCount);
        model.addAttribute("rowCount", pageCount);
        model.addAttribute("list", list);

        return model;
    }

}
