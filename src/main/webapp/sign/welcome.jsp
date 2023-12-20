<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sign/welcome.css" />
<title>welcome</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div id="mc">
		<div id="mch">회원가입을 축하드립니다.</div>
		<a id="mcl" href="/sign/goLogin.do">로그인</a>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>