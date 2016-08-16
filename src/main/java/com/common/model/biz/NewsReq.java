package com.common.model.biz;

import com.common.component.param.AbstractPageParam;
import com.google.common.base.Preconditions;

/**
 * Created by zhang.peng on 2016/8/15.
 */
public class NewsReq extends AbstractPageParam {
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 验证前端参数
     */
    @Override
    public void paramCheck() {
        Preconditions.checkNotNull(super.getOpenId(), "微信OpenID不能为空");
    }
}
