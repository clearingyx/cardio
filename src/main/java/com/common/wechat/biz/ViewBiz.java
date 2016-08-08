package com.common.wechat.biz;

import com.common.model.auto.PersonEntity;
import com.common.wechat.entity.user.UserAuthorize;
import com.util.GetHttp;
import com.util.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhang.peng on 2016/8/3.
 */
@Controller
@RequestMapping("/viewBiz")
public class ViewBiz{
    /**
     * 用户访问链接跳转，通过code得到用户的所有信息（需要用户进入链接前对网页进行授权）
     * @param code
     * @param out
     * @throws IOException
     */
    @RequestMapping(value = "userInfo",method = RequestMethod.GET)
    public void userInfo(String code, PrintWriter out) throws IOException {
        //固定url
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + BaseBiz.appid
                +"&secret=" + BaseBiz.secret
                +"&code=" + code
                +"&grant_type=authorization_code";

        //get发送url，得到的json转型成WeixinAuthorizeBack类
        String result = GetHttp.Get(url);
        UserAuthorize userAuthorize = JSONUtil.toBean(result,UserAuthorize.class);

        //这里的access_token和运营方的access_token不一样，这个是用户的随机码，5分钟刷新
        //ps：这里注意，最好是放到redis里面，设置5分钟获取一次
        url = "https://api.weixin.qq.com/sns/userinfo?"
                +"access_token="+ userAuthorize.getAccess_token()
                +"&openid="+ userAuthorize.getOpenid()
                +"&lang="+ userAuthorize.getLang();

        //get发送url，转型成Person对象，微信返回用户信息
        result = GetHttp.Get(url);
        PersonEntity person = JSONUtil.toBean(result,PersonEntity.class);

        //测试头像，事务看业务
        out.print(person.getHeadimgurl());
    }
}
