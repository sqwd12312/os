<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.bwm.db.Data"%>
<%@ include file="include.jsp"%>
<%

request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");

String tName=(String)request.getParameter("tName");
System.out.println(tName);
Data data=new Data();
int intT=data.delete("DELETE FROM tb_teacher WHERE name='"+tName+"'");
	if(intT>0){
		out.print("<script>alert('删除成功！');document.location='teacher.jsp';</script>");
	}else{
	    new Show().errorBox("删除失败！","错误信息");
	}
%>
