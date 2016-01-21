<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head>
    <title>修改用户资料</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	
  </head>
    <body>
 <form action="updateok.action" method="post" name="update">
 
    <h2><center>修改资料</center></h2>
    <table border="0" width="500" height="50" align="center">
	<tr>
	<td >用户名</td>
	<td><input type="text" name="loginid"  value= "${requestScope.login.loginid}"></td>
	</tr>
	<tr>
	<td>密码</td>
	<td><input type="password" name="passwd"  value= "${requestScope.login.passwd }"></td>
	</tr>
	<tr>
	<td>生日</td>
	<td><input type="text" name="birth"  value= "${requestScope.login.birth }"></td>
	</tr>
	<tr>
	<td>性别</td>
	<td><input type="radio" name="sex" checked value='1' >男&nbsp;&nbsp;
	<input type="radio" name="sex" value='2'>女
	</td>
	</tr>
	
	<tr>
	<td>邮箱</td>
	<td><input type="text" name="mail"  value="${requestScope.login.mail}"></td>
	</tr>
	<tr>
	<td>电话</td>
	<td><input type="text" name="tel"  value= "${requestScope.login.tel}"></td>
	</tr>
	<tr>
	<td colspan="2">&nbsp&nbsp&nbsp&nbsp<input type="submit" value="修改" >&nbsp&nbsp&nbsp<input type="reset" value="取消"></td>
	</tr>
	</table>
	<center><a href="adminsuccess.jsp">返回首页</a></center>
	</form>
	<hr>
	<p align="center">
  	@2015
	</p>
	  </body>
	</html>