package com.common.model.biz;

import com.common.model.auto.User;
import com.other.resp.PageResp;

import java.util.List;

/**
 * 向页面返回的对象是UserGet对象，是数据库对应的User类的List集合，并且继承了Page分页类
 * ps：从前端获得的User对象，是UserSet对象
 */
public class UserResp extends PageResp{
    private List<User> userList ;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
