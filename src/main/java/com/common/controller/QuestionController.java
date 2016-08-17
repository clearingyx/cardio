package com.common.controller;

import com.common.component.resp.RspCodeMsg;
import com.common.dao.biz.PersonBizDao;
import com.common.model.auto.PersonQuestionEntity;
import com.common.model.biz.RiskReq;
import com.common.modular.risk.RiskBiz;
import com.common.service.PersonQuestionService;
import com.exception.base.RspRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by zhang.peng on 2016/8/15.
 * 答题相关控制
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    RiskBiz riskBiz;
    @Autowired
    PersonQuestionService personQuestionSrvice;
    @Autowired
    PersonBizDao personBizDao;



    /**
     * 答题
     * @param openid，回答人的openid
     * @param session，存入题目
     * @param model，返回person_id
     * @param page，答题当前页码
     * @return
     */
    @RequestMapping("answer")
    public String answer(PersonQuestionEntity person, HttpSession session, Model model,
                         Integer page){
        session.setAttribute("person"+page,person);
        model.addAttribute("openid",person.getOpenId());
        if (page == 5) {
            //已经到了最后一页码，将session进行封装计算
            RiskReq riskReq = jumpRisk(session, person.getOpenId());
            model.addAttribute("risk",riskReq);
            return "weixin/result.jsp";
        } else {
            return "weixin/question"+(page+1)+".jsp";
        }
    }

    /**
     * 处理答题结果
     * @param session
     * @return
     */
    public RiskReq jumpRisk(HttpSession session, String openid){
        for(int i = 1; i <= 5; i++){
            if(session.getAttribute("person" + i) == null){
                throw new RspRuntimeException(RspCodeMsg.QUESTION_PARAMS_ERR,"答题参数错误");
            }
        }
        PersonQuestionEntity person  = new PersonQuestionEntity();

        PersonQuestionEntity p1 = (PersonQuestionEntity)session.getAttribute("person1");
        person.setAge(p1.getAge());
        person.setGender(p1.getGender());
        person.setWeight(p1.getWeight());
        person.setHeight(p1.getHeight());

        PersonQuestionEntity p2 = (PersonQuestionEntity)session.getAttribute("person2");
        person.sethSmk(p2.gethSmk());
        person.sethDrink(p2.gethDrink());
        person.setDiet(p2.getDiet());
        person.setActivity(p2.getActivity());
        person.setStress(p2.getStress());
        person.setFamilys(p2.getFamilys());

        PersonQuestionEntity p3 = (PersonQuestionEntity)session.getAttribute("person3");
        person.setSbp(p3.getSbp());
        person.setHyprx(p3.getHyprx());
        person.setTc(p3.getTc());
        person.setLdl(p3.getLdl());

        PersonQuestionEntity p4 = (PersonQuestionEntity)session.getAttribute("person4");
        person.sethDiab(p4.gethDiab());
        person.setCvd(p4.getCvd());
        person.setLvh(p4.getLvh());
        person.setAf(p4.getAf());

        PersonQuestionEntity p5 = (PersonQuestionEntity)session.getAttribute("person5");
        person.setCognitive(p5.getCognitive());
        person.setPoorMemory(p5.getPoorMemory());
        person.setInjury(p5.getInjury());
        person.setMiniStroke(p5.getMiniStroke());

        person.setCreateDate(new Date());
        person.setOpenId(openid);
        return riskBiz.risk(person);
    }
}
