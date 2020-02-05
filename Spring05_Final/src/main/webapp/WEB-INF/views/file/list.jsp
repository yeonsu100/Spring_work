<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/file/list.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
<style>
	h1{color:#6EE3F7;}
	h3{color : #FF9090;}
	thead{background-color:#B2EBF4;}
</style>
</head>
<body>
<jsp:include page="../include/navbar.jsp">
	<jsp:param value="file" name="category" />
</jsp:include>

<div class="container">
	<ol class="breadcrumb">
		<li><a href="list.do">Show all uploaded files (List)</a></li>
	</ol>
	
	<h1>List of File</h1>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>No.</th>
				<th>Writer</th>
				<th>Title</th>
				<th>File Name</th>
				<th>File Size</th>
				<th>Down Count</th>
				<th>Date</th>
				<th>Delete</th>
			</tr>
		</thead>
				
		<tbody>
		
		<c:forEach var="tmp" items="${list }">
			<tr>
				<td>${tmp.num }</td>
				<td>${tmp.writer }</td>
				<td>${tmp.title }</td>
				<td>
					<a href="download.do?num=${tmp.num }">
						${tmp.orgFileName }
					</a>
				</td>
				<td>${tmp.fileSize }</td>
				<td>${tmp.downCount }</td>
				<td>${tmp.regdate }</td>
				<td>
					<c:if test="${id eq tmp.writer }">
						<a href="javascript:deleteConfirm(${tmp.num })">Delete</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>

		</tbody>
	</table>
	
	<h3><a href="${pageContext.request.contextPath }/file/upload_form.do">File Upload</a></h3>
	
	<div class="page-display">
		<ul class="pagination pagination-sm">
		
		<c:choose>
			<c:when test="${startPageNum ne 1 }">
				<li>
					<a href="list.do?pageNum=${startPageNum-1 }">&laquo;</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="disabled">
					<a href="javascript:">&laquo;</a>
				</li>
			</c:otherwise>
		</c:choose>
		
		<c:forEach var="w" begin="${startPageNum }" end="${endPageNum }" step="1">
			<c:choose>
				<c:when test="${w eq pageNum }">
					<li class="active">
						<a href="list.do?pageNum=${w }">${w }</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="list.do?pageNum=${w }">${w }</a>
					</li>
				</c:otherwise>
			</c:choose>	
		</c:forEach>
		
			<c:choose>
				<c:when test="${endPageNum lt totalPageNum }">
					<li>
						<a href="list.do?pageNum=${endPageNum+1 }">&raquo;</a>
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
</div>

<script>
	// 삭제 여부를 확인하고 삭제를 진행하는 javascript 함수
	function deleteConfirm(num){
		var isDelete=confirm("Are you sure delete this No."+num+" file?");
		if(isDelete){
			location.href="delete.do?num="+num;
		}
	}
</script>

</body>
</html>