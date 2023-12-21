<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/user/user_menu.css" />

<div id="ms">
	<div>
		<p>나의 쇼핑</p>

		<a href="/user/orderList.do">주문/배송 조회</a> <a href="/cart.do">장바구니</a>
	</div>
	<div>
		<p>나의 혜택</p>
		<a href="/user/pointList.do">포인트</a>
	</div>
	<div>
		<p>나의 활동</p>
		<a href="/user/reviewList.do">상품 후기</a> <a href="/user/inquiryList.do">상품
			Q&A 내역</a> <a href="/user/boardList.do">작성 글 내역</a> <a
			href="/user/replyList.do">작성 댓글 내역</a>
	</div>
	<div>
		<p>나의 정보</p>
		<a href="/user/checkInfo.do">회원정보 변경</a> <a
			href="/user/addressList.do">주소지 관리</a>
	</div>
</div>
