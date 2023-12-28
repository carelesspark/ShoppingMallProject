<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/header.css">
<header>
	<nav class="navbar navbar-expand-lg">
		<div class="container">
			<a class="navbar-brand" href="/main.do">DAZZLE</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/main.do">HOME</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/category_products.do?category=1">TOP</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/category_products.do?category=2">BOTTOM</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/category_products.do?category=3">OUTER</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/category_products.do?category=4">SHOES</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/category_products.do?category=5">ETC</a></li>
				</ul>

				<ul class="navbar-nav gap-2">
					<li class="nav-item"><a class="nav-link" href="/boardMain.do">CODY</a></li>
					<li class="nav-item"><a class="nav-link" href="/cart.do">CART</a></li>
					<c:if test="${sessionScope.is_admin == 1}">
						<li class="nav-item"><a class="nav-link"
						href="/admin/userList.do">ADMIN PAGE</a></li>
					</c:if>
					<c:if test="${sessionScope.is_admin == 0 }">
						<li class="nav-item"><a class="nav-link"
						href="/user/orderList.do">MY PAGE</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link"
						href="/sign/goRegister.do">JOIN</a></li>
					<c:if test="${sessionScope.user_name == null}">
						<li class="nav-item"><a class="nav-link"
						href="/sign/goLogin.do">LOGIN</a></li>
					</c:if>
					<c:if test="${sessionScope.user_name != null }">
						<li class="nav-item"><a class="nav-link"
						href="/sign/logout.do">LOGOUT</a></li>
					</c:if>
				</ul>

				<form class="d-flex mt-3" action="/search_result.do">
					<input class="form-control me-1" type="search" placeholder="Search" name="search_keyword"
						aria-label="Search" />
					<button class="btn btn-outline-success" type="submit">
						<i class="fas fa-search"></i>
					</button>
				</form>
			</div>
		</div>
	</nav>
</header>
<!-- <script -->
<!-- 	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" -->
<!-- 	integrity="sha384-kQtW33rZJAHjy8F/xC0k+O2eFgHgOnMm7e3f0sM/9f0zUYGPtFhQJhXdJiV6pG5a" -->
<!-- 	crossorigin="anonymous"></script> -->