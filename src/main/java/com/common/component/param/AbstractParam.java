package com.common.component.param;


/**
 * 抽象参数，所有 api 接口的参数必须继承该类
 * 
 * @author song.chang
 * @create 2015年8月19日
 */
public abstract class AbstractParam {
    private String traceId;
    private String caller;
    private String authToken;
    private String openId; // 微信OpenID

    /**
     * 参数校验，子类如果需要参数校验，必须复写该方法 如果校验失败，抛出一个的异常(可是任意异常，建议ParamCheckException)，异常的 msg 为错误提示
     */
    public abstract void paramCheck();

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
