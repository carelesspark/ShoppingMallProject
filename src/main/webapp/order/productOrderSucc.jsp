<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="${pageContext.request.contextPath}/resources/css/order/productOrderSucc.css"
	rel="stylesheet" />
<title>주문 성공 페이지</title>

</head>
<body>
	<%@ include file="../header.jsp"%>
	<main>
		<div id="order-info">
			<div id="order-success">
				<div>
					<svg width="100" height="100" viewBox="0 0 200 200" fill="none"
						xmlns="http://www.w3.org/2000/svg">
				<circle cx="100" cy="100" r="98.5" fill="white" stroke="black"
							stroke-width="3" />
				<path
							d="M82.5 130L46.5 86.5L41 92L82.5 142.5L159.5 64L154.5 58L82.5 130Z"
							fill="black" stroke="black" />
				</svg>
				</div>
				<div>
					<div style="font-size: 20px; font-weight: bold;">주문 성공</div>
					<div>주문하신 상품은 주문내역조회에서 확인 가능합니다.</div>
					<br>
					<div>
						주문번호 :
						${order.order_num }</div>
					<div>
						주문날짜 :
						${order.order_date }</div>
				</div>
			</div>
			<br>
			<hr>
			<div>
				<div style="text-align: center">
					<h3>주문 내역</h3>
				</div>
				<hr>
				<c:set var="total_price" value="0" />
				<c:forEach items="${productList}" var="product">
				    <div class="product-list">
				        <div class="image">
				        	<img src="${pageContext.request.contextPath}/resources/image/product/${product.product_num}/${product.img_name }" id="img" />
				        </div>
				        <div class="product">
				            <div class="product-name">${product.product_name}</div>
				            <br>
				            <div class="product-code">
				                <div class="column">상품코드</div>
				                <div>${product.product_code}</div>
				            </div>
				            <div class="product-info">
				                <div class="column">상품정보</div>
				                <div>${product.size_name} / ${product.color_name}</div>
				            </div>
				            <div class="product-price">
				                <div class="column">구매가격</div>
				                <div>
				                	<fmt:formatNumber value="${product.amountMultiPrice}" pattern="#,###"/> 원
				                </div>
				            </div>
				            <div class="sales-volume">
				                <div class="column">구매수량</div>
				                <div>${product.amount}개</div>
				            </div>
				            <div class="sum">
				                <div class="column">합계</div>
				                <div>
				                	<fmt:formatNumber value="${product.amountMultiPrice * product.amount}" pattern="#,###"/> 원
				                </div>
				                <c:set var="total_price" value="${total_price + (product.amountMultiPrice * product.amount)}" />
				            </div>
				        </div>
				    </div>
				    <hr>
				</c:forEach>
				
			</div>
			<div style="text-align: center">
				<h3>결제 금액</h3>
			</div>
			<hr>
			<div>
				<div id="order-fee">
					<div>
						<div id="order-fee-div-div">총 주문 금액</div>
						<div>
				        	<fmt:formatNumber value="${total_price}" pattern="#,###"/> 원
				        </div>
					</div>
					<div>
						<svg width="49" height="47" viewBox="0 0 49 47" fill="none"
							xmlns="http://www.w3.org/2000/svg">
		                <path
								d="M17.8718 18.027V1H23.8974H29.9231V18.027H48V28.973H29.9231V46H17.8718V44.7838V36.8784V28.973H1V18.027H17.8718Z"
								fill="black" stroke="black" />
		            </svg>
					</div>
					<div>
						<div id="order-fee-div-div">배송비</div>
						<div>
				        	<fmt:formatNumber value="${order.delivery_price }" pattern="#,###"/> 원
				        </div>
							<c:set var="total_price" value="${total_price + order.delivery_price}" />
					</div>
					<div>
						<svg width="49" height="47" viewBox="0 0 49 47" fill="none"
							xmlns="http://www.w3.org/2000/svg">
		                <path
								d="M17.8718 18.027V1H23.8974H29.9231V18.027H48V28.973H29.9231V46H17.8718V44.7838V36.8784V28.973H1V18.027H17.8718Z"
								fill="black" stroke="black" />
		            </svg>
					</div>
					<div>
						<div id="order-fee-div-div">포인트 차감</div>
						<div>-<fmt:formatNumber value="${order.points}" pattern="#,###"/>포인트</div>
					</div>
					<div>
						<svg width="50" height="30" viewBox="0 0 50 30" fill="none"
							xmlns="http://www.w3.org/2000/svg">
		                <path d="M49 10H1V1H49V10Z" fill="black"
								stroke="black" />
		                <path d="M49 29H1V20H49V29Z" fill="black"
								stroke="black" />
		            </svg>
					</div>
					<div>
						<div id="order-fee-div-div">총 결재 금액</div>
						<div>
				        	<fmt:formatNumber value="${order.totalPrice }" pattern="#,###"/> 원
				        </div>
					</div>
				</div>

			</div>
			<hr>
			<div style="text-align: center">
				<h3>결제 수단</h3>
			</div>
			<hr>
			<div id="payment">
				<div>결제 수단</div>
				<div>${order.payment }</div>
			</div>

			<hr>
			<div style="text-align: center">
				<h3>배송 정보</h3>
			</div>
			<hr>
			<div class="addr-list">
				<div class="addr-info">
					<div class="recipient">
						<div class="name">${order.recipient }</div>
					</div>
					<div class="postal-code">
						[${order.postal_num }] ${order.address } ${order.detail_address}</div>
					<div class="phn">${order.phone_num}</div>
					<div class="request">${order.request }</div>
				</div>
			</div>
			<hr>
			<div id="buttons">
				<button id="continue" onclick="location.href='/main.do'">쇼핑 계속 하기</button>
				<button id="order-list" onclick="location.href='/user/orderList.do'">주문 내역 조회</button>
			</div>

		</div>
	</main>
	</body>
	<%@ include file="../footer.jsp"%>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
	<script src="user_menu.js"></script>
</html>

