<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/product/productList.css">
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div class="container mt-5">
		<div class="row">
			<div class="col-md-2">
				<ul class="top-menu">
					<li><a href="#">TOP</a></li>
					<li><a href="#">후드티</a></li>
					<li><a href="#">긴소매 티</a></li>
					<li><a href="#">반소매 티</a></li>
					<li><a href="#">니트/스웨터</a></li>
					<li><a href="#">셔츠/블라우스</a></li>
					<li><a href="#">기타 상의</a></li>
				</ul>
			</div>
			<div class="col-md-10">
				<div class="row">
					<!-- 상품 -->
					<div class="col-md-3">
						<a href="#">
							<div class="card">
								<img alt="Placeholder image of a real estate property"
									class="card-img-top" height="200"
									src="https://placehold.co/300x200" width="300" />
								<div class="card-body">
									<h5 class="card-title">상품 이름</h5>
									<p class="card-text">가격 000,000,000</p>
									<p class="card-text">
										<i class="far fa-heart"> 455</i>
									</p>
								</div>
							</div>
						</a>
					</div>
					<div class="col-md-3">
						<a href="#">
							<div class="card">
								<img alt="Placeholder image of a real estate property"
									class="card-img-top" height="200"
									src="https://placehold.co/300x200" width="300" />
								<div class="card-body">
									<h5 class="card-title">상품 이름</h5>
									<p class="card-text">가격 000,000,000</p>
									<p class="card-text">
										<i class="far fa-heart"> 455</i>
									</p>
								</div>
							</div>
						</a>
					</div>
					<div class="col-md-3">
						<a href="#">
							<div class="card">
								<img alt="Placeholder image of a real estate property"
									class="card-img-top" height="200"
									src="https://placehold.co/300x200" width="300" />
								<div class="card-body">
									<h5 class="card-title">상품 이름</h5>
									<p class="card-text">가격 000,000,000</p>
									<p class="card-text">
										<i class="far fa-heart"> 455</i>
									</p>
								</div>
							</div>
						</a>
					</div>
					<div class="col-md-3">
						<a href="#">
							<div class="card">
								<img alt="Placeholder image of a real estate property"
									class="card-img-top" height="200"
									src="https://placehold.co/300x200" width="300" />
								<div class="card-body">
									<h5 class="card-title">상품 이름</h5>
									<p class="card-text">가격 000,000,000</p>
									<p class="card-text">
										<i class="far fa-heart"> 455</i>
									</p>
								</div>
							</div>
						</a>
					</div>
					<div class="col-md-3">
						<a href="#">
							<div class="card">
								<img alt="Placeholder image of a real estate property"
									class="card-img-top" height="200"
									src="https://placehold.co/300x200" width="300" />
								<div class="card-body">
									<h5 class="card-title">상품 이름</h5>
									<p class="card-text">가격 000,000,000</p>
									<p class="card-text">
										<i class="far fa-heart"> 455</i>
									</p>
								</div>
							</div>
						</a>
					</div>
					<div class="col-md-3">
						<a href="#">
							<div class="card">
								<img alt="Placeholder image of a real estate property"
									class="card-img-top" height="200"
									src="https://placehold.co/300x200" width="300" />
								<div class="card-body">
									<h5 class="card-title">상품 이름</h5>
									<p class="card-text">가격 000,000,000</p>
									<p class="card-text">
										<i class="far fa-heart"> 455</i>
									</p>
								</div>
							</div>
						</a>
					</div>
					<div class="col-md-3">
						<a href="#">
							<div class="card">
								<img alt="Placeholder image of a real estate property"
									class="card-img-top" height="200"
									src="https://placehold.co/300x200" width="300" />
								<div class="card-body">
									<h5 class="card-title">상품 이름</h5>
									<p class="card-text">가격 000,000,000</p>
									<p class="card-text">
										<i class="far fa-heart"> 455</i>
									</p>
								</div>
							</div>
						</a>
					</div>
					<div class="col-md-3">
						<a href="#">
							<div class="card">
								<img alt="Placeholder image of a real estate property"
									class="card-img-top" height="200"
									src="https://placehold.co/300x200" width="300" />
								<div class="card-body">
									<h5 class="card-title">상품 이름</h5>
									<p class="card-text">가격 000,000,000</p>
									<p class="card-text">
										<i class="far fa-heart"> 455</i>
									</p>
								</div>
							</div>
						</a>
					</div>

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