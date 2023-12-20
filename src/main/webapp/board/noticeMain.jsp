<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
			<h1>공지사항</h1>
			<a href="/board/noticeWrite.jsp"><button>작성</button></a>
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
			</table>
		</div>
	</div>
</body>
</html>