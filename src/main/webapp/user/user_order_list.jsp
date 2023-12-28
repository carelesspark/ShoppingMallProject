<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user.css?v=1.0" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user_order_list.css?v=2.0" />
<title>user order list</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<%@ include file="./user_card.jsp"%>
		<div id="mc">
			<%@ include file="./user_side.jsp"%>
			<main>
				<div id="md">
					<div id="mt">
						<div id="mtd">주문/배송 조회</div>
					</div>
					<div id="order_list_section">
						<div id="order_list_section_grid">
							<div id="order_list_section1">
								<div id="order_list_section_div1">
									<p>주문 완료</p>
								</div>
								<div id="order_list_section_div2">
									<h2>${orderCount.total_orders}건</h2>
								</div>
							</div>
							<div id="order_list_section2">
								<div id="order_list_section_div1">
									<p>상품 준비 중</p>
								</div>
								<div id="order_list_section_div2">
									<h2>${orderCount.orders_in_preparation}건</h2>
								</div>
							</div>
							<div id="order_list_section3">
								<div id="order_list_section_div1">
									<p>배송 중</p>
								</div>
								<div id="order_list_section_div2">
									<h2>${orderCount.orders_in_delivery}건</h2>
								</div>
							</div>
							<div id="order_list_section4">
								<div id="order_list_section_div1">
									<p>배송 완료</p>
								</div>
								<div id="order_list_section_div2">
									<h2>${orderCount.orders_delivered}건</h2>
								</div>
							</div>
						</div>
					</div>
					<div id="lr">
						<div id="lrb">
							<div>조회기간</div>
							<div>
								<button onclick="update1Month()">1개월</button>
							</div>
							<div>
								<button onclick="update3Month()">3개월</button>
							</div>
							<div>
								<button onclick="update6Month()">6개월</button>
							</div>
						</div>
						<div id="lrc">
							<form action="/user/changeOrderList.do"
								onsubmit="return validateForm(this, event)" id="lrcf">
								<div id="lrcfc">
									<input type="date" id="sCal" name="sDate" value="${startDate}">
									<div>~</div>
									<input type="date" id="eCal" name="eDate" value="${endDate}">
								</div>
								<div>
									<button type="submit">조회</button>
								</div>
							</form>
						</div>
					</div>
					<div id="ml">
						<c:choose>
							<c:when test="${not empty orderMap}">
								<c:forEach var="entry" items="${orderMap}">
									<c:if test="${not empty entry.value }">
										<div class="cob">
											<div class="codtb">
												<div>${entry.value[0].order_date}</div>
												<div>&nbsp·&nbsp주문</div>
											</div>
											<div class="clb">
												<c:forEach var="list" items="${entry.value}">
													<div class="clib">
														<div class="clm">
															<div class="cld">
																<div>${list.delivery_date}</div>
																<div>&nbsp·&nbsp</div>
																<div>${list.product_state}</div>
															</div>
															<div class="cpb">
																<div class="cpn">
																	<div>${list.product_name}</div>
																	<div>&nbsp/&nbsp</div>
																	<div>${list.color_name}</div>
																	<div>&nbsp/&nbsp</div>
																	<div>${list.size_name}</div>
																</div>
																<div class="cpp">
																	<div><fmt:formatNumber value="${list.total_price}" pattern="#,###"/>원</div>
																	<div>&nbsp·&nbsp</div>
																	<div>${list.amount}</div>
																	<div>개</div>
																</div>
															</div>
														</div>
														<div class="cbb">
															<div class="cbb1">
																<button
																	onclick="window.location.href='/orderInfo.do?order_detail_num=${list.order_detail_num}'">상세 조회</button>
															</div>
															<div class="cbb2">
																<button
																	onclick="window.location.href='/product.do?product_num=${list.product_num}'">상품 문의하기</button>
															</div>
															<div class="cbb3">
																<button
																	onclick="window.location.href='/review.do?product_code=${list.product_code}'">상품 리뷰쓰기</button>
															</div>
														</div>
													</div>
												</c:forEach>
											</div>
										</div>
									</c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div id="noList">
									<div>내역이 없습니다.</div>
								</div>
							</c:otherwise>
						</c:choose>
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

		// 현재 날짜를 가져오기
		var currentDate = new Date();
		// 대한민국 시간에 맞춰주기 위해 오프셋 가져오기
		// ms단위라 60000곱해줌
		let offset = currentDate.getTimezoneOffset() * 60000;
		function update1Month() {
			// 시작 날짜
			var startDate = new Date(currentDate.getTime() - offset);
			// 1달을 뺀 날짜, 하루를 더한 날짜로 세팅
			startDate.setMonth(startDate.getMonth() - 1);
			startDate.setDate(startDate.getDate() + 1);

			// 현재 날짜를 endDate에 설정
			var endDate = new Date(currentDate.getTime() - offset);

			// startDate를 폼의 input 요소에 설정
			document.getElementById("sCal").value = startDate.toISOString()
					.slice(0, 10);

			// endDate를 폼의 input 요소에 설정
			document.getElementById("eCal").value = endDate.toISOString()
					.slice(0, 10);
		}
		function update3Month() {
			// 시작 날짜
			var startDate = new Date(currentDate.getTime() - offset);
			// 1달을 뺀 날짜, 하루를 더한 날짜로 세팅
			startDate.setMonth(startDate.getMonth() - 3);
			startDate.setDate(startDate.getDate() + 1);

			// 현재 날짜를 endDate에 설정
			var endDate = new Date(currentDate.getTime() - offset);

			// startDate를 폼의 input 요소에 설정
			document.getElementById("sCal").value = startDate.toISOString()
					.slice(0, 10);

			// endDate를 폼의 input 요소에 설정
			document.getElementById("eCal").value = endDate.toISOString()
					.slice(0, 10);
		}
		function update6Month() {
			// 시작 날짜
			var startDate = new Date(currentDate.getTime() - offset);
			// 1달을 뺀 날짜, 하루를 더한 날짜로 세팅
			startDate.setMonth(startDate.getMonth() - 6);
			startDate.setDate(startDate.getDate() + 1);

			// 현재 날짜를 endDate에 설정
			var endDate = new Date(currentDate.getTime() - offset);

			// startDate를 폼의 input 요소에 설정
			document.getElementById("sCal").value = startDate.toISOString()
					.slice(0, 10);

			// endDate를 폼의 input 요소에 설정
			document.getElementById("eCal").value = endDate.toISOString()
					.slice(0, 10);
		}

		function validateForm(form, event) {
			// startDate, endDate 값을 가져오기

			var startDateValue = new Date(document.getElementById("sCal").value);
			var endDateValue = new Date(document.getElementById("eCal").value);

			// 12개월 이상인 경우
			if (endDateValue - startDateValue >= 365 * 24 * 60 * 60 * 1000) {
				// upDate1Month() 함수 실행
				update1Month();

				// 경고 메시지 출력
				alert("The difference between startDate and endDate is more than 12 months.");

				// 폼 제출 방지
				event.preventDefault();

				return false;
			}

			return true;
		}
	</script>
</body>
</html>