package com.common.model.biz;

import com.common.component.param.AbstractPageParam;
import com.google.common.base.Preconditions;

/**
 * Created by zhang.peng on 2016/8/17.
 */
public class NewsReq extends AbstractPageParam {
    private Integer type;
    private Integer riskLevel;
    private String openId;

    public Integer getType() {
        return type;
    }

    @Override
    public String getOpenId() {
        return openId;
    }

    @Override
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Override
    public void paramCheck() {
        Preconditions.checkNotNull(super.getOpenId(), "微信OpenID不能为空");
        Preconditions.checkNotNull(getType(), "资讯类型不能为空");
    }
}
