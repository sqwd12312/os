package com.bwm.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.bwm.page.Show;
import com.bwm.db.Data;
public class servletMain extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//Servlet接收
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		String strUserName=(String)request.getParameter("username");
		String strPassword=(String)request.getParameter("password");
		String strSelect=(String)request.getParameter("select");
		//JavaBean处理
		Data data=new Data();
		Show show=new Show();
		int intT=0;
		if(strSelect!=null&&strSelect.equals("student")){
		        intT=data.getRowCount("tb_student WHERE name='"+strUserName+"' AND password='"+strPassword+"'");
		        if(intT>0){
		            session.setAttribute("name",strUserName);
		                session.setAttribute("use","student");
		            response.sendRedirect("student/login.jsp");
		        }else{
		                out.print(show.errorBox("检查你的用户名或密码！","验证错误"));
		                return;
		        }
		}else if(strSelect!=null&&strSelect.equals("teacher")){
		        intT=data.getRowCount("tb_teacher WHERE name='"+strUserName+"' AND password='"+strPassword+"'");
		        if(intT>0){
		            session.setAttribute("name",strUserName);
		                session.setAttribute("use","teacher");
		            response.sendRedirect("teacher/login.jsp");
		        }else{
		            out.print(show.errorBox("检查你的用户名或密码！","验证错误"));
		            return;
		        }
		}else{
		        out.print(show.errorBox("检查你的用户名或密码！","验证错误"));
		        return;
		}
		
	}

}
