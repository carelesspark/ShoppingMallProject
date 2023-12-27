<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/boardCSS/questionGet.css">
</head>
<body>
	<div class="wrapper">
		<div class="title">
			<h1>문의사항</h1>
			<a href="deleteQuest.do?pno=${quest.pno }"><button>삭제</button></a>
			<a href="/board/questionEdit.do?pno=${quest.pno }"><button>수정</button></a>
		</div>
		
		<hr style="height: 3px; background-color: black;">
		
		<div class="content">
			<p class="date">${quest.posttime }</p>
			<p>${quest.title }</p>
			
			<form action="writeQuestReply.do">
			<div class="main">
				<p class="main_quest">${quest.content }</p>
				<input type="hidden" name="pno" value="${quest.pno }">
				<textarea name="rcontent">${reply.rcontent }</textarea>
				<input type="submit" value="답변 등록">
			</div>
			</form>
			
			<div class="button">
				<input type="button" value="목록보기" onclick="location.href='questionMain.do'">
			</div>
		</div>
	</div>
</body>
</html>