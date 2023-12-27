<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록 조회 페이지(관리자)</title>
<link href="../resources/css/admin/orderListAdmin.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin_user_list.css?ver=1.0" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<%@ include file="./admin_card.jsp"%>
		<div id="mc">
			<%@ include file="./admin_side.jsp"%>
			<main>
				<div id="admin_order_list">
					<div id="order_list_title">
						<h1>주문 목록 조회</h1>
					</div>
					
					<div id="search">
						<div>
							<form method="get" action="orderListAdmin.do">
								진행 상태 검색
								<select name="product_state">
								  <option value="">전체</option>
								  <c:forEach items="${productStateList}" var="state">
								    <c:choose>
								      <c:when test="${state.product_state eq product_state}">
								        <option value="${state.product_state}" selected>${state.product_state}</option>
								      </c:when>
								      <c:otherwise>
								        <option value="${state.product_state}">${state.product_state}</option>
								      </c:otherwise>
								    </c:choose>
								  </c:forEach>
								</select>
								<button type="submit">검색</button>
							</form>
						</div>
						
						<div>
							<form method="get" action="orderListAdmin.do">
								상품 이름 검색
								<input name="product_name" placeholder="상품 이름을 검색하세요.">
								<button type="submit">검색</button>
							</form>
						</div>
					</div>
					
					<div id="admin_order_list_bottom">
						<div id="order_list_title2">
							<p>주문 목록</p>
						</div>

						<div id="admin_order_list_table">
							<table id="order_list_table">
								<tr id="order_list_table_first_tr">
									<td>주문일</td>
									<td>주문 상세 번호</td>
									<td>상품 이름</td>
									<td>가격</td>
									<td>수량</td>
									<td>진행 상태</td>
									<td>고객 정보</td>
									<td></td>
								</tr>
								<c:forEach items="${orderList}" var="order">
									<tr id="order_list_table_other_tr">
										<td>
											<div id="order_list_table_other_tr_div">${order.order_date }</div></td>
											<td><div id="order_list_table_other_tr_div">${order.order_detail_num }</div></td>
											<td><div id="order_list_table_other_tr_div">${order.product_name}</div></td>
											<td><div id="order_list_table_other_tr_div">${order.product_price }</div></td>
											<td><div id="order_list_table_other_tr_div">${order.amount }</div></td>
											<td><div id="order_list_table_other_tr_div">${order.product_state }</div></td>
											<td><div id="order_list_table_other_tr_div">${order.user_name }</div></td>
											
											<td><div id="table_button">
												<button type="button" class="btn btn-outline-secondary"
													id="button2" onclick="location.href='orderInfoAdmin.do?order_detail_num=${order.order_detail_num}'">주문 정보</button>
												</div>
										</td>
									</tr>
								</c:forEach>
							
							</table>
						</div>
					</div>
					
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>