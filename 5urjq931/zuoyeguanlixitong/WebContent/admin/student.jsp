<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.bwm.db.Conn" %>
<%@ include file="include.jsp"%>
<%
  int intPageSize;  //一页显示的记录数
  int intRowCount;  //记录总数
  int intPageCount; //总页数
  int intPage;      //待显示页码
  java.lang.String strPage; 
  int i;
  intPageSize = 8;  //设置一页显示的记录数
  strPage = request.getParameter("page");  //取得待显示页码

  if(strPage==null){  //表明在QueryString中没有page这一个参数，此时显示第一页数据
    intPage = 1;
} else {
    intPage =java.lang.Integer.parseInt(strPage);    //将字符串转换成整型
    if(intPage<1)
      intPage = 1;
}
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/vcinfo.css" rel="stylesheet" type="text/css">
<link href="../css/perInfo.css" rel="stylesheet" type="text/css">
</head>
<body topmargin="0px">


<div class="all-contain">
  <h3 class="title">学生信息管理</h3>
    <table  class="hovertable" >  
	  <tr class="first_tr" align="center">
	    <td>姓名</td>
	    <td> 密码</td>
	    <td> 电子邮件</td>
	    <td> 删除</td>
	   
	  </tr>
 <%

request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");

Conn con=new Conn();
ResultSet rs=con.getRs("SELECT * FROM tb_student");
rs.last();
intRowCount = rs.getRow();
intPageCount = (intRowCount+intPageSize-1) /intPageSize;

if(intPage>intPageCount) 
intPage = intPageCount;  //调整待显示的页码
rs.absolute((intPage-1)* intPageSize+1);
if(intPageCount>0) {  //显示数据
  i = 0;
	while(i<intPageSize &&!rs.isAfterLast()){  //将记录指针定位到待显示页的第一条记录上
    String strCname=rs.getString(1);
    i++;
%>
      <tr align="center" onmouseover="this.style.backgroundColor='#ffff00';" onmouseout="this.style.backgroundColor='#ffffff';">
	    <td ><%String strSname=rs.getString(1);%>
	         <%=rs.getString(1)%></td>
	    <td ><%=rs.getString(2)%></td>
	    <td ><%=rs.getString(3)%></td>
	    <td ><a href="dstudent.jsp?sname=<%=strSname%>">删除</a></td>
     </tr>
<%
rs.next();}
}
con.close();
%>
 </table>
 
 <div class="paging">
     <div class="paging-contain">
       <center>
              第<%=intPage%>页 共<%=intPageCount%>页
           <%  //以下是分页的“上一页”“下一页”，有上一页就有链接，没有就为文字，下一页同理%>
           <% if(intPage>1){ %>

            <a href="student.jsp?page=<%=intPage-1%>">上一页</a>

           <% }else{ %>
                      上一页
           <%}%>
           
           <% if(intPage<intPageCount){ %>

            <a href="student.jsp?page=<%=intPage+1%>">下一页</a>

           <% }else{ %>
                     下一页
           <%}%>

     <center>
   </div>
</div>
</div>	
</body>
</html>
