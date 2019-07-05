<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.bwm.db.Data"%>
<%@ include file="include.jsp"%>
<%

request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");

String strSname=(String)request.getParameter("sname");
System.out.println(strSname);
Data data=new Data();
int intT=data.delete("DELETE FROM tb_student WHERE name='"+strSname+"'");
	if(intT>0){
		out.print("<script>alert('删除成功！');document.location='student.jsp';</script>");
	}else{
	    new Show().errorBox("删除失败！","错误信息");
	}
%>
