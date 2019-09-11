<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Index Page
	<form action="hello">
		<input type="text" name="name"> <input type="submit"
			value="Click me">
	</form>
	<form action="teachers" method="get">
		<input type="submit" value="Teacher Records">
	</form>
	<form action="students" method="get">
		<input type="submit" value="Student Records">
	</form>
	<form action="customers" method="get">
		<input type="submit" value="Customer Records">
	</form>
	<form action="createCustomerRecord.jsp" method="post">
		<input type="submit" value="Create Customer">
	</form>
	<form action="deleteCustomer" method="post">
		<input type="submit" value="Delete Customer">
	</form>
	<form action="error" method="get">
		<input type="submit" value="Error Generate">
	</form><br>
	Upload doesn't work
	<form action="upload" method="post">
		<input type="file" name="file">
		<input type="submit" value="upload">
	</form><br>
	<form action="download" method="get">
		<button name="file" value="mysql.txt">download file</button>
	</form>
</body>
</html>