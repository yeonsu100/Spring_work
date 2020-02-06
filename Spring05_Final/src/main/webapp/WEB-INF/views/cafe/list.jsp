<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/cafe/list.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
<style>
	h1{color : #6799FF;}
	h3{color : #FF9090;}
</style>
</head>
<body>
<jsp:include page="../include/navbar.jsp">
	<jsp:param value="cafe" name="category" />
</jsp:include>
	
<div class="container">
	<ol class="breadcrumb">
		<li><a href="list.do">Show all contents (List)</a></li>
	</ol>
	
	<h1>Article List</h1>
	<table class="table table-striped table-condensed">
		<colgroup>  <!-- 값을 다 더했을 때 12가 되도록 -->
			<col class="col-xs-1"/>
			<col class="col-xs-2"/>
			<col class="col-xs-4"/>
			<col class="col-xs-1"/>
			<col class="col-xs-2"/>
		</colgroup>
			<thead>
				<tr>
					<th>No.</th>
					<th>Writer</th>
					<th>Title</th>
					<th>View</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="tmp" items="${requestScope.list }">
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.writer }</td>
					<td>
						<a href="detail.do?num=${tmp.num }
						&condition=${condition}&keyword=${encodedKeyword}">${tmp.title }</a>
					</td>
					<td>${tmp.viewCount }</td>
					<td>${tmp.regdate }</td>
				</tr>
			</c:forEach>
			</tbody>
	</table>
	
	<h3><a href="insertform.do">Create a new article</a></h3>

	<div class="page-display pager">
		<ul class="pagination pagination-sm">
		
		<c:choose>
			<c:when test="${startPageNum ne 1 }">
				<li>
					<a href="list.do?pageNum=${startPageNum-1 }
					&condition=${condition}&keyword=${encodedKeyword}">&laquo;</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="disabled">
					<a href="javascript:">&laquo;</a>
				</li>
			</c:otherwise>
		</c:choose>
		
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }" step="1">
			<c:choose>
				<c:when test="${i eq pageNum }">
					<li class="active">
						<a href="list.do?pageNum=${i }
						&condition=${condition}&keyword=${encodedKeyword}">${i }</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="list.do?pageNum=${i }
						&condition=${condition}&keyword=${encodedKeyword}">${i }</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

			<c:choose>
				<c:when test="${endPageNum lt totalPageCount }">
					<li>
						<a href="list.do?pageNum=${endPageNum+1 }
						&condition=${condition}&keyword=${encodedKeyword}">&raquo;</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="disabled">
						<a href="javascript:">&raquo;</a>
					</li>
				</c:otherwise>
			</c:choose>				
		</ul>
	</div>
	
	<form action="list.do" method="get" >
		<label for="condition">검색조건</label>
		<select name="condition" id="condition">
			<option value="titlecontent" <c:if test="${condition eq 'titlecontent' }">selected</c:if>>Title OR Content</option>
			<option value="title" <c:if test="${condition eq 'title' }">selected</c:if>>Title</option>
			<option value="writer" <c:if test="${condition eq 'writer' }">selected</c:if>>Writer</option>
		</select>
		<input value="${keyword }" type="text" name="keyword" placeholder="Enter a Keyword..."/>
		<button type="submit">Search</button>
	</form>
	<c:choose>
		<c:when test="${not empty keyword }">
			<p> The keyword (<strong>${keyword }</strong>) that you searched is here. </br>
					Count of it. : <strong>${totalRow }</strong></p>
		</c:when>
		<c:otherwise>
				<p>Total : <strong>${totalRow }</strong> files are here.</p>
			</c:otherwise>
	</c:choose>
</div>
</body>
</html>