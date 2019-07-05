<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="com.bwm.db.Conn"%>
<%@ page import="com.bwm.page.Show"%>
<%@ page import="com.bwm.string.Str"%>
<%@ page import="java.sql.*"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312 pageEncoding=gb2312" >
<jsp:useBean id="course" scope="request" class="job.Scourse" />
<jsp:setProperty name="course" property="*" />
<script src="../js/default.js" ></script>
<link href="../css/download.css" rel="stylesheet" type="text/css">
<link href="../css/perInfo.css" rel="stylesheet" type="text/css">
<link href="../css/selectfile.css" rel="stylesheet" type="text/css">
</head>
 <body topmargin="0px">
 
 
 <%
  request.setCharacterEncoding("gb2312");
  response.setContentType("text/html;charset=gb2312");
	
  Conn con=new Conn();
  Show show=new Show();
  Str str=new Str();
  String strChecked="checked";
  String strUserName=(String)session.getAttribute("name");
  String identifier=(String)request.getParameter("identifier");
  ResultSet rs=con.getRs("SELECT * FROM tb_student WHERE name='"+strUserName+"'");
        if(rs.next()){      		
%>


<div class="all-contain">
  <div class="box">
  <h3 class="title">我的上传</h3>
</div>

<div id="myDialog" class="selectfile-dialog" >
  <div class="box">
    <h3 class="title2">上传文件</h3>
  </div>

    <form class="from" method="post" action="../servletUpload" enctype="multipart/form-data">

    <div class="costs-uploadfile-div">  
      <button class="allBtn costs-marl15">上传</button>                           
        <input type="file" name="file" id="fileField"  onchange="document.getElementById('textfield').value=this.value" /> 
          <input type='text' id="textfield" class="inputinner"/> 
    </div>
    
    <div class="costs-uploadfile-div">  
      <button class="allBtn costs-marl15">作业编号</button>                           
         <input type="text" name="identifier" value="<%=identifier%>" autocomplete="off" class="inputinner">
    </div>
    
    

  

    <div class="btn_group_file">
      <input type="submit" name="Submit" value="提交"  class="fileConfirm">
        <a href="vcinfo.jsp">
          <input class = "fCancel" type="button" value="取消">
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
