package com.common.modular.wechat.biz;

import com.common.component.resp.RspCodeMsg;
import com.common.dao.auto.PersonDao;
import com.common.dao.biz.PersonBizDao;
import com.common.model.auto.PersonEntity;
import com.common.service.PersonService;
import com.common.modular.wechat.emun.EventEmun;
import com.common.modular.wechat.emun.MsgTypeEmun;
import com.common.modular.wechat.entity.BaseResp;
import com.common.modular.wechat.entity.news.NewsArticle;
import com.common.modular.wechat.entity.news.NewsResp;
import com.common.modular.wechat.entity.resp.*;
import com.common.modular.wechat.event.MenuEvent;
import com.common.modular.wechat.util.XmlUtil;
import com.exception.base.RspRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang.peng on 2016/7/29.
 * 微信反馈给使用者的事件处理
 */
@Service
public class EventBiz{
    @Autowired
    PersonDao personDao;
    @Autowired
    PersonBizDao personBizDao;
    @Autowired
    PersonService personService;

    /**
     * 根据微信发送回来的信息判断用户事件
     */
    public String backXmlString(HttpServletRequest request){
        //定义回复微信xml-->String变量
        String backXmlString;

        //解析微信发送过来的xml，得到参数map集合
        Map<String,String> map = XmlUtil.weixinResolveXml(request);

        //通过MsgType判断是“触发事件”还是“用户发送信息”
        String type = map.get("MsgType");
        if((MsgTypeEmun.EVENT.getValue()).equals(type)){
            //用户触发事件
            backXmlString = eventHandl(map);
        } else {
            //用户发送信息，这个分类也较多，暂时和业务不相关，可以查看MsgTypeEmun类
            backXmlString = infoHandl(map);
        }
        return backXmlString;
    }

    /**
     * 用户触发事件操作
     */
    public String eventHandl(Map<String,String> map){
        MenuEvent menuEvent = new MenuEvent(map);

        //需要返回的xml
        String backXmlString = "";

        //判断是什么事件
        String event = map.get("Event");

        //1.未关注事件（包括点击关注和扫医生码）
        if((EventEmun.SUBSCRIBE.getValue()).equals(event)){
            backXmlString = FollowInsert(menuEvent);
        }

        //2.已经关注，扫码进入事件
        if((EventEmun.SCAN.toString()).equals(event)){
            //是一个32位无符号整数，即创建二维码时的二维码scene_id
            //Ticket，二维码的ticket，可用来换取二维码图片
            String eventKey = map.get("EventKey");
        }

        //3.取消关注
        if((EventEmun.UNSUBSCRIBE.getValue()).equals(event)){//是取消关注

        }

        //4.上报地理位置
        //5.自定义菜单click事件
        if((EventEmun.CLICK.toString()).equals(event)){
            if ("push_text".equals(map.get("EventKey"))) {
                BaseResp br = new TextResp(menuEvent.getFromUserName(), menuEvent.getToUserName(),
                        menuEvent.getMsgType(), MsgTypeEmun.TEXT.getValue(),
                        "发送文字，key是push_text");
                backXmlString = XmlUtil.weixinBuildXml(br);
            } else if ("push_photo".equals(map.get("EventKey"))) {
                BaseResp br = new ImageResp(menuEvent.getFromUserName(), menuEvent.getToUserName(),
                        menuEvent.getMsgType(), MsgTypeEmun.IMAGE.getValue(),
                        "5FZvGRE47npa6s7BhLbffIgH_3lxmuhEzShB3jRbyhI");
                backXmlString = XmlUtil.weixinBuildXml(br);
            } else if ("push_news".equals(map.get("EventKey"))) {
                List<NewsArticle> list = new ArrayList<NewsArticle>();
                NewsArticle newsArticle = new NewsArticle("图文详情", "这个是图文详情的描述",
                        "http://mmbiz.qpic.cn/mmbiz/HQ7r8nFZQKWIMianm9LnnViaADrB3AFVLRuCEPpbPbLMCNdlfbAibWgbhnGyo1mUPPgRC4EL8iaiaQINjusSkkcoDyg/0?wx_fmt=jpeg", "www.baidu.com");
                list.add(newsArticle);
                BaseResp br = new NewsResp(menuEvent.getFromUserName(), menuEvent.getToUserName(),
                        menuEvent.getMsgType(), MsgTypeEmun.NEWS.getValue(),
                        1,list);
                backXmlString = XmlUtil.weixinBuildXml(br);
            }
        }

        //6.自定义菜单view事件

        return backXmlString;
    }

    /**
     * 用户发送信息反馈处理
     * 用户输入文本，图像，音频是否需要有所反馈？
     */
    public String infoHandl(Map<String,String> map){
        String backXmlString = "";

        return backXmlString;
    }

    /**
     * 扫码关注、点击关注，类似于创建新用户
     * @param menuEvent
     * @return
     */
    public String FollowInsert(MenuEvent menuEvent){
        String xmlBack = "";

        //数据库insert新用户
        PersonEntity person = new PersonEntity();
        person.setOpenid(menuEvent.getFromUserName());
        person.setCreateDate(new Date(menuEvent.getCreateTime()));

        //1、扫码后进行关注，关注后推送图文
        //因为参数需要视频id，永久二维码的参数不一定是int类型，所以医生的扫码都是临时二维码
        String eventKey = menuEvent.getEventKey();
        if(null != eventKey && !"".equals(eventKey)){
            //插入数据
            person.setSource(1);//点击是0，其他是医生的id
            int temp = personService.insertSelective(person);
            if (temp == 1) {
                //插入成功，推送图文
                //QRcodeParam：截取到二维码参数（视频id）
                String videoId = eventKey.replace("qrscene_","");
                //这里举例子返回text
                BaseResp br = new TextResp(menuEvent.getFromUserName(), menuEvent.getToUserName(),
                        menuEvent.getMsgType(),  MsgTypeEmun.TEXT.getValue(),
                        "关注后发送的文字");
                xmlBack = XmlUtil.weixinBuildXml(br);
                //xmlBack = "";
            } else {
                throw new RspRuntimeException(RspCodeMsg.FAIL,"微信信息插入数据库失败");
                //log
            }

            return xmlBack;
        } else {
            //2、普通点击关注
            //插入成功，看看要不要推送东西
            person.setSource(0);//扫码是1，点击是0
            int temp = personService.insertSelective(person);
            if(temp == 1){
                //这里举例子返回text
                BaseResp br = new TextResp(menuEvent.getFromUserName(), menuEvent.getToUserName(),
                        menuEvent.getMsgType(),  MsgTypeEmun.TEXT.getValue(),
                        "关注后发送的文字");
                xmlBack = XmlUtil.weixinBuildXml(br);
            } else {
                //log
            }
            return xmlBack;
        }
    }

}
