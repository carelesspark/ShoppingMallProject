<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/boardCSS/boardMain.css">
<script src="../resources/js/boardJS/code.jquery.com_jquery-3.7.0.min.js"></script>
<link >
</head>
<body>
	<div class="wrapper">
		<div class="board">
			게시판
			<button onclick="location.href='/board/boardWrite.jsp'">작성</button>
		</div>
		<hr>
		<div class="tag_container">
			<nav class="tag_btn_container">
				<ul class="tag">
					<li class="tag_tab">
						<img alt="전체 보기" src="../resources/image/boardIMG/all.png">
						<p>전체 보기</p>
					</li>
					
					<li class="tag_tab" onclick="">
						<img alt="오오티디" src="../resources/image/boardIMG/ootd.jpg">
						<p>오오티디</p>
					</li>
					
					<li class="tag_tab" onclick="">
						<img alt="트렌드" src="../resources/image/boardIMG/trend.jpg">
						<p>트렌드</p>
					</li>
					
					<li class="tag_tab" onclick="">
						<img alt="스트릿" src="../resources/image/boardIMG/street.jpg">
						<p>스트릿</p>
					</li>
					
					<li class="tag_tab" onclick="">
						<img alt="캐주얼" src="../resources/image/boardIMG/casual.jpg">
						<p>캐주얼</p>
					</li>
					
					<li class="tag_tab" onclick="">
						<img alt="클래식" src="../resources/image/boardIMG/classic.jpg">
						<p>클래식</p>
					</li>
					
					<li class="tag_tab" onclick="">
						<img alt="빈티지" src="../resources/image/boardIMG/vintage.jpg">
						<p>빈티지</p>
					</li>
				</ul>
			</nav>
			<hr>
		</div>
		
		<div class="feed_container">
			<div class="feed">
				<div class="feed_post">
					<div class="feed_card">
						<c:forEach items="${boardList }" var="board">
						<a href='boardGet.do?pno=${board.pno }'>
							<div class="card_img">
								<img alt="게시물" src="../resources/image/boardIMG/all.png">
							</div>
							
							<div class="card_id">
								<p>${board.userNum }</p>
							</div>
							
							<div class="card_title">
								<p>${board.title }</p>
							</div>
						</a>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>