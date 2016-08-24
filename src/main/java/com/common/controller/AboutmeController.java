package com.common.controller;

import com.common.component.resp.RspCodeMsg;
import com.common.dao.auto.AboutmeDao;
import com.common.model.auto.AboutmeEntity;
import com.common.model.auto.AboutmeExample;
import com.exception.base.RspRuntimeException;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by zhang.peng on 2016/8/24.
 */
@Controller
@RequestMapping("aboutme")
public class AboutmeController {
    @Autowired
    AboutmeDao aboutmeDao;

    @RequestMapping("page")
    public String page(Model model){
        RowBounds rowBounds = new RowBounds(0,1);
        AboutmeExample example = new AboutmeExample();
        example.setOrderByClause("id desc");
        List<AboutmeEntity> aboutlist = aboutmeDao.selectByExampleWithBLOBsWithRowbounds(example, rowBounds);
        if(aboutlist.size() >0 ){
            model.addAttribute("content", aboutlist.get(0).getContents());
            return "weixin/page-jlb/page-jlb.jsp";
        } else {
            throw new RspRuntimeException(RspCodeMsg.FAIL,"关于我们查找出错");
        }
    }
}
