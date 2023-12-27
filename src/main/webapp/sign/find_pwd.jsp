<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<a href="/sign/goFindId.do">아이디 찾기</a>
			</div>
			<div id="mcs-">
				<a href="/sign/goFindPwd.do">비밀번호 찾기</a>
			</div>
		</div>
		<div id="mcp">
			<p>비밀번호를 잊으셨나요?</p>
			<p>아래의 정보를 입력해 주세요.</p>
		</div>

		<form id="mcf" action="/sign/findPwd.do" method="post"
			onsubmit="validateForm(this, event)">
			<input type="text" name="id" placeholder="아이디를 입력해 주세요." /> <input
				type="email" name="user_email" placeholder="이메일을 입력해 주세요." /> <input
				type="submit" value="다음" />
		</form>
	</div>

	<%@ include file="../footer.jsp"%>

	<c:if test="${!empty error}">
		<script type="text/javascript">
			alert("등록된 정보와 일치하지 않습니다. 다시 입력해 주세요.");
		</script>
	</c:if>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/sign/find_pwd.js"></script>
</body>
</html>