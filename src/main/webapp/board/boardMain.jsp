<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/boardCSS/boardMain.css?ver=1">
<script
	src="../resources/js/boardJS/code.jquery.com_jquery-3.7.0.min.js"></script>
</head>
<body>
<%@ include file="../header.jsp"%>
	<div class="wrapper">
		<div class="board">
			게시판
			<c:if test="${user_num ne null }">
				<button onclick="location.href='/board/writeBoard.do'">작성</button>
			</c:if>
		</div>
		<hr>
		<div class="tag_container">
			<nav class="tag_btn_container">
				<ul class="tag">
					<li class="tag_tab" onclick="location.href='boardMain.do'"><img
						alt="전체 보기" src="../resources/image/boardIMG/all.png">
						<p>전체 보기</p></li>

					<li class="tag_tab"
						onclick="location.href='boardMain.do?ctgr_num=1'"><img
						alt="오오티디" src="../resources/image/boardIMG/ootd.jpg">
						<p>오오티디</p></li>

					<li class="tag_tab"
						onclick="location.href='boardMain.do?ctgr_num=2'"><img
						alt="트렌드" src="../resources/image/boardIMG/trend.jpg">
						<p>트렌드</p></li>

					<li class="tag_tab"
						onclick="location.href='boardMain.do?ctgr_num=3'"><img
						alt="스트릿" src="../resources/image/boardIMG/street.jpg">
						<p>스트릿</p></li>

					<li class="tag_tab"
						onclick="location.href='boardMain.do?ctgr_num=4'"><img
						alt="캐주얼" src="../resources/image/boardIMG/casual.jpg">
						<p>캐주얼</p></li>

					<li class="tag_tab"
						onclick="location.href='boardMain.do?ctgr_num=5'"><img
						alt="클래식" src="../resources/image/boardIMG/classic.jpg">
						<p>클래식</p></li>

					<li class="tag_tab"
						onclick="location.href='boardMain.do?ctgr_num=6'"><img
						alt="빈티지" src="../resources/image/boardIMG/vintage.jpg">
						<p>빈티지</p></li>
				</ul>
			</nav>
			<hr>
		</div>

		<div class="feed_container">
			<div class="feed">
				<div class="feed_post">
					<div class="feed_card">
						<c:forEach items="${boardList }" var="board" varStatus="loop">
							<a href='boardGet.do?pno=${board.pno }'>
								<div class="card_img">
									<img alt="게시물"
										src="${pageContext.request.contextPath}/resources/image/board/${file[loop.index].pno}/${file[loop.index].fname}" />
								</div>

								<div class="card_id">
									<p>${board.user_name }</p>
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
<%@ include file="../footer.jsp"%>
</body>
</html>