<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
</head>
<body>
<form>
	<input type="button" onclick="history.back()" value="Go Back" />
</form>
<h3 style="text-align: center">Fill in Customer details</h3>
<form action="createCustomer" method="post">
	ID: <input type="number" name="id" required pattern="[0-9]+">
	Name: <input type="text" name="name" required pattern="[a-zA-Z ]+">
	Amount: <input type="number" name="amount" pattern="[0-9]+">
	<button type="submit" value="ms">Submit</button>
</form>

</body>
</html>