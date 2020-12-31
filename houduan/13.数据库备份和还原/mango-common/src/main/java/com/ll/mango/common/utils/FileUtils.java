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
    /**
     * 递归删除文件
     * @param file
     */
    public static void deleteFile(File file) {
        // 判断是否是一个目录, 不是的话跳过, 直接删除; 如果是一个目录, 先将其内容清空.
        if(file.isDirectory()) {
            // 获取子文件/目录
            File[] subFiles = file.listFiles();
            // 遍历该目录
            for (File subFile : subFiles) {
                // 递归调用删除该文件: 如果这是一个空目录或文件, 一次递归就可删除.
                // 如果这是一个非空目录, 多次递归清空其内容后再删除
                deleteFile(subFile);
            }
        }
        // 删除空目录或文件
        file.delete();
    }

}
