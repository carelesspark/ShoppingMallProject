<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user_order_list.css" />
<title>user order list</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<%@ include file="./user_card.jsp"%>
		<div id="mc">
			<%@ include file="./user_side.jsp"%>
			<main>
				<div id="main_order_list">
					<div id="main-order-container">
						<p id="order_list_title">주문 목록 조회</p>
					</div>
					<div id="order_list_section">
						<div id="order_list_section_grid">
							<div id="order_list_section1">
								<div id="order_list_section_div1">
									<p>주문 완료</p>
								</div>
								<div id="order_list_section_div2">
									<h2>${orderCount.total_orders}건</h2>
								</div>
							</div>
							<div id="order_list_section2">
								<div id="order_list_section_div1">
									<p>상품 준비 중</p>
								</div>
								<div id="order_list_section_div2">
									<h2>${orderCount.orders_in_preparation}건</h2>
								</div>
							</div>
							<div id="order_list_section3">
								<div id="order_list_section_div1">
									<p>배송 중</p>
								</div>
								<div id="order_list_section_div2">
									<h2>${orderCount.orders_in_delivery}건</h2>
								</div>
							</div>
							<div id="order_list_section4">
								<div id="order_list_section_div1">
									<p>배송 완료</p>
								</div>
								<div id="order_list_section_div2">
									<h2>${orderCount.orders_delivered}건</h2>
								</div>
							</div>
						</div>
					</div>
					<div id="order_list_second_title">
						<h3>${sessionScope.user_name}님 주문 목록 조회</h3>
					</div>

					<div id="order_list_date_buttons">
						<div>
							<button type="button" class="btn btn-dark" id="button_0"
								onclick="location.href='/user/orderList.do'">전체</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_3"
								onclick="location.href='/user/orderListDate.do?date=${3}'">최근
								3개월</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_6"
								onclick="location.href='/user/orderListDate.do?date=${6}'">최근
								6개월</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_1"
								onclick="location.href='/user/orderListDate.do?date=${12}'">최근
								1년</button>
						</div>
						<div></div>
						<form action="orderList.do" method="post">
							<div id="search_box">
								<input type="text" placeholder="주문한 상품의 이름을 검색해보세요!"
									id="search_order_list" name="search_order" />
								<button type="submit" >
									<img alt="button"
										src="../resources/image/order/search_button.png"
										id="button_img">
								</button>
							</div>
						</form>
					</div>
					<div id="order_list_table">
						<table id="order_table">
							<tr id="order_table_first_tr">
								<td id="order_table_product_num">주문번호</td>
								<td id="order_table_product_state">물품상태</td>
								<td id="order_table_product_date">구매 날짜</td>
								<td id="order_table_product_pic"></td>
								<td id="order_table_product_name">상품명</td>
								<td id="order_table_product_price">가격</td>
								<td id="order_table_product_button"></td>
							</tr>
							<c:forEach items="${orderList}" var="order">

								<tr id="order_table_other_tr">
									<td id="order_num">${order.order_num }</td>
									<td>${order.product_state}</td>
									<td>${order.order_date}</td>
									<td id="order_pic"><a href='#'><img
											src="${order.main_img }" id="order_pic" /></a></td>
									<td>${order.product_name }</td>
									<td>${order.product_price}원</td>
									<td id="order_table_buttons">
										<div id="order_table_div_button">
											<a href="/orderInfo.do?order_num=${order.order_num}">>
												상세조회</a>
										</div>
										<div id="order_table_div_button">
											<a href="#">> 판매자문의</a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div id="order_list_bottom">
						<div id="button_div1">
							<button type="button" class="btn btn-dark"
								id="order_list_bottom_button1" disabled>이전</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark"
								id="order_list_bottom_button2" disabled>다음</button>
						</div>
					</div>
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