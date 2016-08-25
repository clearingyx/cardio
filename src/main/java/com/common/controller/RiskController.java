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
        RiskReq riskReq = (RiskReq)map.get("riskReq");
        model.addAttribute("risk",riskReq);
        model.addAttribute("riskLevel",riskReq.getRisk_level());
        model.addAttribute("openId",openId);
        if(riskReq.getRisk_level() == 0){
            return "weixin/result/result-green.jsp";
        } else if(riskReq.getRisk_level() == 1) {
            return "weixin/result/result-yellow.jsp";
        } else if(riskReq.getRisk_level() == 2) {
            return "weixin/result/result-orange.jsp";
        } else {
            return "weixin/result/result-red.jsp";
        }
    }
}
