<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 교환 요청 페이지</title>
<link href="../css/productChange.css" rel="stylesheet" />
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
				<div id="main_change">
					<div id="change_title">
						<h1>상품 교환 요청</h1>
					</div>
					<div id="change_content">
						<table id="change_table">
							<tr>
								<td id="change_table_left">주문 번호</td>
								<td id="change_table_right">123213231</td>
							</tr>
							<tr>
								<td id="change_table_left">제품명</td>
								<td id="change_table_right">00000000옷</td>
							</tr>
							<tr>
								<td id="change_table_left">고객명</td>
								<td id="change_table_right">박종혁</td>
							</tr>
							<tr>
								<td id="change_table_left">전화번호</td>
								<td id="change_table_right">000-0000-0000</td>
							</tr>
							<tr>
								<td id="change_table_left">주소</td>
								<td id="change_table_right">00도 00시 00구</td>
							</tr>
							<tr>
								<td id="change_table_left">상품 교환 사유</td>
								<td id="change_table_right"><select id="select"><option value="damaged">상품 불량</option>
										<option value="simple_change">단순 변심</option>
										<option value="different_info">상품정보와 상이</option>
										<option value="etc">기타</option></select></td>
							</tr>
							<tr>
								<td id="change_table_left_textarea">사유 설명</td>
								<td id="change_table_right2"><textarea id="textarea" placeholder="상품 교환 사유를 상세하게 적어주세요.&#13;&#10;단순 변심의 경우 7일 이내에 교환 신청 시 청약철회가 가능합니다.&#13;&#10;(최대 1000자 작성 가능)"></textarea></td>
							</tr>
						</table>
					</div>
					<div id="change_agreement">
						<div>
							<label><input type="checkbox"/><span>청약 후 또는 상품을 공급 받은 날로부터 7일 이내에는 소비자의 귀책사유로 인한 상품의 멸실 또는 훼손된 경우 등을 제외하고는<br/> 단순변심으로 인한 교환이 가능합니다.</span></label>
						</div>
						<div>
							<label><input type="checkbox"/><span>고의적인 파손, 사용 흔적이 발견될 경우 교환 진행이 불가합니다.</span></label>
						</div>
						<div>
							<label><input type="checkbox"/><span>상품 교환 진행에 동의합니다.</span></label>
						</div>
					</div>
					<div id="buttons">
						<div id="button1">
							<button type="button" class="btn btn-outline-secondary">돌아가기</button>
						</div>
						<div id="button2">
							<button type="button" class="btn btn-outline-secondary">상품 교환 등록</button>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<footer>임시 푸터</footer>
</body>
</html>