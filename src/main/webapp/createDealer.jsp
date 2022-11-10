<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method = "post" action="InsertDealer">
		<div>
			<td><label for ="Company" >Company</label></td>
			<td><input type="text" name="company" id = "Company"></td><br>
		</div><br>
		
		<tr>
			<td><label for ="Location" >Location</label></td>
			<td><input type="text" name="location" id = "Location"></td><br>
		</tr><br>
		
		<div>
			<td><button type="submit">Submit</td>
		</div>
	</form>
</body>
</html>