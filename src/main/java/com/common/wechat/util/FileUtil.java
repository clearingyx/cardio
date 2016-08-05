package com.common.wechat.util;

import com.common.wechat.emun.MsgTypeEmun;
import com.common.wechat.entity.resp.FileResp;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by zhang.peng on 2016/8/3.
 */
public class FileUtil {

    public FileResp UploadFile(MultipartFile file, HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("upload_temp/");

        String fileName = file.getOriginalFilename();

        File temp_file = new File(path, fileName);//生成临时文件
        if(!temp_file.exists()){
            temp_file.mkdirs();
        }

        try {
            file.transferTo(temp_file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String suffix = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();

        String type = "";
        if("jpg".equals(suffix)){
            type = MsgTypeEmun.IMAGE.getValue();//这里还有缩略图也是png格式的，需要再改改，看情况
        } else if("amr".equals(suffix) || "mp3".equals(suffix)){
            type = MsgTypeEmun.VOICE.getValue();
        } else if("mp4".equals(suffix)){
            type = MsgTypeEmun.VIDEO.getValue();
        }
        FileResp fileResp = new FileResp();
        fileResp.setType(type);
        fileResp.setPath(path+fileName);
        return fileResp;
    }

    //删除本地缓存文件
    public boolean deleteFile(String path){
        boolean b = true;
        //自定义异常
        try {
            File f = new File(path);
            f.delete();
        }catch (Exception e){
            b = false;
            //log
        }
        return b;
    }
}
