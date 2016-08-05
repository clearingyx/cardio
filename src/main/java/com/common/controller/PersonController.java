package com.common.controller;

import com.common.dao.auto.PersonDao;
import com.common.model.auto.PersonEntity;
import com.common.model.auto.PersonExample;
import com.other.annotation.ApiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 用户（person）的各项操作
 * Created by zhangpeng on 2016/7/28.
 */
@Controller
@RequestMapping("/person")
public class PersonController extends BaseController{
    @Autowired
    PersonDao personDao;

    /**
     * 新增 关注用户（这是微信发送回来的数据）
     * @param nickname，openid，sex，city，province，country
     * @return success or error
     */
    @ApiRequest
    @RequestMapping("wxinsert")
    @ResponseBody
    public Object insert(PersonEntity person){
        person.setCreateDate(new Date());
        return personDao.insertSelective(person)==1?SUCCESS:ERROR;
    }

    @RequestMapping("list")
    @ResponseBody
    public Object list(PersonExample personExample){
        return personDao.selectByExample(personExample);
    }

    @RequestMapping("insert")
    @ResponseBody
    public Object insert(){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setSource(1);
        return personDao.insertSelective(personEntity);
    }
}
