package com.ll.mango.common.utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

import java.io.*;

/**
 * POI相关操作
 * POI提供API给java程序对Microsoft Office格式档案读和写的功能。使用POI实现用户信息的Excel报表
 */
public class PoiUtis {
    public static File createExcelFile(Workbook workbook, String fileName){
        OutputStream stream=null;
        File file=null;
        try {
            file = File.createTempFile(fileName, ".xlsx");
            stream=new FileOutputStream(file.getAbsoluteFile());
            workbook.write(stream);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(stream);
        }
        return file;
    }
}
