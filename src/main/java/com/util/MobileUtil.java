package com.util;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhang.peng on 2016/8/4.
 */
public class MobileUtil {
    /**
     * 归属地查询
     * @param mobile
     * @return mobileAddress
     */
    private static String getLocationByMobile(final String mobile) throws ParserConfigurationException, SAXException, IOException {
        String MOBILEURL = " http://www.youdao.com/smartresult-xml/search.s?type=sms&q=";
        String result = callUrlByGet(MOBILEURL + mobile, "GBK");
        StringReader stringReader = new StringReader(result);
        InputSource inputSource = new InputSource(stringReader);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputSource);

        if (!(document.getElementsByTagName("location").item(0) == null)) {
            return document.getElementsByTagName("location").item(0).getFirstChild().getNodeValue();
        }else{
            return "无此号记录！";
        }
    }
    /**
     * 获取URL返回的字符串
     * @param callurl
     * @param charset
     * @return
     */
    private static String callUrlByGet(String callurl,String charset){
        String result = "";
        try {
            URL url = new URL(callurl);
            URLConnection connection = url.openConnection();
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),charset));
            String line;
            while((line = reader.readLine())!= null){
                result += line;
                result += "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return result;
    }
    /**
     * 手机号码归属地
     * @param tel  手机号码
     * @return 135XXXXXXXX,联通/移动/电信,北京
     * @throws Exception
     * @author
     */
    public static String getMobileLocation(String tel) throws Exception{
        Pattern pattern = Pattern.compile("1\\d{10}");
        Matcher matcher = pattern.matcher(tel);
        String url = "http://life.tenpay.com/cgi-bin/sms/MobileQueryAttribution.cgi?chgmobile=" + tel;
        String result = callUrlByGet(url,"GBK");
        StringReader stringReader = new StringReader(result);
        InputSource inputSource = new InputSource(stringReader);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputSource);
        String retmsg = document.getElementsByTagName("retmsg").item(0).getFirstChild().getNodeValue();
        if(retmsg.equals("OK")){
            //String supplier = document.getElementsByTagName("supplier").item(0).getFirstChild().getNodeValue().trim();
            String province = document.getElementsByTagName("province").item(0).getFirstChild().getNodeValue().trim();
            String city = document.getElementsByTagName("city").item(0).getFirstChild().getNodeValue().trim();
            if (province.equals("-") || city.equals("-")) {
//                    return (tel + "," + supplier + ","+ getLocationByMobile(tel));
//                    return (getLocationByMobile(tel) + "," + supplier);
                return (getLocationByMobile(tel));
            }else {
//                    return (tel + "," + supplier + ","+ province + city);
//                    return (province + city + "," + supplier );
                return (province+","+city);
            }
        }else {
            return "无此号记录！";
        }
    }


//    public static void main(String[] args) {
//        try {
//            System.out.println(MobileUtil.getMobileLocation("13453412046"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
