<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method = "post" action="InsertDealer" modelAttribute ="references">
		<table>
		<tr>
			<td>Company</td>
			<td><form:input type="text" path="company"/></td>
		</tr>
		<tr>
			<td>Location</td>
			<td><form:input type="text" path="location"/></td>
		</tr>
		<tr>
			<td><button type="submit">Submit</button></td>
		</tr>
		</table>
	${reference}
	</form:form>
</body>
</html>