package com.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Administrator on 2016/8/8.
 */
public class ConnectUtil {
    /**
     * get访问
     * @param url
     * @return
     */
    public static String getConnectForGet(String url){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);

        httpGet.setConfig(RequestConfig.DEFAULT);

        String res = null;
        try {
            //发送请求
            CloseableHttpResponse response = httpClient.execute(httpGet);
            response.setHeader(HTTP.CONTENT_TYPE, "text/html;charset=UTF-8");

            //返回信息
            HttpEntity entity = response.getEntity();
            res = EntityUtils.toString(entity);
            res = new String(res.getBytes("iso8859-1"), "UTF-8");
        } catch (IOException e) {
            //写入日志，返回错误
        } finally{
            httpGet.releaseConnection();
        }
        return res;
    }
}
