<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/product/product.css">
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div class="container my-5">
		<div class="row">
			<div class="col-md-6">
				<div class="carousel slide" data-bs-ride="carousel"
					id="productCarousel">	
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img alt="Placeholder image for product" class="d-block w-100"
								height="600" src="https://placehold.co/600x600" width="600" />
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="product-info">
					<h2>상품이름</h2>
					<p class="price">가격 000,000</p>
					<p class="discount">000p (1%) 적립</p>
					<p class="delivery-info">오늘출발 상품 오전 2시 이전 주문시 오늘 바로 출발</p>
					<hr />
					<div class="options">
						<select aria-label="Default select example" class="form-select">
							<option selected="">옵션 1</option>
							<option value="1">옵션 2</option>
							<option value="2">옵션 3</option>
							<option value="3">옵션 4</option>
						</select> <select aria-label="Default select example" class="form-select">
							<option selected="">옵션 1</option>
							<option value="1">옵션 2</option>
							<option value="2">옵션 3</option>
							<option value="3">옵션 4</option>
						</select>
					</div>
					<hr />
					<div class="quantity">
						<button class="btn btn-outline-secondary" type="button"
							onclick="decrementQuantity()">-</button>
						<input id="quantityInput" type="text" value="1" />
						<button class="btn btn-outline-secondary" type="button"
							onclick="incrementQuantity()">+</button>
					</div>
					<div class="buttons">
						<button class="btn btn-outline-secondary">장바구니 담기</button>
						<button class="btn btn-outline-secondary">바로 구매하기</button>
					</div>
				</div>
			</div>
		</div>
		<div class="product-tabs mt-3">
			<div class="product-tab fs-4">
				<a href="">상품상세</a>
			</div>
			<div class="product-tab fs-4">
				<a href="">상품리뷰</a>
			</div>
			<div class="product-tab fs-4">
				<a href="">상품문의</a>
			</div>
		</div>
		<div class="email-icon" id="product-detail">
			<img alt="Placeholder image for product" class="d-block w-100 mb-5"
				height="100%" src="https://placehold.co/600x600" width="100%" />
		</div>
		<table class="table">
			<tbody>
				<tr>
					<th>제품 소재</th>
					<td class="score">●●●●</td>
				</tr>
				<tr>
					<th>색상</th>
					<td class="score">●●●●</td>
				</tr>
				<tr>
					<th>치수</th>
					<td class="score">●●●●</td>
				</tr>
				<tr>
					<th>제조자</th>
					<td class="score">●●●●</td>
				</tr>
				<tr>
					<th>제조국</th>
					<td class="score">●●●●</td>
				</tr>
				<tr>
					<th>세탁방법</th>
					<td class="score">●●●●</td>
				</tr>
				<tr>
					<th>제조연월</th>
					<td class="score">●●●●</td>
				</tr>
			</tbody>
		</table>

		<div class="review-qna-container" id="product-review">
			<div class="review-qna-header">
				<div class="review-qna-title">리뷰 (454)</div>
				<div class="review-qna-date">
					<a href="">리뷰 쓰기</a>
				</div>
			</div>
			<!-- Repeat for each review item -->
			<div class="review-qna-item">
				<div class="review-qna-rating">★★★★★</div>
				<div class="review-qna-rating">abc***</div>
				<div class="review-qna-author">사이즈 : m</div>
				<div class="review-qna-author">키 : 160cm</div>
				<div class="review-qna-author">몸무게 : 44kg</div>
				<div class="review-qna-content">택배가 어쩌구 저쩌구 상품이 어쩌구 저쩌구 다이어트
					중인 저에게 딱 맞습니다</div>
				<div class="review-qna-date">2023.12.05</div>
			</div>
			<!-- ... other review items ... -->
			<div class="review-qna-pagination">
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

		<div class="review-qna-container" id="product-inquiry">
			<div class="review-qna-header">
				<div class="review-qna-title">상품문의 (454)</div>
				<div class="review-qna-date">
					<a href="">문의 쓰기</a>
				</div>
			</div>
			<!-- Repeat for each review item -->
			<div class="review-qna-item">
				<div class="review-qna-rating">abc***</div>
				<div class="review-qna-author">@@문의</div>
				<div class="review-qna-content">택배가 어쩌구 저쩌구 상품이 어쩌구 저쩌구 다이어트
					중인 저에게 딱 맞습니다</div>
				<div class="review-qna-date">2023.12.05</div>
			</div>
			<!-- ... other review items ... -->
			<div class="review-qna-pagination">
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
	<script crossorigin="anonymous"
		integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5+z0I5t9z5lFf5r5l5u5z5F5w5f5Oj04meM1a7xj"
		src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script>
	<script crossorigin="anonymous"
		integrity="sha384-kQtW33rZJAHjy8F/xzRnt+8DJSsIh2F5r2M5anjzL5F5K/3NS72V8h6Iq5a7LxN8"
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="../resources/js/product/product.js"></script>
	<%@ include file="../footer.jsp"%>
</body>
</html>