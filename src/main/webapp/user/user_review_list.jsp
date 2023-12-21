<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user_review_list.css" />
<title>user review list</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div id="m">
		<div id="c">
			<div id="cc">
				<div id="cc-r">
					<div id="cc-rb"></div>
				</div>
				<div id="cc-u">
					<div id="cc-un">${sessionScope.user_name }님</div>
					<div id="cc-ur">${user_rank }</div>
				</div>
				<div id="cc-c">
					<div id="cc-cn">쿠폰</div>
					<div id="cc-cc">
						<a href="">$2</a>장
					</div>
				</div>
				<div id="cc-d">
					<div id="cc-dn">배송중</div>
					<div id="cc-dc">
						<a href="">$0</a>건
					</div>
				</div>
				<div id="cc-p">
					<div id="cc-pn">포인트</div>
					<div id="cc-pc">
						<a href="">${user_point }</a>원
					</div>
				</div>
			</div>
		</div>

		<div id="mc">
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
					<a href="/user/reviewList.do">상품 후기</a> <a
						href="/user/inquiryList.do">상품 Q&A 내역</a> <a
						href="/user/boardList.do">작성 글 내역</a> <a href="/user/replyList.do">작성
						댓글 내역</a>
				</div>
				<div>
					<p>나의 정보</p>
					<a href="/user/checkInfo.do">회원정보 변경</a> <a
						href="/user/addressList.do">주소지 관리</a>
				</div>
			</div>

			<main>
				<div id="md">
					<div id="mh">
						<div>주문일</div>
						<div>배송일</div>
						<div>수취인</div>
						<div>삼품명</div>
						<div>색깔</div>
						<div>사이즈</div>
						<div>개수</div>
						<div>가격</div>
						<div>상품 상태</div>
					</div>
					<c:forEach var="list" items="${reviewList}">
						<div id="ml">
							<div>${list.order_date}</div>
							<div>${list.delivery_date}</div>
							<div>${list.recipient}</div>
							<div>${list.product_name}</div>
							<div>${list.color_name}</div>
							<div>${list.size_name}</div>
							<div>${list.product_name}</div>
							<div>${list.amount}</div>
							<div>${list.total_price}</div>
							<div>${list.product_state}</div>
						</div>
					</c:forEach>
				</div>
			</main>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>

	<script type="text/javascript">
		var rank = '${user_rank}';
		var rankBadge = document.getElementById('cc-rb');

		if ('${user_rank}' === 'BRONZE') {
			rankBadge.innerText = 'B';
			rankBadge.style.color = '#B87333';
		} else if (rank === 'SILVER') {
			rankBadge.innerText = 'S';
		} else if (rank === 'GOLD') {
			rankBadge.innerText = 'G';
		} else if (rank === 'DIAMOND') {
			rankBadge.innerText = 'D';
		} else if (rank === 'VIP') {
			rankBadge.innerText = 'V';
		} else if (rank === 'Admin') {
			rankBadge.innerText = 'A';
		}
	</script>
</body>
</html>