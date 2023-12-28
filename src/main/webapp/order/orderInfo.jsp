<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록 상세 조회</title>
<link href="../resources/css/order/orderInfo.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<%@ include file="../user/user_card.jsp"%>
		<div id="mc">
			<%@ include file="../user/user_side.jsp"%>
			<main>
				<div id="main_order_info">
					<div id="main-order-container">
						<p id="order_info_title">주문 목록 상세 조회</p>
					</div>
					<div id="order_info_text">
						<c:choose>
							<c:when test="${orderInfo.product_state eq '상품 준비 중'}">
								<h1>상품 배송 준비 중입니다!</h1>
							</c:when>
							<c:when test="${orderInfo.product_state eq '배송 중'}">
								<h1>상품이 배송되고 있습니다!</h1>
							</c:when>
							<c:when test="${orderInfo.product_state eq '취소/환불 요청 중'}">
								<h1>상품 취소/환불 요청이 진행 중 입니다.</h1>
							</c:when>
							<c:when test="${orderInfo.product_state eq '교환 요청 중'}">
								<h1>상품 교환 요청이 진행 중 입니다.</h1>
							</c:when>
							<c:when test="${orderInfo.product_state eq '환불 승인'}">
								<h1>상품 환불이 승인되었습니다.</h1>
							</c:when>
							<c:when test="${orderInfo.product_state eq '환불 거절'}">
								<h1>상품 환불이 거절되었습니다.</h1>
							</c:when>
							<c:when test="${orderInfo.product_state eq '교환 승인'}">
								<h1>상품 교환이 승인되었습니다.</h1>
							</c:when>
							<c:when test="${orderInfo.product_state eq '교환 거절'}">
								<h1>상품 교환이 거절되었습니다.</h1>
							</c:when>
							<c:otherwise>
								<h1>상품 배송이 완료되었습니다!</h1>
							</c:otherwise>
						</c:choose>
					</div>
					<div id="product_info_title">
						<p>구매 정보</p>
					</div>
					<div id="product_info_box">
						<div id="prdocut_info_box_grid">
							<div>
								<img src="${pageContext.request.contextPath}/resources/image/product/${orderInfo.product_num}/${orderInfo.img_name }" id="product_img" />
							</div>
							<div id="product_info_left">
								<div>
									<p>제품 이름</p>
								</div>
								<div>
									<p>사이즈</p>
								</div>
								<div>
									<p>색상</p>
								</div>
								<div>
									<p>수량</p>
								</div>
								<div>
									<p>금액</p>
								</div>
							</div>
							<div id="product_info_right">
								<div>
									<p>${orderInfo.product_name }</p>
								</div>
								<div>
									<p>${orderInfo.size_name }</p>
								</div>
								<div>
									<p>${orderInfo.color_name }</p>
								</div>
								<div>
									<p>${orderInfo.amount }</p>
								</div>
								<div>
									<p><fmt:formatNumber value="${orderInfo.product_price }" pattern="#,###"/>원</p>
								</div>
							</div>
						</div>
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
								<img src="../resources/image/order/truck.png" id="truck" />
							</div>
							<div id="info_box_left1">
								<div></div>
								<div id="info_box_left1_div">
									<p>주문 상세 번호</p>
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
									<p>${orderInfo.order_detail_num }</p>
								</div>
								<div id="info_box_right1_div">
									<p>${orderInfo.product_state }</p>
								</div>
								<div id="info_box_right1_div">
									<p>${orderInfo.delivery_date }예정</p>
								</div>
								<div id="info_box_right1_div">
									<p>${orderInfo.delivery_company }</p>
								</div>
								<div id="info_box_right1_div">
									<p>${orderInfo.invoice_num }</p>
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
									<p>${orderInfo.recipient }</p>
								</div>
								<div id="info_box_right2_div">
									<p>${orderInfo.address}${orderInfo.detail_address}</p>
								</div>
								<div id="info_box_right2_div">
									<p>${orderInfo.phone_num }</p>
								</div>
								<div id="info_box_right2_div">
									<p>${orderInfo.request}</p>
								</div>
								<div></div>
							</div>
						</div>
					</div>
					<div id="buttons">
						<div>
							<c:choose>
								<c:when test="${orderInfo.product_state eq '상품 준비 중'}">
									<button type="button" class="btn btn-dark" id="button_1"
										disabled='disabled'
										onclick="location.href='/productChange.do?order_detail_num=${orderInfo.order_detail_num}'">교환
										요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '배송 중'}">
									<button type="button" class="btn btn-dark" id="button_1"
										disabled='disabled'
										onclick="location.href='/productChange.do?order_detail_num=${orderInfo.order_detail_num}'">교환
										요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '취소/환불 요청 중'}">
									<button type="button" class="btn btn-dark" id="button_1"
										disabled='disabled'
										onclick="location.href='/productChange.do?order_detail_num=${orderInfo.order_detail_num}'">교환
										요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '교환 요청 중'}">
									<button type="button" class="btn btn-dark" id="button_1"
										disabled='disabled'
										onclick="location.href='/productChange.do?order_detail_num=${orderInfo.order_detail_num}'">교환
										요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '환불 승인'}">
									<button type="button" class="btn btn-dark" id="button_1"
										disabled='disabled'
										onclick="location.href='/productChange.do?order_detail_num=${orderInfo.order_detail_num}'">교환
										요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '환불 거절'}">
									<button type="button" class="btn btn-dark" id="button_1"
										disabled='disabled'
										onclick="location.href='/productChange.do?order_detail_num=${orderInfo.order_detail_num}'">교환
										요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '교환 승인'}">
									<button type="button" class="btn btn-dark" id="button_1"
										disabled='disabled'
										onclick="location.href='/productChange.do?order_detail_num=${orderInfo.order_detail_num}'">교환
										요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '교환 거절'}">
									<button type="button" class="btn btn-dark" id="button_1"
										disabled='disabled'
										onclick="location.href='/productChange.do?order_detail_num=${orderInfo.order_detail_num}'">교환
										요청</button>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-dark" id="button_1"
										onclick="location.href='/productChange.do?order_detail_num=${orderInfo.order_detail_num}'">교환
										요청</button>
								</c:otherwise>
							</c:choose>
						</div>
						<div>
							<c:choose>
								<c:when test="${orderInfo.product_state eq '상품 준비 중'}">
									<button type="button" class="btn btn-dark" id="button_2"
										onclick="location.href='/orderRefund.do?order_detail_num=${orderInfo.order_detail_num}'">
										취소/환불 요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '배송 중'}">
									<button type="button" class="btn btn-dark" id="button_2"
										onclick="location.href='/orderRefund.do?order_detail_num=${orderInfo.order_detail_num}'">
										취소/환불 요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '취소/환불 요청 중'}">
									<button type="button" class="btn btn-dark" id="button_2"
										disabled='disabled'
										onclick="location.href='/orderRefund.do?order_detail_num=${orderInfo.order_detail_num}'">
										취소/환불 요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '교환 요청 중'}">
									<button type="button" class="btn btn-dark" id="button_2"
										disabled='disabled'
										onclick="location.href='/orderRefund.do?order_detail_num=${orderInfo.order_detail_num}'">
										취소/환불 요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '환불 승인'}">
									<button type="button" class="btn btn-dark" id="button_2"
										disabled='disabled'
										onclick="location.href='/orderRefund.do?order_detail_num=${orderInfo.order_detail_num}'">
										취소/환불 요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '환불 거절'}">
									<button type="button" class="btn btn-dark" id="button_2"
										disabled='disabled'
										onclick="location.href='/orderRefund.do?order_detail_num=${orderInfo.order_detail_num}'">
										취소/환불 요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '교환 승인'}">
									<button type="button" class="btn btn-dark" id="button_2"
										disabled='disabled'
										onclick="location.href='/orderRefund.do?order_detail_num=${orderInfo.order_detail_num}'">
										취소/환불 요청</button>
								</c:when>
								<c:when test="${orderInfo.product_state eq '교환 거절'}">
									<button type="button" class="btn btn-dark" id="button_2"
										disabled='disabled'
										onclick="location.href='/orderRefund.do?order_detail_num=${orderInfo.order_detail_num}'">
										취소/환불 요청</button>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-dark" id="button_2"
										onclick="location.href='/orderRefund.do?order_detail_num=${orderInfo.order_detail_num}'">
										취소/환불 요청</button>
								</c:otherwise>
							</c:choose>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_3"
								onclick="location.href='/user/orderList.do'">목록으로 돌아가기</button>
						</div>
					</div>
					<c:if
						test="${orderInfo.product_state eq '환불 승인' || orderInfo.product_state eq '환불 거절' || orderInfo.product_state eq '교환 승인' || orderInfo.product_state eq '교환 거절'}">
						<div id="refund_change_result">
							<div id="refund_change_result_title">
								<c:choose>
									<c:when test="${orderInfo.product_state eq '환불 승인'}">
										<h3>환불 승인 사유</h3>
									</c:when>
									<c:when test="${orderInfo.product_state eq '환불 거절'}">
										<h3>환불 거절 사유</h3>
									</c:when>
									<c:when test="${orderInfo.product_state eq '교환 승인'}">
										<h3>교환 승인 사유</h3>
									</c:when>
									<c:when test="${orderInfo.product_state eq '교환 거절'}">
										<h3>교환 거절 사유</h3>
									</c:when>
								</c:choose>
							</div>
							<div id="refund_change_result_reason">
								<textarea id="result_reason_textarea" readonly>
								${orderResult.response_detail}
							</textarea>
							</div>
						</div>
					</c:if>
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