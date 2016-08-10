package com.common.model.biz;

import com.google.common.base.Preconditions;
import com.common.component.param.AbstractPageParam;

/**
 * 从前端获得的User对象，将需要的参数整合成UserSet对象，继承了参数验证类，实现了参数验证方法
 * ps：向页面返回的对象是UserGet对象
 */
public class UserReq extends AbstractPageParam{
    private String userName;
    private String password;

    /**
     * 验证前端参数
     */
    @Override
    public void paramCheck() {
        Preconditions.checkNotNull(super.getOpenId(), "微信OpenID不能为空");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
