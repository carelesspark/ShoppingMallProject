<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sign/login_admin.css" />
<title>login admin</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="mc">
		<div id="mch">관리자 로그인</div>
		<form id="mcf" action="/sign/loginAdmin.do" method="post"
			onsubmit="validateForm(this, event)">
			<input type="text" name="id" placeholder="아이디를 입력해 주세요." /> <input
				type="password" name="pwd" placeholder="비밀번호를 입력해 주세요." />
			<div id="em"></div>
			<input type="submit" value="로그인" />
		</form>
	</div>
	<%@ include file="../footer.jsp"%>

	<c:if test="${!empty error}">
		<script type="text/javascript">
			// 'block'은 'default'와 같은 의미입니다.
			document.querySelector('#mcf input[type="password"]').style.marginBottom = '5px';
			document.getElementById('em').style.display = 'block';
			document.getElementById('em').innerHTML = "로그인 정보가 일치하지 않습니다. 다시 입력해 주세요.";
		</script>
	</c:if>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/sign/login_admin.js"></script>
</body>
</html>