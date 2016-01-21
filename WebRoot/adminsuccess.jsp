<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
	<title>登陆成功</title>
</head>
<body bgcolor="#90EE90">

<p align="right"><br>欢迎光临，${requestScope.persion.loginid}|<a href="index.jsp">注销</a></p>
<center><font size=6><P>职务管理系统</font></center>
<table cellSpacing="1" cellPadding="1" width="500" align="center" border="0">
	<tr valign="bottom">
		<td align="center"><a href="info.action">所有会员</a></td>
		<td align="center"><a href="select.jsp">会员查找</a></td>
		<td align="center"><a href="showjob.job">所有职位</a></td>
	</tr>
	<tr valign="bottom">
		<td align="center"><a href="./job/insertjob.jsp">职位添加</a></td>
		<td align="center"><a href="assign.action">职位任命</a></td>
	</tr>
</table>
</body>
</html>
