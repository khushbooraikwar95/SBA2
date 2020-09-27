<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Add New Product</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>  
  	<jsp:include page="header.jsp" />	
	<ul class="nav nav-pills ">
		<li class="nav-item"><a class="btn btn-outline-primary btn-sm m-1"  role="button" href="${pageContext.request.contextPath}/admin/home">Home</a></li>
		<li class="nav-item"><a class="btn btn-outline-primary btn-sm m-1" href="${pageContext.request.contextPath}/admin/product-list">View Products</a></li>
	</ul>
  	<h2 align="center" style="font: normal; color: blue;">Add Product</h2>
  <div align="center">
    <div align="left" style="display: inline-block; padding: 10px;">
      <form:form action="${pageContext.request.contextPath}/admin/product-save" method="post" modelAttribute="product">
      
        <div class="form-group row">
          <form:label class="col-sm-2 col-form-label" path="productName">Name:</form:label>
          <form:input class="form-control" type="text" path="productName" required="required" maxlength="50" />
          <form:errors path="productName"/>
        </div>
        <div class="form-group row">
          <form:label class="col-sm-2 col-form-label" path="cost">Cost:</form:label>
          <form:input class="form-control" type="number" path="cost" step="1" min="1" required="required" />
          <form:errors path="cost"/>
        </div>
        <div class="form-group row">
          <form:label class="col-sm-2 col-form-label" path="productDescription">Description:</form:label>
          <form:input class="form-control" type="text" path="productDescription" maxlength="100" />
          <form:errors path="productDescription"/>
        </div>
       <button>SAVE</button>	
        <br>
      </form:form>
    </div>
  </div>
</body>

</html>