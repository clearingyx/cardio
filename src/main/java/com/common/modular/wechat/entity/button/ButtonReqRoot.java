package com.common.modular.wechat.entity.button;

import java.util.List;

/**
 * Created by zhang.peng on 2016/8/4.
 * 菜单总类
 */
public class ButtonReqRoot {
    private List<ButtonReq> buttonReq ;

    public void setButton(List<ButtonReq> buttonReq){
        this.buttonReq = buttonReq;
    }
    public List<ButtonReq> getButton(){
        return this.buttonReq;
    }

    public ButtonReqRoot(List<ButtonReq> buttonReq) {
        this.buttonReq = buttonReq;
    }

    public ButtonReqRoot() {
    }

    @Override
    public String toString() {
        return "ButtonReqRoot{" +
                "buttonReq=" + buttonReq +
                '}';
    }
}
