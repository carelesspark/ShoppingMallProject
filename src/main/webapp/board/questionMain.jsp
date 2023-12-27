<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/boardCSS/noticeMain.css">
</head>
<body>
	<div class="wrapper">
		<div class="title">
			<h1>문의사항</h1>
			<a href="/board/questionWrite.jsp"><button>작성</button></a>
		</div>
		
		<hr style="height: 3px; background-color: black;">
		
		<div>
			<table>
			<c:forEach items="${questList }" var="quest">
				<tr>
					<a href="questionGet.do?pno=${quest.pno }">비밀글입니다.</a>
					<hr>
				</tr>
			</c:forEach>
			
			<div style="text-align: center">
				<c:forEach var="i" begin="1" end="${page/15 + 1 }">
					<a href="questionMain.do?pageNum=${i }">${i }</a>
				</c:forEach>
			</div>
			</table>
		</div>
	</div>
</body>
</html>