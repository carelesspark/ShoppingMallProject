<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin_product_detail.css?ver=1.0" />
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
					<div id="pi">
						<div id="pih">제품 정보</div>
						<div id="pim">
							<div>
								<div>제품 번호</div>
								<div>${productInfo.product_num }</div>
							</div>
							<div>
								<div>제품명</div>
								<div>${productInfo.product_name }</div>
							</div>
							<div>
								<div>제품 설명</div>
								<div>${productInfo.product_info }</div>
							</div>
							<div>
								<div>등록일</div>
								<div>${productInfo.product_date }</div>
							</div>
							<div>
								<div>판매액</div>
								<div>${productInfo.product_sell }</div>
							</div>
							<div>
								<div>금액</div>
								<div>${productInfo.product_price }</div>
							</div>
							<div>
								<div>수정일</div>
								<div>${productInfo.modify_date }</div>
							</div>
							<div>
								<div>삭제일</div>
								<div>${productInfo.delete_date }</div>
							</div>
							<div>
								<div>활성화 여부</div>
								<div>${productInfo.registration_status }</div>
							</div>
							<div>
								<div>세부 카테고리명</div>
								<div>${productInfo.sub_category_name }</div>
							</div>
							<div>
								<div>카테고리명</div>
								<div>${productInfo.category_name }</div>
							</div>
						</div>
					</div>
					<div>
						<div id="mh">
							<div>색상</div>
							<div>사이즈</div>
							<div>재고</div>
						</div>
						<c:forEach var="list" items="${stockList}">
							<div id="ml">
								<div>${list.color_name}</div>
								<div>${list.size_name}</div>
								<div>${list.product_stock}</div>
							</div>
						</c:forEach>
					</div>
					<div>
						<button type="button" onclick="">상품 수정</button>
						<button type="button" onclick="">상품 비활성화</button>
						<button type="button" onclick="">상품 삭제</button>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>