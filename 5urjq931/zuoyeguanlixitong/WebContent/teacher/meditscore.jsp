<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="com.bwm.page.Show"%>
<%@ page import="com.bwm.db.Data"%>
<%request.setCharacterEncoding("GB2312");%>
<jsp:useBean id="course" class="job.Scourse" scope="request" />
<jsp:setProperty name="course" property="*"/>
<%
Show show=new Show();
course.setScore(course.getScore());
System.out.println(course.getScore());
String strCname=(String)session.getAttribute("cname");
if(String.valueOf(course.getScore()).equals("")){
	out.print(show.errorBox("����д������Ϣ!","������Ϣ"));
	return;
}else{
	int intT=0;
	Data data=new Data();
	intT=data.insert("UPDATE tb_work_completed SET score='"+course.getScore()+"' WHERE cname='"+strCname+"'");
	if(intT<=0){
		out.print(show.errorBox("�޸�ʧ�ܣ����ݿ����!","������Ϣ"));
		return;
	}else{
		out.print("<script>alert('�޸ĳɹ���');document.location='vcinfo.jsp';</script>");
    }
}
%>
