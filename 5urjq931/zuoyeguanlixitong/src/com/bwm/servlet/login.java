package com.bwm.servlet;
import java.sql.*;
import com.bwm.page.Show;
import com.bwm.db.Data;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		//Servlet接收
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String strName=(String)request.getParameter("name");
		String strPassword=(String)request.getParameter("password");
		//JavaBean处理
		Data data=new Data();
		Show show=new Show();
		int intT=0;
		if(strName!=null||strPassword!=null){
		    intT=data.getRowCount("tb_admin WHERE name='"+strName+"' AND password='"+strPassword+"'");
		    if(intT>0){
		    	
			session.setAttribute("admin",strName);
			response.sendRedirect("admin/admin.jsp");
		    }else{
			out.print(show.errorBox("请检查你的用户名密码！","验证信息"));
			return;
		    }
		}else{
		    out.print(show.errorBox("请检查你的用户名密码！","验证信息"));
		    return;
		}
	}

}
