<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/fortune.jsp</title>
</head>
<body>

<h1>Daily Fortune</h1>		<%-- 오늘의 운세를 출력하려면 모델 (데이터들)이 있어야 한다 --%>
<p>${fortuneToday }</p>

</body>
</html>