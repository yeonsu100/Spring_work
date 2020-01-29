<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>

<h1>Index Page</h1>

<ul>		<%-- 아직 DB와 연동하지 않았지만 가상의 To Do 리스트를 출력해보자 --%>
	<li><a href="todo/list.do">To Do List - 1</a></li>
	<li><a href="todo/list2.do">To Do List - 2</a></li>
	<li><a href="todo/list3.do">To Do List - 3</a></li>
</ul>

<h2>Notice</h2>
<ul>
	<c:forEach var="tmp" items="${requestScope.notice }">
		<li>${tmp }</li>
	</c:forEach>
</ul>

</body>
</html>