<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sign/sign_up.css" />
<title>sign up</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div id="mc">
		<div id="mch">회원가입</div>
		<div id="mcp">회원정보를 입력해 주세요.</div>
		<form id="mcf" action="" method="post">
			<input type="text" name="id" id="mcf-id" placeholder="아이디를 입력해 주세요." />
			<div id="id-dupl">이미 존재하는 아이디입니다.</div>
			<input type="password" name="pwd1" id="mcf-p1"
				placeholder="비밀번호를 입력해 주세요." />
			<div id="pwd-check">비밀번호는 영문자, 숫자를 포함해 8 글자 이상을 입력해야합니다.</div>
			<input type="password" name="pwd2" id="mcf-p2"
				placeholder="비밀번호를 다시 입력해 주세요." />
			<div id="pwd-dupl">새 비밀번호가 일치하지 않습니다.</div>
			<input type="text" name="name" placeholder="이름을 입력해 주세요." /> <input
				type="email" name="email" placeholder="이메일을 입력해 주세요." />

			<div id="mcf-cb">
				<input type="checkbox" name="" id="" />
				<p>[필수] 이용약관 동의</p>
				<input type="checkbox" name="" id="" />
				<p>[필수] 전자금융거래 이용약관 동의</p>
				<input type="checkbox" name="" id="" />
				<p>[필수] 개인정보 수집 및 이용 동의</p>
			</div>
			<div id="mcf-cb-check">필수 항목을 전부 체크해 주세요.</div>
			<input type="submit" value="회원가입" />
		</form>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>