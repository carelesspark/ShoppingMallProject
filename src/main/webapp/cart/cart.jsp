<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<script>
	
</script>
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
								<a href="/deleteCartAll.do?user_num=${sessionScope.user_num}"
									id="cart_all_delete_a">장바구니 모두 삭제</a>
							</div>
						</div>
					</div>
					<div id="cart_middle">
						<table id="cart_table">
							<tr id="cart_table_first_tr">
								<td id="cart_table_first_td">
<!-- 									 <input type="checkbox" -->
<!-- 									id="cart_check_all" name="checkAll" value="check_value" />--> 선택
								</td>
								<td id="cart_table_product_img"></td>
								<td id="cart_table_product_name">제품명</td>
								<td>수량</td>
								<td>개당 가격</td>
								<td>삭제</td>
							</tr>	
							<c:forEach items="${cartList}" var="cart" varStatus="status">
								<input type="hidden" name="product_code_list" id="input1"
									value="${cart.product_code}" />
								<tr id="cart_table_other_tr">
									<td id="cart_table_first_td"><input type="checkbox"
										id="cart_check_1" class="cart_product_checkbox" /> <input
										type="hidden" id="checkbox" value="0" name="checkbox" /></td>
									<td id="cart_table_product_img"><img src="${pageContext.request.contextPath}/resources/image/product/${cart.product_num}/${cart.img_name }"/></td>
									<td id="cart_table_product_name">${cart.product_name }</td>
									<td><input type="number" id="cart_product_count"
										name="amount_list" class="cart_product_amount"
										value="${cart.amount }" min="1" max="10" /><input
										type="hidden" id="amount" class="reset_product_amount"
										value="${cart.amount }" /></td>
									<td id="cart_product_price"><fmt:formatNumber value="${cart.product_price }" pattern="#,###"/>원<input
										type="hidden" id="cart_product_price2"
										class="cart_product_price" value="${cart.product_price}" />
									</td>
									<td><button type="button" class="btn btn-dark"
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
									<p id="total_price_right_p">0원</p>
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
							<p id="total_price_value">0원</p>
						</div>
						<div id="cart_bottom_buttons_grid">
							<div id="cart_buttons_div1">
								<button type="button" class="btn btn-dark"
									id="return_home_button"
									onclick="location.href='../main/main.jsp'">홈으로 돌아가기</button>
							</div>
							<div id="cart_buttons_div2">
								<button type="submit" class="btn btn-dark" id="cart_buy_button" disabled>구매하기</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</main>
	<%@ include file="../footer.jsp"%>
	<script>
	$(document).ready(function() {
	    $(".cart_product_amount").on("change", function() {
	        const inputValue = $(this).val();

	        if (inputValue < 1 || inputValue > 10) {

	            alert("수량은 1에서 10 사이어야 합니다.");

	            $(this).val(1);

	        }


	    });


	    $(".cart_product_checkbox").on("change", function() {
	    	$(this).next("#checkbox").val(this.checked ? 1 : 0);

	        const row = $(this).closest('tr');
	        const countInput = row.find('.cart_product_amount');
	        countInput.prop("readonly", this.checked);


	        updateTotalPrice();
	    });



	    function updateTotalPrice() {
	        let totalPrice = 0;


	        $(".cart_product_checkbox:checked").each(function() {
	            const row = $(this).closest('tr');
	            const count = row.find('.cart_product_amount').val();
	            const price = row.find('.cart_product_price').val();
	            totalPrice += count * price;
	        });

 
	        $("#total_price_right p").text(totalPrice + "원");
	        if (totalPrice >= 30000) {
	            $("#total_delivery_right").text("0원");
	            $("#total_price_value").text(totalPrice + "원");
	        } else if (totalPrice === 0) {
	            $("#total_delivery_right").text("0원");
	            $("#total_price_value").text(totalPrice + "원");
	        } else {
	            $("#total_delivery_right").text("3000원");
	            $("#total_price_value").text(totalPrice + 3000 + "원");
	        }
	    }
	    
	    $(".cart_product_checkbox").change(function () {
            var allUnchecked = $(".cart_product_checkbox:not(:checked)").length === $(".cart_product_checkbox").length;
            if (!allUnchecked) {
                $("#cart_buy_button").prop("disabled", false);
            } else {
                $("#cart_buy_button").prop("disabled", true);
            }
        });
	});
	</script>
</body>
</html>