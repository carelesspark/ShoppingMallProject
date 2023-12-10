<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link href="../css/cart.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="../js/cart.js"></script>
</head>
<body>
	<header>임시 헤더</header>
	<main>
		<div id="main_container">
			<div id="cart">
				<div id="cart_top_grid">
					<div id="cart_title">
						<h1>장바구니</h1>
					</div>
					<div id="cart_img">
						<img src="../img/cart.png" id="order_cart_img" />
					</div>
				</div>
				<div id="cart_middle">
					<table id="cart_table">
						<tr id="cart_table_first_tr">
							<td id="cart_table_first_td"><input type="checkbox"
								id="cart_check_all" name="checkAll" value="check_value"/>선택</td>
							<td id="cart_table_product_name">제품명</td>
							<td>수량</td>
							<td>가격</td>
							<td>배송비</td>
							<td>삭제</td>
						</tr>
						<tr id="cart_table_other_tr">
							<td id="cart_table_first_td"><input type="checkbox"
								id="cart_check_1" name="checkbox" value="check_value2" class="cart_product_checkbox" /></td>
							<td id="cart_table_product_name">제품 이름1</td>
							<td><input type="number" id="cart_product_count1"></td>
							<td>19,000원</td>
							<td>0원</td>
							<td><button type="submit" class="btn btn-dark"
									id="cart_delete">삭제</button></td>
						</tr>
						<tr id="cart_table_other_tr">
							<td id="cart_table_first_td"><input type="checkbox"
								id="cart_check_2" name="checkbox" value="check_value3" class="cart_product_checkbox" /></td>
							<td id="cart_table_product_name">제품 이름2</td>
							<td><input type="number" id="cart_product_count2"></td>
							<td>19,000원</td>
							<td>0원</td>
							<td><button type="submit" class="btn btn-dark"
									id="cart_delete">삭제</button></td>
						</tr>
						<tr id="cart_table_other_tr">
							<td id="cart_table_first_td"><input type="checkbox"
								id="cart_check_3" name="checkbox" value="check_value4" class="cart_product_checkbox" /></td>
							<td id="cart_table_product_name">제품 이름3</td>
							<td><input type="number" id="cart_product_count3"></td>
							<td>19,000원</td>
							<td>0원</td>
							<td><button type="submit" class="btn btn-dark"
									id="cart_delete">삭제</button></td>
						</tr>
						<tr id="cart_table_other_tr">
							<td id="cart_table_first_td"><input type="checkbox"
								id="cart_check_4" name="checkbox" value="check_value5" class="cart_product_checkbox" /></td>
							<td id="cart_table_product_name">제품 이름4</td>
							<td><input type="number" id="cart_product_count4"></td>
							<td>19,000원</td>
							<td>0원</td>
							<td><button type="submit" class="btn btn-dark"
									id="cart_delete">삭제</button></td>
						</tr>
						<tr id="cart_table_other_tr">
							<td id="cart_table_first_td"><input type="checkbox"
								id="cart_check_5" name="checkbox" value="check_value6" class="cart_product_checkbox" /></td>
							<td id="cart_table_product_name">제품 이름5</td>
							<td><input type="number" id="cart_product_count5"></td>
							<td>19,000원</td>
							<td>0원</td>
							<td><button type="submit" class="btn btn-dark"
									id="cart_delete">삭제</button></td>
						</tr>
					</table>
				</div>
				<div id="cart_bottom">
					<div id="cart_total_price">
						<h3>합계 금액 : 95,000원</h3>
					</div>
					<div id="cart_bottom_buttons_grid">
						<div id="cart_buttons_div1">
							<button type="button" class="btn btn-dark"
								id="return_home_button">홈으로 돌아가기</button>
						</div>
						<div id="cart_buttons_div2">
							<button type="submit" class="btn btn-dark" id="cart_buy_button">구매하기</button>
						</div>
					</div>
				</div>

			</div>
		</div>
	</main>
	<footer>임시 푸터</footer>
</body>
</html>