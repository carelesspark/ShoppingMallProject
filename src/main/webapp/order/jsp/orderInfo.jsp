<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록 상세 조회</title>
<link href="../css/orderInfo.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
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
				<div id="main_order_info">
					<div id="main-order-container">
						<p id="order_info_title">주문 목록 상세 조회</p>
					</div>
					<div id="order_info_text">
						<h1>상품이 배송되고 있습니다!</h1>
					</div>
					<div id="order_info_box_title">
						<div>
							<p>배송 정보</p>
						</div>
						<div>
							<p>배송지 정보</p>
						</div>
					</div>
					<div id="order_info_box">
						<div id="order_info_box_grid">
							<div>
								<img src="../img/truck.png" id="truck" />
							</div>
							<div id="info_box_left1">
								<div></div>
								<div id="info_box_left1_div">
									<p>주문 번호</p>
								</div>
								<div id="info_box_left1_div">
									<p>물품 상태</p>
								</div>
								<div id="info_box_left1_div">
									<p>배송 도착일</p>
								</div>
								<div id="info_box_left1_div">
									<p>택배사</p>
								</div>
								<div id="info_box_left1_div">
									<p>송장 번호</p>
								</div>
								<div></div>
							</div>
							<div id="info_box_right1">
								<div></div>
								<div id="info_box_right1_div">
									<p>1231234</p>
								</div>
								<div id="info_box_right1_div">
									<p>배송 중</p>
								</div>
								<div id="info_box_right1_div">
									<p>2023/12/11 예정</p>
								</div>
								<div id="info_box_right1_div">
									<p>CJ대한통운</p>
								</div>
								<div id="info_box_right1_div">
									<p>124123224</p>
								</div>
								<div></div>
							</div>
							<div></div>
							<div id="info_box_left2">
								<div></div>
								<div id="info_box_left2_div">
									<p>이름</p>
								</div>
								<div id="info_box_left2_div">
									<p>주소</p>
								</div>
								<div id="info_box_left2_div">
									<p>전화번호</p>
								</div>
								<div id="info_box_left2_div">
									<p>요청사항</p>
								</div>
								<div></div>
							</div>
							<div id="info_box_right2">
								<div></div>
								<div id="info_box_right2_div">
									<p>박종혁</p>
								</div>
								<div id="info_box_right2_div">
									<p>경기도 00시 00구 00동</p>
								</div>
								<div id="info_box_right2_div">
									<p>000-0000-0000</p>
								</div>
								<div id="info_box_right2_div">
									<p>문 앞으로 배송해주세요!</p>
								</div>
								<div></div>
							</div>
						</div>
					</div>
					<div id="buttons">
						<div>
							<button type="button" class="btn btn-dark" id="button_1">교환
								요청</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_2">
								취소/환불 요청</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_3">목록으로
								돌아가기</button>
						</div>
					</div>
					<div id="question">
						<p>배송 관련 자주 생기는 궁금한 점!</p>
					</div>
					<div id="accordion">
						<div class="card">
							<div class="card-header">
								<a class="btn" data-bs-toggle="collapse" href="#collapseOne">
									[배송] 구매한 상품이 어디에 있는지 알고 싶어요!</a>
							</div>
							<div id="collapseOne" class="collapse"
								data-bs-parent="#accordion">
								<div class="card-body" id="answer">제공해드리는 송장번호를 이용하여 해당
									택배사 페이지에서 구매하신 상품의 위치를 알 수 있습니다:)</div>
							</div>
						</div>

						<div class="card">
							<div class="card-header">
								<a class="collapsed btn" data-bs-toggle="collapse"
									href="#collapseTwo">[배송] 상품 배송을 받았는데 상품이 파손되어 왔어요.</a>
							</div>
							<div id="collapseTwo" class="collapse"
								data-bs-parent="#accordion">
								<div class="card-body" id="answer">
									만약 상품이 파손되어 배송되었을 경우, 저희 홈페이지에 있는 이메일 또는 번호로 연락을 주시면 새 상품으로<br />
									교환해드리고 있습니다.<br /> 다른 방법으로는, 상세 홈페이지의 '교환' 버튼을 클릭하여 새 상품으로 교환
									받으실 수 있습니다:)
								</div>
							</div>
						</div>

						<div class="card">
							<div class="card-header">
								<a class="collapsed btn" data-bs-toggle="collapse"
									href="#collapseThree">[배송] 주말에도 상품을 배송받을 수 있을까요? </a>
							</div>
							<div id="collapseThree" class="collapse"
								data-bs-parent="#accordion">
								<div class="card-body" id="answer">일요일을 제외한 월~토요일에 구매하신
									상품을 받아보실 수 있습니다:)</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<footer>임시 푸터</footer>
</body>
</html>