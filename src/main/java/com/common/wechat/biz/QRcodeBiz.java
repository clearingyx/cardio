package com.common.wechat.biz;

import com.common.wechat.emun.QRcodeEmun;
import com.common.wechat.entity.qrcode.ActionInfo;
import com.common.wechat.entity.qrcode.QRcodeReq;
import com.common.wechat.entity.qrcode.QRcodeResp;
import com.common.wechat.entity.qrcode.Scene;
import com.common.wechat.util.ConnectUtil;
import com.util.JSONUtil;
import com.util.QRcodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by zhang.peng on 2016/8/3.
 */
@Controller
@RequestMapping("/qrcodeBiz")
public class QRcodeBiz extends BaseBiz{
    /**
     * 生成临时二维码
     * @param expire_seconds 存在时间;
     * @param scene_id 参数，本业务的话就是保存视频的id
     *
     * @deprecated 医生生成的二维码的参数只需要media_id，然后关注什么的结束了直接展示这个图文素材即可
     */
    @RequestMapping("createQR_SCENE")
    public String createQR_SCENE(int expire_seconds,int scene_id, Model model){
        //微信二维码固定url，本地生成的图片就需要url+ticked，不过一般也不用本地，使用showQR方法直接就能展示图片
        String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";

        //给微信发送的对象
        QRcodeResp qRcodeResp = new QRcodeResp(expire_seconds, QRcodeEmun.QR_SCENE.toString(),
                new ActionInfo(new Scene(scene_id)));
        //得到access_token
        String access_token = new BaseBiz().getAccess_token();

        //post连接，生成二维码
        Map map = ConnectUtil.getConnectForPost("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="
                +access_token, JSONUtil.toJson(qRcodeResp));

//        //封装微信发送回来的信息，可以直接放入数据库，这里的封装并没有什么意义，测试用
//        QRcodeReq qRcodeReq = new QRcodeReq(map.get("ticket").toString(),
//                Integer.valueOf(map.get("expire_seconds").toString()),
//                map.get("url").toString());
//
//        //生成本地图片，如果数据库存放的是ticked的话，这个图片是不用生成的，直接去微信数据库取即可
//        new QRcodeUtil().Encode(url+qRcodeReq.getTicket(),"C:/Users/admin/Desktop/","QRcodeUtil.png");
//
//        //不需要返回值，这里是main方法测试用
//        return map.get("ticket").toString();
        //直接页面展示吧

        String show_url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
        model.addAttribute("url",url+map.get("ticket").toString());
        return "qr_code.jsp";
    }

    /**
     * 生成永久二维码，最多10万条，行内注释同上
     */
    @RequestMapping("createQR_LIMIT_STR_SCENE")
    public void createQR_LIMIT_STR_SCENE(String scene_str){
        String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";

        QRcodeResp qRcodeResp = new QRcodeResp(QRcodeEmun.QR_LIMIT_STR_SCENE.toString(),new ActionInfo(new Scene(scene_str)));
        String access_token = getAccess_token();
        //System.out.println(access_token);

        Map map = ConnectUtil.getConnectForPost("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="
                +access_token,JSONUtil.toJson(qRcodeResp));

        QRcodeReq qRcodeReq = new QRcodeReq(map.get("ticket").toString(),
                Integer.valueOf(map.get("expire_seconds").toString()),
                map.get("url").toString());

        new QRcodeUtil().Encode(url+qRcodeReq.getTicket(),"C:/Users/admin/Desktop/","QRcodeUtil.png");
    }

    /**
     * 通过ticked展示二维码
     * 返回去的是img的src，直接展示即可
     * 如果是公众号二维码，记录下来ticket直接展示即可
     */
    @RequestMapping("showQR")
    public String showQR(String ticket, Model model){
        //微信的固定发送url
        String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";

        //ticked是生成二维码的时候微信返回来的，这个应该是保存到数据库，下面的这个ticked是永久的
        // 用来测试的
//        ticket = "gQHX8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL3FqcWp5OVRsSndaZUlXcW84UksyAAIEjwKfVwMEAAAAAA==";
        model.addAttribute("url",url+ticket);
        return "qr_code.jsp";
    }
}
