<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.bwm.db.Data"%>
<%@ include file="include.jsp"%>
<%
String cName=(String)request.getParameter("cName");
Data data=new Data();
int intT=data.delete("DELETE FROM tb_course WHERE cname='"+cName+"'");
	if(intT>0){
		out.print("<script>alert('删除成功！');document.location='course.jsp';</script>");
	}else{
	    new Show().errorBox("删除失败！","错误信息");
	}
%>
