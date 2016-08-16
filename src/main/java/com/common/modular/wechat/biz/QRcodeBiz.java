package com.common.modular.wechat.biz;

import com.common.component.annotation.ApiRequest;
import com.common.component.resp.RspCodeMsg;
import com.common.dao.auto.LastingQrcodeDao;
import com.common.model.auto.LastingQrcodeEntity;
import com.common.modular.wechat.emun.QRcodeEmun;
import com.common.modular.wechat.entity.qrcode.ActionInfo;
import com.common.modular.wechat.entity.qrcode.QRcodeResp;
import com.common.modular.wechat.entity.qrcode.Scene;
import com.common.modular.wechat.util.WexinConnectUtil;
import com.exception.base.RspRuntimeException;
import com.util.DateUtils;
import com.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by zhang.peng on 2016/8/3.
 */
@Controller
@RequestMapping("/qrcodeBiz")
public class QRcodeBiz extends BaseBiz{
    @Autowired
    LastingQrcodeDao lastingQrcodeDao;

    // http://zp.tunnel.phpor.me/qrcodeBiz/createQR_LIMIT_STR_SCENE.do?scene_str=http://zp.tunnel.phpor.me/viewBiz/video.do?1=1";

    /**
     * 生成永久二维码，最多10万条，行内注释同上
     * @param scene_str 参数，图文数据库id
     * @param remark 参数，生成的二维码备注信息
     */
    @ApiRequest
    @RequestMapping(value = "createQR_LIMIT_STR_SCENE", method = RequestMethod.POST)
    @ResponseBody
    public Object createQR_LIMIT_STR_SCENE(String scene_str, String remark){
        String access_token = getAccess_token();
        QRcodeResp qRcodeResp = new QRcodeResp(QRcodeEmun.QR_LIMIT_STR_SCENE.toString(),new ActionInfo(new Scene(scene_str)));

        Map map = WexinConnectUtil.getConnectForPost("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="
                +access_token,JSONUtil.toJson(qRcodeResp));

//        QRcodeReq qRcodeReq = new QRcodeReq(map.get("ticket").toString(),
//                Integer.valueOf(map.get("expire_seconds").toString()),
//                map.get("url").toString());
        //生成二维码
//        new QRcodeUtil().Encode(url+qRcodeReq.getTicket(),"C:/Users/admin/Desktop/","QRcodeUtil.png");

        //将永久二维码的ticket和remark放入数据库
        LastingQrcodeEntity qrcodeEntity = new LastingQrcodeEntity();
        qrcodeEntity.setTicket(map.get("ticket").toString());
        qrcodeEntity.setCreateDate(new Date());
        qrcodeEntity.setRemark(remark);
        //永久的过期时间为空，这里不添加
        int temp = lastingQrcodeDao.insertSelective(qrcodeEntity);
        if (temp != 1) {
            throw new RspRuntimeException(RspCodeMsg.FAIL, "微信信息插入数据库失败");
        }
        //return "redirect:./showQR.do?ticket=" + qrcodeEntity.getTicket();
        return map.get("ticket").toString();
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
        return "weixin/qr_code.jsp";
    }

    /**
     * 生成临时二维码
     * @param expire_seconds 过期时间，秒单位，最长2592000;
     * @param scene_id 参数，图文数据库id
     * @param remark 参数，生成的二维码备注信息
     *
     * @deprecated 医生生成的二维码的参数只需要scene_id，然后关注什么的结束了直接展示这个图文素材即可，
     * 保存多久看情况，未定
     */
    @RequestMapping("createQR_SCENE")
    public String createQR_SCENE(int expire_seconds,int scene_id, String remark){
        //给微信发送的对象
        QRcodeResp qRcodeResp = new QRcodeResp(expire_seconds, QRcodeEmun.QR_SCENE.getValue(),
                new ActionInfo(new Scene(scene_id)));
        //得到access_token
        String access_token = new BaseBiz().getAccess_token();

        //post连接，生成二维码
        Map map = WexinConnectUtil.getConnectForPost("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="
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

//        String show_url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
//        model.addAttribute("url",url+map.get("ticket").toString());
//        return "weixin/qr_code.jsp";
        LastingQrcodeEntity qrcodeEntity = new LastingQrcodeEntity();
        qrcodeEntity.setTicket(map.get("ticket").toString());
        qrcodeEntity.setCreateDate(new Date());
        qrcodeEntity.setRemark(remark);
        //过期时间
        qrcodeEntity.setOverDate(DateUtils.addDateBySecond(new Date(),expire_seconds));
        int temp = lastingQrcodeDao.insertSelective(qrcodeEntity);
        if (temp != 1) {
            throw new RspRuntimeException(RspCodeMsg.FAIL, "微信信息插入数据库失败");
        }
        return "redirect:./showQR.do?ticket=" + qrcodeEntity.getTicket();
    }

}
