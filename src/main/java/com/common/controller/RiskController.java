package com.common.controller;

import com.common.dao.biz.PersonBizDao;
import com.common.dao.biz.PersonQuestionBizDao;
import com.common.model.auto.PersonEntity;
import com.common.model.auto.PersonQuestionEntity;
import com.common.model.biz.RiskReq;
import com.common.modular.risk.RiskBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by zhang.peng on 2016/8/23.
 */
@Controller
@RequestMapping("/riskJump")
public class RiskController {
    @Autowired
    RiskBiz riskBiz;
    @Autowired
    PersonQuestionBizDao personQuestionBizDao;
    @Autowired
    PersonBizDao personBizDao;

    @RequestMapping("myRisk")
    public String myRisk(String openId, Model model){
        PersonQuestionEntity personQuestion =
                personQuestionBizDao.selectLastQuestionByOpenId(openId);
        Map map = riskBiz.risk(personQuestion);
        model.addAttribute("risk",(RiskReq)map.get("riskReq"));
        return "weixin/result.jsp";
    }
}
