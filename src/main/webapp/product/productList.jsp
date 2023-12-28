<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/product/productList.css?v=1">
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div class="container mt-5 mb-5" id="main-content">
		<div class="row">
			<div class="col-md-2">
				<ul class="top-menu">
					<c:forEach var="c" items="${category }">
						<c:set var="uppercase_category_name"
							value="${fn:toUpperCase(c.category_name)}" />
						<li><a
							href="/category_products.do?category=${c.category_num }">${uppercase_category_name}</a></li>
						<c:forEach var="s" items="${sub_category }">
							<li><a
								href="/sub_category_products.do?category=${c.category_num }&sub_category=${s.sub_category_num }">${s.sub_category_name }</a></li>
						</c:forEach>
					</c:forEach>

				</ul>
			</div>
			<div class="col-md-10">
				<div class="row">
					<!-- 상품 -->
					<c:choose>
						<c:when test="${not empty category_products }">
							<c:forEach var="c" items="${category_products}">
								<div class="col-md-3">
									<a href="product.do?product_num=${c.product_num }">
										<div class="card">
											<img class="card-img-top" height="200"
												src="${pageContext.request.contextPath}/resources/image/product/${c.product_num}/${c.img_name}"
												width="300" />
											<div class="card-body">
												<h5 class="card-title">${c.product_name}</h5>
												<p class="card-text">${c.product_price}원</p>
												<p class="card-text"></p>
											</div>
										</div>
									</a>
								</div>
							</c:forEach>
						</c:when>
						<c:when test="${not empty sub_category_products }">
							<c:forEach var="s" items="${sub_category_products}">
								<div class="col-md-3">
									<a href="product.do?product_num=${s.product_num }">
										<div class="card">
											<img class="card-img-top" height="200"
												src="${pageContext.request.contextPath}/resources/image/product/${s.product_num}/${s.img_name}"
												width="300" />
											<div class="card-body">
												<h5 class="card-title">${s.product_name}</h5>
												<p class="card-text">${s.product_price}원</p>
												<p class="card-text"></p>
											</div>
										</div>
									</a>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="s" items="${search_products}">
								<div class="col-md-3">
									<a href="product.do?product_num=${s.product_num }">
										<div class="card">
											<img class="card-img-top" height="200"
												src="${pageContext.request.contextPath}/resources/image/product/${s.product_num}/${s.img_name}"
												width="300" />
											<div class="card-body">
												<h5 class="card-title">${s.product_name}</h5>
												<p class="card-text">${s.product_price}원</p>
												<p class="card-text"></p>
											</div>
										</div>
									</a>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>

					<!-- 페이지네이션 -->
				</div>

				<nav>
					<ul class="pagination mb-5">
						<!-- 이전 버튼 -->
						<c:if test="${currentPage > 1}">
							<li class="page-item"><c:choose>
									<c:when test="${not empty selectedSearchKeyword}">
										<a class="page-link"
											href="/search_result.do?search_keyword=${selectedSearchKeyword}&page=${currentPage - 1}">이전</a>
									</c:when>
									<c:when test="${not empty selectedSubCategory}">
										<a class="page-link"
											href="/sub_category_products.do?category=${selectedCategory}&sub_category=${selectedSubCategory}&page=${currentPage - 1}">이전</a>
									</c:when>
									<c:otherwise>
										<a class="page-link"
											href="/category_products.do?category=${selectedCategory}&page=${currentPage - 1}">이전</a>
									</c:otherwise>
								</c:choose></li>
						</c:if>

						<!-- 페이지 번호 -->
						<c:forEach var="i" begin="1" end="${totalPages}">
							<li class="page-item ${i == currentPage ? 'active' : ''}"><c:choose>
									<c:when test="${not empty selectedSearchKeyword}">
										<a class="page-link"
											href="/search_result.do?search_keyword=${selectedSearchKeyword}&page=${i}">${i}</a>
									</c:when>
									<c:when test="${not empty selectedSubCategory}">
										<a class="page-link"
											href="/sub_category_products.do?category=${selectedCategory}&sub_category=${selectedSubCategory}&page=${i}">${i}</a>
									</c:when>
									<c:otherwise>
										<a class="page-link"
											href="/category_products.do?category=${selectedCategory}&page=${i}">${i}</a>
									</c:otherwise>
								</c:choose></li>
						</c:forEach>

						<!-- 다음 버튼 -->
						<c:if test="${currentPage < totalPages}">
							<li class="page-item"><c:choose>
									<c:when test="${not empty selectedSearchKeyword}">
										<a class="page-link"
											href="/search_result.do?search_keyword=${selectedSearchKeyword}&page=${currentPage + 1}">다음</a>
									</c:when>
									<c:when test="${not empty selectedSubCategory}">
										<a class="page-link"
											href="/sub_category_products.do?category=${selectedCategory}&sub_category=${selectedSubCategory}&page=${currentPage + 1}">다음</a>
									</c:when>
									<c:otherwise>
										<a class="page-link"
											href="/category_products.do?category=${selectedCategory}&page=${currentPage + 1}">다음</a>
									</c:otherwise>
								</c:choose></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>
	<script src="../resources/js/product/productList.js"></script>
</body>
</html>