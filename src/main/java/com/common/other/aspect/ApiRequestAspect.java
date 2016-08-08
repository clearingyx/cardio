package com.common.other.aspect;

import com.exception.ParamCheckException;
import com.common.other.param.AbstractParam;
import com.common.other.resp.Response;
import com.common.other.resp.ResponseData;
import com.common.other.resp.RspCodeMsg;
import com.util.LogUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 请求切面，完成接口的参数校验，处理异常捕获，日志记录，返回结果封装。
 * <p>
 * 顺序为 0 先执行
 * 
 * @author song.chang
 * @create 2015年8月19日
 */
@Aspect
//@Order(0)
@Component
public class ApiRequestAspect {

    /**
     * 定义 api 接口的切面，方法上有 ApiRequest 注解
     */
    @Pointcut("@annotation(com.common.other.annotation.ApiRequest)")
    public void apiReqAspect() {
    }

    /**
     * api 接口需要对结果进行封装
     * 
     * @author song.chang
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("apiReqAspect()")
    public Object doApiReqAspect(ProceedingJoinPoint pjp) throws Throwable {
        Object result = doReqAspect(pjp, "Api");
        // 最终返回的结果都是 Response
        Response resp = null;
        // 判断最后结果是否为 null
        if (result == null) {
            resp = new Response(RspCodeMsg.NULL);
        } else if (result instanceof RspCodeMsg) {
            resp = new Response((RspCodeMsg) result);
        } else if (result instanceof Response) {
            // 如果是Response暂不做处理
            resp = (Response) result;
        } else {
            resp = new ResponseData(RspCodeMsg.SUCCESS, result);
        }
        return resp;
    }


    /**
     * 处理参数校验、异常捕获、日志记录
     * 
     * @author song.chang
     * @param pjp
     * @param tag
     * @return
     * @throws Throwable
     */
    public Object doReqAspect(ProceedingJoinPoint pjp, String tag) throws Throwable {
        // 存储最终返回的结果
        long start = System.currentTimeMillis();
        Object result = null;

        // 请求校验
        Object[] args = pjp.getArgs();
        try {
            paramCheck(args);
        } catch (ParamCheckException e) {
            // 直接返回参数验证失败
            result = new Response(e.getCodeMsg(), e.getMessage());
            return result;
        }

        // 监控的关键Metric，获得类全名+方法名
        String monitorKey = AspectUtils.getMonitorKey(pjp, tag);

        try {
            // 调用 Controller 具体逻辑
            result = pjp.proceed(args);

        } catch (Exception e) {
            //获得异常码
            RspCodeMsg rsp = AspectUtils.getExceptionRsp(e);
            // 未知异常不抛出错误详情
            if (rsp == RspCodeMsg.UNKNOWN_ERR) {
                result = new Response(rsp);
            } else {
                result = new Response(rsp, e.getMessage());
            }
        } finally {
            // 记日志监控
            long time = System.currentTimeMillis() - start;
            LogUtils.info("{}【接口方法耗时】: {}", monitorKey, time);
        }

        return result;
    }

    /**
     * 参数校验，失败会抛出异常，否则表示成功
     * 
     * @param args
     * @throws ParamCheckException
     */
    private void paramCheck(Object[] args) throws ParamCheckException {
        if (args == null || args.length == 0) {
            return;
        }
        for (Object arg : args) {
            if (!(arg instanceof AbstractParam)) {
                // 非 AbstractParam 的参数不做校验，AbstractParam是所有参数验证的父类，在com.param.base内
                continue;
            }

            // 参数校验
            AbstractParam param = (AbstractParam) arg;
            try {
                param.paramCheck();
            } catch (Exception e) {
                if (e instanceof ParamCheckException) {
                    // 如果是 ParamCheckException 异常，直接抛出
                    throw (ParamCheckException) e;
                }
                // 其他异常返回错误信息，这里直接返回参数验证失败，同if内的返回码
                throw new ParamCheckException(RspCodeMsg.PARAM_CHECK_ERR, e.getMessage());
            }
        }
    }

}
