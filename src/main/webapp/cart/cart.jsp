<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link href="../resources/css/cart/cart.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="../resources/js/cart/cart.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<main>
		<div id="main_container">
			<form action="/productOrderFromCart.do" method="post">
				<div id="cart">
					<div id="cart_top_grid">
						<div id="cart_title">
							<h1>장바구니</h1>
						</div>
						<div id="cart_img">
							<div>
								<img src="../resources/image/cart/cart.png" id="order_cart_img" />
							</div>
							<div id="cart_all_delete">
								<a href="#" id="cart_all_delete_a">장바구니 모두 삭제</a>
							</div>
						</div>
					</div>
					<div id="cart_middle">
						<table id="cart_table">
							<tr id="cart_table_first_tr">
								<td id="cart_table_first_td">
									<!-- <input type="checkbox"
									id="cart_check_all" name="checkAll" value="check_value" />선택 -->
								</td>
								<td id="cart_table_product_img"></td>
								<td id="cart_table_product_name">제품명</td>
								<td>수량</td>
								<td>가격</td>
								<td>삭제</td>
							</tr>
							<c:forEach items="${cartList}" var="cart">
								<input type="hidden" name="product_code_list" id="input1"
									value="${cart.product_code}" />
								<tr id="cart_table_other_tr">
									<td id="cart_table_first_td"><input type="checkbox"
										id="cart_check_1" class="cart_product_checkbox" /> <input
										type="hidden" id="checkbox" value="0" name="checkbox" /></td>
									<td id="cart_table_product_img"><img
										src="${cart.main_img }" /></td>
									<td id="cart_table_product_name">${cart.product_name }</td>
									<td><input type="number" id="cart_product_count1"
										name="amount_list" value="${cart.amount }"></td>
									<td>${cart.total_price }</td>
									<td><button type="submit" class="btn btn-dark"
											id="cart_delete"
											onclick="location.href='/deleteCart.do?cart_num=${cart.cart_num}&user_num=${cart.user_num }'">삭제</button></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div id="cart_bottom">
						<div id="cart_total_price">
							<h4>주문 예상 금액</h4>
							<div id="total_price">
								<div>
									<p>총 상품 가격</p>
								</div>
								<div id="total_price_right">
									<p>95,000원</p>
								</div>
							</div>
							<div id="total_delivery">
								<div>
									<p>총 배송비</p>
								</div>
								<div id="total_delivery_right">
									<p>0원</p>
								</div>
							</div>
							<p id="total_price_value">95,000원</p>
						</div>
						<div id="cart_bottom_buttons_grid">
							<div id="cart_buttons_div1">
								<button type="button" class="btn btn-dark"
									id="return_home_button"
									onclick="location.href='../main/main.jsp'">홈으로 돌아가기</button>
							</div>
							<div id="cart_buttons_div2">
								<button type="submit" class="btn btn-dark" id="cart_buy_button">구매하기</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</main>
	<%@ include file="../footer.jsp"%>
	<script>
		$(".cart_product_checkbox").on("change", function(){
			$(this).next("#checkbox").val(this.checked ? 1 : 0);
		})
	</script>
</body>
</html>