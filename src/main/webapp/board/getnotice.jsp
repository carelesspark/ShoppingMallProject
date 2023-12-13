<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.wrapper {
		padding: 10px 15% 0;
		height: 100%
	}
	
	.date {
		font-size: 12px;
		margin-top: 0;
	}
	
	.content {
		height: 100%;
	}
	
	.main {
		background-color: #f1f1f1;
		height:60%;
		padding: 16px;
	}
	
	.main p {
		margin: 0;
	}

	html, body {
		height: 100%;
	}
	
	.button {
		text-align: center;
		margin-top: 20px;
	}
	
	.button input {
		background-color: white;
		width: 100px;
		height: 50px;
	}
</style>
</head>
<body>
	<div class="wrapper">
		<div class="title">
			<h1>공지사항</h1>
		</div>
		
		<hr style="height: 3px; background-color: black;">
		
		<div class="content">
			<p class="date">작성 날짜 들어갈 자리</p>
			<p>제목 들어갈 자리</p>
			
			<div class="main">
				<p>공지 내용 들어갈 자리</p>
			</div>
			
			<div class="button">
				<input type="button" value="목록보기" onclick="location.href='./notice.jsp'">
			</div>
		</div>
	</div>
</body>
</html>