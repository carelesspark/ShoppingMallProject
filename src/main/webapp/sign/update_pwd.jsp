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
<link rel="stylesheet" href="../resources/css/sign/update_pwd.css" />
<title>update pwd</title>
</head>
<body>
	<!--include header-->
	<header></header>

	<div id="mc">
		<div id="mch">비밀번호 재설정</div>
		<form id="mcf" method="post">
			<input type="password" name="" id="mcf-p1"
				placeholder="새 비밀번호를 입력해 주세요." /> <input type="password" name=""
				id="mcf-p2" placeholder="비밀번호를 다시 입력해 주세요." />
			<p>비밀번호는 영문자, 숫자를 포함해 8 글자 이상을 입력해야합니다.</p>
			<input type="submit" value="다음" />
		</form>
	</div>

	<!--include footer-->
	<footer></footer>
</body>
</html>
