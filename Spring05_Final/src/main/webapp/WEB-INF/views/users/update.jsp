<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/update.jsp</title>
</head>
<body>

<div class="container">
	<c:choose>
		<c:when test="${isSuccess }">
			<script>
				alert("Successfully Updated!")
				location.href="info.do";
			</script>
		</c:when>
		<c:otherwise>
			<h1>Alert</h1>
			<p>Failure to update
			<a href="updateform.do">Please try it again.</a>
			</p>
		</c:otherwise>
	</c:choose>
</div>

</body>
</html>