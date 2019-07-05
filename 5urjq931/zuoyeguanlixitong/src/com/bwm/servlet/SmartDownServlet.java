package com.bwm.servlet;


import java.io.File;
import com.bwm.page.Show;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class SmartDownServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
        //设置请求头信息
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment;filename=test.zip");
        String path = "C:\\Users\\qny\\Desktop\\上传\\";
        //初始化smartupload
        SmartUpload sm=new SmartUpload();
        sm.initialize(getServletConfig(), request, response);
        sm.setContentDisposition(null);
        String[] fileNames=request.getParameterValues("filename");
        if(fileNames==null) {
        	PrintWriter out = response.getWriter();
        	Show show=new Show();
        	out.print(show.errorBox("修改失败，数据库错误!","错误信息"));
        }else {
      
        String str = "";
        String rt = "\r\n";
        //返回一个压缩包
        ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
        for(String filename : fileNames){
            str += filename + rt;
            File file = new File(path + filename);
            zos.putNextEntry(new ZipEntry(filename));
            FileInputStream fis = new FileInputStream(file);
            //复制文件到压缩流中
            IOUtils.copy(fis, zos);     
            zos.flush();
            fis.close();
        }
        //设置注释
        zos.setComment("下载成功:" + rt + str);
        zos.flush();
        zos.close();
    }
    }
}
