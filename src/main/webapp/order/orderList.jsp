<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록 조회 페이지</title>
<link href="../resources/css/order/orderList.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<%@ include file="../user/user_card.jsp"%>
		<div id="mc">
			<%@ include file="../user/user_side.jsp"%>
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
									<h2>1 건</h2>
								</div>
							</div>
							<div id="order_list_section2">
								<div id="order_list_section_div1">
									<p>배송 준비</p>
								</div>
								<div id="order_list_section_div2">
									<h2>0 건</h2>
								</div>
							</div>
							<div id="order_list_section3">
								<div id="order_list_section_div1">
									<p>배송 시작</p>
								</div>
								<div id="order_list_section_div2">
									<h2>0 건</h2>
								</div>
							</div>
							<div id="order_list_section4">
								<div id="order_list_section_div1">
									<p>배송 완료</p>
								</div>
								<div id="order_list_section_div2">
									<h2>3 건</h2>
								</div>	
							</div>
						</div>
					</div>
					<div id="order_list_second_title">
						<h3>000님 주문 목록 조회</h3>
					</div>
					
					<div id="order_list_date_buttons">
						<div>
							<button type="button" class="btn btn-dark" id="button_0" onclick="location.href='/orderListDate.do?user_num=${orderList.user_num}'">전체</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_3" onclick="location.href='/orderListDate.do?user_num=${1}&date=${3}'">최근 3개월</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_6" onclick="location.href='/orderListDate.do?user_num=${1}&date=${6}'">최근 6개월</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_1" onclick="location.href='/orderListDate.do?user_num=${1}&date=${12}'">최근 1년</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark"
								id="button_before_2022">~2022년</button>
						</div>
						<div id="search_box">
							<input type="text" placeholder="주문한 상품의 이름을 검색해보세요!"
								id="search_order_list" />
							<button onclick="location.href='#'">
								<img alt="button" src="../resources/image/order/search_button.png" id="button_img">
							</button>
						</div>
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
										src="../resources/image/order/shirt.png" id="order_pic" /></a></td>
								<td>${order.product_name }</td>
								<td>${order.product_price}원</td>
								<td id="order_table_buttons">
									<div id="order_table_div_button">
										<a href="/orderInfo.do?order_num=${order.order_num}">> 상세조회</a>
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
								id="order_list_bottom_button1">이전</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark"
								id="order_list_bottom_button2">다음</button>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>