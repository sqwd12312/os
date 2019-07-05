<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="com.bwm.db.Conn"%>
<%@ page import="com.bwm.page.Show"%>
<%@ page import="com.bwm.string.Str"%>
<%@ page import="java.sql.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<link href="../css/download.css" rel="stylesheet" type="text/css">
<script src="../js/default.js" ></script>

</head>
 <body topmargin="0px">
 
 
 <%
Conn con=new Conn();
Show show=new Show();
Str str=new Str();
String strChecked="checked";
String strUserName=(String)session.getAttribute("name");
String strCname=(String)request.getParameter("cName");
String sName=(String)request.getParameter("sName");

session.setAttribute("cname",strCname);
ResultSet rs=con.getRs("SELECT * FROM tb_work_completed WHERE sname='"+sName+"'");
        while(rs.next()){
        	
   	  	    if(strCname.equals(rs.getString(1))){
%>


<form name="form" method="post" action="meditscore.jsp">
<div class="all-contain">
    <div class="box">
      <h3 class="title">批改分数</h3>
    </div>
<div class="editscore-div">
  
  <p class="nock word">
  <span class="nc">学生姓名：</span>
  
  <div class="from_item">
    <div class="from-content">
      <div class="ncinput">
        <input type="text" name="sName" value="<%=sName%>" autocomplete="off" class="inputinner">
     </div>
   </div>
  </div>
  
  <p class="nock word">
  <span class="nc">作业名称：</span>

  <div class="from_item">
    <div class="from-content">
      <div class="ncinput">
        <input type="text" name="fName" value="<%=strCname%>" autocomplete="off" class="inputinner">
      </div>
    </div>
  </div>
  </p>
  
   <span class="nc">作业分数：</span>

  <div class="from_item">
    <div class="from-content">
      <div class="ncinput">
        <input type="text" name="score"  autocomplete="off" class="inputinner">
      </div>
    </div>
  </div>
  </p>

  <div class="btn_group">
    <input type="submit" name="Submit" value="提交"  class="confirm">
      <a href="vcinfo.jsp">
    <input class = "cancel" type="button" value="返回">
     </a>
  </div>

  </div>
  </div>
</form>

<%
   	  	    }
}
%>
</body>
</html>
