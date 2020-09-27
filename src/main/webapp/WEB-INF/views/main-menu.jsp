<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<h1>Welcome to Corona Prevention Kit Dashboard</h1>
	<hr>
	<jsp:include page="header.jsp" />
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		 <div class="collapse navbar-collapse" id="collapsibleNavbar">

 <c:choose>
      	<c:when test="${unm!=null && role=='ADMIN' }">
      	<ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath }/admin/home">ADMIN DASHBOARD</a>
	      </li>   
	    
	      </ul>
	      </c:when>
	     
      	<c:when test="${unm!=null && role=='USER' }">
      	<ul class="navbar-nav"> 
	      	<li class="nav-item">
		       <a class="nav-link" href="${pageContext.request.contextPath }/user/home">USER DASHBOARD</a>
		    </li>
		   
	      </ul>	
      	</c:when>
      	
      	
      </c:choose>
      </div>
      </nav>
</body>
<br>
<br>
<br>

</html>