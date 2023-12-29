<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록 상세 조회</title>
<link href="../resources/css/admin/orderInfoAdmin.css" rel="stylesheet" />
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
						<p id="order_info_title">주문 상세 조회(관리자)</p>
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
							<button type="button" class="btn btn-dark" id="button_1"
										onclick="location.href='orderInfoEdit.do?order_detail_num=${orderInfo.order_detail_num}'">
										주문 수정
							</button>
						</div>
						<div>
							<button type="button" class="btn btn-dark" id="button_3"
								onclick="location.href='orderListAdmin.do'">목록으로
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