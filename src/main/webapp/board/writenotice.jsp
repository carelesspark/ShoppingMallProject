<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	html, body {
		height: 100%;
	}
	
	.wrapper {
		padding: 10px 15% 0;
		height: 100%;
	}
	
	.content {
		height: 60%;
	}
	
	.content_title input {
		width: 90%;
	}
	
	.content_content {
		height: 60%;
		margin-top: 20px;
	}
	
	.content_content textarea {
		width: 95%;
		height: 100%;
		resize: none;
	}
	
	.button_box {
		text-align: right;
		margin-right: 5%;
	}
	
	.button_box input {
		background-color: white;
		width: 100px;
		height: 50px;
		border: 1px solid;
	}
</style>
</head>
<body>
	<div class="wrapper">
		<div class="title">
			<p>공지작성</p>
		</div>
		
		<div class="content">
			<div class="content_title">
				<label>제목</label>
				<input type="text">
			</div>
			
			<div class="content_content">
				<label>내용</label>
				<br>
				<textarea></textarea>
			</div>
		</div>
		
		<div class="button_box">		
			<input type="button" value="취소">
			<input type="submit" value="등록">
		</div>
	</div>
</body>
</html>