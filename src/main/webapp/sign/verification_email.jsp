<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sign/verification_email.css" />
<title>verification email</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div id="mc">
		<div id="mch">계정 찾기</div>
		<div id="mcs">
			<div>
				<a href="/sign/goFindId.do">아이디 찾기</a>
			</div>
			<div id="mcs-">
				<a href="/sign/goFindPwd.do">비밀번호 찾기</a>
			</div>
		</div>
		<div id="mcp">
			<p>사용자의 이메일로 인증번호를 전송했습니다.</p>
			<p>아래에 인증번호를 입력해주시기 바랍니다.</p>
		</div>
		<form id="mcf" action="/sign/verificationEmail.do" method="get">
			<input type="text" name="authStr" placeholder="인증번호를 입력해 주세요." /> <input
				type="submit" value="비밀번호 재설정" />
		</form>
	</div>

	<%@ include file="../footer.jsp"%>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/sign/verification_email.js"></script>
</body>
</html>