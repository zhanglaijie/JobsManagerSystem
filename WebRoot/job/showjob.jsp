<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="foooot.job.bean.JobBean"%>
<%@ page import="foooot.job.dao.JobDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showjob.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body bgcolor="#90EE90">
	<h1 align="center">职位列表</h1>
	<table width="80%" class="default" align="center" border="1">
		<tr class="title">
			<td>职位编号：</td>
			<td>职位名称：</td>
			<td>最高工资：</td>
			<td>最低工资：</td>
			<td colspan="2">操作</td>
		</tr>

		<%  ArrayList<JobBean> lg =new ArrayList<JobBean>();
	lg =(ArrayList<JobBean>)request.getAttribute("alljob");
	System.out.println(lg);
	for(int i=0;i<lg.size();i++){
%>
		<tr>
			<td><%= lg.get(i).getJobId() %></td>
			<td><%= lg.get(i).getJobTitle() %></td>
			<td><%= lg.get(i).getMaxSalary() %></td>
			<td><%= lg.get(i).getMinSalary() %></td>
			<td><a href="./job/update.jsp?jobid=<%=lg.get(i).getJobId() %>">修改信息</a>
				| <a href="./delete.job?jobid=<%=lg.get(i).getJobId() %>">删除</a></td>
			<%}%>
		</tr>
	</table>
	<h2 align="center"><a  href="adminsuccess.jsp">返回主页</a></h2>
</body>
</html>
