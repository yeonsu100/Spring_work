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
				<th>UPDATE</th>
				<th>DELETE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${requestScope.list }">		<!-- tmp의 타입 : MemberDto -->
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.name }</td>
					<td>${tmp.addr }</td>
					<td><a href="updateform.do?num=${tmp.num }">Update</a></td>
					<td><a href="delete.do?num=${tmp.num }">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="insertform.do">Add a member</a>
</div>

</body>
</html>