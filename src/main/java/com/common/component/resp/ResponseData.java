package com.common.component.resp;

/**
 * 接口返回 ResponseData
 * 
 * @author song.chang
 * @create 2015年8月19日
 */
public class ResponseData extends Response {

    private Object data;

    public ResponseData(String code, String status, Object data) {
        this(code, "", status, data);
    }

    public ResponseData(RspCodeMsg rsp, Object data) {
        this(rsp.getCode(), rsp.getMsg().equals("处理成功")?"":rsp.getMsg(), rsp.getStatus(), data);
    }

    public ResponseData(String code, String msg, String status, Object data) {
        super(code, msg, status);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
