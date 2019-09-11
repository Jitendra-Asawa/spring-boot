<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Records</title>
</head>
<body>

	${studentList}

	<br>
	<br> ${teacherList}
	<br>
	<c:forEach items="${teacherList}" var="teacher">
		<c:out value="${teacher.getId() }" />
		<c:out value="${teacher.getName() }" />
		<c:out value="${teacher.getSalary() }" />
		<c:out value="${teacher.getTimeCreate() }" />
		<c:out value="${teacher.getTimeUpdate() }" />
	</c:forEach>
	
	<br> ${customerList}
	<br>
	<c:forEach items="${customerList}" var="customer">
		<c:out value="${customer.getId() }" />
		<c:out value="${customer.getName() }" />
		<c:out value="${customer.getAmount() }" />
		<c:out value="${customer.getFormatCreate() }" />
		<c:out value="${customer.getFormatUpdate() }" />
	</c:forEach>
</body>
</html>