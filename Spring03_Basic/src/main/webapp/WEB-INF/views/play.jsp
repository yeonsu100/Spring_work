<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/play.jsp</title>
</head>
<body>

<h1>Users ONLY are allowed on this page</h1>
<p>Let's have a fun <strong>${id }</strong>!</p>
<a href="${pageContext.request.contextPath }/">Go to the Index page</a>

</body>
</html>