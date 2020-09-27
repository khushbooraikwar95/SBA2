<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unauthorized Access Error</title>
</head>
<body>
<h1><security:authentication property="principal.username"/> is not authorized to view page as
<security:authorize access="hasRole('ADMIN')">
	"ADMIN"
</security:authorize>
<security:authorize access="hasRole('USER')">
	"Normal"
</security:authorize></h1>
<a href="${pageContext.request.contextPath}/">HOME</a>

</body>
</html>