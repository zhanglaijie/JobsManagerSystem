<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  </head>
  
  <body>
  
  	<form action="assignok.action" method="post" name="assign">
  	<table align="center">
  	<caption>职位任命</caption>
  	<tr>
  	<td>用户名：</td>
  	<td>
  	<select  name="loginselect">  
	  	<c:forEach items="${requestScope.persion}" var="login">
		 <option value="${login.loginid}">${login.loginid}</option> 	
		</c:forEach>
 	</select>
 	</td>
 	</tr>
 	<tr>
 	<td>工号：</td>
 	<td>
 	<select name="jobselect">
	  	<c:forEach items="${requestScope.job}" var="job">
	  	<option value="${job.jobId}">${job.jobTitle}</option>
		</c:forEach>
	</select>
	</td>
	</tr>
	<tr>
	<td><input type="submit" value="确认任命"></td>
	</tr>
	</table>
  	</form>
  	<h2 align="center"><a  href="adminsuccess.jsp">返回主页</a></h2>
  </body>
</html>
