<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/delete.jsp</title>
<jsp:include page="../include/resource.jsp"/>
</head>
<body>

<script>
	alert("Removed this account safely. (User name : ${id})");
	location.href="${pageContext.request.contextPath }/";
</script>

</body>
</html>