<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form action="insert.job" method="post">
     <h2><center>职位添加</center></h2>
    <table border="0" width="500" height="50" align="center">
	<tr>
	<td >工号</td>
	<td><input type="text" name="jobid" ></td>
	</tr>
	<tr>
	<td>名称</td>
	<td><input type="text" name="jobtitle" ></td>
	</tr>
	<tr>
	<td>最大工资</td>
	<td><input type="text" name="maxsalary"  ></td>
	</tr>
	<tr>
	<td>最小工资</td>
	<td><input type="text" name="minsalary"  ></td>
	</tr>
	<tr>
	<td colspan="2">&nbsp&nbsp&nbsp&nbsp<input type="submit" value="添加" >&nbsp&nbsp&nbsp<input type="reset" value="取消"></td>
	</tr>
	</table>
	</form>
	<h2 align="center"><a  href="adminsuccess.jsp">返回主页</a></h2>
  </body>
</html>
