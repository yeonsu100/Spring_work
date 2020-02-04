<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/login.jsp</title>
<style>
	strong{color:skyblue;}
</style>
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${not empty sessionScope.id }">
			<p>
				Successfully signed in! </br>
				ID : <strong>${sessionScope.id }</strong> </br>
				<a href="${requestScope.url }">Back to the HOME page</a>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				Please confirm your ID or Password
				<a href="loginform.do?url=${requestScope.encodedUrl }">Back to the SIGN IN page</a>
			</p>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>
