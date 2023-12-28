<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin_product_detail.css?ver=1.2" />
<title>admin product detail</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<%@ include file="./admin_card.jsp"%>
		<div id="mc">
			<%@ include file="./admin_side.jsp"%>
			<main>
				<div id="md">
					<div id="mt">
						<div id="mtd">제품 상세 정보</div>
					</div>
					<div id="pi">
						<div class="infoDiv">
							<div class="name">제품 번호</div>
							<div class="value">${productInfo.product_num }</div>
						</div>
						<div class="infoDiv">
							<div class="name">제품명</div>
							<div class="value">${productInfo.product_name }</div>
						</div>
						<div class="infoDiv">
							<div class="name">제품 설명</div>
							<div class="value">${productInfo.product_info }</div>
						</div>
						<div class="infoDiv">
							<div class="name">등록일</div>
							<div class="value">${productInfo.product_date }</div>
						</div>
						<div class="infoDiv">
							<div class="name">판매액</div>
							<div class="value">${productInfo.product_sell }</div>
						</div>
						<div class="infoDiv">
							<div class="name">금액</div>
							<div class="value">${productInfo.product_price }</div>
						</div>
						<div class="infoDiv">
							<div class="name">수정일</div>
							<div class="value">${productInfo.modify_date }</div>
						</div>
						<div class="infoDiv">
							<div class="name">삭제일</div>
							<div class="value">${productInfo.delete_date }</div>
						</div>
						<div class="infoDiv">
							<div class="name">활성화 여부</div>
							<c:choose>
								<c:when test="${productInfo.registration_status == 0}">
									<div class="value">비활성화 되어있음</div>
								</c:when>
								<c:otherwise>
									<div class="value">활성화 되어있음</div>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="infoDiv">
							<div class="name">세부 카테고리명</div>
							<div class="value">${productInfo.sub_category_name }</div>
						</div>
						<div class="infoDiv">
							<div class="name">카테고리명</div>
							<div class="value">${productInfo.category_name }</div>
						</div>
					</div>
					<div id="remainInfoDiv">
						<div id="mh">
							<div>색상</div>
							<div>사이즈</div>
							<div>재고</div>
						</div>
						<c:forEach var="list" items="${stockList}">
							<div class="ml">
								<div>${list.color_name}</div>
								<div>${list.size_name}</div>
								<div>${list.product_stock}</div>
							</div>
						</c:forEach>
					</div>
					<div id="buttonDiv">
						<button type="button" onclick="">상품 수정</button>

						<c:choose>
							<c:when test="${productInfo.registration_status == 1}">
								<button type="button"
									onclick="window.location.href='/admin/deactivateProduct.do?product_num=${productInfo.product_num}'">상품
									비활성화</button>
							</c:when>
							<c:otherwise>
								<button type="button"
									onclick="window.location.href='/admin/activateProduct.do?product_num=${productInfo.product_num}'">상품
									활성화</button>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>