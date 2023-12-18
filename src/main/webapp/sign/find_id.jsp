<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<a href="./find_id.jsp">아이디 찾기</a>
			</div>
			<div>
				<a href="./find_pwd.jsp">비밀번호 찾기</a>
			</div>
		</div>
		<div id="mcp">
			<p>아이디를 잊으셨나요?</p>
			<p>아래의 정보를 입력해 주세요.</p>
		</div>

		<form id="mcf" action="/practice/findId.do" method="post"
			onsubmit="validateForm(this, event)">
			<input type="text" name="user_name" placeholder="이름을 입력해 주세요." /> <input
				type="email" name="user_email" placeholder="이메일을 입력해 주세요." /> <input
				type="submit" value="다음" />
		</form>
	</div>

	<%@ include file="../footer.jsp"%>

	<script type="text/javascript">
		function validateForm(form, event) {
			if (form.user_name.value.trim() === "") {
				alert("등록된 정보와 일치하지 않습니다. 다시 입력해 주세요.");
				event.preventDefault();

				return false;
			}
			if (form.user_email.value.trim() === "") {
				alert("등록된 정보와 일치하지 않습니다. 다시 입력해 주세요.");
				event.preventDefault();

				return false;
			}

			return true;
		}
	</script>
</body>
</html>
