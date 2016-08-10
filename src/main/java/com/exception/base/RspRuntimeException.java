package com.exception.base;


import com.common.component.resp.RspCodeMsg;

/**
 * RC unchecked 异常基类，可以存储RspCodeMsg
 * RuntimeException不是运行时异常，不用抛出，直接返回到前台
 * @author song.chang
 * @create 2015年8月19日
 */
public class RspRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 87012420802149927L;

    // 子类需要设置一个默认的异常返回状态码
    protected RspCodeMsg codeMsg;

    public RspRuntimeException(RspCodeMsg codeMsg) {
        super(codeMsg.getMsg());
        this.codeMsg = codeMsg;
    }

    public RspRuntimeException(RspCodeMsg codeMsg, String message) {
        super(message);
        this.codeMsg = codeMsg;
    }

    public RspRuntimeException(RspCodeMsg codeMsg, String message, Throwable cause) {
        super(message, cause);
        this.codeMsg = codeMsg;
    }

    public RspRuntimeException(RspCodeMsg codeMsg, Throwable cause) {
        super(cause);
        this.codeMsg = codeMsg;
    }

    public RspCodeMsg getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(RspCodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }
}
