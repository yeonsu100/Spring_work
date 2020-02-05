<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/updateform.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
</head>
<body>

<div class="container">
	<h1>Revision of Member's Info</h1>
	<form action="update.do" method="post">
		<input type="hidden" name="id" value="${id }" />
		<div class="form-group">
			<label for="id">ID</label>
			<input class="form-control" type="text" id="id" value="${id }" disabled/>
		</div>
		<div class="form-group">
			<label for="email">E-mail</label>
			<input class="form-control" type="text" id="email" name="email" value="${dto.email }"/>
		</div>
		<button class="btn btn-primary" type="submit">SAVE</button>
		<button class="btn btn-default" type="reset">Reset All</button>
	</form>
</div>

</body>
</html>