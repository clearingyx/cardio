package com.other.resp;

/**
 * 响应码及说明定义
 *
 * @author song.chang
 * @create 2015年8月19日
 */
public enum RspCodeMsg {
    // 0 开头表示基本成功失败状态
    SUCCESS("0000", "处理成功"), //
    FAIL("0001", "处理失败"), //
    NULL("0002", "结果为null"), //

    // 1 开头表示常见通用异常
    PARAM_CHECK_ERR("1001", "参数校验失败"), //

    // 2-8 开头表示业务异常，建议每个开头，表示一个业务

    // 9 开头表示系统、框架、模板异常
    UNKNOWN_ERR("9999", "未知错误"); //

    private String code;
    private String msg;

    RspCodeMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code搜索RspCodeMsg实例
     *
     * @param code 状态码
     * @return 状态实例，可能为null
     */
    public static RspCodeMsg find(String code) {
        RspCodeMsg result = null;
        for (RspCodeMsg rsp : RspCodeMsg.values()) {
            if (rsp.getCode().equals(code)) {
                result = rsp;
            }
        }
        return result;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return code + "-" + msg;
    }
}
