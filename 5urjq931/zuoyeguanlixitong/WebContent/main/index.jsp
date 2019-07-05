<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""

%>
	
	<!-- String path = request.getContextPath();代表当前目录的上一级目录
<%
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<title>作业提交系统</title>
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="27" colspan="3" align="right"><div id="link"></div></td>
		</tr>
		<tr>
			<td width="1" height="36" background="images/gbnavl.gif"></td>
			<td width="99%" background="images/gbnavm.gif"><div id="link1">
					<a href="student/index.htm">学生注册</a> <a href="teacher/index.htm">教师注册</a>
				</div></td>
			<td width="1" background="images/gbnavr.gif"></td>
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="120" bgcolor="#FFFFFF" background="images/gbindex.png"><div
					id="top" align="center">作业提交系统</div></td>
		</tr>
	</table>
	<form id="form1" name="form1" method="post" action="servletMain">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"">
			<tr>
			
				<td height="22" colspan="2" align="center"
					background="images/tdbg.jpg"><div id="font1">登录入口</div></td>
			</tr>
			<tr>
				<td width="26%" height="22" align="center">用户名： <label>
						<input type="text" name="username" />
				</label></td>
			</tr>
			<tr>
				<td height="22" align="center">密&nbsp; 码:&nbsp; <label>
						<input type="password" name="password" />
				</label></td>
			</tr>
			<tr>
				<td height="30" colspan="2">
					<div align="center">
						<input name="select" type="radio" value="student" checked>学生
						<input type="radio" name="select" value="teacher">教师
					</div>
				</td>
			</tr>
			<tr>
				<td height="30" colspan="2">
					<div align="center">
						<input type="submit" name="Submit2" value="进入"> &nbsp; <input
							name="Submit" type="reset" value="重置">
					</div>
				</td>
			</tr>
			<tr>
				<td height="24" background="images/gbnavm.gif"></td>
				<td height="24" background="images/gbnavm.gif"><div id="link1">
						<a href="student/">关于?</a>
					</div></td>
			</tr>
		</table>
	</form>
	<table width="100%" height="50" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="1" bgcolor="#FFFFFF"><hr size="1" color="#CC3300"
					style="position: absolute;"></td>
		</tr>
		<tr>
			<td bgcolor="#FFFFFF">&nbsp;<a href="http://www.baidu.com">联系本站</a>
				| <a href="admin/index.htm">管理员入口</a>
			</td>
		</tr>
	</table>
</body>
</html>

 -->
 
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8; pageEncoding=UTF-8">

  <title>作业系统首页</title>

  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">

</head>
 

  

<body>
<% request.setCharacterEncoding("utf-8");
   response.setContentType("text/html;charset=utf-8");
  
%>

<div class="container">
  <div class="info">
    <h1>Operation System</h1></span>
  </div>
</div>
<div class="form">
  <div class="thumbnail"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/169963/hat.svg"/></div>
  <form class="register-form" method="post" action="userReg">
    <input type="text" name="name" value="账号" onfocus="this.value=''"/>
 
    <input type="password" name="password" value="密码" onfocus="this.value=''"/>
    <input type="text" name="email" value="邮箱" onfocus="this.value=''"/>
    
    <div class="container-login">
    
    <div class="stu-register">
    <button name="select" value="student">Student</button>
    </div>
    
    <div class="tea-register">
    <button name="select" value="teacher">Teacher</button>
    </div>
    
    <div class="clear"></div><!-- html注释：清除float产生浮动 --> </div>
    
    <p class="message">Already registered? <a href="#">Sign In</a></p>
  </form>
  <form class="login-form" method="post" action="<%=path%>/servletMain">
    <input type="text" name="username" value="账号" onfocus="this.value=''"/>
    <input type="password" name="password" value="密码" onfocus="this.value=''"/>
    
    <div class="container-login">
    
    <div class="stu-login">
    <button name="select" value="student">Student</button>
    </div>
    
    <div class="tea-login">
    <button name="select" value="teacher">Teacher</button>
    </div>
    
    <div class="clear"></div><!-- html注释：清除float产生浮动 --> </div>
    
       <div>
    <p class="message">Not registered? <a href="#">Create an account</a></p>
    </div>
      <div>
      <p class="admin-message"><a href="<%=path%>/admin/index.html">Admin Login</a></p>
      </div>
      
    </div>
    
 
      
  </form>
</div>
<video id="video" autoplay="autoplay" loop="loop" poster="polina.jpg">
  <source src="http://andytran.me/A%20peaceful%20nature%20timelapse%20video.mp4" type="video/mp4"/>
</video>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script  src="js/script.js"></script>

</body>

</html>
 
