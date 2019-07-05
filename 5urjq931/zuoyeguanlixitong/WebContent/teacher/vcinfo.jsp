<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.bwm.db.Conn"%>
<%@ page import="java.sql.*"%>


<%@ page import="com.bwm.page.Show"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8 pageEncoding=utf-8">

<link href="../css/vcinfo.css" rel="stylesheet" type="text/css">
<link href="../css/perInfo.css" rel="stylesheet" type="text/css">

</head>
<body topmargin="0px">


<div class="all-contain">
  <h3 class="title">查看作业信息</h3>
    <table  class="hovertable" >  
	  <tr class="first_tr" align="center">
	    <td>作业名称</td>
	    <td>作业编号</td>
	    <td> 布置時間</td>
	    <td> 截止時間</td> 
	    <td> 提交人数</td> 
	    <td> 操作</td> 
	  </tr>
	  
	  
<%


  request.setCharacterEncoding("utf-8");
  response.setContentType("text/html;charset=utf-8");

  Conn con=new Conn();
  String strChecked="checked";
  String strUserName=(String)session.getAttribute("name");
  ResultSet rs=con.getRs("SELECT * FROM tb_course  WHERE tname='"+strUserName+"' order by ptime desc");
  rs.last();
  intRowCount = rs.getRow();
  intPageCount = (intRowCount+intPageSize-1) /intPageSize;

  if(intPage>intPageCount) 
  intPage = intPageCount;  //调整待显示的页码
  rs.absolute((intPage-1)* intPageSize+1);
  if(intPageCount>0) {  //显示数据
    i = 0;
	while(i<intPageSize &&!rs.isAfterLast()){  //将记录指针定位到待显示页的第一条记录上
      String identifier=rs.getString(6);
      i++;
%>


	  <tr  align="center" onmouseover="this.style.backgroundColor='#ffff00';" onmouseout="this.style.backgroundColor='#ffffff';">
	    <td><%=rs.getString(1)%></td>
	    <td><%=rs.getString(6)%></td>
	    <td><%=rs.getString(4)%></td>
	    <td><%=rs.getString(5)%></td>
	    <%
	    ResultSet rs2=con.getRs("SELECT * FROM tb_work_completed WHERE identifier='"+identifier+"'");
	    rs2.last();
	    int workCount = rs2.getRow();
	    %>
	      <td><%=workCount%></td>
	    <td align="center"><a href="workDetail.jsp?identifier=<%=identifier%>">查看</a></td>
	 </tr>
	 
	 
<%
rs.next();}
}
%>

	       	 
</table>
   <div class="paging">
     <div class="paging-contain">
       <center>
              第<%=intPage%>页 共<%=intPageCount%>页
           <%  //以下是分页的“上一页”“下一页”，有上一页就有链接，没有就为文字，下一页同理%>
           <% if(intPage>1){ %>

            <a href="vcinfo.jsp?page=<%=intPage-1%>">上一页</a>

           <% }else{ %>
                      上一页
           <%}%>
           
           <% if(intPage<intPageCount){ %>

            <a href="vcinfo.jsp?page=<%=intPage+1%>">下一页</a>

           <% }else{ %>
                     下一页
           <%}%>

     <center>
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


</body>
</html>