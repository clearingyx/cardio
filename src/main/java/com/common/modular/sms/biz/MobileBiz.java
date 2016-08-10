package com.common.modular.sms.biz;

import com.common.dao.auto.SmsDao;
import com.common.model.auto.SmsEntity;
import com.common.modular.sms.entity.Mobile;
import com.exception.base.RspRuntimeException;
import com.common.component.annotation.ApiRequest;
import com.common.component.resp.RspCodeMsg;
import com.util.ConnectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Random;

/**
 * Created by zhangpeng on 2016/8/8.
 * 短信业务
 */
@Controller
@RequestMapping("/sms")
public class MobileBiz {
    @Autowired
    SmsDao smsDao;

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
        //[0]result,[1]value,[2]resule_desc（例如返回0,201405071234,发送成功）
        String[] sms_back = str.split(",");
        //如果发送失败
        if (!"0".equals(sms_back[0])) {
            judgeStatus(sms_back[0]);
        } else {
            //短信插入数据库
            SmsEntity smsEntity = new SmsEntity();
            smsEntity.setMobile(mobiles);
            smsEntity.setContent(content);
            smsEntity.setValue(sms_back[1]);
            smsEntity.setCreateDate(new Date());
            int temp = smsDao.insertSelective(smsEntity);
            if (temp != 1) {
                //log
                throw new RspRuntimeException(RspCodeMsg.FAIL,"短信插入数据库失败！");
            }
        }
        return "success";
    }

    /**
     * 余额查询
     */
    @ApiRequest
    @RequestMapping("querySmsBalance")
    @ResponseBody
    public Object querySmsBalance(){
        Mobile mobile = Mobile.getMobile();

        StringBuffer url = new StringBuffer("http://115.29.47.5:8080/CxfSmsWs/service/SmsWebServices/queryBalance?");
        url = url .append("loginid=" +mobile.getLoginid()
                + "&loginpwd=" +mobile.getLoginpwd());
        //get方式提交
        String str = ConnectUtil.getConnectForGet(url.toString());

        //[0]result,[1]value,[2]resule_desc（例如返回0,100,查询成功）
        String[] sms_back = str.split(",");
        //如果发送失败
        if (!"0".equals(sms_back[0])) {
            judgeStatus(sms_back[0]);
        }
        return sms_back[1];
    }

    /**
     * 状态报告推送
     * 暂时没有用到，先不写
     */

    /**
     * 短信返回来的状态码进行异常抛出
     * @param res
     * @return
     */
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

    /**
     * 生成短信验证码
     * 这里最好需要redis对验证码进行2分钟的时效性验证，否则只能前端做验证
     * @param charCount
     * @return
     */
    public String getRandNum(int charCount) {
        String charValue = "";
        for (int i = 0; i < charCount; i++){
            Random r = new Random();
            char c = (char)(0 + r.nextInt(10 - 0)+'0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }



}
