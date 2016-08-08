package com.common.service;

import com.common.dao.auto.PersonDao;
import com.common.dao.biz.PersonBizDao;
import com.common.model.auto.PersonEntity;
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

    //公众号关注事物
    public int insertSelective(PersonEntity personEntity){
        int temp = 0;
        //查看是否存在原用户
        PersonEntity oldPersonEntity = personBizDao.selectPersonByOpenid(personEntity.getOpenid());

        if (oldPersonEntity != null){   //该用户存在
            personEntity.setId(oldPersonEntity.getId());

            //电话不等于null和空说明已经注册过了，状态是0
            if(oldPersonEntity.getPhone() != null && !"".equals(oldPersonEntity.getPhone())){
                personEntity.setUseStatus(0);
                //测评结果不等于-1说明已经测评过了，状态是1
                if(oldPersonEntity.getRiskLevel() != -1){
                    personEntity.setUseStatus(1);
                }
            }//end if 判断user_state

            personEntity.setCreateDate(null);//取消本次的关注时间
            //更新
            temp = personDao.updateByPrimaryKeySelective(personEntity);
            if (temp == 0){
                //log
            }
        } else {    //该用户不存在
            //插入
            temp = personDao.insertSelective(personEntity);
            if (temp == 0){
                //log
            }
        }
        return temp;
    }
}
