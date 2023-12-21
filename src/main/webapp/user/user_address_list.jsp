<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user_address_list.css" />

<title>user address list</title>
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
				주소지 내용
					<div id="mh">
						
						<div></div>
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<c:forEach var="list" items="${boardList}">
						<div id="ml"></div>
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
			rankBadge.style.color = '#CCCCCC';
		} else if (rank === 'GOLD') {
			rankBadge.innerText = 'G';
			rankBadge.style.color = '#FFD700';
		} else if (rank === 'DIAMOND') {
			rankBadge.innerText = 'D';
			rankBadge.style.color = '#EEEEEE';
		} else if (rank === 'VIP') {
			rankBadge.innerText = 'V';
			rankBadge.style.color = '#8A2BE2';
		} else if (rank === 'ADMIN') {
			rankBadge.innerText = 'A';
			rankBadge.style.color = '#DD2476';
		}
	</script>
</body>
</html>