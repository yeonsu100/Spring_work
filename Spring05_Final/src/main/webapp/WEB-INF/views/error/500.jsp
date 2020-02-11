<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/error/500.jsp</title>
<jsp:include page="../include/resource.jsp"/>
</head>
<body>

<div class="container">
	<h1>500</h1>
	<p class="alert alert-danger">
		Error was erupted. </br>
		We'll fix it soon. Sorry about it! </br>
		<a href="${pageContext.request.contextPath }/home.do">Go back to main page</a>
	</p>
</div>

</body>
</html>