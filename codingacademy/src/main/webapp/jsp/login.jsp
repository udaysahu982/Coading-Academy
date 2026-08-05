<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Wada come to Login</h1>


<form action="loginuser" method="post">

<table>

	<tr>
	<td><input name="loginid" type="text" placeholder="Enter your email"> </td>
	</tr>
	
	<tr>
	<td><input name="password" type="text" placeholder="Enter your password"> </td>
	</tr>
	
	<tr>
	<td> <input type="submit" value="submit"> </td>
	</tr>
	
</table>
<h4>${error}</h4>

</form>
</body>
</html>