<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/boardCSS/noticeWrite.css">
</head>
<body>
	<div class="wrapper">
	<form action="editQuest.do?pno=${quest.pno }" method="post">
		<div class="title">
			<p>문의작성</p>
		</div>
		
		<div class="content">
			<div class="content_title">
				<label>제목</label>
				<input type="text" name="title" value="${quest.title }">
			</div>
			
			<div class="content_content">
				<label>내용</label>
				<br>
				<textarea name="content">${quest.content }</textarea>
			</div>
		</div>
		
		<div class="button_box">		
			<input type="button" value="취소" onclick="location.href='/questionMain.do'">
			<input type="submit" value="수정">
		</div>
		</form>
	</div>
</body>
</html>