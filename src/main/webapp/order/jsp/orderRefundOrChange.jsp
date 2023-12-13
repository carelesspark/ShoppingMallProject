<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 환불/교환 요청 조회 페이지(관리자)</title>
<link href="../css/orderRefundOrChange.css" rel="stylesheet" />
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
				<div id="admin_request_list">
					<div id="request_list_title">
						<h1>주문 환불/교환 요청 조회</h1>
					</div>
					<div id="list_classification">
						<div id="list_classification_grid">
							<div id="category">
								<div id="grid1">
									<p>카테고리</p>
								</div>
								<div id="grid2">
									<select><option value="default">전체</option>
										<option value="top">상의</option>
										<option value="bottom">하의</option>
										<option value="outer">아우터</option>
										<option value="shoes">신발</option>
										<option value="etc">기타</option></select>
								</div>
							</div>
							<div id="request_status">
								<div id="grid1">
									<p>요청 상태</p>
								</div>
								<div id="grid2">
									<select><option value="default">전체</option>
										<option value="request_refund">취소/환불 요청</option>
										<option value="change">교환 요청</option>
										<option value="refund">취소/환불</option>
										<option value="changing">교환 중</option>
										<option value="change_complete">교환 완료</option>
									</select>
								</div>
							</div>
							<div id="request_date">
								<div id="grid1">
									<p>요청 날짜</p>
								</div>
								<div>
									<input type="date" data-placeholder="날짜 선택" required />
								</div>
								<div id="wave">
									<p>~</p>
								</div>
								<div>
									<input type="date" data-placeholder="날짜 선택" required />
								</div>
								<div>
									<div id="button">
										<button type="button" class="btn btn-outline-secondary"
											id="date_button">7일</button>
									</div>
								</div>
								<div>
									<div id="button">
										<button type="button" class="btn btn-outline-secondary"
											id="date_button">30일</button>
									</div>
								</div>
								<div>
									<div id="button">
										<button type="button" class="btn btn-outline-secondary"
											id="date_button">3개월</button>
									</div>
								</div>
							</div>
							<div id="search_num">
								<div id="grid3">
									<p>주문 번호 검색</p>
								</div>
								<div id="search_box">
									<input type="text" placeholder="주문 번호 입력"
										id="search_request_list" />
								</div>
							</div>
						</div>
					</div>
					<div id="search_button">
						<button type="button" class="btn btn-outline-secondary"
							id="button1">선택항목 검색</button>
					</div>
					<div id="admin_request_list_bottom">
						<div id="request_list_title2">
							<p>요청 목록</p>
						</div>

						<div id="admin_request_list_table">
							<table id="request_list_table">
								<tr id="request_list_table_first_tr">
									<td>요청일</td>
									<td>주문 번호</td>
									<td>상품 이름</td>
									<td>가격</td>
									<td>요청 상태</td>
									<td>고객 정보</td>
									<td></td>
								</tr>
								<tr id="request_list_table_other_tr">
									<td><div id="request_list_table_other_tr_div">2023/12/05</div></td>
									<td><div id="request_list_table_other_tr_div">12312323</div></td>
									<td><div id="request_list_table_other_tr_div">000000옷</div></td>
									<td><div id="request_list_table_other_tr_div">59,000원</div></td>
									<td><div id="request_list_table_other_tr_div">취소/환불
											요청</div></td>
									<td><div id="request_list_table_other_tr_div">박종혁</div></td>
									<td><div id="table_button">
											<div>
												<button type="button" class="btn btn-outline-secondary"
													id="button2">상세 확인</button>
											</div>
										</div></td>
								</tr>
								<tr id="request_list_table_other_tr">
									<td><div id="request_list_table_other_tr_div">2023/11/17</div></td>
									<td><div id="request_list_table_other_tr_div">21323142</div></td>
									<td><div id="request_list_table_other_tr_div">000000바지</div></td>
									<td><div id="request_list_table_other_tr_div">49,000원</div></td>
									<td><div id="request_list_table_other_tr_div">교환 중</div></td>
									<td><div id="request_list_table_other_tr_div">송민수</div></td>
									<td><div id="table_button">
											<div>
												<button type="button" class="btn btn-outline-secondary"
													id="button2">상세 확인</button>
											</div>
										</div></td>
								</tr>
								<tr id="request_list_table_other_tr">
									<td><div id="request_list_table_other_tr_div">2023/10/17</div></td>
									<td><div id="request_list_table_other_tr_div">2252222</div></td>
									<td><div id="request_list_table_other_tr_div">000000신발</div></td>
									<td><div id="request_list_table_other_tr_div">79,000원</div></td>
									<td><div id="request_list_table_other_tr_div">교환 완료</div></td>
									<td><div id="request_list_table_other_tr_div">안병현</div></td>
									<td><div id="table_button">
											<div>
												<button type="button" class="btn btn-outline-secondary"
													id="button2">상세 확인</button>
											</div>
										</div></td>
								</tr>
							</table>
						</div>
					</div>
					<div id="bottom_buttons">
						<div id="bottom_button_div1">
							<button type="button" class="btn btn-outline-secondary"
								id="button3">이전</button>
						</div>
						<div>
							<button type="button" class="btn btn-outline-secondary"
								id="button4">다음</button>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<footer>임시 푸터</footer>
</body>
</html>