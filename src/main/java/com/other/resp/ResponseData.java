package com.other.resp;

/**
 * 接口返回 ResponseData
 * 
 * @author song.chang
 * @create 2015年8月19日
 */
public class ResponseData extends Response {

    private Object data;

    public ResponseData(String code, Object data) {
        this(code, null, data);
    }

    public ResponseData(RspCodeMsg rsp, Object data) {
        this(rsp.getCode(), rsp.getMsg(), data);
    }

    public ResponseData(String code, String msg, Object data) {
        super(code, msg);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
