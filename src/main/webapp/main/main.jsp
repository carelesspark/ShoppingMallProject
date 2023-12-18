<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAZZLE</title>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container">
		<div class="content">content</div>

		<!-- 이미지 슬라이드 시작 -->
		<div id="carouselExample" class="carousel slide mb-5">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="https://placehold.co/300x200" class="d-block w-100"
						alt="..." />
				</div>
				<div class="carousel-item">
					<img src="https://placehold.co/300x200" class="d-block w-100"
						alt="..." />
				</div>
				<div class="carousel-item">
					<img src="https://placehold.co/300x200" class="d-block w-100"
						alt="..." />
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExample" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExample" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>

		<!-- 상품 카드 시작 -->
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<img src="https://placehold.co/300x200"
						alt="Placeholder image with grey background and dimension 300x200" />
					<div class="card-body">
						<h5 class="card-title">이미지 없음</h5>
						<p class="card-text">
							상품명<br />상세 설명이 들어가는 곳입니다. 상세 설명이 들어가는 곳입니다. 상세 설명이 들어가는 곳입니다.
						</p>
						<button class="btn btn-buy">BUY NOW</button>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<img src="https://placehold.co/300x200"
						alt="Placeholder image with grey background and dimension 300x200" />
					<div class="card-body">
						<h5 class="card-title">이미지 없음</h5>
						<p class="card-text">
							상품명<br />상세 설명이 들어가는 곳입니다. 상세 설명이 들어가는 곳입니다. 상세 설명이 들어가는 곳입니다.
						</p>
						<button class="btn btn-buy">BUY NOW</button>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<img src="https://placehold.co/300x200"
						alt="Placeholder image with grey background and dimension 300x200" />
					<div class="card-body">
						<h5 class="card-title">이미지 없음</h5>
						<p class="card-text">
							상품명<br />상세 설명이 들어가는 곳입니다. 상세 설명이 들어가는 곳입니다. 상세 설명이 들어가는 곳입니다.
						</p>
						<button class="btn btn-buy">BUY NOW</button>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<img src="https://placehold.co/300x200"
						alt="Placeholder image with grey background and dimension 300x200" />
					<div class="card-body">
						<h5 class="card-title">이미지 없음</h5>
						<p class="card-text">
							상품명<br />상세 설명이 들어가는 곳입니다. 상세 설명이 들어가는 곳입니다. 상세 설명이 들어가는 곳입니다.
						</p>
						<button class="btn btn-buy">BUY NOW</button>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<img src="https://placehold.co/300x200"
						alt="Placeholder image with grey background and dimension 300x200" />
					<div class="card-body">
						<h5 class="card-title">이미지 없음</h5>
						<p class="card-text">
							상품명<br />상세 설명이 들어가는 곳입니다. 상세 설명이 들어가는 곳입니다. 상세 설명이 들어가는 곳입니다.
						</p>
						<button class="btn btn-buy">BUY NOW</button>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<img src="https://placehold.co/300x200"
						alt="Placeholder image with grey background and dimension 300x200" />
					<div class="card-body">
						<h5 class="card-title">이미지 없음</h5>
						<p class="card-text">
							상품명<br />상세 설명이 들어가는 곳입니다. 상세 설명이 들어가는 곳입니다. 상세 설명이 들어가는 곳입니다.
						</p>
						<button class="btn btn-buy">BUY NOW</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>

</html>