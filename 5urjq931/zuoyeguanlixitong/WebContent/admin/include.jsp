<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.bwm.page.Show" %>
<%
if(session.getAttribute("admin")==null){
	out.print(new Show().errorBox("登录超时","错误信息"));
	return;
}
%>