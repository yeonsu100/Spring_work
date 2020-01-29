<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/WEB-INF/views/users/login.jsp</title>
</head>
<body>

<h1>Alert!</h1>
<c:choose>
	<c:when test="${requestScope.isSuccess }">
		<p>Successfully Signed in as <strong>${sessionScope.id }</strong>
			<a href="${pageContext.request.contextPath }/">Confirm</a>
		</p>
	</c:when>
	<c:otherwise>
		<p>ID or Password is wrong.
			<a href="${pageContext.request.contextPath }/users/loginform.do"></a>
		</p>
	</c:otherwise>
</c:choose>

</body>
</html>