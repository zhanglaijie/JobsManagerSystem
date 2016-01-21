<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/default.css"/>
<title> 会员显示 </title>
</head>
<body bgcolor="#90EE90" >
<h1 align="center">会员列表</h1>
<table  width="80%"  class="default" align="center" border="1">
<tr class="title">
	<td >用户名</td>
	<td >密码</td>
	<td >生日</td>
	<td >性别</td>
	<td >邮箱</td>
	<td >电话</td>
	<td>工号</td>
	<td>工资</td>
	<td colspan="2">操作	</td>	
</tr>
<c:forEach items="${requestScope.all}" var="login">
<tr>
	<td> <c:out value="${login.loginid}"></c:out> </td>
	<td><c:out value="${login.passwd}"></c:out> </td>
	<td><c:out value="${login.birth}"></c:out> </td>
	<td><c:out value='${login.sex=="1"?"男":"女"}'></c:out> </td>
	<td><c:out value="${login.mail}"></c:out> </td>
	<td><c:out value="${login.tel}"></c:out> </td>
	<td><c:out value="${login.jobid}"></c:out> </td>
	<td><c:out value="${login.salary}"></c:out> </td>
	<td>
	 <a href="./update.action?loginid=${login.loginid}">修改信息</a>
	|<a	href="./deleteone.action?loginid=${login.loginid}">删除</a>
	|<a href="./give.action?loginid=${login.loginid}">发工资</a>
	</td>	
<tr>
</c:forEach>
</table>
<h2 align="center"><a  href="adminsuccess.jsp">返回主页</a></h2>
</body>
</html>