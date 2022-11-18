<%@page import="com.ideas2it.productManagement.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<title>Product Menu</title>
</head>
<body>
<ol>
	<div class="container">
			    <li><a href="createProduct"><button
							class="btn btn-success btn-sm">Create</button></a><br></li><hr>
							
				<li><a href="getProducts"><button
							class="btn btn-success btn-sm">All Products</button></a><br></li><hr>
			
				<li><a href="displayProduct"><button
							class="btn btn-success btn-sm">Product Details</button></a><br></li><hr>
							
				<li><a href="deleteProduct"><button
							class="btn btn-success btn-sm">Delete </button></a><br></li><hr>
			
				<li><a href="updateProduct.jsp"><button
							class="btn btn-success btn-sm">Update </button></a><br></li><hr>
		
				<li><a href="searchProduct"><button
							class="btn btn-success btn-sm">Search</button></a> <br></li><hr>
					
				<li><a href="getProductBetweenDate.jsp"><button
							class="btn btn-success btn-sm">Display Product Between Date</button></a></li><br><hr>
				
				<li><a href="getChoice.jsp"><button
							class="btn btn-success btn-sm">Multiple Product</button></a></li><hr>
	</div>
	</ol>
</body>
</html>