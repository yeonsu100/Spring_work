<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/list.jsp</title>
</head>
<body>

<div class="container">
	<h1>List of members</h1>
	<table>
		<thead>
			<tr>
				<th>No.</th>
				<th>NAME</th>
				<th>ADDRESS</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${requestScope.list }">		<!-- tmp의 타입 : MemberDto -->
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.name }</td>
					<td>${tmp.addr }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>