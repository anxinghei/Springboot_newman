<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>邮件模板</title>
</head>
<body>
	
	<div>这是${title}</div>
<table border="1">
	<tr>
		<td>用户名</td>
		<td>性别</td>
	</tr>
	<#list userList as user>
		<tr>	
			<td>${user.userName}</td>
			<td>${user.sex}</td>	
		</tr>
	</#list>
</table>

</body>
</html>