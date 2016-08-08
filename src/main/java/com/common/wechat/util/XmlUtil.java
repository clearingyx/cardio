package com.common.wechat.util;

import com.common.wechat.emun.MsgTypeEmun;
import com.common.wechat.entity.BaseResp;
import com.common.wechat.entity.news.NewsArticle;
import com.common.wechat.entity.news.NewsResp;
import com.common.wechat.entity.resp.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang.peng on 2016/7/29.
 */
public class XmlUtil {
    /**
     * 解析微信发送过来的xml文件
     * @param requset
     * @return map
     */
    public static Map<String,String> weixinResolveXml(HttpServletRequest requset) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            // 从request中取得输入流
            InputStream inputStream = requset.getInputStream();
            // 读取输入流
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            // 得到xml根元素
            Element root = document.getRootElement();
            // 得到根元素的所有子节点
            List<Element> elementList = root.elements();
            // 遍历所有子节点
            for (Element e : elementList) {
                map.put(e.getName(), e.getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            return map;
        }
    }

    /**
     * 拼接发送会微信的xml
     * @param br
     * @return
     */
    public static String weixinBuildXml(BaseResp br){
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("xml");
        root.addElement("ToUserName").addCDATA(br.getToUserName());
        root.addElement("FromUserName").addCDATA(br.getFromUserName());
        root.addElement("CreateTime").setText(String.valueOf(new Date().getTime()));
        root.addElement("MsgType").addCDATA(br.getType());
        if(MsgTypeEmun.TEXT.getValue().equals(br.getType())) {
            if(br instanceof TextResp) {
                TextResp tr = (TextResp) br;
                root.addElement("Content").addCDATA(tr.getContent());
            }
        } else if (MsgTypeEmun.IMAGE.getValue().equals(br.getType())){
            if(br instanceof ImageResp) {
                ImageResp ir = (ImageResp) br;
                Element image = root.addElement("Image");
                image.addElement("MediaId").addCDATA(ir.getMediaId());
            }
        } else if (MsgTypeEmun.NEWS.getValue().equals(br.getType())){
            if(br instanceof NewsResp) {
                NewsResp nr = (NewsResp)br;
                root.addElement("ArticleCount").setText(String.valueOf(nr.getArticleCount()));
                Element Articles = root.addElement("Articles");
                int size = nr.getArticles().size();
                for (int i = size-1 ; i >= 0 ; i--){
                    NewsArticle na = nr.getArticles().get(i);
                    Element item = Articles.addElement("item");
                    item.addElement("Title").addCDATA(na.getTitle());
                    item.addElement("Description").addCDATA(na.getDescription());
                    item.addElement("PicUrl").addCDATA(na.getPicurl());
                    item.addElement("Url").addCDATA(na.getUrl());
                }
            }
        }
        return document.asXML();
    }
}
