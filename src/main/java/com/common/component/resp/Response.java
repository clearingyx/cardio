package com.common.component.resp;

/**
 * 接口返回 Response
 * 
 * @author song.chang
 * @create 2015年8月19日
 */
public class Response {

    public Response(String code) {
        this(code, null);
    }

    public Response(RspCodeMsg rsp) {
        this(rsp.getCode(), rsp.getMsg(), rsp.getStatus());
    }

    public Response(RspCodeMsg rsp, String msg) {
        // 如果 msg 为空，使用 rsp 的 msg，否则使用 msg
        this(rsp.getCode(), msg == null ? rsp.getMsg() : msg, rsp.getStatus());
    }

    public Response(String code, String msg) {
        this(code, msg, null);
    }

    public Response(String code, String msg, String status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    private String code;
    private String msg;
    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
