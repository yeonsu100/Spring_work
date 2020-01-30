<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>

<div class="container">
	<h1>Index Page</h1>
	
	<ul>
		<li><a href="member/list.do">Show member list (Member Table)</a></li>
	</ul>
	
	<h2>Notice</h2>
	<ul>
		<c:forEach var="tmp" items="${requestScope.notice }">
			<li>${tmp }</li>
		</c:forEach>
	</ul>
</div>

</body>
</html>