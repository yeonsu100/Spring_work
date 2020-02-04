<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/pwd_update.do</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
</head>
<body>

<div class="container">
	<c:choose>
		<c:when test="${isSuccess }">
			<script>
			alert("Successfully changed your password!")
			location.href="info.do";
		</script>
		</c:when>
		<c:otherwise>
			<script>
			alert("Mismatch between current password and you did enter. Please confirm again!")
			location.href="pwd_updateform.do";
		</script>
		</c:otherwise>
	</c:choose>
</div>

</body>
</html>