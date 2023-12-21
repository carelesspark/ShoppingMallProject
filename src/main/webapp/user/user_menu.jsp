<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/user/user_menu.css" />

<div id="ms">
	<div>
		<p>나의 쇼핑</p>

		<a href="/orderList.do?user_num=${1}">주문/배송조회</a> <a
			href="/cart.do">장바구니</a>
	</div>
	<div>
		<p>나의 혜택</p>
		<a href="user/user_order_tracking.jsp">쿠폰</a> <a
			href="user/user_order_tracking.jsp">마일리지</a>
	</div>
	<div>
		<p>나의 활동</p>
		<a href="user/user_order_tracking.jsp">상품 후기</a> <a
			href="user/user_order_tracking.jsp">상품 Q&A 내역</a> <a
			href="user/user_order_tracking.jsp">작성 글 내역</a> <a
			href="user/user_order_tracking.jsp">작성 댓글 내역</a>
	</div>
	<div>
		<p>나의 정보</p>
		<a href="user/user_order_tracking.jsp">회원정보 변경</a>
	</div>
</div>
