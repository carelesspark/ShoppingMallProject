<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/boardCSS/noticeMain.css">
</head>
<body><%@ include file="../header.jsp"%>
	<div class="wrapper">
		<div class="title">
			<h1>공지사항</h1>
			<c:if test="${user_num eq 4 }">
			<a href="/board/noticeWrite.jsp"><button>작성</button></a>
			</c:if>
		</div>
		
		<hr style="height: 3px; background-color: black;">
		
		<div>
			<table>
			<c:forEach items="${noticeList }" var="notice">
			<tr>
					<a href="noticeGet.do?pno=${notice.pno }">${notice.title }</a>
					<hr>
				</tr>
			</c:forEach>
			
			<div style="text-align: center">
			<c:forEach var="i" begin="1" end="${page/15 + 1 }">
				<a href="noticeMain.do?pageNum=${i }" >${i }</a>
			</c:forEach>
			</div>
			</table>
		</div>
	</div>
</body><%@ include file="../footer.jsp"%>
</html>