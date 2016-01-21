<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="foooot.job.bean.JobBean" %>
<%@ page import="foooot.job.dao.JobDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
  <% 
  	int jobid = Integer.parseInt(request.getParameter("jobid")) ;
  	JobBean bean = new JobBean();
  	JobDao dao = new JobDao();
  	bean = dao.queryByIdJob(jobid);
  %>
  	<form action="update.job" method="post">
     <h2><center>职位更改</center></h2>
    <table border="0" width="500" height="50" align="center">
	<tr>
	<td >工号</td>
	<td><input type="text" name="jobid"  value= <%= bean.getJobId() %>></td>
	</tr>
	<tr>
	<td>名称</td>
	<td><input type="text" name="jobtitle"  value= <%= bean.getJobTitle() %>></td>
	</tr>
	<tr>
	<td>最大工资</td>
	<td><input type="text" name="maxsalary"  value= <%= bean.getMaxSalary() %>></td>
	</tr>
	<tr>
	<td>最小工资</td>
	<td><input type="text" name="minsalary"  value= <%= bean.getMinSalary() %>></td>
	</tr>
	<tr>
	<td colspan="2">&nbsp&nbsp&nbsp&nbsp<input type="submit" value="修改" >&nbsp&nbsp&nbsp<input type="reset" value="取消"></td>
	</tr>
	</table>
	</form>
  </body>
</html>
