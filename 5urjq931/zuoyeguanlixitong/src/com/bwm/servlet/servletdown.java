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
    //����GET����
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    	PrintWriter out=response.getWriter();
    	out.println("�������������post");
    }
    //��ӦPOST����
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    	PageContext pageContext   =   JspFactory.getDefaultFactory().getPageContext(this,request,   
    			response,null,true,8192,true); 
    	response.setContentType("text/html;charset=UTF-8");
//    	PrintWriter out=response.getWriter();
    	//�������
    	int count=0;
    	SmartUpload mySmartUpload=new SmartUpload();
    	//String file=request.getParameter(arg0)
    	try{
    		//��ʼ��
    		mySmartUpload.initialize(pageContext);
    		//����
    		mySmartUpload.setContentDisposition(null);
    		//���������ļ���ָ��Ŀ¼
    		//PATHΪform����������
    		HttpSession s=request.getSession();
    		String file=(String)s.getAttribute("cname");
    		mySmartUpload.downloadFile("C:/Users/qny/Desktop/�ϴ�/"+file+"");
    		
    		//��ʾ������
//    		out.println(count+" file download"); 
    	}
    	catch(Exception e)
    	{
//    		out.println("unable to download the file");
//    		out.println(e.toString()+"");
    	}
    }
    
}