package com.common.mobile.biz;

import com.common.mobile.entity.Mobile;
import com.exception.base.RspRuntimeException;
import com.common.other.annotation.ApiRequest;
import com.common.other.resp.RspCodeMsg;
import com.util.ConnectUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangpeng on 2016/8/8.
 * 短信业务
 */
@Controller
@RequestMapping("/sms")
public class MobileBiz {

    /**
     * 发送短信
     * @param content
     * @param mobiles
     * @param sendtime
     */
    @ApiRequest
    @RequestMapping(value = "sendSms", method = RequestMethod.GET)
    @ResponseBody
    public Object sendSms(String content, String mobiles, String sendtime){
        Mobile mobile = Mobile.getMobile();

        //发送短信的url
        StringBuffer url = new StringBuffer("http://115.29.47.5:8080/CxfSmsWs/service/SmsWebServices/sendSms?");
        url = url .append("loginid=" +mobile.getLoginid()
                + "&loginpwd=" +mobile.getLoginpwd()
                + "&content=" +content+ "&sign="+mobile.getSign()+"&mobiles="+mobiles);
        if (null != sendtime && !"".equals(sendtime)){
            url = url.append("&sendtime=" + sendtime);
        }

        //get方式提交
        String str = ConnectUtil.getConnectForGet(url.toString());
        String[] s = str.split(",");
        if (!"0".equals(s[0])) {
            judgeStatus(s[0]);
        }
        return "success";
    }

    public String judgeStatus(String res){
        if("1".equals(res)){
            throw new RspRuntimeException(RspCodeMsg.SMS_LOGIN_ERR, "短信发送用户名或密码错误");
        } else if ("2".equals(res)) {
            throw new RspRuntimeException(RspCodeMsg.SMS_CONTENT_ERR, "短信内容不能为空或超过指定字数");
        } else if ("3".equals(res)) {
            throw new RspRuntimeException(RspCodeMsg.SMS_SIGN_ERR, "短信签名应由2至10个英文、数字或汉字组成且不能为空");
        } else if ("4".equals(res)) {
            throw new RspRuntimeException(RspCodeMsg.SMS_MOBILE_ERR, "有效的发信号码不能为空");
        } else if ("5".equals(res)) {
            throw new RspRuntimeException(RspCodeMsg.SMS_SENDTIME_ERR, "定时发送时间格式错误");
        } else if ("6".equals(res)) {
            throw new RspRuntimeException(RspCodeMsg.SMS_BALANCE_ERR, "余额不足请充值后使用");
        } else if ("101".equals(res) || "102".equals(res) || "103".equals(res) || "104".equals(res) ||
                "105".equals(res) || "106".equals(res) || "107".equals(res) || "108".equals(res)) {
            throw new RspRuntimeException(RspCodeMsg.SMS_OTHER_ERR, "短信其他错误");
        }
        return "fail";
    }
}
