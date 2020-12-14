package com.ll.mango.common.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件相关操作
 * 在编写到处解耦的时候我们通过FileUtils中的downloadFile将Excel文件下载到本地
 */
public class FileUtils {
    public static void downloadFile(HttpServletResponse response, File file, String fileName) {
        try {
            //设置响应头的格式
            response.setHeader("Content-Disposition", "attachment;filename= " + new String(fileName.getBytes("ISO-8859-1"), "UTF-8"));
            //输出流
            BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
            //将File的文件路径放入输入流
            InputStream is=new FileInputStream(file.getAbsolutePath());
            BufferedInputStream bis=new BufferedInputStream(is);
            int length=0;
            byte[] temp=new byte[1*1024*10];
            while((length=bis.read(temp))!=-1){
                bos.write(temp,0,length);
            }
            bos.flush();
            bis.close();
            bos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
