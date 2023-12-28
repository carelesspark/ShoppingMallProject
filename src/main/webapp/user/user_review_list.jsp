<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user_review_list.css?v=1.1" />
<title>user review list</title>
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
						<div id="mtd">내 리뷰</div>
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
							<form action="/user/changeReviewList.do"
								onsubmit="return validateForm(this, event)" id="lrcf">
								<div id="lrcfc">
									<input type="date" id="sCal" name="sDate" value="${startDate}">
									<div>~</div>
									<input type="date" id="eCal" name="eDate" value="${endDate}">
									<input type="hidden" name="currentPage" value="${currentPage}">
									<input type="hidden" name="itemsPerPage"
										value="${itemsPerPage}">
								</div>
								<div>
									<button type="submit">조회</button>
								</div>
							</form>
						</div>
					</div>
					<div id="mh">
						<div id="mh1">등록일</div>
						<div id="mh2">상품명</div>
						<div id="mh3">평가</div>
						<div id="mh4">상세 페이지</div>
					</div>
					<div id="ml">
						<c:choose>
							<c:when test="${not empty reviewList}">
								<c:forEach var="list" items="${reviewList}">
									<div class="clb">
										<div>${list.review_date}</div>
										<div class="cpb">
											<div class="cpn">
												<div>${list.product_name}</div>
												<div>&nbsp/&nbsp</div>
												<div>${list.color_name}</div>
												<div>&nbsp/&nbsp</div>
												<div>${list.size_name}</div>
											</div>
										</div>
										<div class="reviewRating">${list.review_ratings}</div>
										<div class="cbb">
											<div class="cbb1">
												<button type="button"
													onclick="window.location.href='/product.do?product_num=${list.product_num}'">&gt;</button>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div id="noList">
									<div>내역이 없습니다.</div>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<div id="mp">
						<div id="pBtn">
							<div id="prevbb">
								<button type="button" id="prevb"
									<c:if test="${currentPage > 1}">onclick="window.location.href='/user/changeReviewList.do?sDate=${startDate}&eDate=${endDate}&currentPage=${currentPage - 1}&itemsPerPage=${itemsPerPage}'"</c:if>>&lt;</button>
							</div>
							<div id="pShow">
								<div>${currentPage}</div>
								<div>&nbsp/&nbsp</div>
								<div>
									<c:choose>
										<c:when test="${totalPage == 0}">1</c:when>
										<c:otherwise>${totalPage}</c:otherwise>
									</c:choose>
								</div>
								<div>페이지</div>
							</div>
							<div id="nextbb">
								<button type="button" id="nextb"
									<c:if test="${currentPage < totalPage}">onclick="window.location.href='/user/changeReviewList.do?sDate=${startDate}&eDate=${endDate}&currentPage=${currentPage + 1}&itemsPerPage=${itemsPerPage}'"</c:if>>&gt;</button>
							</div>
						</div>
						<div id="pSize">
							<div id="pSizeShow">현재 페이지 표시 개수: ${itemsPerPage}</div>
							<div id="psbb">
								<div>변경&nbsp</div>
								<div id="psbb1">
									<button type="button"
										onclick="window.location.href='/user/changeReviewList.do?sDate=${startDate}&eDate=${endDate}&currentPage=${currentPage}&itemsPerPage=10'">10</button>
								</div>
								<div id="psbb2">
									<button type="button"
										onclick="window.location.href='/user/changeReviewList.do?sDate=${startDate}&eDate=${endDate}&currentPage=${currentPage}&itemsPerPage=20'">20</button>
								</div>
								<div id="psbb3">
									<button type="button"
										onclick="window.location.href='/user/changeReviewList.do?sDate=${startDate}&eDate=${endDate}&currentPage=${currentPage}&itemsPerPage=30'">30</button>
								</div>
							</div>

						</div>
					</div>
				</div>
			</main>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>

	<script type="text/javascript">
		var rank = '${rankLetter}';
		var rankBadge = document.getElementById('cc-rb');

		if (rank === 'B') {
			rankBadge.style.color = '#B87333';
		} else if (rank === 'S') {
			rankBadge.style.color = '#CCCCCC';
		} else if (rank === 'G') {
			rankBadge.style.color = '#FFD700';
		} else if (rank === 'D') {
			rankBadge.style.color = '#EEEEEE';
		} else if (rank === 'V') {
			rankBadge.style.color = '#8A2BE2';
		} else if (rank === 'A') {
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