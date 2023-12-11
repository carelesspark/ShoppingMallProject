<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문/결제 페이지</title>
<link href="../css/productOrder.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<header>임시 헤더</header>
	<main>
		<div id="main_container">
			<div id="order_list">
				<div id="order_list_title">
					<h1>주문 결제</h1>
				</div>
				<div>
					<h3>주문 내역</h3>
				</div>
				<div id="order_list_box">
					<div id="order_list_grid">
						<div id="order_list_pic">
							<a href=""><img src="../img/shirt.png" id="order_list_pic1" /></a>
						</div>
						<div id="order_list_price">
							<p>19,000</p>
						</div>
						<div id="order_list_amount">
							<p>수량/1개</p>
						</div>
						<div id="order_list_name">
							<p>000000셔츠</p>
						</div>
					</div>
				</div>
				<div id="order_list_total_price">
					<p>전체 가격 : 19,000원</p>
				</div>
			</div>
			<form>
				<div id="order_address">
					<div id="order_address_title">
						<div>
							<h3>배송지 정보</h3>
						</div>
						<div>
							<button type="button" class="btn btn-dark"
								id="order_address_button">배송지 주소 변경</button>
						</div>
					</div>
					<div id="order_address_box">
						<div id="order_address_grid">
							<div id="order_address_grid_rows_1">
								<div id="order_address_name">
									<p>이름</p>
								</div>
								<div id="order_address_address">
									<p>주소</p>
								</div>
								<div id="order_address_phone">
									<p>전화번호</p>
								</div>
								<div id="order_address_request">
									<p>요청사항</p>
								</div>
							</div>
							<div id="order_address_grid_rows_2">
								<div id="order_address_name_value">
									<p>박종혁</p>
								</div>
								<div id="order_address_address_value">
									<p>경기도 00시 00구 00동</p>
								</div>
								<div id="order_address_phone_value">
									<p>000-0000-0000</p>
								</div>
								<div id="order_address_request_value">
									<select>
										<option value="default">---요청사항을 선택해주세요. ---</option>
										<option value="direct">--- 직접 받겠습니다. ---</option>
										<option value="security">--- 경비실에 보관해주세요. ---</option>
										<option value="box">--- 택배함에 보관해주세요. ---</option>
										<option value="door">--- 문 앞으로 배송해주세요. ---</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="order_payment">
					<div id="order_payment_title">
						<div>
							<h3>결제</h3>
						</div>
					</div>
					<div id="order_payment_box">
						<div id="order_payment_grid">
							<div id="order_payment_grid_rows_1">
								<div id="order_payment_price">
									<p>전체 상품가격</p>
								</div>
								<div id="order_payment_coupon">
									<p>쿠폰</p>
								</div>
								<div id="order_payment_point">
									<p>포인트</p>
								</div>
								<div id="order_payment_delivery">
									<p>배송비</p>
								</div>
								<div id="order_payment_actual_price">
									<p>전체 결제 금액</p>
								</div>
								<div id="order_payment_method">
									<p>결제 방식</p>
								</div>
							</div>
							<div id="order_payment_grid_rows_2">
								<div id="order_payment_price_value">
									<p>19,000원</p>
								</div>
								<div id="order_payment_coupon_value">
									<select>
										<option value="default">--- 적용할 수 있는 쿠폰이 없습니다. ---</option>
										<option value="coupon1">--- 쿠폰1 ---</option>
										<option value="coupon2">--- 쿠폰2 ---</option>
										<option value="coupon3">--- 쿠폰3 ---</option>
										<option value="coupon4">--- 쿠폰4 ---</option>
									</select>
								</div>
								<div id="order_payment_point_value">
									<div id="order_payment_div_css">
										<input type="number" name="point" id="order_payment_point_box"
											readonly />
									</div>
									<div id="order_payment_label_css">
										<label>포인트</label>
									</div>
									<div id="order_payment_label_css">
										<label>보유 : </label>
									</div>
									<div id="order_payment_label_css">
										<label>10,000포인트</label>
									</div>
									<div id="order_payment_div_css">
										<button type="button" class="btn btn-dark"
											id="order_payment_point_button">포인트 사용하기</button>
									</div>
								</div>
								<div id="order_payment_delivery_value">
									<p>0원</p>
								</div>
								<div id="order_payment_actual_price_value">
									<p>19,000원</p>
								</div>
								<div id="order_payment_method_value">
									<div>
										<input type="radio" id="credit_card" name="payment"
											value="credit_card"><label>신용카드/체크카드</label>
									</div>
									<div>
										<input type="radio" id="deposit_without_passbook"
											name="payment" value="deposit_without_passbook"><label>무통장입금</label>
									</div>
									<div>
										<input type="radio" id="transfer" name="payment"
											value="transfer"><label>계좌이체</label>
									</div>
									<div>
										<input type="radio" id="kakaopay" name="payment"
											value="kakaopay"><label>카카오페이</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="order_buttons">
					<div id="order_buttons_div1">
						<button type="button" class="btn btn-dark" id="return_home_button"
							onclick="location.href='orderListAdmin.jsp';">홈으로 돌아가기</button>
					</div>
					<div id="order_buttons_div2">
						<button type="submit" class="btn btn-dark" id="order_buy_button">구매하기</button>
					</div>
				</div>
			</form>
		</div>
	</main>
	<footer>임시 푸터</footer>
</body>
</html>