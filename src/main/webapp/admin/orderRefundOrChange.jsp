<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 환불/교환 요청 조회 페이지(관리자)</title>
<link href="../resources/css/admin/orderRefundOrChange.css" rel="stylesheet" />
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
				<div id="admin_request_list">
					<div id="request_list_title">
						<h1>주문 환불/교환 요청 조회</h1>
					</div>
					
					<div id="search">
						<div>
							<form method="get" action="orderRefundOrChange.do">
						    <input type="hidden" name="approve_search" value="1">
						  	  승인 상태 검색
						    <select name="approve">
						        <option value="2" ${approve eq '2' ? 'selected' : ''}>전체</option>
						        <option value="0" ${approve eq '0' ? 'selected' : ''}>승인 대기중</option>
						        <option value="1" ${approve eq '1' ? 'selected' : ''}>승인</option>
						        <option value="-1" ${approve eq '-1' ? 'selected' : ''}>거절</option>
						    </select>
						    <button type="submit">검색</button>
						</form>

						</div>
						
						<div>
							<form method="get" action="orderRefundOrChange.do">
								상품 이름 검색
								<input name="product_name" placeholder="상품 이름을 검색하세요.">
								<button type="submit">검색</button>
							</form>
						</div>
					</div>
					
					<div id="admin_request_list_bottom">
						<div id="request_list_title2">
							<p>요청 목록</p>
						</div>

						<div id="admin_request_list_table">
							<table id="request_list_table">
								<tr id="request_list_table_first_tr">
									<td>요청일</td>
									<td>요청번호</td>
									<td>주문상세번호</td>
									<td>상품이름</td>
									<td>가격</td>
									<td>요청수량</td>
									<td>요청상태</td>
									<td>고객정보</td>
									<td>교환/환불</td>
									<td>승인상태</td>
									<td></td>
								</tr>
								
								<c:forEach items="${orderList}" var="order">
									<tr id="order_list_table_other_tr">
											<td><div id="order_list_table_other_tr_div">${order.request_date }</div></td>
											<td><div id="order_list_table_other_tr_div">${order.refund_change_num }</div></td>
											<td><div id="order_list_table_other_tr_div">${order.order_detail_num }</div></td>
											<td><div id="order_list_table_other_tr_div">${order.product_name}</div></td>
											<td><div id="order_list_table_other_tr_div">${order.product_price }</div></td>
											<td><div id="order_list_table_other_tr_div">${order.refund_change_amount }</div></td>
											<td><div id="order_list_table_other_tr_div">${order.product_state }</div></td>
											<td><div id="order_list_table_other_tr_div">${order.user_name }</div></td>
											<td><div id="order_list_table_other_tr_div">
													<c:if test="${order.change == 1}">
													    교환
													</c:if>
													<c:if test="${order.cancel == 1}">
													    환불
													</c:if>
												</div></td>
											<td>
												<div id="order_list_table_other_tr_div">
													<c:choose>
													    <c:when test="${order.approve == 1}">
													        승인
													    </c:when>
													    <c:when test="${order.approve == -1}">
													       거절
													    </c:when>
													    <c:when test="${order.approve == 0}">
													       승인 대기중
													    </c:when>
													</c:choose>
												</div>
											</td>
											<td>
												<div id="table_button">
												<button type="button" class="btn btn-outline-secondary"
													id="button2" onclick="location.href='orderRefundInfo.do?refund_change_num=${order.refund_change_num}'">요청 정보</button>
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