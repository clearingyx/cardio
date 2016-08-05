package com.exception;

import com.exception.base.RspRuntimeException;
import com.other.resp.RspCodeMsg;

/**
 * 参数检验异常，属于框架的异常
 * 
 * @author song.chang
 * @create 2015年7月9日
 */
public class ParamCheckException extends RspRuntimeException {

    private static final long serialVersionUID = -26123892338334081L;

    // 默认异常返回码
    private static RspCodeMsg defaultCodeMsg = RspCodeMsg.PARAM_CHECK_ERR;

    public ParamCheckException() {
        super(defaultCodeMsg);
    }

    public ParamCheckException(String message) {
        super(defaultCodeMsg, message);
    }

    public ParamCheckException(String message, Throwable cause) {
        super(defaultCodeMsg, message, cause);
    }

    public ParamCheckException(Throwable cause) {
        super(defaultCodeMsg, cause);
    }

    public ParamCheckException(RspCodeMsg codeMsg) {
        super(codeMsg);
    }

    public ParamCheckException(RspCodeMsg codeMsg, String message) {
        super(codeMsg, message);
    }

    public ParamCheckException(RspCodeMsg codeMsg, String message, Throwable cause) {
        super(codeMsg, message, cause);
    }

    public ParamCheckException(RspCodeMsg codeMsg, Throwable cause) {
        super(codeMsg, cause);
    }
}
