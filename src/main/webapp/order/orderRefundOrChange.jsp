<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 환불/교환 요청 조회 페이지(관리자)</title>
<link href="../resources/css/order/orderRefundOrChange.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="main-container">
		<div id="user-explanation">
			<div id="user-explanation-grid">
				<div>
					<div id="user-explanation-rank-container">
						<p>M</p>
					</div>
				</div>
				<div id="user-explanation-1-container">
					<div id="user-explanation-name-container">
						<p>관리자</p>
					</div>
					<div id="user-explanation-name-rank-container">
						<p>Manager</p>
					</div>
				</div>
				<div id="user-explanation-2-container">
					<div>
						<p>월매출</p>
					</div>
					<div>
						<p>(1일~현재 매출합)원</p>
					</div>
				</div>
				<div id="user-explanation-3-container">
					<div>
						<p>주문 현황</p>
					</div>
					<div>
						<a href=""><p>클릭</p></a>
					</div>
				</div>
				<div id="user-explanation-4-container">
					<div>
						<p>상품 현황</p>
					</div>
					<div>
						<a href=""><p>클릭</p></a>
					</div>
				</div>
			</div>
		</div>
		<div id="menu-container">
			<section>
				<div id="menu-user-container" class="menu-section">
					<p class="menu-section-name">회원 정보</p>
					<a href="" class="menu-section-anchor"><p
							class="menu-section-name-detail">회원 목록</p></a> <a href=""
						class="menu-section-anchor"><p
							class="menu-section-name-detail">블랙리스트 목록</p></a>
				</div>
				<div id="menu-product-container" class="menu-section">
					<p class="menu-section-name">상품 관리</p>
					<a href="" class="menu-section-anchor"><p
							class="menu-section-name-detail">상품 목록</p></a> <a href=""
						class="menu-section-anchor"><p
							class="menu-section-name-detail">상품 추가</p></a> <a href=""
						class="menu-section-anchor"><p
							class="menu-section-name-detail">상품 수정</p></a> <a href=""
						class="menu-section-anchor"><p
							class="menu-section-name-detail">상품 삭제</p></a>
				</div>
				<div id="menu-order-container" class="menu-section">
					<p class="menu-section-name">주문 관리</p>
					<a href="/order/orderListAdmin.jsp" class="menu-section-anchor"><p
							class="menu-section-name-detail">주문 목록</p></a> <a href="/order/orderRefundOrChange.jsp"
						class="menu-section-anchor"><p
							class="menu-section-name-detail">반품 및 환불 목록</p></a> <a href=""
						class="menu-section-anchor"><p
							class="menu-section-name-detail">Q&A 목록</p></a>
				</div>
				<div id="menu-myinfo-container" class="menu-section">
					<p class="menu-section-name">나의 정보</p>
					<a href="" class="menu-section-anchor"><p
							class="menu-section-name-detail">정보 변경</p></a>
				</div>
			</section>
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
													id="button2" onclick="location.href='/orderRefundInfo.do?refund_change_num=${order.refund_change_num}'">요청 정보</button>
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