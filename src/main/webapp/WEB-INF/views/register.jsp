<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user registration</title>
</head>
<body>
	<h2>New User? Register here...</h2>
	<hr/>
	
	<spring:form action="${pageContext.request.contextPath}/register-save" method="POST" modelAttribute="userDetails">
		<br/>
		<br/>
		<spring:label path="userName">Enter user name</spring:label>
		<spring:input path="userName"/>
		<br/>
		<br/>
		<spring:label path="password">Enter password</spring:label>
		<spring:password  path="password"/>
		<br/>
		<br/>
		<spring:label path="confirmPassword">Confirm Password</spring:label>
		<spring:password path="confirmPassword"/>
		<br/>
		<br/>
		<spring:label path="email">Enter email</spring:label>
		<spring:input path="email"/>
		<br/>
		<br/>
		<spring:label path="contact">Enter Contact number</spring:label>
		<spring:input path="contact"/>
		<br/>
		<br/>
		<spring:label path="roles">Select Role</spring:label>
		<ul>
			<li> <spring:checkbox path="roles" value="ADMIN" label="ADMIN"/></li>
			<li> <spring:checkbox path="roles" value="USER" label="USER"/></li>
		</ul>
		<br/>
		<br/>
		<input type="submit" value="Register">

	</spring:form>
	
</body>
</html>