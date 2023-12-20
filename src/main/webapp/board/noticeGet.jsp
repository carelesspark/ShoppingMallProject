<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/boardCSS/noticeGet.css">
</head>
<body>
	<div class="wrapper">
		<div class="title">
			<h1>공지사항</h1>
			<a href="deleteNotice.do?pno=${notice.pno }"><button>삭제</button></a>
		</div>
		
		<hr style="height: 3px; background-color: black;">
		
		<div class="content">
			<p class="date">${notice.posttime }</p>
			<p>${notice.title }</p>
			
			<div class="main">
				<p>${notice.content }</p>
			</div>
			
			<div class="button">
				<input type="button" value="목록보기" onclick="location.href='noticeMain.do'">
			</div>
		</div>
	</div>
</body>
</html>