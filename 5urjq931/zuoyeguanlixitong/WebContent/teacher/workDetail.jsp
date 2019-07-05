<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.bwm.db.Conn"%>
<%@ page import="java.sql.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8 pageEncoding=utf-8">

<link href="../css/vcinfo.css" rel="stylesheet" type="text/css">
<link href="../css/perInfo.css" rel="stylesheet" type="text/css">
<link href="../css/checkBox.css" rel="stylesheet" type="text/css">

</head>
<body topmargin="0px">


<div class="all-contain">
  <h3 class="title">作业详细信息</h3>
   <form class="from" method="post" action="../SmartDownServlet">
   <div class="download-contain">
   <input class="word-download" type="submit" value="作业下载">  
   </div>	
<table class="hovertable">
	  <tr class="first_tr" align="center">
	    <td height="22" align="center">作业名称</td>
	    <td align="center">上交作业的学生</td>
	    <td align="center"> 成绩</td>
	    <td align="center">改分</td>
	    <td align="center">作业全选
	    <input type="checkbox" id="all" name="yon" onclick="chk()"/> 
        <label for="all"></label>
    
	    </td>
	  
	  </tr>
	  
	  
<%
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
Conn con=new Conn();
String strChecked="checked";

String identifier=request.getParameter("identifier");


ResultSet rs=con.getRs("select*from tb_work_completed WHERE identifier='"+identifier+"'");
	while(rs.next()){
		{		
%>


	   <tr  align="center" onmouseover="this.style.backgroundColor='#ffff00';" onmouseout="this.style.backgroundColor='#ffffff';">
	    <td height="22" align="center"><%=rs.getString(1)%></td>
	    <td align="center"><%=rs.getString(2)%></td>
	    <td align="center"><%if(rs.getString(3)==null){%>
	    		  <%="未批改"%>
	    	      <% }else{ %>
	    		  <%=rs.getString(3)%>
	    	      <% }%></td> 	  
	    <td align="center"><a href="editscore.jsp?cName=<%=rs.getString(1)%>&sName=<%=rs.getString(2)%>">改分</a></td>
	    <td align="center"> <input type="checkbox"  name="filename" value="<%=rs.getString(1)%>"> </td>
	  </tr>
	 
<%
	  	 }
	}
%>


</table>
</form>
<div>

<script type="text/javascript">
  
        function chk(){
            var all = document.getElementById("all");
            var mychk = document.getElementsByName("filename");
            if(all.checked==true){
                if(mychk.length){
                    for(var i=0;i<mychk.length;i++){
                        mychk[i].checked = true;
                    }
                
                }
                mychk.chcked=true;
            }else{
            
                if(mychk.length){
                    for(var i=0;i<mychk.length;i++){
                        mychk[i].checked = false;
                    }
                
                }
            }
            
        }   
    </script>
    
</body>
</html>