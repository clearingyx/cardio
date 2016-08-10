package com.common.modular.wechat.util;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by zhang.peng on 2016/8/3.
 */
public class QRcodeUtil {
    public boolean getQRcodeFromWeixin(InputStream inputStream){
        boolean b = false;
        FileOutputStream fos = null;
        try {

            byte[] bytes = new byte[128];

            fos = new FileOutputStream("C:/Users/admin/Desktop/ticked.png");
            while(inputStream.read(bytes)!=-1){
                fos.write(bytes);
            }
            b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(inputStream!=null) inputStream.close();
                if(fos!=null) fos.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return b;
    }
}
