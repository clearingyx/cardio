package com.other.aspect;

import com.exception.base.RspRuntimeException;
import com.other.resp.RspCodeMsg;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 切面复用工具类
 * 
 * @author song.chang
 * @create 2015年10月27日
 */
public class AspectUtils {

    /**
     * 获取监控的Key
     *
     * @author song.chang
     * @param pjp
     * @param tag
     * @return
     */
    public static String getMonitorKey(ProceedingJoinPoint pjp, String tag) {
        Signature signature = pjp.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) signature;
            // 此处需要考虑一下性能问题
            // mapping 方法对应的 类全名 + 方法名
            return tag + "#" + methodSignature.getDeclaringTypeName() + "#" + methodSignature.getName();
        }
        return "NONE_Interface_MonitorKey";
    }


    /**
     * 从 Exception 中获取 codeMsg，如果没有则返回 UNKNOWN_ERR
     *
     * @param e
     * @return
     */
    public static RspCodeMsg getExceptionRsp(Exception e) {
        RspCodeMsg rsp = null;
        if (e instanceof RspRuntimeException) {
            rsp = ((RspRuntimeException) e).getCodeMsg();
        } else if (e instanceof RspRuntimeException) {
            rsp = ((RspRuntimeException) e).getCodeMsg();
        }
        if (rsp == null) {
            rsp = RspCodeMsg.UNKNOWN_ERR;
        }
        return rsp;
    }

}
