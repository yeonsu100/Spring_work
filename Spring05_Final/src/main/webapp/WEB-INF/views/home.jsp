<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
<jsp:include page="include/resource.jsp"/>
</head>
<body>
<jsp:include page="include/navbar.jsp"/>

<div class="container">
	<h1>Index Page</h1>
	
	<ul>
		<li><a href="member/list.do">Show member list (Member Table)</a></li>
		<li><a href="angular/test01.html">angularjs test - 1</a></li>
		<li><a href="angular/test02.html">angularjs test - 2</a></li>
		<li><a href="angular/test03.html">angularjs test - 3</a></li>
		<li><a href="angular/test04.html">angularjs test - 4</a></li>
		<li><p>테스트 중입니다...By 연수</p></li>
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