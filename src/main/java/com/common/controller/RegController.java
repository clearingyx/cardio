package com.common.controller;

import com.common.component.resp.RspCodeMsg;
import com.common.dao.biz.PersonBizDao;
import com.common.model.auto.PersonEntity;
import com.exception.base.RspRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhang.peng on 2016/8/8.
 * 用户注册
 */
@Controller
@RequestMapping("/reg")
public class RegController {
    @Autowired
    PersonBizDao personBizDao;

    /**
     *
     * @param phone,openid
     * @return
     */
    @RequestMapping(value = "reg",method = RequestMethod.POST)
    public Object regPerson(PersonEntity personEntity, Model model){
        //这里需要验证一下电话


//        String address = null;
//        try {
//            //返回参数String-->(省，市)
//            address = MobileUtil.getMobileLocation(phone);
//            if (address.contains(",")){
//                //throw new RspRuntimeException(RspCodeMsg.PHONE_TO_ADDRESS_ERR,"无此号记录");
//
//            }
//        } catch (Exception e) {
//            throw new RspRuntimeException(RspCodeMsg.PHONE_TO_ADDRESS_ERR,"注册电话解析省市失败");
//        }
//        String[] addresses = address.split(",");
//        personEntity.setProvince(addresses[0]);
//        personEntity.setCity(addresses[1]);
        int temp = personBizDao.updatePersonByOpenid(personEntity);
        if (temp != 1){
            throw new RspRuntimeException(RspCodeMsg.FAIL,"根据微信openid添加用户电话失败");
        } else {
            PersonEntity person = personBizDao.selectPersonByOpenid(personEntity.getOpenId());
            //跳转到答题页面
            model.addAttribute("openId", person.getOpenId());
            return "weixin/question1.jsp";
        }
    }
}
