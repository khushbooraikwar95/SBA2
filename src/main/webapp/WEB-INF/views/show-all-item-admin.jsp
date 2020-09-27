<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</head>
<body>	
	<jsp:include page="header.jsp" />	
	<ul class="nav nav-pills ">
		<li class="nav-item"><a class="btn btn-outline-primary btn-sm m-1" href="${pageContext.request.contextPath}/admin/home">Home</a></li>
		<li class="nav-item"><a class="btn btn-outline-primary btn-sm m-1" href="${pageContext.request.contextPath}/admin/product-entry">Add Product</a></li>
	</ul>
	
	<h1 align="center"	style="font: normal; font-size: 30px; color: blue;">All Products</h1>
	<c:choose>
		<c:when test="${products==null || products.isEmpty() }">
			<div align="center" style="font: normal; font-size: 20px; color: red;">No products found. Add some products!!</div>
		</c:when>
		<c:otherwise>
			<div align="center">
				<div style="display: inline-block; border: thin solid black; padding: 10px;">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="col" >Product Id</th>
								<th scope="col" >Name</th>
								<th scope="col" >Description</th>
								<th scope="col" >cost</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${products }" var="product">
								<tr>
									<td>${product.id }</td>
									<td>${product.productName }</td>
									<td>${product.productDescription }</td>
									<td>${product.cost }</td>
									<td><a class="btn" href="${pageContext.request.contextPath}/admin/product-delete/${product.id }">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	
</body>
</html>