<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/product/productList.css">
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div class="container mt-5">
		<div class="row">
			<div class="col-md-2">
				<ul class="top-menu">
					<c:forEach var="c" items="${category }">
						<c:set var="uppercaseCategoryName"
							value="${fn:toUpperCase(c.category_name)}" />
						<li><a href="/category_products.do?category=${c.category_num }">${uppercaseCategoryName}</a></li>
						<c:forEach var="s" items="${sub_category }">
							<li><a href="/sub_category_products.do?category=${c.category_num }&sub_category=${s.sub_category_num }">${s.sub_category_name }</a></li>
						</c:forEach>
					</c:forEach>

				</ul>
			</div>
			<div class="col-md-10">
				<div class="row">
					<!-- 상품 -->
					<c:choose>
						<c:when test="${not empty category_products }">
							<c:forEach var="p" items="${category_products}">
							<div class="col-md-3">
								<a href="product.do">
									<div class="card">
										<img alt="Placeholder image of a real estate property"
											class="card-img-top" height="200"
											src="https://placehold.co/300x200" width="300" />
										<div class="card-body">
											<h5 class="card-title">${p.product_name}</h5>
											<p class="card-text">${p.product_price}</p>
											<p class="card-text">
												<i class="far fa-heart"> 455</i>
											</p>
										</div>
									</div>
								</a>
							</div>
						</c:forEach>
						</c:when>
						<c:when test="${not empty sub_category_products }">
							<c:forEach var="s" items="${sub_category_products}">
							<div class="col-md-3">
								<a href="product.do">
									<div class="card">
										<img alt="Placeholder image of a real estate property"
											class="card-img-top" height="200"
											src="https://placehold.co/300x200" width="300" />
										<div class="card-body">
											<h5 class="card-title">${s.product_name}</h5>
											<p class="card-text">${s.product_price}</p>
											<p class="card-text">
												<i class="far fa-heart"> 455</i>
											</p>
										</div>
									</div>
								</a>
							</div>
						</c:forEach>
						</c:when>
					</c:choose>
						
					<!-- 페이지네이션 -->
				</div>
				<nav aria-label="Page navigation">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#">«</a></li>
						<li class="page-item active"><a class="page-link" href="#">1</a>
						</li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">4</a></li>
						<li class="page-item"><a class="page-link" href="#">5</a></li>
						<li class="page-item"><a class="page-link" href="#">»</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>
	<script src="../resources/js/product/productList.js"></script>
</body>
</html>