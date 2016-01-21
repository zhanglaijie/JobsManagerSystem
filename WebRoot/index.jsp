<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>请登录</title>
	<script language="javascript" >
	function checkLogin(){
	   
	    var flag=${requestScope.flag};
	   
	    if(flag){
	      
	    }else{
	      alert("用户名或密码错误");
	    }
	}
	
	</script>
</head>
<body onload="checkLogin()">
	<form action="login" method="post" name="login">
	<table align="center" width="800px" height="400"><tr bgcolor="#0066CC" ><td colspan="2" align="center"><font size="+2" ><b>用户登录</b></font></td></tr>
		  <tr>
			  <td width="260"><img src="pic2.jpg"/> </td>
			  <td width="540">
		  <table align = "center">
		 		<caption>请输入用户名和密码:</caption>
		  <tr>
			  <td>用户名:</td>
			  <td><input name = "loginid" type = "text" style="width:180px"></td>
		  </tr>
		  <tr>
			  <td>密码:</td>
			  <td><input name = "passwd" type = "password" style="width:180px"></td>
		  </tr>
		  <tr>
			  <td><input name = "ok" type = "submit" value = "确定"></td>
			  <td><input name = "cancel" type = "reset" value = "取消"></td>
		  </tr>
		  <tr>
			  <td></td><td align="right"><a href = "register.jsp">注册</a></td>
		  </tr>
  </table>
	</form>
	<hr>
  	@2015
	</p>
</body>
</html>