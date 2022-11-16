<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:from method="post" action="InsertManufacturer" modelAttribute="references">
	<table>
	
		<tr>
			<td>Brand</td>
			<td><form:input type="text" path="brand" /></td>
		</tr>
		<tr>
			<td>Place</td>
			<td><form:input type="text" path ="place" /></td>
		</tr>
		<tr>
			<td><button type="submit">Submit</td>
		</tr>
		</table>
		</form:from>
</body>
</html>