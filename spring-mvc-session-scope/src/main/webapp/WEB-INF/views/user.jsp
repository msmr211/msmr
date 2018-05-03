<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BORAJI.COM</title>
</head>
<body>
<h1>User profile Page</h1>
<table>
	<tr>
		<td>First Name</td>
		<td>${user.fname}</td>
	</tr>
	<tr>
		<td>Middle Name</td>
		<td>${user.mname}</td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td>${user.lname}</td>
	</tr>
	<tr>
		<td>Age</td>
		<td>${user.age}</td>
	</tr>
</table>

</body>
</html>