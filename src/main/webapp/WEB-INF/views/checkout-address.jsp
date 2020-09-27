<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="header.jsp" />	
	<ul class="nav nav-pills ">
		<li class="nav-item"><a class="btn btn-outline-primary btn-sm m-1" href="${pageContext.request.contextPath}/user/home">Home</a></li>
		<li class="nav-item"><a class="btn btn-outline-primary btn-sm m-1" href="${pageContext.request.contextPath}/user/show-kit">Show Kit</a></li>
		<li class="nav-item"><a class="btn btn-outline-primary btn-sm m-1" href="${pageContext.request.contextPath}/user/show-list">Add Products</a></li>
	</ul>
	<div align="center">
	<h1 align="center" style="font: normal; font-size: 20px; color: blue;">Provide Address</h1>
		<table>
			<tr>
				<td>
					<form action="${pageContext.request.contextPath}/user/finalize" method="post">
						<label>Address	:    <textarea name="address" rows="3" cols="40" required></textarea></label> <br> <br>
						<div align="center">
							<button class="btn btn-outline-primary btn-sm m-1" >Submit Order</button>
						</div>
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>