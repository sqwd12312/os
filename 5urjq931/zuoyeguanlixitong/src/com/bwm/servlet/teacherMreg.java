package com.bwm.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.bwm.page.Show;
import com.bwm.db.Data;
import com.bwm.time.Time;
import com.bwm.string.Str;
import job.Teacher;
public class teacherMreg extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//接收数据
		HttpSession session=request.getSession();
		String strUserName=(String)session.getAttribute("name");
		

		String strEmail=(String)request.getParameter("email");
		String strPassword=(String)request.getParameter("password");
		String strRPassword=(String)request.getParameter("rpassword");
		String strSpecialty=(String)request.getParameter("specialty");
		//处理数据
		Show show=new Show();
		Teacher teacher=new Teacher();
		teacher.setEmail(strEmail);
		teacher.setPassword(strPassword);
		teacher.setSpecialty(strSpecialty);
		if(!strRPassword.equals(strPassword)) {
			out.print(show.errorBox("新的密码与确认密码不符!","错误信息"));
		}else {
		if(teacher.getPassword().equals("")||teacher.getEmail().equals("")||teacher.getSpecialty().equals("")){
			out.print(show.errorBox("请添写完整信息!","错误信息"));
			return;
		}else{
			int intT=0;
			Data data=new Data();
			intT=data.insert("UPDATE tb_teacher SET password='"+teacher.getPassword()+"',email='"+teacher.getEmail()+"',specialty='"+teacher.getSpecialty()+"' WHERE name='"+strUserName+"'");
			if(intT<=0){
				out.print(show.errorBox("修改失败，数据库错误!","错误信息"));
				return;
			}else{
				out.print("<script>alert('修改成功！');document.location='teacher/reginfo.jsp';</script>");
		    }
		}
		
	}

	}

}
