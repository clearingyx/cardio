package com.common.controller;

import com.common.component.annotation.ApiRequest;
import com.common.component.resp.RspCodeMsg;
import com.common.dao.auto.RandomQuestionDao;
import com.common.dao.auto.RandomQuestionRecordDao;
import com.common.dao.biz.RandomQuestionBizDao;
import com.common.model.auto.RandomQuestionEntity;
import com.common.model.auto.RandomQuestionRecordEntity;
import com.exception.base.RspRuntimeException;
import com.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;


/**
 * Created by zhang.peng on 2016/8/12.
 */
@Controller
@RequestMapping("/randomQuestion")
public class RandomQuestionController extends BaseController{
    @Autowired
    RandomQuestionDao randomQuestionDao;
    @Autowired
    RandomQuestionBizDao randomQuestionBizDao;
    @Autowired
    RandomQuestionRecordDao randomQuestionRecordDao;

    /**
     * 随机2道题，返回试题页面的
     * @return
     */
    @RequestMapping("randomTwoQuestion")
    public String radomTwoQuestion(Model model, Integer md_id ,String openId){
        List<RandomQuestionEntity> list = randomQuestionBizDao.selectTwoRandomQuestion(md_id);
        model.addAttribute("list",list);
        model.addAttribute("openId",openId);
        return "weixin/tv/page-tv.jsp";
    }

    /**
     * 随机试题回答
     */
//    @ApiRequest
    @ResponseBody
    @RequestMapping(value = "anwser", method = RequestMethod.GET)
    public void radomQuestionAnwser(String question_1, String question_2, Integer id_1,
                                    Integer id_2, String openId, HttpServletRequest request,
                                    HttpServletResponse response, PrintWriter out){
        String callback = request.getParameter("callback");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        RandomQuestionRecordEntity question = new RandomQuestionRecordEntity();
        question.setOpenId(openId);
        question.setCreateDate(new Date());

        question.setPersonAnwser(question_1);
        question.setQuestionId(id_1);
        int temp = randomQuestionRecordDao.insertSelective(question);

        question.setPersonAnwser(question_2);
        question.setQuestionId(id_2);
        temp = temp + randomQuestionRecordDao.insertSelective(question);

        String json;

        if(temp > 0){
            json = "{\"code\": \"200\",\"data\": {\"data\": \"success\"},\"msg\": \"\",\"status\": \"SUCCESS\"}";
            out.print(callback + "(" + json + ")");
        } else {
            json = "{\"code\": \"500\",\"data\": {\"data\": \"fail\"},\"msg\": \"服务器错误\",\"status\": \"FAIL\"}";
            out.print(callback + "(" + json + ")");
        }
    }

}
