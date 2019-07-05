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
		//收集数据
		HttpSession session=request.getSession();
		String strName=(String)session.getAttribute("name");
		
		String strCname=(String)request.getParameter("cname");
		String strRequire=(String)request.getParameter("require");
		String eTime=(String)request.getParameter("eTime");
		String identifier=(String)request.getParameter("identifier");

		//处理数据
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
			
			out.print(show.errorBox("请添写完整信息!","错误信息"));
			return;
		}else{
			intT=data.insert("insert into tb_course (cname,requirement,tname,identifier,ptime,etime) values('"+course.getCname()+"','"+course.getRequire()+"','"+strName+"','"+course.getIdentifier()+"','"+course.getPtime()+"','"+course.getEtime()+"')");
			if(intT<=0){
				out.print(show.errorBox("发布失败，数据库错误!","错误信息"));
				return;
			}else{
				out.print("<script>alert('发布成功！');document.location='teacher/acinfo.html';</script>");
			}
		}
		
	}

	

}
