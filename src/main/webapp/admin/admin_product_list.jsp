<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin_product_list.css?ver=1.2" />
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
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=0&currentPage=1&itemsPerPage=${itemsPerPage}'">top</button>
							</div>
							<div>
								<button type="button" id="cBtn2"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=5&currentPage=1&itemsPerPage=${itemsPerPage}'">bottom</button>
							</div>
							<div>
								<button type="button" id="cBtn3"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=10&currentPage=1&itemsPerPage=${itemsPerPage}'">outer</button>
							</div>
							<div>
								<button type="button" id="cBtn4"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=15&currentPage=1&itemsPerPage=${itemsPerPage}'">shoes</button>
							</div>
							<div>
								<button type="button" id="cBtn5"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=20&currentPage=1&itemsPerPage=${itemsPerPage}'">etc</button>
							</div>
						</div>
						<div id="subC">
							<div>
								<button type="button" id="subCBtn1"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum}&currentPage=1&itemsPerPage=${itemsPerPage}'">${subCategory[subCategoryStartNum].sub_category_name}</button>
							</div>
							<div>
								<button type="button" id="subCBtn2"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum + 1}&currentPage=1&itemsPerPage=${itemsPerPage}'">${subCategory[subCategoryStartNum + 1].sub_category_name}</button>
							</div>
							<div>
								<button type="button" id="subCBtn3"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum + 2}&currentPage=1&itemsPerPage=${itemsPerPage}'">${subCategory[subCategoryStartNum + 2].sub_category_name}</button>
							</div>
							<div>
								<button type="button" id="subCBtn4"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum + 3}&currentPage=1&itemsPerPage=${itemsPerPage}'">${subCategory[subCategoryStartNum + 3].sub_category_name}</button>
							</div>
							<div>
								<button type="button" id="subCBtn5"
									onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryStartNum + 4}&currentPage=1&itemsPerPage=${itemsPerPage}'">${subCategory[subCategoryStartNum + 4].sub_category_name}</button>
							</div>
						</div>
					</div>
					<div id="mh">
						<div>제품명</div>
						<div>제품 번호</div>
						<div>가격</div>
						<div>재고</div>
						<div>상세정보</div>
					</div>
					<div id="ml">
						<c:forEach var="list" items="${productList}">
							<div class="clb">
								<div>${list.product_name}</div>
								<div>${list.product_num}</div>
								<div>${list.product_price}</div>
								<div>${list.total_stock}</div>
								<div>
									<button
										onclick="window.location.href='/admin/productDetail.do?product_num=${list.product_num}'">✔️</button>
								</div>
							</div>
						</c:forEach>
					</div>
					<div id="mp">
						<div id="pBtn">
							<div id="prevbb">
								<button type="button" id="prevb"
									<c:if test="${currentPage > 1}">onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryNum}&currentPage=${currentPage - 1}&itemsPerPage=${itemsPerPage}'"</c:if>>&lt;</button>
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
									<c:if test="${currentPage < totalPage}">onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryNum}&currentPage=${currentPage + 1}&itemsPerPage=${itemsPerPage}'"</c:if>>&gt;</button>
							</div>
						</div>
						<div id="pSize">
							<div id="pSizeShow">현재 페이지 표시 개수: ${itemsPerPage}</div>
							<div id="psbb">
								<div>변경&nbsp</div>
								<div id="psbb1">
									<button type="button"
										onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryNum}&currentPage=1&itemsPerPage=10'">10</button>
								</div>
								<div id="psbb2">
									<button type="button"
										onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryNum}&currentPage=1&itemsPerPage=20'">20</button>
								</div>
								<div id="psbb3">
									<button type="button"
										onclick="window.location.href='/admin/changeProductList.do?subCategoryNum=${subCategoryNum}&currentPage=1&itemsPerPage=30'">30</button>
								</div>
							</div>
						</div>
					</div>


					<%-- 					<div id="rowNum">
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
					</div> --%>
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