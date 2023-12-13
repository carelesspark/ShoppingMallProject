<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/header.css" />
<link rel="stylesheet" href="../resources/css/footer.css" />
<link rel="stylesheet" href="../resources/css/body.css" />
<link rel="stylesheet" href="../resources/css/sign/sign_in.css" />
<title>login</title>
</head>
<body>
	<!--include header-->
	<header></header>

	<div id="mc">
		<div id="mch">로그인</div>
		<form id="mcf" action="" method="post">
			<input type="text" placeholder="아이디를 입력해 주세요." /> <input
				type="password" name="" id="" placeholder="비밀번호를 입력해 주세요." />
			<div id="mcf-cb">
				<input type="checkbox" name="" id="" />
				<p>아이디 저장</p>
			</div>
			<input type="submit" value="로그인" />
		</form>
		<div id="mcl">
			<a href="">아이디 찾기</a> <a href="">비밀번호 찾기</a> <a href="">회원가입</a>
		</div>
	</div>

	<!--include footer-->
	<footer></footer>
</body>
</html>
