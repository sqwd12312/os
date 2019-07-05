<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="com.bwm.page.Show"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<%
Show show=new Show();
String strUser=(String)session.getAttribute("admin");
if(strUser==null){
	out.print(show.errorBox("登录超时,请重新登录","错误信息"));
	return;
}
%>


 <frameset rows="45,*" cols="*" frameborder="NO" border="0" framespacing="0">

    <frame height="40px" src="../student/top.htm" name="topFrame" scrolling="NO" ><%=strUser %>

      <frameset rows="*" cols="20%,*" framespacing="0" frameborder="no" border="0">
      <frame src="left.htm" name="leftFrame" scrolling="NO" noresize marginwidth="130px" marginheight="0px">
      
      <frame src="student.jsp" name="mainFrame"  marginheight="15px">
      </frameset>
  </frameset>
  <noframes>
 <body>
</body>
  </noframes>

</html>
