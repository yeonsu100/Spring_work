<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<style>
	h1{color:#FFB9B9;}
	h3{color:#B2EBF4;}
</style>
</head>
<body>

<div class="container">
	<h1>Index Page</h1>
	
	<h3>To Do List</h3>
	<ul>
		<li><a href="todo/list.do">Show to do list (To do Table)</a></li>
	</ul>
	
	<h3>Notice</h3>
	<ul>
		<c:forEach var="tmp" items="${requestScope.notice }">
			<li>${tmp }</li>
		</c:forEach>
	</ul>
</div>

</body>
</html>