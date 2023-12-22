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
								<button type="button" onclick="showProductList(1)">top</button>
							</div>
							<div>
								<button type="button" onclick="showProductList(6)">bottom</button>
							</div>
							<div>
								<button type="button" onclick="showProductList(11)">outer</button>
							</div>
							<div>
								<button type="button" onclick="showProductList(16)">shoes</button>
							</div>
							<div>
								<button type="button" onclick="showProductList(21)">etc</button>
							</div>
						</div>
						<div id="subC">
							<div>
								<button type="button"
									onclick="showProductList(${subCategoryStartNum})">${subCategory[subCategoryStartNum].sub_category_name}</button>
							</div>
							<div>
								<button type="button"
									onclick="showProductList(${subCategoryStartNum + 1})">${subCategory[subCategoryStartNum + 1].sub_category_name}</button>
							</div>
							<div>
								<button type="button"
									onclick="showProductList(${subCategoryStartNum + 2})">${subCategory[subCategoryStartNum + 2].sub_category_name}</button>
							</div>
							<div>
								<button type="button"
									onclick="showProductList(${subCategoryStartNum3})">${subCategory[subCategoryStartNum + 3].sub_category_name}</button>
							</div>
							<div>
								<button type="button"
									onclick="showProductList(${subCategoryStartNum + 4})">${subCategory[subCategoryStartNum + 4].sub_category_name}</button>
							</div>
						</div>
					</div>

					<div id="rowNum">
						<div>현재 페이지 표시 개수: ${pageSize}</div>
						<div id="rNumChange">
							<div>변경:</div>
							<a href="">10</a><a href="">50</a><a href="">100</a>
						</div>

					</div>
					<div id="mh">
						<div>번호</div>
						<div>제품 번호</div>
						<div>제품명</div>
						<div>가격</div>
						<div>재고</div>
						<div>상세정보</div>
					</div>
					<div id="ml">
						<c:forEach var="list" items="${productList}">
							<div>${list.list_num}</div>
							<div>${list.product_num}</div>
							<div>${list.product_name}</div>
							<div>${list.product_price}</div>
							<div>${list.total_stock}</div>
							<div>
								<button onclick="goProductDetail()">✔️</button>
							</div>
						</c:forEach>
					</div>
					<div id="pageBtn">
						<div>
							<button id="prevPageBtn"
								<c:if test="${pageNum} > 1">onclick="goToPage(${pageNum - 1})"</c:if>>&lt;</button>
						</div>
						<div>${pageNum}/${totalPage}페이지</div>
						<div>
							<button id="nextPageBtn"
								<c:if test="${pageNum < totalPage}">onclick="goToPage(${pageNum + 1})"</c:if>>&gt;</button>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>

	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script type="text/javascript">
		function showProductList(subCategoryNum) {
			var pageSize = ${pageSize} ;
			var pageNum = ${pageNum} ;
			var data = {subCategoryNum: subCategoryNum,
		            pageSize: pageSize,
		            pageNum: pageNum};
	        $.ajax({
	            type: 'GET',
	            url: '/admin/changeProductList.do', // Replace with your actual controller endpoint
	            data: data,
	            success: function(response) {
	                // Update the content on the page with the received data
	                // For example, assuming you have a <div> with id="product-list"
	                // $('#product-list').html(response);
	                $('#cate').html(response);
	                $('#ml').html(response);
	            },
	            error: function(error) {
	          		console.error('Error:', error);
	            }
	        });
		}
	</script>
</body>
</html>