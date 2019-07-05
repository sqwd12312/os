package com.bwm.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.bwm.page.Show;
import com.bwm.db.Data;
import com.bwm.time.Time;
import com.bwm.string.Str;

import job.Student;
import job.Teacher;
public class userReg extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String strSelect=(String)request.getParameter("select");
		if(strSelect!=null&&strSelect.equals("teacher")){
	
		PrintWriter out = response.getWriter();
		//收集数据
	
		String strName=(String)request.getParameter("name");
		String strEmail=(String)request.getParameter("email");
		String strPassword=(String)request.getParameter("password");

		//处理数据
		Str str=new Str();
		Show show=new Show();
		Teacher teacher=new Teacher();
		teacher.setEmail(strEmail);
		teacher.setName(strName);
		teacher.setPassword(strPassword);

		if(teacher.getName().equals("")||teacher.getPassword().equals("")||teacher.getEmail().equals("")){
		        out.print(show.errorBox("请添写完整信息！","错误信息"));
		        return;
		}else{
		       
		        int intT=0;
		        Data data=new Data();
		        intT=data.getRowCount("tb_teacher WHERE name='"+teacher.getName()+"'");
		        if(intT>0){
		            out.print(show.errorBox("该用户名已被注册！","注册信息"));
		            return;
		        }else{
		            intT=data.insert("INSERT INTO tb_teacher(password,name,email) VALUES('"+teacher.getPassword()+"','"+teacher.getName()+"','"+teacher.getEmail()+"')");
		            if(intT<=0){
		                        out.print(show.errorBox("注册失败，数据库错误!","错误信息"));
		                        return;
		            }else{
		            	        out.print("<script>alert('注册成功！');document.location='main/index.jsp';</script>");
		                     //  response.sendRedirect("main/index.jsp");
		            }
		        }
		}
		
	}else {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		//接收数据

		String strEmail=(String)request.getParameter("email");
		String strName=(String)request.getParameter("name");
		String strPassword=(String)request.getParameter("password"); 

	
		//处理数据
		Str str=new Str();
		Show show=new Show();
		Student student=new Student();
	
		student.setEmail(strEmail);
		student.setName(strName);
		student.setPassword(strPassword);
		

		if(student.getName().equals("")||student.getPassword().equals("")||student.getEmail().equals("")){
		        out.print(show.errorBox("请添写完整信息！","错误信息"));
		        return;
		}else{
		       
		        int intT=0;
		        Data data=new Data();
		        intT=data.getRowCount("tb_student WHERE name='"+student.getName()+"'");
		        if(intT>0){
		            out.print(show.errorBox("该用户名已被注册！","注册信息"));
		            return;
		        }else{
		            intT=data.insert("INSERT INTO tb_student(password,name,email) VALUES('"+student.getPassword()+"','"+student.getName()+"','"+student.getEmail()+"')");
		            System.out.println("password"+student.getPassword());
		            System.out.println("name"+student.getName());
		            System.out.println("email"+student.getEmail());
		            if(intT<=0){
		                        out.print(show.errorBox("注册失败，数据库错误!","错误信息"));
		                        return;
		            }else{
		                        out.print("<script>alert('注册成功！');document.location='main/index.jsp';</script>");
		            }
		        }
		}
	}
  }

	
}
