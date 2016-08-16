package com.common.modular.wechat.biz;

import com.common.dao.auto.PersonDao;
import com.common.dao.biz.PersonBizDao;
import com.common.component.resp.RspCodeMsg;
import com.common.service.PersonService;
import com.common.modular.wechat.util.WexinConnectUtil;
import com.exception.base.RspRuntimeException;
import com.util.SHA1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
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
     * 主入口
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("weixin")
    @ResponseBody
    public Object weixin(HttpServletResponse response, HttpServletRequest request, String signature,
                       String echostr, String timestamp, String nonce){
        //*******
        //要是验证的话，return echostr;
        //*******

        //定义发送回去的xml是utf-8格式，否则中文会乱码
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String[] str = { rb.getString("token"), timestamp, nonce };
        Arrays.sort(str); // 字典序排序
        String bigStr = str[0] + str[1] + str[2];
        // SHA1加密
        String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();

        // 确认请求来自微信
        if (digest.equals(signature)){
            //对微信发送过来的信息进行操作
            String backXmlString = eventBiz.backXmlString(request);
            if ("".equals(backXmlString)){
                //如果不使用success，那么微信就会弹出来“公众号暂时不能服务”，不是很合适，所以建议都是返回success
                return "success";
            }else {
                return backXmlString;
            }
        } else { //错误
            throw new RspRuntimeException(RspCodeMsg.WEIXIN_URL_ERR, "链接不是来自微信");
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
}
