<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
			<%-- 위 요청은 아파치 톰캣의 기본 서블릿이 응답을 한다. 만약 위 요청경로가 .do로 끝났으면 maves을 거치게 된다. --%>
</head>
<body>

<div class="container">
	<h1>Index Page</h1>
	<c:if test="${not empty id }">
		<p>
			Signed in as <strong>${id }</strong>
			<a href="users/logout.do">Signed Out</a>
		</p>
	</c:if>
	
	<ul>		<%-- 아직 DB와 연동하지 않았지만 가상의 To Do 리스트를 출력해보자 --%>
		<li><a href="todo/list.do">To Do List - 1</a></li>
		<li><a href="todo/list2.do">To Do List - 2</a></li>
		<li><a href="todo/list3.do">To Do List - 3</a></li>
		
		<li><a href="users/loginform.do">Go to the Sign in page</a></li>
		
		<li><a href="play.do">Can access ONLY users</a></li>
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