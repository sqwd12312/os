// JavaScript Document
<!--
function reg(){
	if(document.form.password.value!=document.form.rpassword.value){
		alert("确认密码输入错误，请重新输入");
		return false;
	}
	return true;
}
function email(){
	if(document.form1.tname.value==""||document.form1.tname.value.indexOf("@")==-1||document.form1.tname.value.indexOf(".")==-1){
		alert("邮箱格式不正确");
		return false;
	}
	if(document.form1.sname.value==""||document.form1.sname.value.indexOf("@")==-1||document.form1.sname.value.indexOf(".")==-1){
		alert("邮箱格式不正确");
		return false;
	}
	return true;
}

-->
var x = document.getElementById("myDialog"); 
function showDialog(){ 
	x.show(); 
} 
function closeDialog(){
	x.close(); 
} 