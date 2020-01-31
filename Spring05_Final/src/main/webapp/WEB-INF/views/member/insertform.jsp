<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/insertform.jsp</title>
</head>
<body>

<div class="container">
	<form action="insert.do" method="post">
		<div>
			<label for="name">Name</label>
			<input type="text" name="name" id="name" />
		</div>
		<div>
			<label for="addr">Address</label>
			<input type="text" name="addr" id="addr" />
		</div>
		<button type="submit">Save</button>
	</form>
</div>

</body>
</html>