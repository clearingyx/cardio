package com.common.service;

import com.common.component.resp.RspCodeMsg;
import com.common.dao.auto.PersonDao;
import com.common.dao.auto.PersonQuestionDao;
import com.common.dao.biz.PersonQuestionBizDao;
import com.common.model.auto.PersonEntity;
import com.common.model.auto.PersonQuestionEntity;
import com.exception.base.RspRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhang.peng on 2016/8/10.
 */
@Service
public class PersonQuestionService {
    @Autowired
    PersonQuestionBizDao personQuestionBizDao;
    @Autowired
    PersonQuestionDao personQuestionDao;
    @Autowired
    PersonDao personDao;

    public void saveRisk(PersonQuestionEntity personQuestionEntity,int risk_level){
        //定义临时变量
        int temp = 0;

        //通过用户id查看该用户是否已经测评过
        PersonQuestionEntity question = personQuestionBizDao.selectByPersonId(personQuestionEntity.getPersonId());
        //没有测评过
        if(question == null){
            temp = personQuestionDao.insert(personQuestionEntity);
            if(temp != 1) {
                throw new RspRuntimeException(RspCodeMsg.FAIL,"插入用户测评结果失败");
            }
        } else {
            //已经测评过，重新测评
            personQuestionEntity.setId(question.getId());
            temp = personQuestionDao.updateByPrimaryKey(personQuestionEntity);
            if(temp != 1) {
                throw new RspRuntimeException(RspCodeMsg.FAIL,"更新用户测评结果失败");
            }
        }

        //插入测评以后更新用户的危险等级
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(personQuestionEntity.getPersonId());
        personEntity.setRiskLevel(risk_level);

        temp = personDao.updateByPrimaryKeySelective(personEntity);
        if (temp != 1) {
            throw new RspRuntimeException(RspCodeMsg.FAIL,"更新用户危险等级失败");
        }
    }
}
