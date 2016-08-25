package com.common.controller;

import com.common.component.resp.RspCodeMsg;
import com.common.dao.biz.PersonBizDao;
import com.common.model.auto.PersonQuestionEntity;
import com.common.model.biz.RiskReq;
import com.common.modular.redis.biz.CourseUrlWithRedis;
import com.common.modular.risk.RiskBiz;
import com.common.modular.wechat.biz.EventBiz;
import com.common.modular.wechat.entity.Course;
import com.common.service.PersonQuestionService;
import com.exception.base.RspRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

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
    @Autowired
    PersonQuestionService personQuestionService;
    @Autowired
    CourseUrlWithRedis courseUrlWithRedis;

    /**
     * 跳转答题第一页
     * @param openId
     * @param model
     * @return
     */
    @RequestMapping("jumpPageOne")
    public String jumpPageOne(String openId, Model model){
        model.addAttribute("openId", openId);
        return "weixin/page-one/page-one.jsp";
    }

    /**
     * 答题
     * @param person，回答人的openId
     * @param session，存入题目
     * @param model，返回person_id
     * @param page，答题当前页码
     * @return
     */
    @RequestMapping("answer")
    public String answer(PersonQuestionEntity person, HttpSession session, Model model,
                         Integer page){
        session.setAttribute("person"+page,person);
        model.addAttribute("openId",person.getOpenId());
        if (page == 5) {
            //已经到了最后一页码，将session进行封装计算
            RiskReq riskReq = jumpRisk(session, person.getOpenId());
            model.addAttribute("risk",riskReq);
            model.addAttribute("riskLevel",riskReq.getRisk_level());
            //begin if
            if(riskReq.getRisk_level() == 0){
                return "weixin/result/result-green.jsp";
            } else if(riskReq.getRisk_level() == 1) {
                return "weixin/result/result-yellow.jsp";
            } else if(riskReq.getRisk_level() == 2) {
                return "weixin/result/result-orange.jsp";
            } else {
                return "weixin/result/result-red.jsp";
            }
            //end if
        } else if (page == 1) {
            return "weixin/page-two/page-two.jsp";
        } else if (page == 2) {
            return "weixin/page-three/page-three.jsp";
        } else if (page == 3) {
            return "weixin/page-four/page-four.jsp";
        } else if (page == 4) {
            return "weixin/page-five/page-five.jsp";
        } else {
            throw new RspRuntimeException(RspCodeMsg.PARAM_CHECK_ERR,"参数page不能为1-5之外的值");
        }
    }

    /**
     * 答题返回上一页
     * @param openId
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("backPage")
    public String backPage(String openId, Integer page, Model model){
        model.addAttribute("openId",openId);
        if (page == 2) {
            return "weixin/page-one/page-one.jsp";
        } else if (page == 3) {
            return "weixin/page-two/page-two.jsp";
        } else if (page == 4) {
            return "weixin/page-three/page-three.jsp";
        } else if (page == 5) {
            return "weixin/page-four/page-four.jsp";
        } else {
            throw new RspRuntimeException(RspCodeMsg.PARAM_CHECK_ERR,"参数page不能为1-5之外的值");
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

        Map map = riskBiz.risk(person);
        //得到测评等级结果，insert person_question 并且 update person，走事务，已经都抛出异常了
        RiskReq riskReq = (RiskReq)map.get("riskReq");
        personQuestionService.saveRisk((PersonQuestionEntity)map.get("personQuestion"),
                riskReq.getRisk_level());
        return riskReq;
    }

    /**
     * 结果页面的跳转
     * @param flag，标志是第几页，一共有3页，第一页不用判断，不是这里跳
     * @param riskLevel
     * @param openId
     * @return
     */
    @RequestMapping("result")
    public String result(Integer flag, Integer riskLevel, String openId, Model model){
        model.addAttribute("openId", openId);
        model.addAttribute("riskLevel", riskLevel);
        if(flag == 1) {
            if(riskLevel == 0) {
                return "weixin/result/result-green1.jsp";
            } else if(riskLevel == 1) {
                return "weixin/result/result-yellow1.jsp";
            } else if(riskLevel == 2) {
                return "weixin/result/result-orange1.jsp";
            } else {
                return "weixin/result/result-red1.jsp";
            }
        } else {
            //判断是否是视频
            Course course = courseUrlWithRedis.takeOutCourseByOpenid(openId);
            if(null != course && null != course.getCourseId()){
                String url = new EventBiz().getImageTextUrl(course);
                model.addAttribute("url", url);
            } else {
                model.addAttribute("url","");
            }
            if(riskLevel == 0) {
                return "weixin/result/result-green2.jsp";
            } else if(riskLevel == 1) {
                return "weixin/result/result-yellow2.jsp";
            } else if(riskLevel == 2) {
                return "weixin/result/result-orange2.jsp";
            } else {
                return "weixin/result/result-red2.jsp";
            }
        }
    }

    /*
     * 下面两个方法是试题总体测试用
     */
    @RequestMapping("risk")
    public String risk(String openId, Model model){
        model.addAttribute("openId", openId);
        return "weixin/question_all_test.jsp";
    }

    @RequestMapping("allTest")
    public String allTest(PersonQuestionEntity person, Model model ,String openId){
        Map map = riskBiz.risk(person);
        RiskReq riskReq = (RiskReq)map.get("riskReq");
        model.addAttribute("risk",riskReq);
        model.addAttribute("riskLevel",riskReq.getRisk_level());
        model.addAttribute("openId",openId);

        personQuestionService.saveRisk((PersonQuestionEntity)map.get("personQuestion"),
                riskReq.getRisk_level());

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
