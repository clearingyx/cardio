package com.common.modular.wechat.biz;

import com.common.component.annotation.ApiRequest;
import com.common.component.resp.RspCodeMsg;
import com.common.dao.auto.PersonDao;
import com.common.dao.biz.PersonBizDao;
import com.common.model.auto.PersonEntity;
import com.common.modular.wechat.entity.user.UserAuthorize;
import com.exception.base.RspRuntimeException;
import com.util.GetHttp;
import com.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

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

    /**
     * 微信：我的信息按钮
     * 通过code得到用户的openid判断该用户是否注册（需要用户进入链接前对网页进行授权）
     * @param code
     * @throws IOException
     */
    @RequestMapping(value = "userInfo",method = RequestMethod.GET)
    public String userInfo(String code, Model model){
        PersonEntity person = getUserInfoByCode(code);

        //电话为空，则说明没有注册，跳转到注册页面
        if (null == person.getPhone() || "".equals(person.getPhone())){
            model.addAttribute("openid", person.getOpenid());
            return "weixin/reg.jsp";
        } else {
            //评估结果为-1，则跳转到答题页面
            if (-1 == person.getRiskLevel()) {
                //跳转到答题页面
                model.addAttribute("person_id", person.getId());
                return "weixin/question.jsp";
            } else {
                //跳转到信息页面
                model.addAttribute("person", person);
                return "weixin/person_info.jsp";
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
    public String reg(String code, Model model){
        PersonEntity person = getUserInfoByCode(code);

        //电话为空，则说明没有注册，跳转到注册页面
        if (null == person.getPhone() || "".equals(person.getPhone())){
            model.addAttribute("openid",person.getOpenid());
            return "weixin/reg.jsp";
        } else {
            //跳转到答题页面
            model.addAttribute("person_id", person.getId());
            return "weixin/question.jsp";
        }
    }

    /**
     * 得到微信用户详情
     * @param code
     * @return
     * @throws IOException
     */
    public PersonEntity getUserInfoByCode(String code){
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
        //将userAuthorize存入redis，设置为5分钟丢失

        //这里的access_token和运营方的access_token不一样，这个是用户的随机码，5分钟刷新
        //ps：这里注意，最好是放到redis里面，设置5分钟获取一次
        url = "https://api.weixin.qq.com/sns/userinfo?"
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
        return personBizDao.selectPersonByOpenid(person.getOpenid());
    }
}
