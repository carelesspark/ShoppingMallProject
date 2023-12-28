<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 교환 요청 페이지</title>
<link href="../resources/css/order/productChange.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="../resources/js/order/checkAgreement.js"></script>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<%@ include file="../user/user_card.jsp"%>
		<div id="mc">
			<%@ include file="../user/user_side.jsp"%>
			<main>
				<form action="insertProductChange.do" method="post" name="form">
					<div id="main_change">
						<div id="change_title">
							<h1>상품 교환 요청</h1>
						</div>
						<input type="hidden" name="amount" value="${productChange.amount}" />
						<input type="hidden" name="order_detail_num"
							value="${productChange.order_detail_num}" /> <input
							type="hidden" name="order_num" value="${productChange.order_num}" />
						<div id="change_content">
							<table id="change_table">
								<tr>
									<td id="change_table_left">주문 상세 번호</td>
									<td id="change_table_right">${productChange.order_detail_num}</td>
								</tr>
								<tr>
									<td id="change_table_left">제품명</td>
									<td id="change_table_right">${productChange.product_name }</td>
								</tr>
								<tr>
									<td id="change_table_left">고객명</td>
									<td id="change_table_right">${productChange.recipient }</td>
								</tr>
								<tr>
									<td id="change_table_left">전화번호</td>
									<td id="change_table_right">${productChange.phone_num }</td>
								</tr>
								<tr>
									<td id="change_table_left">주소</td>
									<td id="change_table_right">${productChange.address }
										${productChange.detail_address }</td>
								</tr>
								<tr>
									<td id="change_table_left">상품 교환 사유</td>
									<td id="change_table_right"><select id="select"
										name="refund_or_change_reason"><option value="상품 불량">상품
												불량</option>
											<option value="단순 변심">단순 변심</option>
											<option value="배송 지연">배송 지연</option>
											<option value="상품정보와 상이">상품정보와 상이</option>
											<option value="기타">기타</option></select></td>
								</tr>
								<tr>
									<td id="change_table_left_textarea">사유 설명</td>
									<td id="change_table_right2"><textarea id="textarea"
											name="reason_detail"
											placeholder="상품 교환 사유를 상세하게 적어주세요.&#13;&#10;단순 변심의 경우 7일 이내에 교환 신청 시 청약철회가 가능합니다.&#13;&#10;(최대 1000자 작성 가능)"></textarea></td>
								</tr>
							</table>
						</div>
						<div id="change_agreement">
							<div>
								<label><input type="checkbox" /><span>청약 후 또는
										상품을 공급 받은 날로부터 7일 이내에는 소비자의 귀책사유로 인한 상품의 멸실 또는 훼손된 경우 등을 제외하고는<br />
										단순변심으로 인한 교환이 가능합니다.
								</span></label>
							</div>
							<div>
								<label><input type="checkbox" /><span>고의적인 파손,
										사용 흔적이 발견될 경우 교환 진행이 불가합니다.</span></label>
							</div>
							<div>
								<label><input type="checkbox" /><span>상품 교환 진행에
										동의합니다.</span></label>
							</div>
						</div>
						<div id="buttons">
							<div id="button1">
								<button type="button" class="btn btn-outline-secondary"
									onclick="location.href='/orderInfo.do?order_detail_num=${productChange.order_detail_num}'">돌아가기</button>
							</div>
							<div id="button2">
								<button type="submit" class="btn btn-outline-secondary"
									onclick="checkAgreement()">상품 교환 등록</button>
							</div>
						</div>
					</div>
				</form>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
	<script type="text/javascript">
		var rank = '${user_rank}';
		var rankBadge = document.getElementById('cc-rb');

		if ('${user_rank}' === 'BRONZE') {
			rankBadge.innerText = 'B';
			rankBadge.style.color = '#B87333';
		} else if (rank === 'SILVER') {
			rankBadge.innerText = 'S';
			rankBadge.style.color = '#CCCCCC';
		} else if (rank === 'GOLD') {
			rankBadge.innerText = 'G';
			rankBadge.style.color = '#FFD700';
		} else if (rank === 'DIAMOND') {
			rankBadge.innerText = 'D';
			rankBadge.style.color = '#EEEEEE';
		} else if (rank === 'VIP') {
			rankBadge.innerText = 'V';
			rankBadge.style.color = '#8A2BE2';
		} else if (rank === 'ADMIN') {
			rankBadge.innerText = 'A';
			rankBadge.style.color = '#DD2476';
		}
	</script>
</body>
</html>