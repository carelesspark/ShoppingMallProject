<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록 조회 페이지</title>
<link href="../css/orderList.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<header>임시 헤더</header>
	<div id="main-container">
		<div id="user-explanation">
			<div id="user-explanation-grid">
				<div>
					<div id="user-explanation-rank-container">
						<p>C</p>
					</div>
				</div>
				<div id="user-explanation-1-container">
					<div id="user-explanation-name-container">
						<p>회원</p>
					</div>
					<div id="user-explanation-name-rank-container">
						<p>CareLess</p>
					</div>
				</div>
				<div id="user-explanation-2-container">
					<div>
						<p>포인트</p>
					</div>
					<div>
						<p>10,000포인트</p>
					</div>
				</div>
				<div id="user-explanation-3-container">
					<div>
						<p>장바구니</p>
					</div>
					<div>
						<a href=""><p>클릭</p></a>
					</div>
				</div>
				<div id="user-explanation-4-container">
					<div>
						<p>주문 현황</p>
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
							class="menu-section-name-detail">회원 정보 수정</p></a> <a href=""
						class="menu-section-anchor"><p
							class="menu-section-name-detail">배송지 정보 수정</p></a>
				</div>
				<div id="menu-product-container" class="menu-section">
					<p class="menu-section-name">주문</p>
					<a href="" class="menu-section-anchor"><p
							class="menu-section-name-detail">장바구니</p></a> <a href=""
						class="menu-section-anchor"><p
							class="menu-section-name-detail">주문 목록 조회</p></a> <a href=""
						class="menu-section-anchor"><p
							class="menu-section-name-detail">상품 수정</p></a> <a href=""
						class="menu-section-anchor"><p
							class="menu-section-name-detail">상품 삭제</p></a>
				</div>
				<div id="menu-order-container" class="menu-section">
					<p class="menu-section-name">주문 관리</p>
					<a href="" class="menu-section-anchor"><p
							class="menu-section-name-detail">주문 목록</p></a> <a href=""
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
							<button type="button" class="btn btn-dark" id="button_3">최근
								3개월</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_6">최근
								6개월</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_1">최근
								1년</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_2022">2022년</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark"
								id="button_before_2021">~2021년</button>
						</div>
						<div id="search_box">
							<input type="text" placeholder="주문한 상품의 이름을 검색해보세요!"
								id="search_order_list" />
							<button onclick="location.href='#'">
								<img alt="button" src="../img/search_button.png" id="button_img">
							</button>
						</div>
					</div>
					<div id="order_list_table">
						<table id="order_table">
							<tr id="order_table_first_tr">
								<td id="order_table_product_num">주문번호</td>
								<td id="order_table_product_state">물품상태</td>
								<td id="order_table_product_date">배송 도착일</td>
								<td id="order_table_product_pic"></td>
								<td id="order_table_product_name">상품명</td>
								<td id="order_table_product_price">가격</td>
								<td id="order_table_product_button"></td>
							</tr>
							<tr id="order_table_other_tr">
								<td id="order_num">12312312</td>
								<td>주문 완료</td>
								<td>미정</td>
								<td id="order_pic"><a href='#'><img
										src="../img/shirt.png" id="order_pic" /></a></td>
								<td>00000옷</td>
								<td>39,000원</td>
								<td id="order_table_buttons">
									<div id="order_table_div_button">
										<a href="#">> 상세 조회</a>
									</div>
									<div id="order_table_div_button">
										<a href="#">> 판매자 문의</a>
									</div>
								</td>
							</tr>
							<tr id="order_table_other_tr">
								<td id="order_num">2223132</td>
								<td>배송 완료</td>
								<td>2023/12/09</td>
								<td id="order_pic"><a href='#'><img
										src="../img/hat.png" id="order_pic" /></a></td>
								<td>000000모자</td>
								<td>23,000원</td>
								<td id="order_table_buttons">
									<div id="order_table_div_button">
										<a href="#">> 상세 조회</a>
									</div>
									<div id="order_table_div_button">
										<a href="#">> 판매자 문의</a>
									</div>
								</td>
							</tr>
							<tr id="order_table_other_tr">
								<td id="order_num">35312323</td>
								<td>배송 완료</td>
								<td>2023/10/11</td>
								<td id="order_pic"><a href='#'><img
										src="../img/shoe.png" id="order_pic" /></a></td>
								<td>0000신발</td>
								<td>55,500</td>
								<td id="order_table_buttons">
									<div id="order_table_div_button">
										<a href="#">> 상세 조회</a>
									</div>
									<div id="order_table_div_button">
										<a href="#">> 판매자 문의</a>
									</div>
								</td>
							</tr>
							<tr id="order_table_other_tr">
								<td id="order_num">12312323</td>
								<td>교환 완료</td>
								<td>2023/06/13</td>
								<td id="order_pic"><a href='#'><img
										src="../img/shorts.png" id="order_pic" /></a></td>
								<td>00000반바지</td>
								<td>33,000원</td>
								<td id="order_table_buttons">
									<div id="order_table_div_button">
										<a href="#">> 상세 조회</a>
									</div>
									<div id="order_table_div_button">
										<a href="#">> 판매자 문의</a>
									</div>
								</td>
							</tr>
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
	<footer>임시 푸터</footer>
</body>
</html>