<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.bwm.db.Conn"%>
<%@ page import="com.bwm.page.Show"%>
<%@ page import="com.bwm.string.Str"%>
<%@ page import="java.sql.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8 pageEncoding=utf-8">

<link href="../css/download.css" rel="stylesheet" type="text/css">
<script src="../js/default.js" ></script>

</head>
 <body topmargin="0px">
 
 
<%request.setCharacterEncoding("utf-8"); %>
<%
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
 
Conn con=new Conn();
Show show=new Show();
Str str=new Str();
String strChecked="checked";
String strUserName=(String)session.getAttribute("name");
String strCname=(String)request.getParameter("cName");
String strSname=(String)request.getParameter("sName");

session.setAttribute("cname",strCname);
ResultSet rs=con.getRs("SELECT * FROM tb_work_completed WHERE cname='"+strCname+"' AND sname='"+strSname+"'");
        if(rs.next()){
%>


<div class="all-contain">
    <div class="box">
      <h3 class="title">作业下载</h3>
    </div>
  <div class="download-div">
  
  <form class="from" method="post" action="../servletdown" enctype="multipart/form-data">
  <p class="nock word">
  <span class="nc">学生姓名：</span>
  
  <div class="from_item">
    <div class="from-content">
      <div class="ncinput">
        <input type="text" name="sName" value="<%=strSname%>" autocomplete="off" class="inputinner">
     </div>
   </div>
  </div>
  
  <p class="nock word">
  <span class="nc">作业名称：</span>

  <div class="from_item">
    <div class="from-content">
      <div class="ncinput">
        <input type="text" name="fName" value="<%=rs.getString(1)%>" autocomplete="off" class="inputinner">
      </div>
    </div>
  </div>
  </p>

  <div class="btn_group">
    <input type="submit" name="Submit" value="下载"  class="confirm">
      <a href="vcinfo.jsp">
    <input class = "cancel" type="button" value="返回">
     </a>
  </div>
  </form>
</div>
</div>
 
<%		
        }else{
            out.print(show.errorBox("数据库错误，请重新登录！","错误信息"));
        }
%>
</body>
</html>
