<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User-dashboard</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<h2>This is User Dashboard</h2>
	<hr>
	<jsp:include page="header.jsp" />
	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		<security:authorize access="hasRole('USER')">
			<a class="btn btn-outline-primary btn-sm m-1" href="${pageContext.request.contextPath}/user/home">Home</a>
		</security:authorize>
	</nav>
	<div style="padding-left: 30px">
		<h3>Select an option</h3>
		<ul>
			<li><a href="${pageContext.request.contextPath}/user/show-list">View & Add Products</a></li>
			<li><a href="${pageContext.request.contextPath}/user/show-kit">Show Kit</a></li>
		</ul>
	</div>
</body>
</html>