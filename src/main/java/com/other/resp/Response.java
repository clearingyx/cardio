package com.other.resp;

/**
 * 接口返回 Response
 * 
 * @author song.chang
 * @create 2015年8月19日
 */
public class Response {
    public static final String DEFAULT_VERSION = "1.0";

    public Response(String code) {
        this(code, null, DEFAULT_VERSION);
    }

    public Response(RspCodeMsg rsp) {
        this(rsp.getCode(), rsp.getMsg(), DEFAULT_VERSION);
    }

    public Response(RspCodeMsg rsp, String msg) {
        // 如果 msg 为空，使用 rsp 的 msg，否则使用 msg
        this(rsp.getCode(), msg == null ? rsp.getMsg() : msg, DEFAULT_VERSION);
    }

    public Response(String code, String msg) {
        this(code, msg, DEFAULT_VERSION);
    }

    public Response(String code, String msg, String ver) {
        this.code = code;
        this.msg = msg;
        this.ver = ver;
    }

    private String code;
    private String msg;
    private String ver;

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

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }
}
