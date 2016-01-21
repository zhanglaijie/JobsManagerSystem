<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>登陆成功</title>
</head>
<body bgcolor="#90EE90">
${requestScope.persion.loginid}

<p align="right"><br>欢迎光临，${requestScope.persion.loginid}|<a href="index.jsp">注销</a></p>
<h2 align="center">个人信息管理</h2>
<hr>
<table>
<tr>
	<td>用户名：</td>
	<td>${requestScope.persion.loginid}</td>
</tr>
<tr>
	<td>密码：</td>
	<td>${requestScope.persion.passwd}</td>
</tr>
<tr>
	<td>生日：</td>
	<td>${requestScope.persion.birth}</td>
</tr>
<tr>
	<td>性别：</td>
	<td>
	${requestScope.persion.sex=="1"?"男":"女"}
	</td>
</tr>
<tr>
	<td>邮箱：</td>
	<td>${requestScope.persion.mail}</td>
</tr>
<tr>
	<td>电话：</td>
	<td>${requestScope.persion.tel}</td>
</tr>
<tr>
	<td>职位：</td>
	<td>${requestScope.persion.jobid}</td>
</tr>
<tr>
	<td>工资：</td>
	<td>${requestScope.persion.salary}</td>
	<td><a href="./get.action?loginid=${requestScope.persion.loginid}">领取</a></td>
</tr>

<tr>
	<td><a	href="./updateone.action?loginid=${requestScope.persion.loginid}">修改信息</a></td>
	<td><a	href="./delete.action?loginid=${requestScope.persion.loginid}">删除</a></td>
</tr>
</table>
</body>
</html>
