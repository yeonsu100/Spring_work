<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/todo/list.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<style>
	h1{color:#FFB9B9;}
	h3{color:#B2EBF4;}
</style>
</head>
<body>

<div class="container">
	<h1>List of Daily Assignments</h1>
	<table class="table table-striped table-hover">
		<colgroup> 
			<col class="col-xs-1"/>
			<col class="col-xs-4"/>
			<col class="col-xs-3"/>
			<col class="col-xs-1"/>
			<col class="col-xs-1"/>
		</colgroup>
		<thead>
			<tr>
				<th>No.</th>
				<th>Content</th>
				<th>Dates</th>
				<th>Edit</th>
				<th>Remove</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${requestScope.list }">	
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.content }</td>
					<td>${tmp.regdate }</td>
					<td><a href="updateform.do?num=${tmp.num }"><span class="glyphicon glyphicon-edit"></span></a></td>
					<td><a href="delete.do?num=${tmp.num }"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h3><a href="insertform.do">Add an assignment</a></h3>
</div>

</body>
</html>