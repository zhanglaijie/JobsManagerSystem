<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<title>查找用户</title>
<body>
	<h2 align="center">用户查找</h2>
	<form action="select.action" method="post">
		<table align="center">
		<tr>
			<td>账号:</td>
			<td><input type="text" name="loginid" ></td>
			<td><input type="submit" value="查找"></td>
		</tr>
		</table>
	</form>
	<h2 align="center"><a  href="adminsuccess.jsp">返回主页</a></h2>
</body>
</html>