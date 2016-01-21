<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head>
    <title>注册页面</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <script type="text/javascript">
		function createRequest(url)
		{
			http_request=false;
			if(window.XMLHttpRequest)
			{
				http_request = new XMLHttpRequest();
			}
			else if(window.ActiveXObject)
			{
				try{
				http_request = new ActiveXObject("Msxml2.XMLHTTP");
				}
				catch(e){
				try{
				http_request = new ActiveXObject("Microsoft.XMLHTTP"); 
				}
				catch(e){}
				}	
			}
			if(!http_request)
			{
				alert("不能创建");
				return false;
			}
			http_request.onreadystatechange=getResult;
			http_request.open("GET", url, true);
			http_request.send(null);
		}
		
		function getResult()
		{
			
			if(http_request.readyState==4){
				if(http_request.status==200){
				alert(http_request.responseText);
				}
				else 
				{
					alert("你请求的页面有错");
				}
			}
			
		}
		
		function checkUser(userName)
		{
			if(userName.value=="")
			{
				alert("请输入用户名");
				userName.focus();
				return;
			}
			else{
				createRequest('check.action?loginid='+register1.loginid.value);
				
			}
		}
	
	</script>

</style>

  </head>
    <body>
 <form action="register.action" method="post" name="register1">
    <h2><center>注册信息</center></h2>
    <table border="0" width="500" height="50" align="center">
	<tr>
	<td >用户名</td>
	<td><input type="text" name="loginid"></td>
	<td>
		<img alt="image/jiance.jpg" src="image/jiance2.jpg" 
    	width="104" height="23" style="cursor:hand;" onclick="checkUser(register1.loginid);">
	</tr>
	<tr>
	<td>密码</td>
	<td><input type="password" name="passwd"></td>
	<td>*密码不能为空</td>
	</tr>
	<tr>
	<td>生日</td>
	<td><input type="text" name="birth"></td>
	<td>*可为空</td>
	</tr>
	<tr>
	<td>性别</td>
	<td><input type="radio" name="sex" checked value='1' >男&nbsp;&nbsp;
	<input type="radio" name="sex" value='2'>女
	</td>
	</tr>
	<tr>
	<td>邮箱</td>
	<td><input type="text" name="mail"></td>
	<td>*可为空</td>
	</tr>
	<tr>
	<td>电话</td>
	<td><input type="text" name="tel"></td>
	<td>*可为空</td>
	</tr>
	<tr>
	<td colspan="2">&nbsp&nbsp&nbsp&nbsp<input type="submit" value="注册" >&nbsp&nbsp&nbsp<input type="reset" value="取消"></td>
	</tr>
	</table>
	<center><a href="index.jsp">已有账号？返回登陆</a></center>
	</form>
	<hr>
	<p align="center">
  	@2015
	</p>
	  </body>
	</html>

