<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>

<h1>Index Page</h1>
<p>Hi, Chloe. Aloha!</p>

<ul>
	<li><a href="fortune.do">Show today's fortune</a></li>
	<li><a href="person.do">Show today's person</a></li>
</ul>

<h2>Notice</h2>
<ul>
	<c:forEach var="tmp" items="${requestScope.notice }">
		<li>${tmp }</li>
	</c:forEach>
</ul>

</body>
</html>