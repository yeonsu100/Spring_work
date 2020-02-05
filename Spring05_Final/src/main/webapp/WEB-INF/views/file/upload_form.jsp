<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
	[ 파일 업로드 처리하는 방법 ]
	
	1. form 속성에 method="post" enctype="multipart/form-data"
	2. input type="file"
	3. commons-io.jar, commons-fileupload.jar 라이브러리를 
	   WEB-INFlib 폴더에 붙여넣기해서 사용할 준비하기
	4. WebContent/upload 폴더 만들기
	5. upload.jsp 에서 파일 업로드에 관련된 비즈니스 로직 처리하기
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/file/upload_form.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../include/navbar.jsp">
	<jsp:param value="file" name="category" />
</jsp:include>
<div class="container">
	<h1>File upload Form</h1>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="title">Title</label>
			<input class="form-control" type="text" name="title" id="title" />
		</div>
		<div class="form-group">
			<label for="myFile">Attachment</label>
			<input class="form-control" type="file" name="myFile" id="myFile" />
		</div>
		<button class="btn btn-primary" type="submit">Save</button>
		<button class="btn btn-default" type="reset">Reset</button>
	</form>
</div>
</body>
</html>