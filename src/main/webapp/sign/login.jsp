<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sign/login.css?v=1.0" />
<title>login</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="mc">
		<div id="mch">로그인</div>
		<form id="mcf" action="/sign/login.do" method="post"
			onsubmit="validateForm(this, event)">
			<input type="text" name="id" id="iid" placeholder="아이디를 입력해 주세요." />
			<div id="mcf-cb">
				<input type="checkbox" name="saveId" id="icb" />
				<p>아이디 저장</p>
			</div>
			<input type="password" name="pwd" id="ipwd"
				placeholder="비밀번호를 입력해 주세요." />
			<div id="em"></div>
			<input type="submit" id="isb" value="로그인" />
		</form>
		<div id="mcl">
			<a href="/sign/goFindId.do">아이디 찾기</a> <a href="/sign/goFindPwd.do">비밀번호
				찾기</a> <a href="/sign/goRegister.do">회원가입</a>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>

	<c:if test="${!empty error}">
		<script type="text/javascript">
			// Check if the error contains the string "none admin"
			if ('${error}' === 'none admin') {
				// Display an alert if the condition is true
				alert("관리자가 아닙니다.");
			} else { // 기존 로그인 사용자가 잘못 입력했을 때
				document.getElementById('em').innerHTML = "로그인 정보가 일치하지 않습니다. 다시 입력해 주세요.";
			}
		</script>
	</c:if>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/sign/login.js"></script>
</body>
</html>