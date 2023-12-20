<%@page import="com.dazzle.shop.model.board.BoardVO"%>
<%@page import="com.dazzle.shop.model.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
				<p class="id">${board.userNum }</p>
				<a href="deleteBoard.do?pno=${board.pno }"><button>삭제</button></a>
			</div>
		</div>
		
		<div class="content">
			<div class="content_img">
				<img alt="옷사진" src="../resources/image/boardIMG/all.png">
				<img alt="옷사진" src="../resources/image/boardIMG/classic.jpg">
				<img alt="옷사진" src="../resources/image/boardIMG/casual.jpg">
				<img alt="옷사진" src="../resources/image/boardIMG/post.jpg">
			</div>
			
			<div class="reply_box">
				<div class="reply">
					<div class="reply_content">
						<c:forEach items="${replyList }" var="reply">
							<p>${reply.rcontent }<button onclick="location.href='deleteReply.do?rno=${reply.rno}&pno=${reply.pno }'">x</button></p>
						</c:forEach>
					</div>
				</div>
				<form action="writeReply.do">
				<div class="input">
					<input type="text" style="visibility: hidden; width: 0" name="pno" value="${board.pno }">
					<input type="text" class="reply_input" placeholder="댓글 달기..." name="rcontent">
					<input type="submit" class="reply_submit" value="게시">
				</div>
				</form>
			</div>
		</div>
		
		
		
		<div class="product">
			<div class="product_info">
				<p><a href="board.jsp">
					${board.cate }
					</a>
				</p>
				<span>상품 태그</span>
			</div>
			
			<div class="product_box">
				<div class="product_img">
					<a href="">
						<img alt="상품" src="../resources/image/boardIMG/all.png">
						
						<p>상품 이름</p>
					</a>
				</div>
				
				<div class="product_img">
					<a href="">
						<img alt="상품" src="../resources/image/boardIMG/post.jpg">
						
						<p>상품 이름</p>
					</a>
				</div>
				
				<div class="product_img">
					<a href="">
						<img alt="상품" src="../resources/image/boardIMG/post.jpg">
						
						<p>상품 이름</p>
					</a>
				</div>
				
				<div class="product_img">
					<a href="">
						<img alt="상품" src="../resources/image/boardIMG/post.jpg">
						
						<p>상품 이름</p>
					</a>
				</div>
				
				<div class="product_img">
					<a href="">
						<img alt="상품" src="../resources/image/boardIMG/post.jpg">
						
						<p>상품 이름</p>
					</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>