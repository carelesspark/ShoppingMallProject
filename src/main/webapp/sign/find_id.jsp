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
<link rel="stylesheet" href="../resources/css/sign/find_id.css" />
<title>find id</title>
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
			<p>아이디를 잊으셨나요?</p>
			<p>아래의 정보를 입력해 주세요.</p>
		</div>

		<form id="mcf" action="" method="post">
			<input type="text" name="userName" id="" placeholder="이름을 입력해 주세요." />
			<input type="email" name="userEmail" id=""
				placeholder="이메일을 입력해 주세요." /> <input type="submit" value="다음" />
		</form>
	</div>

	<!--include footer-->
	<footer></footer>

	<script src="https://code.jquery.com/jquery-latest.min.js" />
</body>
</html>
