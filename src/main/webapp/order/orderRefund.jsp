<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 취소/환불 요청 페이지</title>
<link href="../resources/css/order/orderRefund.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="../resources/js/order/checkAgreement2.js"></script>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<%@ include file="../user/user_card.jsp"%>
		<div id="mc">
			<%@ include file="../user/user_side.jsp"%>
			<main>
				<form action="insertOrderRefund.do" method="post" name="form">
					<div id="main_refund">
						<div id="refund_title">
							<h1>주문 취소/환불 요청</h1>
						</div>
						<div id="refund_content">

							<input type="hidden" name="amount" value="${orderRefund.amount}" />
							<input type="hidden" name="order_detail_num"
								value="${orderRefund.order_detail_num}" /> <input type="hidden"
								name="order_num" value="${orderRefund.order_num}" />
							<table id="refund_table">
								<tr>
									<td id="refund_table_left">주문 상세 번호</td>
									<td id="refund_table_right">${orderRefund.order_detail_num}</td>
								</tr>
								<tr>
									<td id="refund_table_left">고객명</td>
									<td id="refund_table_right">${orderRefund.recipient }</td>
								</tr>
								<tr>
									<td id="refund_table_left">환불액</td>
									<td id="refund_table_right"><fmt:formatNumber value="${orderRefund.amountMultiPrice }" pattern="#,###"/>원</td>
								</tr>
								<tr>
									<td id="refund_table_left">은행명</td>
									<td id="refund_table_right"><input type="text" name="bank"
										id="input" /></td>
								</tr>
								<tr>
									<td id="refund_table_left">계좌번호</td>
									<td id="refund_table_right"><input type="text"
										name="account_num" id=input /></td>
								</tr>
								<tr>
									<td id="refund_table_left">취소/환불 사유</td>
									<td id="refund_table_right"><select id="select"
										name="refund_or_change_reason"><option value="상품 불량">상품
												불량</option>
											<option value="단순 변심">단순 변심</option>
											<option value="배송 지연">배송 지연</option>
											<option value="상품정보와 상이">상품정보와 상이</option>
											<option value="기타">기타</option></select></td>
								</tr>
								<tr>
									<td id="refund_table_left_textarea">사유 설명</td>
									<td id="refund_table_right2"><textarea id="textarea"
											name="reason_detail"
											placeholder="취소/환불 사유를 상세하게 적어주세요.&#13;&#10;단순 변심의 경우 7일 이내에 취소/환불 신청 시 청약철회가 가능합니다.&#13;&#10;(최대 1000자 작성 가능)"></textarea></td>
								</tr>
							</table>

						</div>
						<div id="refund_agreement">
							<div>
								<label><input type="checkbox" /><span>청약 후 또는
										상품을 공급 받은 날로부터 7일 이내에는 소비자의 귀책사유로 인한 상품의 멸실 또는 훼손된 경우 등을 제외하고는<br />
										단순변심으로 인한 청약철회가 가능합니다.
								</span></label>
							</div>
							<div>
								<label><input type="checkbox" /><span>고의적인 파손,
										사용 흔적이 발견될 경우 환불 진행이 불가합니다.</span></label>
							</div>
							<div>
								<label><input type="checkbox" /><span>취소/환불 진행에
										동의합니다.</span></label>
							</div>
						</div>
						<div id="buttons">
							<div id="button1">
								<button type="button" class="btn btn-outline-secondary"
									onclick="location.href='/orderInfo.do?order_detail_num=${orderRefund.order_detail_num}'">돌아가기</button>
							</div>
							<div id="button2">
								<button type="button" class="btn btn-outline-secondary"
									onclick="checkAgreement2()">취소/환불 등록</button>
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