<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin_product_list.css?ver=1.0" />
<title>admin product list</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<%@ include file="./admin_card.jsp"%>
		<div id="mc">
			<%@ include file="./admin_side.jsp"%>
			<main>
				<div id="md">
					<div id="cate">
						<div id="mainC">
							<div>
								<button type="button" id="cBtn1"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=0&pageSize=${pageSize}&pageNum=${pageNum}'">top</button>
							</div>
							<div>
								<button type="button" id="cBtn2"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=5&pageSize=${pageSize}&pageNum=${pageNum}'">bottom</button>
							</div>
							<div>
								<button type="button" id="cBtn3"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=10&pageSize=${pageSize}&pageNum=${pageNum}'">outer</button>
							</div>
							<div>
								<button type="button" id="cBtn4"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=15&pageSize=${pageSize}&pageNum=${pageNum}'">shoes</button>
							</div>
							<div>
								<button type="button" id="cBtn5"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=20&pageSize=${pageSize}&pageNum=${pageNum}'">etc</button>
							</div>
						</div>
						<div id="subC">
							<div>
								<button type="button" id="subCBtn1"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum}&pageSize=${pageSize}&pageNum=${pageNum}'">${subCategory[subCategoryStartNum].sub_category_name}</button>
							</div>
							<div>
								<button type="button" id="subCBtn2"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum + 1}&pageSize=${pageSize}&pageNum=${pageNum}'">${subCategory[subCategoryStartNum + 1].sub_category_name}</button>
							</div>
							<div>
								<button type="button" id="subCBtn3"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum + 2}&pageSize=${pageSize}&pageNum=${pageNum}'">${subCategory[subCategoryStartNum + 2].sub_category_name}</button>
							</div>
							<div>
								<button type="button" id="subCBtn4"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum + 3}&pageSize=${pageSize}&pageNum=${pageNum}'">${subCategory[subCategoryStartNum + 3].sub_category_name}</button>
							</div>
							<div>
								<button type="button" id="subCBtn5"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum + 4}&pageSize=${pageSize}&pageNum=${pageNum}'">${subCategory[subCategoryStartNum + 4].sub_category_name}</button>
							</div>
						</div>
					</div>
					<div id="rowNum">
						<div>현재 페이지 표시 개수: ${pageSize}</div>
						<div id="rNumChange">
							<div>변경:</div>
							<div>
								<button type="button"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum}&pageSize=10&pageNum=${pageNum}'">10</button>
							</div>
							<div>
								<button type="button"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum}&pageSize=50&pageNum=${pageNum}'">50</button>
							</div>
							<div>
								<button type="button"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum}&pageSize=100&pageNum=${pageNum}'">100</button>
							</div>
						</div>
					</div>
					<div id="mh">
						<div>번호</div>
						<div>제품명</div>
						<div>제품 번호</div>
						<div>가격</div>
						<div>재고</div>
						<div>상세정보</div>
					</div>
					<div id="ml">
						<c:forEach var="list" items="${productList}">
							<div>${list.list_num}</div>
							<div>${list.product_name}</div>
							<div>${list.product_num}</div>
							<div>${list.product_price}</div>
							<div>${list.total_stock}</div>
							<div>
								<button
									onclick="window.location.href='/admin/productDetail.do?product_num=${list.product_num}'">✔️</button>
							</div>
						</c:forEach>
					</div>
					<div id="pageBtn">
						<div>
							<button type="button" id="prevPageBtn"
								<c:if test="${pageNum} > 1">onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum}&pageSize=${pageSize}&pageNum=${pageNum - 1}'"</c:if>>&lt;</button>
						</div>
						<div>${pageNum}/${totalPage}페이지</div>
						<div>
							<button type="button" id="nextPageBtn"
								<c:if test="${pageNum < totalPage}">onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum}&pageSize=${pageSize}&pageNum=${pageNum + 1}'"</c:if>>&gt;</button>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>

	<script type="text/javascript">
		var subCategoryNum = "${subCategoryNum}";
		var categoryBtnColor = "#F6BB43";

		document.getElementById('cBtn' + (Math.floor(subCategoryNum / 5) + 1)).style.backgroundColor = categoryBtnColor;
		document.getElementById(('subCBtn') + (subCategoryNum % 5 + 1)).style.backgroundColor = categoryBtnColor;
	</script>
</body>
</html>