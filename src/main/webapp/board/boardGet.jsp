<%@page import="com.dazzle.shop.model.board.BoardVO"%>
<%@page import="com.dazzle.shop.model.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/boardCSS/boardGet.css">
<script src="../resources/js/boardJS/code.jquery.com_jquery-3.7.0.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<div class="title">
			<div class="title_content">
				<p>${board.title }</p>
				<p class="id">${board.user_name }</p>
				</div>
			<div class="title_btn">
			<c:if test="${board.userNum eq user_num || user_num eq 4}">
				<a href="deleteBoard.do?pno=${board.pno }"><button>삭제</button></a>
				<a href="/board/boardEdit.do?pno=${board.pno }"><button>수정</button></a></c:if>
				<a href="/boardMain.do"><button>목록</button></a>
			</div>
		</div>
		
		<div class="content">
		<c:forEach items="${file }" var="files">
			<div class="content_img">
				<img alt="옷사진" src="${pageContext.request.contextPath}/resources/image/board/${files.pno}/${files.fname}">
			</div>
		</c:forEach>
			
			<div class="reply_box">
				<div class="reply">
					<div class="reply_content">
						<c:forEach items="${replyList }" var="reply">
							<p>${reply.rcontent }
							<c:if test="${reply.userNum eq user_num || user_num eq 4}">
							<button onclick="location.href='deleteReply.do?rno=${reply.rno}&pno=${reply.pno }'">x</button></p>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<form action="writeReply.do">
				<div class="input">
					<input type="text" style="visibility: hidden; width: 0" name="pno" value="${board.pno }">
					<c:if test="${user_num ne null }">
						<input type="text" class="reply_input" placeholder="댓글 달기..." name="rcontent">
						<input type="submit" class="reply_submit" value="게시">
					</c:if>
				</div>
				</form>
			</div>
		</div>
		
		
		
		<div class="product">
			<div class="product_info">
			<c:if test="${board.ctgr_num ne 0 }">
				<p><a href="boardMain.do?ctgr_num=${board.ctgr_num }">
					#${board.ctgr_name }
					</a>
				</p>
			</c:if>
				<span>상품 태그</span>
			</div>
			
			<div class="product_box">
				<div class="product_img">
					<a href="">
						<img alt="상품" src="../resources/image/boardIMG/all.png">
						
					</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>