package com.common.service;

import com.common.component.resp.RspCodeMsg;
import com.common.dao.auto.PersonDao;
import com.common.dao.biz.PersonBizDao;
import com.common.model.auto.PersonEntity;
import com.exception.base.RspRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhang.peng on 2016/8/4.
 */
@Service
public class PersonService {
    @Autowired
    PersonDao personDao;
    @Autowired
    PersonBizDao personBizDao;

    /**
     * 公众号关注事务
     * @return risk_level，需要判断4个视频取哪个
     */
    public int insertSelectiveRetrunRisk(PersonEntity personEntity){
        //数据库判断成功与否的临时变量
        int temp;

        //查看是否存在原用户
        PersonEntity oldPersonEntity = personBizDao.selectPersonByOpenid(personEntity.getOpenId());
        //该用户存在，会进行update操作
        if (oldPersonEntity != null) {

            personEntity.setId(oldPersonEntity.getId());

            //电话不等于null和空说明已经注册过了
            //这次又是关注，说明之前取消关注过。取消关注状态为2，此时将状态设为0
            if(oldPersonEntity.getPhone() != null && !"".equals(oldPersonEntity.getPhone())){
                personEntity.setUseStatus(0);
                //测评结果不等于-1说明已经测评过了，状态设为1
                if(oldPersonEntity.getRiskLevel() != -1){
                    personEntity.setUseStatus(1);
                }
            }//end if 判断user_state

            //更新
            temp = personDao.updateByPrimaryKeySelective(personEntity);
            if (temp != 1){
                throw new RspRuntimeException(RspCodeMsg.FAIL,"数据库修改用户信息失败");
            }

            //返回已经存在的用户的危险等级
            return oldPersonEntity.getRiskLevel();
        }
        //该用户不存在，进行insert操作,type已经默认是0了
        else {
            //插入
            temp = personDao.insertSelective(personEntity);
            if (temp != 1){
                throw new RspRuntimeException(RspCodeMsg.FAIL,"新建用户插入数据库失败");
            }
            return -1;
        }
    }
}
