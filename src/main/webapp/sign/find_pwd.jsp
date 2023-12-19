<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sign/find_pwd.css" />
<title>find pwd</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div id="mc">
		<div id="mch">계정 찾기</div>
		<div id="mcs">
			<div>
				<a href="sign/find_id.jsp">아이디 찾기</a>
			</div>
			<div id="mcs-">
				<a href="sign/find_pwd.jsp">비밀번호 찾기</a>
			</div>
		</div>
		<div id="mcp">
			<p>비밀번호를 잊으셨나요?</p>
			<p>아래의 정보를 입력해 주세요.</p>
		</div>

		<form id="mcf" action="../findPwd.do" method="post">
			<input type="text" name="id" placeholder="아이디를 입력해 주세요." /> <input
				type="email" name="userEmail" placeholder="이메일을 입력해 주세요." /> <input
				type="submit" value="다음" />
		</form>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>