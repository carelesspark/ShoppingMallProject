<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAZZLE</title>
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" />

<body>
	<%@ include file="../header.jsp"%>
	<div class="container">
		<div class="content">content</div>

		<!-- 이미지 슬라이드 시작 -->
		<div id="carouselExample" class="carousel slide mb-5">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="${pageContext.request.contextPath}/resources/image/main/main1.png" class="d-block w-100"
						alt="..." />
				</div>
				<div class="carousel-item">
					<img src="${pageContext.request.contextPath}/resources/image/main/main4.png" class="d-block w-100"
						alt="..." />
				</div>
				<div class="carousel-item">
					<img src="${pageContext.request.contextPath}/resources/image/main/main3.png" class="d-block w-100"
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
	</div>
	<%@ include file="../footer.jsp"%>
</body>

</html>