<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 수정 페이지(관리자)</title>
<link href="../css/orderInfoEdit.css" rel="stylesheet" />
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
				<div id="admin_order_info_edit">
					<div id="order_info_edit_title">
						<h1>000님 주문 정보 수정</h1>
					</div>
					<div id="order_info_box">
						<div id="info_box_grid">
							<div id="order_pic">
								<a href="#"><img src="../img/shirt.png" id="pic"></a>
							</div>
							<div id="info_box_middle_grid">
								<div id="border_bottom">
									<p>제품명</p>
								</div>
								<div id="border_bottom">
									<p>주문 번호</p>
								</div>
								<div id="border_bottom">
									<p>주문일</p>
								</div>
								<div id="border_bottom">
									<p>결제 금액</p>
								</div>
								<div id="border_bottom">
									<p>고객명</p>
								</div>
								<div id="border_bottom">
									<p>주소</p>
								</div>
								<div id="border_bottom">
									<p>전화번호</p>
								</div>
								<div id="border_bottom">
									<p>요청사항</p>
								</div>
								<div id="border_bottom">
									<p>택배사</p>
								</div>
								<div id="border_bottom">
									<p>진행상태</p>
								</div>
								<div id="">
									<p>송장번호</p>
								</div>
							</div>
							<div id="info_box_right_grid">
								<div id="border_bottom">
									<p>00000000셔츠</p>
								</div>
								<div id="border_bottom">
									<p>123124213</p>
								</div>
								<div id="border_bottom">
									<p>2023/12/05</p>
								</div>
								<div id="border_bottom">
									<p>429,000원</p>
								</div>
								<div id="border_bottom">
									<p>박종혁</p>
								</div>
								<div id="border_bottom">
									<p>00시 00구 00동</p>
								</div>
								<div id="border_bottom">
									<p>000-0000-0000</p>
								</div>
								<div id="border_bottom">
									<p>배송 시 문 앞으로 배송해주세요</p>
								</div>
								<div id="border_bottom">
									<p>
										<select><option value="default">택배사</option>
											<option value="cj">CJ대한통운</option>
											<option value="hanjin">한진택배</option>
											<option value="lotte">롯데택배</option>
											<option value="post">우체국소포</option>
											<option value="logen">로젠택배</option></select>
									</p>
								</div>
								<div id="border_bottom">
									<p>
										<select><option value="default">진행 상태</option>
											<option value="prepare">상품 준비 중</option>
											<option value="start">배송 시작</option>
											<option value="ing">배송 중</option>
											<option value="finish">배송 완료</option></select>
								</div>
								<div>
									<p id="textbox"><input type="text"/></p>
								</div>
							</div>
						</div>
					</div>
					<div id="bottom_buttons">
						<div id="bottom_button_div1">
							<button type="button" class="btn btn-outline-secondary"
								id="button3">저장하기</button>
						</div>
						<div>
							<button type="button" class="btn btn-outline-secondary"
								id="button4">목록</button>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<footer>임시 푸터</footer>
</body>
</html>