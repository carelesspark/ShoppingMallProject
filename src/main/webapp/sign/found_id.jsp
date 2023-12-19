<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sign/found_id.css" />
<title>found id</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div id="mc">
		<div id="mch">계정 찾기</div>
		<div id="mcs">
			<div id="mcs-">
				<a href="/practice/sign/find_id.jsp">아이디 찾기</a>
			</div>
			<div>
				<a href="/practice/sign/find_pwd.jsp">비밀번호 찾기</a>
			</div>
		</div>
		<div id="mcp">
			<p>사용자의 아이디는</p>
			<p id="mcp-uid">${id}</p>
			<p>입니다.</p>
		</div>
		<a id="mcl" href="/practice/sign/sign_in.jsp">로그인</a>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>