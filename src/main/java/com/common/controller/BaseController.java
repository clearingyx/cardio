package com.common.controller;

import com.common.model.biz.NewsReq;
import com.sun.javafx.sg.PGShape;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangpeng on 2016/7/25.
 * 定义常量，Controller继承该类
 */
@Controller
@RequestMapping("/base")
public class BaseController {

    final static String SUCCESS = "success";
    final static String ERROR = "error";
    final static String REPEAT = "repeat";
    final static String FAIL = "fail";


    @RequestMapping("test")
    public String test(String openId, Model model){
        model.addAttribute("openId", openId);
        return "weixin/shouye/index.jsp";
    }

    @RequestMapping("pageZc")
    public String pageZc(String openId, Model model){
        model.addAttribute("openId", openId);
        return "weixin/page-zc/zhccg.jsp";
    }

    @RequestMapping("pageText")
    public String pageText(String openId, Model model){
        model.addAttribute("openId", openId);
        return "weixin/page-test/test.jsp";
    }

    @RequestMapping("green")
    public String green(){
        return "weixin/result/result-green.jsp";
    }

}
