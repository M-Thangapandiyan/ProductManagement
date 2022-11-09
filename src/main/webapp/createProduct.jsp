<%@page import="com.ideas2it.productManagement.model.Product"%>
<%@page import="com.ideas2it.productManagement.model.Manufacturer"%>
<%@page import="com.ideas2it.productManagement.model.Dealer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<% Manufacturer manufacturer = null;
Dealer dealer = null; %>
<style>
.myDiv {
  border: 0.5px outset red;
  background-color: lightblue;
  text-align: center;
}

.myDiver {
  border: 0.5px outset red;
  background-color: blue;
  text-align: center;
}
</style>

<head>
<div class="myDiv">
<h1 class="btn btn-success btn-sm"> Create Product</h1>
</div>
<body>
	<form method="get" action="assignManufacturer"></form>
	<form method="get" action="assignDealer"></form>
	<form method="post" action="InsertProduct">
		<table>
			<div class = "myDiver">
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</div>
			<tr>
				<td>Price</td>
				<td><input type="number" name="Price"></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<td>Color</td>
				<td>
				<input type="radio" name="colour" value="RED" id = "red"><label for = "red">RED</label>
				<input type="radio" name="colour" value="BLUE" id = "blue"><label for = "blue">RED</label>
				<input type="radio" name="colour" value="GREEN" id = "green"><label for = "green">RED</label>
				<input type="radio" name="colour" value="YELLOW" id = "yellow"><label for = "yellow">RED</label>
			</tr>
			<tr>
				<td><a href="assignManufacturer"><input type="button"
						value="assignManufacturer"></a></td>
				<td>
					<%
					List<Manufacturer> manufacturers = (List<Manufacturer>) session.getAttribute("manufacturers");
					%> <%
                    if (null != manufacturers) {
                    %><select name="manufacturerId" required>
						<%
						for (int index = 0; index < manufacturers.size(); index++) {
						%>
						<%
						manufacturer = manufacturers.get(index);
						%>
						<option value="<%=manufacturer.getId()%>">
							<%=manufacturer%>
						</option>
						<%
						}
						%>
				</select> <%
                       }
                       %>
				</td>
			</tr>

			<tr>
				<td><a href="assignDealer"> <input type="button"
						value="assignDealer">
				</a></td>
				<td>
					<%
					List<Dealer> dealers = (List<Dealer>) session.getAttribute("dealers");
					%> <%
 if (null != dealers) {
 %><select name="dealerId" required>

						<%
						for (int index = 0; index < dealers.size(); index++) {
						%>
						<%
						dealer = dealers.get(index);
						%>
						<option value="<%=dealer.getId()%>">
							<%=dealer%>
						</option>
						<%
						}
						%>
				</select> <%
 }
 %>
				</td>
			</tr>
			<tr>
				<td><button type="submit">Submit</td>
			</tr>
		</table>
	</form>
	
	<div>
  <h2>Created Product</h2>

	<%
	Product product = (Product) session.getAttribute("product");
	%>
	<%
	if (null != product) {
	%>
	<table>
		<tr>
			<td>id</td>
			<td><%=product.getId()%></td>
		</tr>
		<tr>
			<td>Code</td>
			<td><%=product.getCode()%></td>
		</tr>

		<tr>
			<td>Name</td>
			<td><%=product.getName()%></td>
		</tr>

		<tr>
			<td>Price</td>
			<td><%=product.getPrice()%></td>
		</tr>

		<tr>
			<td>Color</td>
			<td><%=product.getColour()%></td>
		</tr>

		<tr>
			<td>LifeTime</td>
			<td><%=product.getLifeTime(product.getDate())%></td>
		</tr>

		<tr>
			<td>Dealer</td>
			<td><%=product.getDealer()%></td>
		</tr>

		<tr>
			<td>Manufacturer</td>
			<td><%=product.getManufacturer()%></td>
		</tr>
	</table>
	<%
	}
	%>
	</div>
</body>
</html>