<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/error/404.jsp</title>
<jsp:include page="../include/resource.jsp"/>
</head>
<body>

<div class="container">
	<h1>404</h1>
	<p class="alert alert-danger">
		This page is NOT exist.
		<a href="${pageContext.request.contextPath }/home.do">Go back to main page</a>
	</p>
</div>

</body>
</html>