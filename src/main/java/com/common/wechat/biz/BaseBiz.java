package com.common.wechat.biz;

import com.common.dao.auto.PersonDao;
import com.common.dao.biz.PersonBizDao;
import com.common.model.auto.PersonEntity;
import com.common.service.PersonService;
import com.common.wechat.entity.user.UserAuthorize;
import com.common.wechat.util.WexinConnectUtil;
import com.common.other.annotation.ApiRequest;
import com.util.GetHttp;
import com.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by zhangpeng on 2016/7/6.
 * 微信服务器所有的反馈进入本类
 */
@Controller
@RequestMapping("/baseBiz")
public class BaseBiz {
    @Autowired
    PersonDao personDao;
    @Autowired
    PersonBizDao personBizDao;
    @Autowired
    PersonService personService;
    @Autowired
    EventBiz eventBiz;

    //获取appid和secret
    static ResourceBundle rb = ResourceBundle.getBundle("wx");
    public static final String appid = rb.getString("wechat_appid");
    public static final String secret = rb.getString("wechat_secret");
    //2小时过期
//    private String access_token;
//    public void setAccess_token(String access_token) {
//        this.access_token = access_token;
//    }

    /**
     * 获得运营的access_token，保存2小时
     * ps：存入redis最好，如果到了2小时，redis缓存无数据了，再走这个方法
     */
    @RequestMapping("getAccess_token")
    public String getAccess_token(){
        //先判断缓存是否存在，如果不存在再走微信后台
        String url = "https://api.weixin.qq.com/cgi-bin/token?"
                +"grant_type=client_credential"
                +"&appid=" + appid
                +"&secret=" + secret;
        Map<String,Object> map = WexinConnectUtil.getConnectForGet(url);
        return map.get("access_token").toString();
    }

    /**
     * 微信验证服务器时使用，如果是向微信验证服务，注释掉下面的方法，放开这个方法
     */
//    @RequestMapping("weixin")
//    public void weixin(String signature, String echostr,String timestamp,
//                       String nonce,PrintWriter out) throws IOException{
//        String[] str = { rb.getString("token"), timestamp, nonce };
//        Arrays.sort(str); // 字典序排序
//        String bigStr = str[0] + str[1] + str[2];
//        // SHA1加密
//        String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();
//        // 确认请求来至微信
//        if (digest.equals(signature)) {
//            out.print(echostr);
//        }
//    }

    /**
     * 其他的信息发送都是走的这个验证接口
     * @param response
     * @param request
     * @throws IOException
     */
    @ApiRequest
    @RequestMapping("weixin")
    public void weixin(HttpServletResponse response, HttpServletRequest request){
        //定义发送回去的xml是utf-8格式，否则中文会乱码
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            String backXmlString = eventBiz.backXmlString(request);
            out.print(backXmlString);
        }catch (IOException e){
            e.printStackTrace();
            //log
        }
    }

//    @RequestMapping("upload")
//    @ResponseBody
//    public Object upload(String type){
//        String access_token = new BaseBiz().getAccess_token();
//        return "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="+access_token+"&type="+type;
//    }

    public static void main(String[] args) {
        String str = new BaseBiz().getAccess_token();
        System.out.println(str);
    }

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
