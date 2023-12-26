<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sign/register.css" />
<title>register</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div id="mc">
		<div id="mch">회원가입</div>
		<div id="mcp">회원정보를 입력해 주세요.</div>
		<form id="mcf" action="/sign/register.do" method="post"
			onsubmit="validateForm(this, event)">
			<input type="text" name="id" id="mcf-id" placeholder="아이디를 입력해 주세요." />
			<div id="id-dupl">
				<p id="id-dupl-p">영문자로 시작하고 최소 4글자 이상 입력해야 합니다.</p>
				<input type="checkbox" disabled id="id-dupl-cb">
				<button type="button" id="id-dupl-btn">중복 확인</button>
			</div>
			<input type="password" name="pwd" id="mcf-p1"
				placeholder="비밀번호를 입력해 주세요." />
			<div id="pwd-check">영문자, 숫자를 포함해 8 글자 이상을 입력해야 합니다.</div>
			<input type="password" name="pwd2" id="mcf-p2"
				placeholder="비밀번호를 다시 입력해 주세요." />
			<div id="pwd-dupl">새 비밀번호가 일치하지 않습니다.</div>
			<input type="text" name="user_name" placeholder="이름을 입력해 주세요." /> <input
				type="email" name="user_email" id="mcf-e"
				placeholder="이메일을 입력해 주세요." />
			<div id="email-dupl">
				<input type="checkbox" disabled id="email-dupl-cb">
				<button type="button" id="email-dupl-btn">중복 확인</button>
			</div>
			<div id="mcf-cb">
				<input type="checkbox" name="" id="cb1" />
				<p>[필수] 이용약관 동의</p>
				<input type="checkbox" name="" id="cb2" />
				<p>[필수] 전자금융거래 이용약관 동의</p>
				<input type="checkbox" name="" id="cb3" />
				<p>[필수] 개인정보 수집 및 이용 동의</p>
			</div>
			<div id="mcf-cb-check">필수 항목을 전부 체크해 주세요.</div>
			<input type="submit" value="회원가입" />
		</form>
	</div>

	<%@ include file="../footer.jsp"%>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/sign/register.js"></script>
</body>
</html>