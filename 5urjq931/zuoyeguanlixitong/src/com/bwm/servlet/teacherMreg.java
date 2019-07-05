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
		//��������
		HttpSession session=request.getSession();
		String strUserName=(String)session.getAttribute("name");
		

		String strEmail=(String)request.getParameter("email");
		String strPassword=(String)request.getParameter("password");
		String strRPassword=(String)request.getParameter("rpassword");
		String strSpecialty=(String)request.getParameter("specialty");
		//��������
		Show show=new Show();
		Teacher teacher=new Teacher();
		teacher.setEmail(strEmail);
		teacher.setPassword(strPassword);
		teacher.setSpecialty(strSpecialty);
		if(!strRPassword.equals(strPassword)) {
			out.print(show.errorBox("�µ�������ȷ�����벻��!","������Ϣ"));
		}else {
		if(teacher.getPassword().equals("")||teacher.getEmail().equals("")||teacher.getSpecialty().equals("")){
			out.print(show.errorBox("����д������Ϣ!","������Ϣ"));
			return;
		}else{
			int intT=0;
			Data data=new Data();
			intT=data.insert("UPDATE tb_teacher SET password='"+teacher.getPassword()+"',email='"+teacher.getEmail()+"',specialty='"+teacher.getSpecialty()+"' WHERE name='"+strUserName+"'");
			if(intT<=0){
				out.print(show.errorBox("�޸�ʧ�ܣ����ݿ����!","������Ϣ"));
				return;
			}else{
				out.print("<script>alert('�޸ĳɹ���');document.location='teacher/reginfo.jsp';</script>");
		    }
		}
		
	}

	}

}
