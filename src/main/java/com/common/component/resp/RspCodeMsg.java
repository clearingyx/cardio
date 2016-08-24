package com.common.component.resp;

/**
 * 响应码及说明定义
 *
 * @author song.chang
 * @create 2015年8月19日
 */
public enum RspCodeMsg {
    // 0 开头表示基本成功失败状态
    SUCCESS("200", "处理成功", "SUCCESS"), //
    FAIL("0001", "处理失败", "FAIL"), //
    SERVER_FAIL("500", "服务器错误", "FAIL"),
    NOT_FOUND_FAIL("404","页面没有找到", "FAIL"),
    NULL("0002", "结果为null", "FAIL"), //

    // 1 开头表示常见通用异常
    PARAM_CHECK_ERR("1001", "参数校验失败", "FAIL"), //
    DATE_REPEAT_ERR("1002","数据重复", "FAIL"),

    // 2-8 开头表示业务异常，建议每个开头，表示一个业务

    // 2 开头表示短信异常
    SMS_LOGIN_ERR("2001","用户名或密码错误", "FAIL"),
    SMS_CONTENT_ERR("2002","短信内容不能为空或超过指定字数", "FAIL"),
    SMS_SIGN_ERR("2003","短信签名应由2至10个英文、数字或汉字组成且不能为空", "FAIL"),
    SMS_MOBILE_ERR("2004","有效的发信号码不能为空", "FAIL"),
    SMS_SENDTIME_ERR("2005","定时发送时间格式错误", "FAIL"),
    SMS_BALANCE_ERR("2006","余额不足请充值后使用", "FAIL"),
    SMS_OTHER_ERR("2007","短信其他错误", "FAIL"),

    // 3 微信错误
    WEIXIN_URL_ERR("3001","链接不是来自微信", "FAIL"),
    WEIXIN_REG_ERR("3002","微信信息插入数据库失败", "FAIL"),
    WEIXIN_SOURCE_ERR("3003","链接不是来自微信", "FAIL"),
    WEIXIN_QRCODE_ERR("3004","微信二维码参数错误", "FAIL"),
    WEIXIN_OPENID_ERR("3005","openid不能为空", "FAIL"),

    // 4 测评错误
    RISK_PARAMS_ERR("4001","测评结果参数出错", "FAIL"),

    // 5 答题参数错误
    QUESTION_PARAMS_ERR("5001","答题参数错误", "FAIL"),

    // 9 开头表示系统、框架、模板异常
    UNKNOWN_ERR("9999", "未知错误", "FAIL"); //

    private String code;
    private String msg;
    private String status;

    RspCodeMsg(String code, String msg, String status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "RspCodeMsg{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
