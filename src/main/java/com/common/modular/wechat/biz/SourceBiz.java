package com.common.modular.wechat.biz;

import com.common.modular.wechat.emun.MsgTypeEmun;
import com.common.modular.wechat.entity.source.ArticlesReq;
import com.common.modular.wechat.entity.source.ArticlesReqRoot;
import com.common.modular.wechat.entity.resp.ImageResp;
import com.common.modular.wechat.entity.source.SourceResp;
import com.common.modular.wechat.util.WexinConnectUtil;
import com.util.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangpeng on 2016/8/3.
 */
@Controller
@RequestMapping("/sourceBiz")
public class SourceBiz extends BaseBiz{
    public static void main(String[] args) {
        new SourceBiz().lastingSourceAdd();
    }
    /**
     * 生成临时多媒体文件，这里是测试，使用image
     * 会从前台得到该文件，将该文件存入本地的缓存文件中，然后再上传到微信，然后本地删除该文件
     */
    @RequestMapping("temporaryAdd")
    @ResponseBody
    public Object temporaryAdd(Map map){
        //@RequestParam(value = "file")MultipartFile file
        //FileResp fileResp = new FileUtil().UploadFile(file);//FileResp里面包含type和path
        String all_path = "C:\\small.jpg";
        String access_token = getAccess_token();
        String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token="+access_token+"&type="+ MsgTypeEmun.IMAGE.getValue();
        try {
            map = WexinConnectUtil.getConnectForFile(url,all_path);//path
        } catch (Exception e) {
            e.printStackTrace();
        }

        //成功，删除本地媒体文件
        //new FileUtil().deleteFile(all_path);

        //微信返回数据封装，如果存入数据库的话
        SourceResp sr = new SourceResp();
        sr.setCreated_at(map.get("created_at").toString());
        sr.setMedia_id(map.get("media_id").toString());
        sr.setType(map.get("type").toString());
        return sr;
    }
    /**
     * 生成永久媒体
     * 这里是做测试，使用的是image
     * 最后样子同上
     */
    @RequestMapping("lastingAdd")
    @ResponseBody
    public Object lastingAdd(Map map){
        String access_token = getAccess_token();
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token="+access_token+"&type="+ MsgTypeEmun.IMAGE.getValue();
        try {
            map = WexinConnectUtil.getConnectForFile(url,"C:\\small.jpg");//path
        } catch (Exception e) {
            e.printStackTrace();
        }
        //微信返回数据封装，如果存入数据库的话
        SourceResp sr = new SourceResp();
        sr.setMedia_id(map.get("media_id").toString());
        sr.setUrl(map.get("url").toString());
        System.out.println(sr.getMedia_id());
        return sr;
        //String midia_id = "5FZvGRE47npa6s7BhLbffIgH_3lxmuhEzShB3jRbyhI";
        //String p = "http://mmbiz.qpic.cn/mmbiz/HQ7r8nFZQKWIMianm9LnnViaADrB3AFVLRuCEPpbPbLMCNdlfbAibWgbhnGyo1mUPPgRC4EL8iaiaQINjusSkkcoDyg/0?wx_fmt=jpeg";
    }
    /**
     * 生成永久素材
     */
    @RequestMapping("createLastingSource")
    @ResponseBody
    public Object lastingSourceAdd(){
        String access_token = getAccess_token();
        //System.out.println(access_token);
        //媒体文件的id，需要的是永久的素材，不能是临时的。
        String media_id = "5FZvGRE47npa6s7BhLbffIgH_3lxmuhEzShB3jRbyhI";
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token="+access_token;

        List list = new ArrayList();
        ArticlesReq articlesReq = new ArticlesReq("推送视频",media_id,"zhangpeng","digest",1,"<p>这个是视频的页面</p>","http://www.baidu.com");
        list.add(articlesReq);

        ArticlesReqRoot articlesReqRoot = new ArticlesReqRoot(list);

        Map map = WexinConnectUtil.getConnectForPost(url, JSONUtil.toJson(articlesReqRoot));

        //用户素材的这个media_id是唯一的，是要存入数据库的
        ImageResp imageResp = new ImageResp();
        imageResp.setMediaId(map.get("media_id").toString());
        return imageResp.getMediaId();
        //5FZvGRE47npa6s7BhLbffPjUIG-d9bsJ5OIYGKJFwdo
    }

    /*
     * 获得临时多媒体文件
     * 这个获得的是流，因为没有临时素材的业务，暂时不写了
     */
    @RequestMapping("getImage")
    public void getImage(){
        //之前传上去的临时素材，8月5号过期
        String media_id = "rsvqEy505izp-CPTd37e0UPTmzg7BnCB3f8k6r9TuflwzXViyI2ciE0Clb58g3Td";
        String access_token = getAccess_token();

        String url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token="+access_token+"&media_id="+media_id;

        /*Map<String,Object> map = WexinConnectUtil.getConnectForGet(url);
        System.out.println(map.toString());*/
    }
}
