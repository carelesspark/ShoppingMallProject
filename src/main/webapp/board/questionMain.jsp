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
			<h1>문의사항</h1>
			<c:if test="${user_num ne null }">
			<a href="/board/questionWrite.jsp"><button>작성</button></a>
			</c:if>
		</div>
		
		<hr style="height: 3px; background-color: black;">
		
		<div>
			<table>
			<c:forEach items="${questList }" var="quest">
				<tr>
				<c:choose>
					<c:when test="${quest.userNum eq user_num }">
						<a href="questionGet.do?pno=${quest.pno }">${quest.title }</a>
					</c:when>
					
					<c:when test="${user_num eq 4 }">
						<a href="questionGet.do?pno=${quest.pno }">${quest.title }</a>
					</c:when>
					
					<c:otherwise>
						<a href="" onclick="alert('작성자만 확인할수있습니다.')">비밀글입니다.</a>
					</c:otherwise>
				</c:choose>
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
</body><%@ include file="../footer.jsp"%>
</html>