<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="deleteProduct">
				<input type="number" name="id" placeholder = "Enter the ProductId: ">
		<table>
			<tr>
				<td><button type="submit"> </button>Submit</td>
			</tr>
		</table>
	</form>
	${found}
</body>
</html>