<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.bwm.db.Conn"%>
<%@ page import="com.bwm.page.Show"%>
<%@ page import="java.sql.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8 pageEncoding=utf-8">
<link href="../css/perInfo.css" rel="stylesheet" type="text/css">
<script src="../js/default.js"></script>
</head>
<body topmargin="0px">


<%
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");

String specialty = request.getParameter("specialty");

Conn con=new Conn();
Show show=new Show();
String strChecked="checked";
String strUserName=(String)session.getAttribute("name");
ResultSet rs=con.getRs("SELECT * FROM tb_teacher WHERE name='"+strUserName+"'");
        if(rs.next()){
%>


  <div class="all-contain">
    <dialog id="myDialog" class="dialog" >
      <div class="box">
        <h3 class="title2">修改信息</h3>
          <span class="close" onclick="Dclose()">x</span>
     </div>
     
     <form class="from" method="post" action="../teacherMreg">
     
     
    
     
    <p class="nock word">
      <span class="nc">专业名称：</span>
      <div class="from_item">
        <div class="from-content">
          <div class="ncinput">
          <input type="text" name="specialty" value="<%=rs.getString(4)%>"  autocomplete="off" minlength="0" maxlength="20"class="inputinner">
          </div>
       </div>
     </div>
     </p>
     
      <p class="nock word">
      <span class="nc">邮箱账号：</span>
      <div class="from_item">
        <div class="from-content">
          <div class="ncinput">
          <input type="text" name="email"  value="<%=rs.getString(3)%>" autocomplete="off" minlength="6" maxlength="20"class="inputinner">
          </div>
       </div>
     </div>
     </p>
     
     <p class="nock word">
     <span class="nc">新的密码：</span>
     <div class="from_item">
       <div class="from-content">
         <div class="ncinput">
           <input type="text" name="password" autocomplete="off" minlength="6" maxlength="20"class="inputinner">
         </div>
      </div>
     </div>
     </p>
     
    <p class="nock word">
     <span class="nc">确认密码：</span>
     <div class="from_item">
       <div class="from-content">
         <div class="ncinput">
           <input type="text" name="rpassword" autocomplete="off" minlength="6" maxlength="20"class="inputinner">
         </div>
      </div>
     </div>
     </p>



     <div class="btn_group">
     <input type="submit" name="Submit" value="提交"  class="confirm">
     </div>
     </form>
     </dialog>

     <div class="per-info">
     <h3 data-v-0d738edb="" class="title">个人资料</h3>      
       <div class="user-info">
         <div class="header">
         <img src="https://profile.csdnimg.cn/1/9/4/1_qq_36925114" alt="" class="head">
         <p class="modify">我的头像</p>
         </div>
       <div class="right-c">
         <div class="user-name">
         <span  class="name">姓名:<%=strUserName%></span>
         </div>
         <div class="line">
         </div>
         <div class="email">
         <span >邮箱：<%=rs.getString(3)%></span>
         </div>
         <div class="specialty">
         <span >专业：<%=rs.getString(4)%></span>
         </div>
         <div class="reginfo">
         <a onclick="myFunction()"  target="mainFrame">修改资料</a>
         </div>
      </div>
    </div>
  </div>
</div>


<script>
var x = document.getElementById("myDialog");
function myFunction()
{
x.show();

}

function Dclose()
{
      x.close();
}
</script>


<%
        }else{
            out.print(show.errorBox("数据库错误，请重新登录！","错误信息"));
        }
%>


</body>
</html>