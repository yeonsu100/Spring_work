<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/WEB-INF/views/users/loginform.jsp</title>
</head>
<body>

<h1>Sign in form</h1>
<form action="login.do" method="post">
	<label for="id">ID</label>
	<input type="text" name="id" id="id" />
	<label for="pwd">PASSWORD</label>
	<input type="password" name="pwd" id="pwd" />
	<button type="submit">Sign In</button>
</form>

</body>
</html>