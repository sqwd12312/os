package com.bwm.servlet;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;
import com.bwm.page.Show;
import com.bwm.db.Data;
import com.bwm.time.Time;
import com.bwm.string.Str;
import job.Scourse;
public class teacherAcinfo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		//�ռ�����
		HttpSession session=request.getSession();
		String strName=(String)session.getAttribute("name");
		
		String strCname=(String)request.getParameter("cname");
		String strRequire=(String)request.getParameter("require");
		String eTime=(String)request.getParameter("eTime");
		String identifier=(String)request.getParameter("identifier");

		//��������
		Show show=new Show();
		Data data=new Data();
		Str str=new Str();
		Time time=new Time();
		Scourse course=new Scourse();
		int intT=0;
		course.setCname(strCname);
		course.setRequire(strRequire);
		course.setEtime(eTime);
		course.setIdentifier(identifier);
		course.setPtime(str.dbEncode(time.getYMD()));
		
		if(course.getCname().equals("")||course.getRequire().equals("")||course.getIdentifier().equals("")||course.getEtime().equals("")){
			
			out.print(show.errorBox("����д������Ϣ!","������Ϣ"));
			return;
		}else{
			intT=data.insert("insert into tb_course (cname,requirement,tname,identifier,ptime,etime) values('"+course.getCname()+"','"+course.getRequire()+"','"+strName+"','"+course.getIdentifier()+"','"+course.getPtime()+"','"+course.getEtime()+"')");
			if(intT<=0){
				out.print(show.errorBox("����ʧ�ܣ����ݿ����!","������Ϣ"));
				return;
			}else{
				out.print("<script>alert('�����ɹ���');document.location='teacher/acinfo.html';</script>");
			}
		}
		
	}

	

}
