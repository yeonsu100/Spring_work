<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/loginform.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>

<style>
	body {
	  padding-top: 40px;
	  padding-bottom: 40px;
	}
	h2{color:#C0DAFF;}
	.container{padding-top: 100px;}
	.form-signin {
	  max-width: 330px;
	  padding: 15px;
	  margin: 0 auto;
	}
	.form-signin .form-signin-heading,
	.form-signin .checkbox {
	  margin-bottom: 10px;
	}
	.form-signin .checkbox {
	  font-weight: 400;
	  color: #C0DAFF;
	}
	.form-signin .form-control {
	  position: relative;
	  -webkit-box-sizing: border-box;
	  -moz-box-sizing: border-box;
	  box-sizing: border-box;
	  height: auto;
	  padding: 10px;
	  font-size: 16px;
	}
	.form-signin .form-control:focus {
	  z-index: 2;
	}
	.form-signin input[type="email"] {
	  margin-bottom: -1px;
	  border-bottom-right-radius: 0;
	  border-bottom-left-radius: 0;
	}
	.form-signin input[type="password"] {
	  margin-bottom: 10px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
	body, html { 
    margin: 0;
    padding: 0;
    height: 100%;
	}
	.bgimg {
	    border: 0;
	    padding: 0; 
	    background-image: url('${pageContext.request.contextPath }/resources/images/sleeping_beauty_castle.jpg');
	    opacity: 80%;
	    min-height: 100%;
	    background-position: center;
	    background-size: cover;
	}
	#bg {
	  position: fixed; 
	  top: 0; 
	  left: 0; 
	  min-width: 100%;
	  min-height: 100%;
	}
</style>

</head>
<body>
<div class="bgimg">

<div class="container">
	<h1>SIGN IN page</h1>
	<form class="form-signin" action="login.do" method="post">
		<%-- 폼 제출할때 목적지 정보도 같이 보내준다. --%>
		<input type="hidden" name="url" value="${url }" />
		<h2 class="form-signin-heading">Sign In</h2>
		<label for="id" class="sr-only">ID</label>
		<input type="text" id="id" name="id" class="form-control" placeholder="User ID..." value="${savedId }" /> </br>
		<label for="pwd" class="sr-only">Password</label>
		<input type="password" id="pwd" name="pwd" class="form-control" placeholder="Password..." value="${savedPwd }"> </br> 
	
		<div class="checkbox">
			<label>
				<input type="checkbox" name="isSave" value="yes" />Save ID, Password
			</label>
		</div>
	
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign In</button>
	</form>
</div>
</body>
</html>