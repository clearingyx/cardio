package com.common.modular.wechat.biz;

import com.common.component.resp.RspCodeMsg;
import com.common.dao.auto.LastingImageTextResourceDao;
import com.common.dao.auto.PersonDao;
import com.common.dao.biz.PersonBizDao;
import com.common.dao.biz.RadomQuestionBizDao;
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
import com.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by zhang.peng on 2016/7/29.
 * 关注|自定义button相关事件
 * 自动回复使用者的事件处理（demo，暂时不用）
 */
@Service
public class EventBiz{
    @Autowired
    PersonDao personDao;
    @Autowired
    PersonBizDao personBizDao;
    @Autowired
    PersonService personService;
    @Autowired
    LastingImageTextResourceDao lastingImageTextResourceDao;
    @Autowired
    RadomQuestionBizDao radomQuestionBizDao;

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
            //触发事件
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

        String openid = menuEvent.getFromUserName();

        //2.已经关注，扫码进入事件
        if((EventEmun.SCAN.toString()).equals(event)){
            //是一个32位无符号整数，即创建二维码时的二维码scene_id
            //得到openid对象的危险等级
            PersonEntity person = personBizDao.selectPersonByOpenid(openid);
            backXmlString = sendOutImageText(menuEvent,person.getRiskLevel());
        }

        //3.取消关注
        if((EventEmun.UNSUBSCRIBE.getValue()).equals(event)){//是取消关注
            PersonEntity person = new PersonEntity();
            person.setOpenId(openid);
            person.setUseStatus(2);
            int temp = personBizDao.updatePersonStatusByOpenid(person);
            if(temp != 1){
                throw new RspRuntimeException(RspCodeMsg.FAIL,"用户取消关注修改数据库失败");
            }
        }

        //4.上报地理位置
        //5.自定义菜单click事件
        if((EventEmun.CLICK.toString()).equals(event)){
            //剪切到下面了
        }

        //6.自定义菜单view事件

        return backXmlString;
    }

    /**
     * 用户发送信息反馈处理
     * 用户输入文本，图像，音频等（暂时不用）
     */
    public String infoHandl(Map<String,String> map){
        String backXmlString = "";

        return backXmlString;
    }

    /**
     * 扫码关注、点击关注，类似于创建新用户
     * 二维码参数是4个视频url
     * @param menuEvent
     * @return
     */
    public String FollowInsert(MenuEvent menuEvent){
        String xmlBack = "";

        //数据库insert新用户
        PersonEntity person = new PersonEntity();
        person.setOpenId(menuEvent.getFromUserName());
        person.setCreateDate(new Date(menuEvent.getCreateTime()));

        //1、扫码后进行关注，关注后推送图文
        String eventKey = menuEvent.getEventKey();

        if(null != eventKey && !"".equals(eventKey)){
            //插入数据
            person.setSource(1);//点击是0，扫医生码是1
            int risk_level = personService.insertSelective(person);

            //根据二维码参数进行图文推送
            xmlBack = sendOutImageText(menuEvent, risk_level);
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
                        "您不是扫描医生二维码关注的，请进行风险评估，如果您之前都没有注册过，点击风险评估会先进行注册。");
                xmlBack = XmlUtil.weixinBuildXml(br);

            } else {
                throw new RspRuntimeException(RspCodeMsg.FAIL,"微信信息插入数据库失败");
            }
            return xmlBack;
        }
    }

    /**
     * 根据二维码参数进行图文推送
     * @param menuEvent
     * @param riskLevel
     * @return
     */
    public String sendOutImageText(MenuEvent menuEvent, int riskLevel){
        //得到图文的配置，暂时只有2个，所以写到配置文件里面了
        ResourceBundle rb = ResourceBundle.getBundle("spring/imageTextDesc");

        //得到事件key
        String eventKey = menuEvent.getEventKey();
        try {
            //如果包含qrscene_，则说明是首次扫码关注；否则是已经关注后再扫码
            if (eventKey.contains("qrscene_")) {
                eventKey = eventKey.replace("qrscene_", "");
            }
        }catch (RspRuntimeException e){
            throw new RspRuntimeException(RspCodeMsg.WEIXIN_QRCODE_ERR,"微信二维码参数错误");
        }

        List<NewsArticle> list = new ArrayList<NewsArticle>();
        NewsArticle newsArticle = new NewsArticle();

        //做了测评，弹出视频图文
        if (riskLevel != -1) {
            //获得4个url，需要判断分隔符“，”
            String[] videos = eventKey.split(",");

            Map map = new HashMap();
            map.put("openid", menuEvent.getFromUserName());
            //因为riskLevel是0-3，二维码携带的参数顺序也是0-3
            map.put("videoid", videos[riskLevel]);
            //得到两道题
            map.put("questions", radomQuestionBizDao.selectTwoRadomQuestion());
            String json = JSONUtil.toJson(map);
            String video_url = rb.getString("base_url") + "&json=" + json;

            //弹出视频图文
            newsArticle = new NewsArticle(rb.getString("video_title"),
                    rb.getString("video_description"), rb.getString("video_picurl"),
                    video_url);

        }
        //没做测评，弹出测评图文
        else if (riskLevel == -1) {
            //弹出测评图文
            newsArticle = new NewsArticle(rb.getString("risk_title"),
                    rb.getString("risk_description"), rb.getString("risk_picurl"),
                    rb.getString("risk_url") + menuEvent.getFromUserName());

        }
        list.add(newsArticle);

        //生成对象，给微信发送
        BaseResp br = new NewsResp(menuEvent.getFromUserName(), menuEvent.getToUserName(),
                menuEvent.getMsgType(), MsgTypeEmun.NEWS.getValue(), 1, list);

        return XmlUtil.weixinBuildXml(br);
    }


//    if ("push_text".equals(map.get("EventKey"))) {
//        BaseResp br = new TextResp(menuEvent.getFromUserName(), menuEvent.getToUserName(),
//                menuEvent.getMsgType(), MsgTypeEmun.TEXT.getValue(),
//                "发送文字，key是push_text");
//        backXmlString = XmlUtil.weixinBuildXml(br);
//    } else if ("push_photo".equals(map.get("EventKey"))) {
//        BaseResp br = new ImageResp(menuEvent.getFromUserName(), menuEvent.getToUserName(),
//                menuEvent.getMsgType(), MsgTypeEmun.IMAGE.getValue(),
//                "5FZvGRE47npa6s7BhLbffIgH_3lxmuhEzShB3jRbyhI");
//        backXmlString = XmlUtil.weixinBuildXml(br);
//    } else if ("push_news".equals(map.get("EventKey"))) {
//        List<NewsArticle> list = new ArrayList<NewsArticle>();
//        NewsArticle newsArticle = new NewsArticle("图文详情", "这个是图文详情的描述",
//                "http://mmbiz.qpic.cn/mmbiz/HQ7r8nFZQKWIMianm9LnnViaADrB3AFVLRuCEPpbPbLMCNdlfbAibWgbhnGyo1mUPPgRC4EL8iaiaQINjusSkkcoDyg/0?wx_fmt=jpeg", "www.baidu.com");
//        list.add(newsArticle);
//        BaseResp br = new NewsResp(menuEvent.getFromUserName(), menuEvent.getToUserName(),
//                menuEvent.getMsgType(), MsgTypeEmun.NEWS.getValue(),
//                1,list);
//        backXmlString = XmlUtil.weixinBuildXml(br);
//    }

}
