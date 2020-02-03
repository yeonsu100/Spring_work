<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup_form.do</title>

<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<style>
	/* 페이지 로딩 시점에 도움말(ID 사용 불가)과 피드백 아이콘은 일단 숨기기 */
	.help-block, .form-control-feedback {display:none;}
	h1 {color:skyblue;}
	h3 {color:#A566FF;}
</style>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
</head>

<body>
<div class="container">
	<h1>Create an account page</h1>
	<blockquote><h3>Join our membership :)</h3></blockquote>
	<form action="signup.do" method="post" id="signupForm">
		<!-- 아이디 -->
		<div class="form-group has-feedback">
			<label class="control-label" for="id">User ID</label>
			<input class="form-control" type="text" id="id" name="id"/>
			<p class="help-block" id="id_notusable">You can NOT use this ID. Already it has taken.</p>
			<p class="help-block" id="id_required">ID is required.</p>
			<!-- 페이지가 로딩되는 시점에서는 아래의 span요소들은 보이지 않다가 특정 조건일 때 노출되도록 한다. -->
			<span class="glyphicon glyphicon-remove form-control-feedback"></span>
			<span class="glyphicon glyphicon-ok form-control-feedback"></span>
		</div>
		
		<!-- 비밀번호 -->
		<div class="form-group has-feedback">
			<label class="control-label" for="pwd">Password</label>
			<input class="form-control" type="password" id="pwd" name="pwd"/>
			<p class="help-block" id="pwd_required">Password is required.</p>
			<p class="help-block" id="pwd_notequal">Please confirm for matching with below password.</p>
			<span class="glyphicon glyphicon-remove form-control-feedback"></span>
			<span class="glyphicon glyphicon-ok form-control-feedback"></span>
		</div>
		<div class="form-group has-feedback">
			<label class="control-label" for="pwd2">Check Password</label>
			<input class="form-control" type="password" id="pwd2" name="pwd2"/>
			<p class="help-block" id="msg_notsame">Please check your password correctly!</p>
		</div>
		
		<!-- 이메일 -->
		<div class="form-group has-feedback">
			<label class="control-label" for="email">E-mail</label>
			<input class="form-control" type="email" id="email" name="email" />
			<p class="help-block" id="email_notmatch">Please confirm email format correctly.</p>
			<span class="glyphicon glyphicon-remove form-control-feedback"></span>
			<span class="glyphicon glyphicon-ok form-control-feedback"></span>
		</div>
		
		<!-- 버튼 -->
		<div class="row">
			<div class="col-xs-6">
				<button disabled="disabled" type="submit" class="btn btn-info">Create</button>
			</div>
			<div class="col-xs-6">
				<button type="reset" class="btn btn-default">Reset all</button>
			</div>
		</div>
	</form>
</div>

<script>
	// 아이디 유효성 여부
	// var isIdValid=false;
	// 아이디를 사용할 수 있는지 여부
	var isIdUsable=false;
	// 아이디를 입력했는지 여부
	var isIdInput=false;
		// 위 두가지 조건 중 어느하나라도 false이면 false가 리턴되어야 한다.

	// 비밀번호를 확인칸과 같게 입력했는지 여부
	var isPwdEqual=false;
	// 비밀번호를 입력했는지 여부
	var isPwdInput=false;
	
	// 이메일을 형식에 맞게 (@ 포함되도록) 입력했는지 여부
	var isEmailMatch=false;
	// 이메일을 입력했는지 여부
	var isEmailInput=false;
	
	// 아이디 입력칸에 한번이라도 입력한 적이 있는지 여부
	var isIdDirty=false;
	// 비밀번호 입력칸에 한번이라도 입력한 적이 있는지 여부
	var isPwdDirty=false;
	
	// 이메일을 입력했을 때 실행할 함수 등록
	$("#email").on("input", function(){
		var email=$("#email").val();
		
		// @가 포함되었는지 여부를 판단
		if(email.match("@")){			// 만약 이메일 형식에 맞게 입력했다면
			isEmailMatch=true;
		}else{							// 그렇지 않다면 (=@가 없다면)
			isEmailMatch=false;
		}
		
		if(email.length==0){			// 만약 이메일을 입력하지 않았다면
			isEmailInput=false;			// email input은 false
		}else{							// 이메일을 입력했다면
			isEmailInput=true;			// true를 리턴
		}
		
		// 이메일 에러 여부 
		var isError=isEmailInput && !isEmailMatch;
		// 이메일 상태 바꾸기 
		setState("#email", isError);	
	});
	
	
	// 비밀번호를 입력할 때 실행할 함수 등록
	$("#pwd, #pwd2").on("input", function(){
		// 비밀번호를 한번이라도 입력하면 실행순서가 여기로 들어오므로 더티값을 true로 바꾸어준다.
		isPwdDirty=true;
		// 입력한 비밀번호를 읽어온다.
		var pwd=$("#pwd").val();
		var pwd2=$("#pwd2").val();
		
		if(pwd!=pwd2){			// 만약 두 비밀번호를 동일하게 입력하지 않았다면
			isPwdEqual=false;
		}else{
			isPwdEqual=true;
		}
			// 위의 조건문을 한줄로 표현하면 다음과 같다 (3항 연산자)
			// isPwdEqual = pwd != pwd2 ? false : true;
		
		if(pwd.length==0){
			isPwdInput=false;
		}else{
			isPwdInput=true;
		}
		// 비밀번호 에러 여부 
		var isError=!isPwdEqual || !isPwdInput;
		// 비밀번호 상태 바꾸기 
		setState("#pwd", isError);
	});
		
		
	// 아이디를 입력할 때 실행할 함수 등록
	$("#id").on("input", function(){
		// 아이디를 한번이라도 입력하면 실행순서가 여기로 들어오므로 아이디 더티값을 true로 바꾸어준다.
		isIdDirty=true;
		
		// 1. 입력한 아이디를 읽어온다.
		var inputId=$("#id").val();
		// 2. 서버에 보내서 사용가능 여부를 응답받는다.
		$.ajax({
			url:"${pageContext.request.contextPath }/users/checkid.do",
			method:"GET",
			data:{inputId:inputId},
			success:function(responseData){
				if(responseData.isExist){		// 만약 이미 존재하는 아이디라면 
					isIdUsable=false;
				}else{
					isIdUsable=true;
				}
				// 아이디 에러 여부 
				var isError= !isIdUsable || !isIdInput ;
				// 아이디 상태 바꾸기 
				setState("#id", isError);
			}
		});
		
		// 아이디를 입력했는지 검증
		if(inputId.length==0){			// 만일 아이디 입력값이 0이면 (=아무것도 입력하지 않았다면)
			isIdInput=false;
		}else{
			isIdInput=true;
		}
		// 화면에 없데이트 해주어야 하는 내용 (isIdUsable에서의 내용과 같으므로 함수 만들어서 선언하는 것이 효율적이다)
		//아이디 에러 여부 
		var isError= !isIdUsable || !isIdInput ;
		//아이디 상태 바꾸기 
		setState("#id", isError );
	});
	
	
	
	// 입력칸의 상태를 바꾸는 함수 (id / pwd / email)
	function setState(sel, isError){
		// 일단 UI를 초기상태로 바꾸어준다.
		$(sel)
		.parent()
		.removeClass("has-success has-error")
		.find(".help-block, .form-control-feedback")
		.hide();
		
		// 입력칸의 색상과 아이콘을 바꾸어주는 작업
		if(isError){
			// 입력칸이 error인 상태
			$(sel)
			.parent()
			.addClass("has-error")
			.find(".glyphicon-remove")
			.show();
		}else{
			// 입력칸이 success인 상태
			$(sel)
			.parent()
			.addClass("has-success")
			.find(".glyphicon-ok")
			.show();	
		}
		// 에러가 있다면 메세지 띄우기 (id, pwd, email)
		if(!isIdUsable && isIdDirty){
			$("#id_notusable").show();
		}
		if(!isIdInput && isIdDirty){
			$("#id_required").show();
		}
		if(!isPwdEqual && isPwdDirty){
			$("#pwd_notequal").show();
		}
		if(!isPwdInput && isPwdDirty){
			$("#pwd_required").show();
		}
		if(isEmailInput && !isEmailMatch){
			$("#email_notmatch").show();
		}
		
		// 버튼의 상태 바꾸기 (위에서 선언한 변수들 중 이메일을 제외한 모든 변수가 전부 true여야 한다)
		if(isIdUsable && isIdInput && 				// id가 유효한지 / id를 입력했는지
			isPwdEqual && isPwdInput && 			// pwd가 pwd2와 일치하는지 / pwd를 입력했는지
			(!isEmailInput || isEmailMatch)  ){		// email을 입력했거나, 입력했다면 @가 들어있는지
		  $("button[type=submit]").removeAttr("disabled");			// 속성 제거 : .removeAttr();
		}else{
			$("button[type=submit]").attr("disabled","disabled");	// 속성 추가 : .attr();
		}
	}

</script>

</body>
</html>