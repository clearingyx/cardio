package com.common.modular.wechat.biz;

import com.common.component.resp.RspCodeMsg;
import com.common.dao.auto.LastingImageTextResourceDao;
import com.common.dao.auto.LastingResourceDao;
import com.common.model.auto.LastingImageTextResourceEntity;
import com.common.model.auto.LastingImageTextResourceExample;
import com.common.model.auto.LastingResourceEntity;
import com.common.model.auto.LastingResourceExample;
import com.common.model.biz.LastingImageTextReq;
import com.common.model.biz.LastingResourceReq;
import com.common.modular.wechat.entity.source.ArticlesReq;
import com.common.modular.wechat.entity.source.ArticlesReqRoot;
import com.common.modular.wechat.util.WeixinConnectUtil;
import com.exception.base.RspRuntimeException;
import com.util.JSONUtil;
import com.util.PageUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangpeng on 2016/8/3.
 */
@Controller
@RequestMapping("/sourceBiz")
public class SourceBiz extends BaseBiz{

    @Autowired
    LastingResourceDao lastingResourceDao;
    @Autowired
    LastingImageTextResourceDao lastingImageTextResourceDao;

    /**
     * 生成永久素材
     * @param file
     * @param request
     * @param type
     * @param map
     * @return
     */
    @RequestMapping("lastingResourceAdd")
    public String lastingAdd(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request,String type, Map map){
        //获得access_token
        String access_token = getAccess_token();

        //保存图片到服务器，上传到微信后再删除
        String path = request.getSession().getServletContext().getRealPath("upload_temp") + "\\" + file.getOriginalFilename();
        File targetFile = new File(path);
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            new RspRuntimeException(RspCodeMsg.FAIL,"上传永久素材到本地失败");
        }

        //向微信post发送永久素材
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token="+access_token+"&type="+ type;
        try {
            map = WeixinConnectUtil.getConnectForFile(url,path);
            //删除图片
            targetFile.delete();
        } catch (Exception e) {
            new RspRuntimeException(RspCodeMsg.WEIXIN_SOURCE_ERR,"微信上传素材返回信息解析失败");
        }

        //微信返回数据封装，存入数据库
        LastingResourceEntity lse = new LastingResourceEntity();
        lse.setMediaId(map.get("media_id").toString());
        lse.setUrl(map.get("url").toString());
        lse.setType(type);
        lse.setCreateDate(new Date());
        //插入永久素材数据库
        int temp = lastingResourceDao.insert(lse);
        if(temp != 1) {
            new RspRuntimeException(RspCodeMsg.FAIL,"永久素材存入数据库失败");
        }

        //返回到永久素材列表页面
        return "redirect:./resourceList.do";
        //String midia_id = "5FZvGRE47npa6s7BhLbffIgH_3lxmuhEzShB3jRbyhI";
        //String p = "http://mmbiz.qpic.cn/mmbiz/HQ7r8nFZQKWIMianm9LnnViaADrB3AFVLRuCEPpbPbLMCNdlfbAibWgbhnGyo1mUPPgRC4EL8iaiaQINjusSkkcoDyg/0?wx_fmt=jpeg";
    }

    /**
     * 添加永久图文
     * @param imageText
     * @param model
     * @return
     */
    @RequestMapping("lastingImageTextAdd")
    public String lastingSourceAdd(LastingImageTextResourceEntity imageText, Model model){
        String access_token = getAccess_token();
        List list = new ArrayList();

        //向微信post发送永久素材
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token="+access_token;
        ArticlesReq articlesReq = new ArticlesReq(imageText.getTitle(), imageText.getThumbMediaId(),
                imageText.getAuthor(), imageText.getDigest(), imageText.getShowCoverPic(),
                imageText.getContent(), imageText.getContentSourceUrl());
        list.add(articlesReq);
        ArticlesReqRoot articlesReqRoot = new ArticlesReqRoot(list);
        Map map = WeixinConnectUtil.getConnectForPost(url, JSONUtil.toJson(articlesReqRoot));

        imageText.setMediaId(map.get("media_id").toString());
        imageText.setCreateDate(new Date());
        int temp = lastingImageTextResourceDao.insertSelective(imageText);
        if(temp != 1) {
            new RspRuntimeException(RspCodeMsg.FAIL,"永久图文存入数据库失败");
        }

        return "redirect:./imageTextList.do";
        //5FZvGRE47npa6s7BhLbffPjUIG-d9bsJ5OIYGKJFwdo
    }

    /**
     * 生成临时素材文件
     * 除了url都是永久素材
     */
    @RequestMapping("temporaryAdd")
    public String temporaryAdd(Map map){
        //String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token="+access_token+"&type="+ MsgTypeEmun.IMAGE.getValue();
        return "";
    }

    /**
     * 测试，跳转添加永久素材界面
     * @return
     */
    @RequestMapping("lastingAddPage")
    public String lastingAddPage(){
        return "weixin/lasting_resource_add.jsp";
    }

    /**
     * 测试，跳转添加永久图文界面
     */
    @RequestMapping("imageTextAddPage")
    public String imageTextAdd(Model model){

        LastingResourceExample example = new LastingResourceExample();
        List<LastingResourceEntity> list = lastingResourceDao.selectByExample(example);
        model.addAttribute("list", list);
        return "weixin/lasting_image_text_add.jsp";
    }

    /**
     * 测试，永久素材列表
     * @param lastingResourceReq
     * @param model
     * @return
     */
    @RequestMapping("/resourceList")
    public String resourceList(LastingResourceReq lastingResourceReq,Model model){
        LastingResourceExample example = new LastingResourceExample();
        //各种条件，排序分页等，这里省略

        // 分页参数
        RowBounds rowBounds = PageUtil.initRowBounds(lastingResourceReq);

        // 读取数据条数
        int rowCount = lastingResourceDao.countByExample(example);
        int pageCount = PageUtil.calculatePageCount(rowCount, lastingResourceReq.getPageSize());
        //分页查询
        List<LastingResourceEntity> list = lastingResourceDao.selectByExampleWithRowbounds(example,rowBounds);

        model.addAttribute("list",list);
        model.addAttribute("pageCount",pageCount);
        return "weixin/lasting_resource_list.jsp";
    }

    /**
     * 测试，图文列表
     * @param imageTextReq
     * @param model
     * @return
     */
    @RequestMapping("imageTextList")
    public String imageTextList(LastingImageTextReq imageTextReq, Model model){
        LastingImageTextResourceExample example = new LastingImageTextResourceExample();

        RowBounds rowBounds = PageUtil.initRowBounds(imageTextReq);

        int rowCount = lastingImageTextResourceDao.countByExample(example);
        int pageCount = PageUtil.calculatePageCount(rowCount, imageTextReq.getPageSize());

        List<LastingImageTextResourceEntity> list = lastingImageTextResourceDao.selectByExampleWithRowbounds(example,rowBounds);

        model.addAttribute("list",list);
        model.addAttribute("pageCount",pageCount);
        return "weixin/lasting_image_text_list.jsp";
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

        /*Map<String,Object> map = weixinConnectUtil.getConnectForGet(url);
        System.out.println(map.toString());*/
    }
}
