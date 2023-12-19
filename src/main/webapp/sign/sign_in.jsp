<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sign/sign_in.css" />
<title>sign in</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div id="mc">
		<div id="mch">로그인</div>
		<form id="mcf" action="/practice/signIn.do" method="post"
			onsubmit="validateForm(this, event)">
			<input type="text" name="id" value="${savedId}"
				placeholder="아이디를 입력해 주세요." /> <input type="password" name="pwd"
				placeholder="비밀번호를 입력해 주세요." />
			<div id="em"></div>
			<div id="mcf-cb">
				<input type="checkbox" name="saveId" />
				<p>아이디 저장</p>
			</div>
			<input type="submit" value="로그인" />
		</form>
		<div id="mcl">
			<a href="/practice/sign/find_id.jsp">아이디 찾기</a> <a
				href="/practice/sign/find_pwd.jsp">비밀번호 찾기</a> <a
				href="./sign_up.jsp">회원가입</a>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>

	<script type="text/javascript">
		function validateForm(form, event) {
			var errorMsg = document.getElementById('em');
			document.querySelector('#mcf input[type="password"]').style.marginBottom = '5px';
			document.getElementById('em').style.display = 'block';

			if (form.id.value.trim() === "") {
				errorMsg.innerHTML = "아이디를 입력해 주세요.";
				event.preventDefault();

				return false;
			}
			if (form.pwd.value.trim() === "") {
				errorMsg.innerHTML = "비밀번호를 입력해 주세요.";
				event.preventDefault();

				return false;
			}

			return true;
		}
	</script>
	<c:if test="${!empty failSignIn}">
		<script type="text/javascript">
			// 'block'은 'default'와 같은 의미입니다.
			document.querySelector('#mcf input[type="password"]').style.marginBottom = '5px';
			document.getElementById('em').style.display = 'block';
			document.getElementById('em').innerHTML = "로그인 정보가 일치하지 않습니다. 다시 입력해 주세요.";
		</script>
	</c:if>
</body>
</html>
