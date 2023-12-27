<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sign/find_id.css" />
<title>find id</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div id="mc">
		<div id="mch">계정 찾기</div>
		<div id="mcs">
			<div id="mcs-">
				<a href="/goFindId.do">아이디 찾기</a>
			</div>
			<div>
				<a href="/goFindPwd.do">비밀번호 찾기</a>
			</div>
		</div>
		<div id="mcp">
			<p>아이디를 잊으셨나요?</p>
			<p>아래의 정보를 입력해 주세요.</p>
		</div>

		<form id="mcf" action="/sign/findId.do" method="post"
			onsubmit="validateForm(this, event)">
			<input type="text" name="user_name" placeholder="이름을 입력해 주세요." /> <input
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
		src="${pageContext.request.contextPath}/resources/js/sign/find_id.js"></script>
</body>
</html>
