<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/boardCSS/noticeGet.css">
</head>
<body><%@ include file="../header.jsp"%>
	<div class="wrapper">
		<div class="title">
			<h1>공지사항</h1>
			<c:if test="${user_num eq 4 }">
			<a href="deleteNotice.do?pno=${notice.pno }"><button>삭제</button></a>
			<a href="/board/noticeEdit.do?pno=${notice.pno }"><button>수정</button></a>
			</c:if>
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
</body><%@ include file="../footer.jsp"%>
</html>