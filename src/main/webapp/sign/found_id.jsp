<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/header.css" />
<link rel="stylesheet" href="../resources/css/footer.css" />
<link rel="stylesheet" href="../resources/css/body.css" />
<link rel="stylesheet" href="../resources/css/sign/found_id.css" />
<title>found id</title>
</head>
<body>
	<!--include header-->
	<header></header>

	<div id="mc">
		<div id="mch">계정 찾기</div>
		<div id="mcs">
			<div id="mcs-">
				<a href="">아이디 찾기</a>
			</div>
			<div>
				<a href="">비밀번호 찾기</a>
			</div>
		</div>
		<div id="mcp">
			<p>사용자의 아이디는</p>
			<p id="mcp-uid">${user_id}- 값 forwarding으로 넘기기?</p>
			<p>입니다.</p>
		</div>
		<a id="mcl" href="">로그인</a>
	</div>

	<!--include footer-->
	<footer></footer>
</body>
</html>