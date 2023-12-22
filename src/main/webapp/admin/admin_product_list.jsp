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
								<button>top</button>
							</div>
							<div>
								<button>bottom</button>
							</div>
							<div>
								<button>outer</button>
							</div>
							<div>
								<button>shoes</button>
							</div>
							<div>
								<button>etc</button>
							</div>
						</div>
						<div id="subC">
							<div>
								<button>${subCategory[categoryNum]. sub_category_name}</button>
							</div>
							<div>
								<button>${subCategory[categoryNum + 1]. sub_category_name}</button>
							</div>
							<div>
								<button>${subCategory[categoryNum + 2]. sub_category_name}</button>
							</div>
							<div>
								<button>${subCategory[categoryNum + 3]. sub_category_name}</button>
							</div>
							<div>
								<button>${subCategory[categoryNum + 4]. sub_category_name}</button>
							</div>
						</div>
					</div>
					<div>현재 표시 개수: ${pageSize}</div>
					<div id="mh">
						<div>번호</div>
						<div>제품 번호</div>
						<div>제품명</div>
						<div>가격</div>
						<div>재고</div>
						<div>상세정보</div>
					</div>
					<c:forEach var="list" items="${productList}">
						<div id="ml">
							<div>${list.list_num}</div>
							<div>${list.product_num}</div>
							<div>${list.product_name}</div>
							<div>${list.product_price}</div>
							<div>${list.total_stock}</div>
							<div>
								<button>✔️</button>
							</div>
						</div>
					</c:forEach>
					<div>
						<button id="prevPageBtn"
							<c:if test="${pageNum} > 1">onclick="goToPage(${pageNum - 1})"</c:if>>&lt;</button>
						<div>${pageNum}/${totalPage}페이지</div>
						<button id="nextPageBtn"
							<c:if test="${pageNum < totalPage}">onclick="goToPage(${pageNum + 1})"</c:if>>&gt;</button>
					</div>
					<div>
						페이지당 표시 개수:&nbsp;<a href="">10</a>&nbsp;<a href="">50</a>&nbsp;<a
							href="">100</a>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>