package com.bwm.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartUpload;


public class servletdown extends HttpServlet{

    public servletdown() {
    }
    //处理GET请求
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    	PrintWriter out=response.getWriter();
    	out.println("这个方法必须用post");
    }
    //相应POST请求
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    	PageContext pageContext   =   JspFactory.getDefaultFactory().getPageContext(this,request,   
    			response,null,true,8192,true); 
    	response.setContentType("text/html;charset=UTF-8");
//    	PrintWriter out=response.getWriter();
    	//定义变量
    	int count=0;
    	SmartUpload mySmartUpload=new SmartUpload();
    	//String file=request.getParameter(arg0)
    	try{
    		//初始化
    		mySmartUpload.initialize(pageContext);
    		//下载
    		mySmartUpload.setContentDisposition(null);
    		//保存下载文件到指定目录
    		//PATH为form表单发过来的
    		HttpSession s=request.getSession();
    		String file=(String)s.getAttribute("cname");
    		mySmartUpload.downloadFile("C:/Users/qny/Desktop/上传/"+file+"");
    		
    		//显示处理结果
//    		out.println(count+" file download"); 
    	}
    	catch(Exception e)
    	{
//    		out.println("unable to download the file");
//    		out.println(e.toString()+"");
    	}
    }
    
}