<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring-form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<header>
	<nav class="navbar navbar-light bg-light justify-content-between">
		<span class="navbar-brand mb-0 h1">Stay home! Stay Safe! <security:authentication property="principal.username" /></span> 
		<spring-form:form class="form-inline" action="${pageContext.request.contextPath}/logout" method="POST">			
			<input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Logout">
		</spring-form:form>
	</nav>
</header>