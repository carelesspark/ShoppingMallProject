<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 취소/환불 승인(관리자)</title>
<link href="../resources/css/order/orderRefundAccept.css" rel="stylesheet" />
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
				<div id="main_refund">
					<div id="refund_title">
						<h1>000님 주문 취소/환불</h1>
					</div>
					<div id="refund_content">
						<table id="refund_table">
							<tr>
								<td id="refund_table_left">주문 번호</td>
								<td id="refund_table_right">123213231</td>
							</tr>
							<tr>
								<td id="refund_table_left">고객명</td>
								<td id="refund_table_right">박종혁</td>
							</tr>
							<tr>
								<td id="refund_table_left">환불액</td>
								<td id="refund_table_right">49,000원</td>
							</tr>
							<tr>
								<td id="refund_table_left">은행명</td>
								<td id="refund_table_right">국민은행</td>
							</tr>
							<tr>
								<td id="refund_table_left">계좌번호</td>
								<td id="refund_table_right">000000-00-000000</td>
							</tr>
							<tr>
								<td id="refund_table_left">취소/환불 사유</td>
								<td id="refund_table_right"><select id="select"><option
											value="damaged">상품 불량</option>
										<option value="simple_change">단순 변심</option>
										<option value="late_deliever">배송 지연</option>
										<option value="shortage">재고 부족</option>
										<option value="different_info">상품정보와 상이</option>
										<option value="etc">기타</option></select></td>
							</tr>
							<tr>
								<td id="refund_table_left_textarea">전달 내용</td>
								<td id="refund_table_right2"><textarea id="textarea"
										placeholder="전달 내용 입력"></textarea></td>
							</tr>
						</table>
					</div>
					<div id="bottom_buttons">
						<div id="bottom_button_div1">
							<button type="button" class="btn btn-outline-secondary"
								id="button3">취소/환불</button>
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