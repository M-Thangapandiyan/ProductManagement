<%@page import="com.ideas2it.productManagement.model.Dealer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="getDealer">
		<input type="number" name="id" placeholder = "Enter the dealerId: ">
		<table>
			<tr>
				<td><button type="submit">Submit</td>
			</tr>
		</table>
	</form>

</body>
</html>