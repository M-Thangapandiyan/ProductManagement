<%@page import="com.ideas2it.productManagement.model.Dealer"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" action="InsertDealer"
		modelAttribute="references">
		<table>
			<form:input type="hidden" path="id" />
			<tr>
				<td>Company</td>
				<td><form:input type="text" path="company" /></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><form:input type="text" path="location" /></td>
			</tr>
			<tr>
				<td><button type="submit">Submit</button></td>
			</tr>
		</table>
	</form:form>
	<%
	if (null != request.getAttribute("reference") && !("updated successfully".equals(request.getAttribute("reference")))) {
	%>
    <%
	Dealer dealer = (Dealer) request.getAttribute("reference");
	%>
	<%="Created Successfully"%>
	<table>

		<tr>
			<td>id</td>
			<td><%=dealer.getId()%></td>
		</tr>

		<tr>
			<td>Company</td>
			<td><%=dealer.getCompany()%></td>
		</tr>

		<tr>
			<td>Location</td>
			<td><%=dealer.getLocation()%></td>
		</tr>
	</table>
	<%
	} else {
	%>
	${reference}
	<%
	}
	%>

</body>
</html>