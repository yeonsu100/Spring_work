<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/private/pwd_updateform.jsp</title>
<jsp:include page="../include/resource.jsp"/>
</head>
<body>

<div class="container">
	<h1>Revision Page (Password)</h1>
	<form action="pwd_update.do" method="post">
		<div>
			<label for="pwd">Current Password</label>
			<input type="password" name="pwd" id="pwd" />
		</div>
		<div>
			<label for="newPwd">New Password</label>
			<input type="password" name="newPwd" id="newPwd" />
		</div>
		<div>
			<label for="newPwd2">New Password (Confirm)</label>
			<input type="password" name="newPwd2" id="newPwd2" />
		</div>
		<button type="sublit">Revision</button>
	</form>
	
</div>

<script>
	// 폼에 submit 이벤트가 일어났을 때 실행할 함수 등록
	$("form").on("submit", function(){
		// 새 비밀번호 2개가 모두 일치하는지 확인
		var pwd=$("#newPwd").val();
		var pwd2=$("#newPwd2").val();
		if(pwd!=pwd2){		// 알림 띄우기
			alert("Please check your password!");	
			$("#newPwd").focus();					// 포커스 주기
			return false;							// 폼 전송 막기
		}
	});
</script>

</body>
</html>