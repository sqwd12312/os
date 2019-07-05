package com.bwm.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import com.bwm.time.Time;
import com.jspsmart.upload.SmartUpload;
import com.bwm.db.Data;
import com.bwm.string.Str;
import com.bwm.page.Show;
import com.bwm.db.Conn;
import job.Scourse;
public class servletUpload extends HttpServlet{

    public servletUpload() {
    }
    //����GET����
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    	PrintWriter out=response.getWriter();
    	out.println("�������������post");
    }
    //��ӦPOST����
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    	
    	request.setCharacterEncoding("gb2312");
    	response.setContentType("text/html;charset=gb2312");
    	
		Show show=new Show();
    	PageContext pageContext   =   JspFactory.getDefaultFactory().getPageContext(this,request, response,null,true,8192,true); 
    	PrintWriter out=response.getWriter();
    
    
    	//�������
    	int count=0;
		HttpSession s=request.getSession();
		String strUserName=(String)s.getAttribute("name");
    	SmartUpload mySmartUpload=new SmartUpload();
    	
    	try{
    		//��ʼ��
    		mySmartUpload.initialize(pageContext);
    		//�ϴ�
    		mySmartUpload.upload();
    		
    		com.jspsmart.upload.Request req = mySmartUpload.getRequest();
    		String identifier = req.getParameter("identifier");
    		
    		String file=mySmartUpload.getFiles().getFile(0).getFileName();
    		if(file.equals("")||file==null||file.equals("null")) {
    			out.print(show.errorBox("δѡ���ļ����ļ���Ϊ��!","������Ϣ"));
    			return;
    		}
        	s.setAttribute("file",file);
    		//�����ϴ��ļ���ָ��Ŀ¼
    		//PATHΪform����������
    		count=mySmartUpload.save("C://Users//qny//Desktop//�ϴ�");
    		//��ʾ������
//    		out.println(count+" file upload");
    		//JavaBean����
    		Conn con=new Conn();
    
    		Data data=new Data();
    		Str str=new Str();
    		Time time=new Time();
    		Scourse course=new Scourse();
    		course.setSname(strUserName);
    		course.setIdentifier(identifier);
    		course.setCname(file);
    		course.setPtime(time.getYMD());
    		int intT=0;
    		intT=data.insert("INSERT INTO tb_work_completed(cname,sname,identifier) VALUES('"+course.getCname()+"','"+course.getSname()+"','"+course.getIdentifier()+"')");
    	      if(intT<=0){
    						out.print(show.errorBox("�ϴ�ʧ�ܣ����ݿ����!","������Ϣ"));
    						return;
    		  }else{
    					out.print("<script>alert('�ϴ��ɹ���');document.location='student/vcinfo.jsp';</script>");
    		}
    		//response.sendRedirect("student/acinfo.jsp");
    	}
    	catch(Exception e)
    	{
    		out.println("unable to upload the file");
    		out.println(e.toString()+"");
    	}
    }
    
}