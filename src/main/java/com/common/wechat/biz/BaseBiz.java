package com.common.wechat.biz;

import com.common.dao.auto.PersonDao;
import com.common.dao.biz.PersonBizDao;
import com.common.service.PersonService;
import com.common.wechat.emun.MsgTypeEmun;
import com.common.wechat.util.ConnectUtil;
import com.common.wechat.util.XmlUtil;
import com.other.annotation.ApiRequest;
import com.util.SHA1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by zhang.peng on 2016/8/3.
 */
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
    public synchronized String getAccess_token(){
        //先判断缓存是否存在，如果不存在再走微信后台
        String url = "https://api.weixin.qq.com/cgi-bin/token?"
                +"grant_type=client_credential"
                +"&appid=" + appid
                +"&secret=" + secret;
        Map<String,Object> map = ConnectUtil.getConnectForGet(url);
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
            String backXmlString = new EventBiz().backXmlString(request);
            out.print(backXmlString);
        }catch (IOException e){
            e.printStackTrace();
            //log
        }
    }



    @RequestMapping("index")
    public String index(){
        return "index.jsp";
    }


    @RequestMapping("upload")
    @ResponseBody
    public Object upload(String type){
        String access_token = new BaseBiz().getAccess_token();
        return "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="+access_token+"&type="+type;
    }

    public static void main(String[] args) {
        String str = new BaseBiz().getAccess_token();
        System.out.println(str);
        //new SourceBiz().createLastingSource();
        //JYAIW0slR9UDzEz6ylHhUY7t-Fkos33ou5CA6H8oGJpoKQlrnm9DkEGqMyvLcn1a
        //new Wechat().upload("image");

        //new WeixinBiz().getImage();
//        try {
//            new XmlUtil().httpsClient();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
