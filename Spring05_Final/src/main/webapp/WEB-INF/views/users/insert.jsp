<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/insert.jsp</title>
<jsp:include page="../include/resource.jsp"/>
</head>
<body>

<div class="container">
	<h1>Alert!</h1>
	<p>
		Successfully Signed up! <strong>${dto.id }</strong>
		<a href="${pageContext.request.contextPath }/users/loginform.do">Go to the sign in page</a>
	</p>
</div>

</body>
</html>