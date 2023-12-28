<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환불/교환 요청 조회</title>
<link href="../resources/css/admin/orderRefundInfo.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin_user_list.css?ver=1.0" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@ include file="../header.jsp"%>
	<div id="m">
		<%@ include file="./admin_card.jsp"%>
		<div id="mc">
			<%@ include file="./admin_side.jsp"%>
			<main>
				<div id="main_order_info">
					<div id="main-order-container">
						<p id="order_info_title">환불/교환 요청 조회</p>
					</div>
					
					<div id="product_info_title">
						<p>구매 정보</p>
					</div>
					<div id="product_info_box">
						<div id="prdocut_info_box_grid">
							<div>
								<img alt="${orderInfo.product_name}" id="truck"
     src="${pageContext.request.contextPath}/resources/image/product/${orderInfo.product_num}/${orderInfo.img_name}">
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
									<p>${orderInfo.product_price }</p>
								</div>
							</div>
						</div>
					</div>
					<div id="product_info_title">
						<div>
							<p>환불 정보</p>
						</div>
					</div>
					<div id="order_info_box">
						<div id="order_info_box_grid">
							<div>
								<img src="../resources/image/order/truck.png" id="truck" />
							</div>
							<div id="info_box_left1">
								<div id="info_box_left1_div">
									<p>요청 번호</p>
								</div>
								<div id="info_box_left1_div">
									<p>요청 시간</p>
								</div>
								<div id="info_box_left1_div">
									<p>상태</p>
								</div>
								<div id="info_box_left1_div">
									<p>요청 이유</p>
								</div>
								<div id="info_box_left1_div">
									<p>요청 상세 이유</p>
								</div>
								<div id="info_box_left1_div">
									<p>취소/환불 수량</p>
								</div>
								<div id="info_box_left1_div">
									<p>은행</p>
								</div>
								<div id="info_box_left1_div">
									<p>계좌 번호</p>
								</div>
								<div id="info_box_left1_div">
									<p>환불 / 교환</p>
								</div>
								<div id="info_box_left1_div">
									<p>승인 / 거절</p>
								</div>
								<div id="info_box_left1_div">
									<p>승인/거절 사유</p>
								</div>
							</div>
							<div id="info_box_right1">
								<div id="info_box_right1_div">
									<p>${orderInfo.refund_change_num }</p>
								</div>
								<div id="info_box_right1_div">
									<p>${orderInfo.request_date }</p>
								</div>
								<div id="info_box_right1_div">
									<p>${orderInfo.product_state }</p>
								</div>
								<div id="info_box_right1_div">
									<p>${orderInfo.refund_or_change_reason}</p>
								</div>
								<div id="info_box_right1_div">
									<p>${orderInfo.reason_detail }</p>
								</div>
								<div id="info_box_right1_div">
									<p>${orderInfo.amount }</p>
								</div>
								<div id="info_box_right1_div">
									<p>${orderInfo.bank }</p>
								</div>
								<div id="info_box_right1_div">
									<p>${orderInfo.account_num }</p>
								</div>
								<div id="info_box_right1_div">
									<c:if test="${orderInfo.change == 1}">
									    <p>교환</p>
									</c:if>
									<c:if test="${orderInfo.cancel == 1}">
									    <p>환불</p>
									</c:if>

								</div>
								<div id="info_box_right1_div">
									<c:choose>
									    <c:when test="${orderInfo.approve == 1}">
									        <p>승인</p>
									    </c:when>
									    <c:when test="${orderInfo.approve == -1}">
									        <p>거절</p>
									    </c:when>
									    <c:otherwise>
									        <p>승인 대기 중</p>
									    </c:otherwise>
									</c:choose>
								</div>
								<div id="info_box_right1_div">
									<p>${orderInfo.response_detail }</p>
								</div>
							</div>
							<div></div>
							
						</div>
					</div>
					<div id="buttons">
						<div>
							<button type="button" class="btn btn-dark" id="button_1"
										onclick="location.href='orderRefundAccept.do?refund_change_num=${orderInfo.refund_change_num}'">
										요청 승인/거절
							</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_3"
								onclick="location.href='orderRefundOrChange.do'">목록으로
								돌아가기</button>
						</div>
					</div>
					<div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>