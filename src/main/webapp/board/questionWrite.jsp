<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/boardCSS/noticeWrite.css">
</head>
<body>
	<div class="wrapper">
		<div class="title">
			<p>문의작성</p>
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