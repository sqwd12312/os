package com.bwm.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.bwm.page.Show;
import com.bwm.db.Data;
import com.bwm.string.Str;
import job.Student;
public class studentMreg extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		  
		PrintWriter out = response.getWriter();
		//��������
		HttpSession session=request.getSession();
		String strUserName=(String)session.getAttribute("name");
		
		String specialty=(String)request.getParameter("specialty");
		String classNum=(String)request.getParameter("classNum");
		String strPassword=(String)request.getParameter("password");
		String strrPassword=(String)request.getParameter("rpassword");
		String strEmail=(String)request.getParameter("email");

		//��������
		Show show=new Show();
		Str str=new Str();
		Student student=new Student();
        
		student.setSpecialty(specialty);
		student.setClass_num(classNum);
		student.setPassword(str.dbEncode(strPassword));
		student.setEmail(str.dbEncode(strEmail));
		

	    if(!strrPassword.equals(strPassword)) {
	    	out.print(show.errorBox("�µ�������ȷ�����벻��!","������Ϣ"));
	    }else {
		if(student.getSpecialty().equals("")||student.getClass_num().equals("")||student.getPassword().equals("")||student.getEmail().equals("")){
			out.print(show.errorBox("����д������Ϣ!","������Ϣ"));
			return;
		}else{
			int intT=0;
			Data data=new Data();
			intT=data.insert("UPDATE tb_student SET password='"+student.getPassword()+"',email='"+student.getEmail()+"',specialty='"+student.getSpecialty()+"',classnum='"+student.getClass_num()+"' WHERE name='"+strUserName+"'");
			
			if(intT<=0){
				out.print(show.errorBox("�޸�ʧ�ܣ����ݿ����!","������Ϣ"));
				return;
			}else{
				out.print("<script>alert('�޸ĳɹ���');document.location='student/reginfo.jsp';</script>");
		    }
		}
		
	}

	}

}
