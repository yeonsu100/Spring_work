<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/updateform.jsp</title>
</head>
<body>

<div class="container">
	<h1>Page of Update form</h1>
	<form action="update.do" method="post">
	<input type="hidden" name="num" value="${dto.num }" />
		<div>
			<label for="num">No.</label>
			<input type="text" id="num" value="${dto.num }" disabled />
		</div>
		<div>
			<label for="name">Name</label>
			<input type="text" name="name" id="name" value="${dto.name }"/>
		</div>
		<div>
			<label for="addr">Address</label>
			<input type="text" name="addr" id="addr" value="${dto.addr }"/>
		</div>
		<button type="submit">Save</button>
		<button type="reset">Reset All</button>
	</form>
</div>

</body>
</html>