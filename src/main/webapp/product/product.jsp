<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dazzle.shop.model.product.ProductSizeVO"%>
<%@ page import="com.dazzle.shop.model.product.ProductColorVO"%>
<%@ page import="com.dazzle.shop.model.product.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/product/product.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<c:set value="${product_img }" var="img"></c:set>
	<c:set value="${product_info }" var="info"></c:set>
	<c:set value="${info.colors}" var="colors"></c:set>
<%-- 	<c:set value="${colors.sizes }" var="size"></c:set> --%>



	<div class="container my-5">
		<div class="row">
			<div class="col-md-6">
				<div class="carousel slide" data-bs-ride="carousel"
					id="productCarousel">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img alt="Placeholder image for product" class="d-block w-100"
								height="600" src="${img.main_img }" width="600" />
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="product-info">
					<h2>${info.product_name }</h2>
					<p class="price">${info.product_price }원</p>
					<p class="discount">${(info.product_price * 0.01).intValue()}p
						(1%) 적립</p>
					<p class="delivery-info">오늘출발 상품 오전 2시 이전 주문시 오늘 바로 출발</p>
					<hr />
					<div class="options">
						<select aria-label="Default select example" class="form-select"
							id="colorSelect" onchange="updateSizeOptions()">
							<option selected>color</option>
							<c:forEach items="${info.colors }" var="c">
								<option value="${c.color_num }">${c.color_name }</option>
							</c:forEach>
						</select> <select aria-label="Default select example" class="form-select"
							id="sizeSelect">
							<option selected>size</option>
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
						<button class="btn btn-outline-secondary" onclick="addToCart()">장바구니
							담기</button>
						<button class="btn btn-outline-secondary" onclick="buyNow()">바로
							구매하기</button>
					</div>
				</div>
			</div>
		</div>
		<div class="product-tabs mt-3">
			<div class="product-tab fs-4">
				<a href="">상품상세</a>
			</div>
			<div class="product-tab fs-4">
				<a href="review.do">상품리뷰</a>
			</div>
			<div class="product-tab fs-4">
				<a href="inquiry.do">상품문의</a>
			</div>
		</div>
		<div class="email-icon" id="product-detail">
			<img alt="Placeholder image for product" class="d-block w-100 mb-5"
				height="100%" src="${img.sub_img }" width="100%" />
		</div>
		<table class="table">
			<tbody>
				<tr>
					<th>제품 명</th>
					<td class="score">${info.product_name }</td>
				</tr>
				<tr>
					<th>색상 및 사이즈</th>
					<td class="score">
					<c:forEach items="${colors }" var="c">
							${c.color_name }
							사이즈 : 
							<c:forEach items="${c.sizes}" var="size">
							    ${size.size_name}
							</c:forEach>
							<br>
						</c:forEach></td>
				</tr>
				
				<tr>
					<th>상품 등록 일</th>
					<td class="score">${info.product_date }</td>
				</tr>
			</tbody>
		</table>

		<div class="review-qna-container" id="product-review">
			<div class="review-qna-header">
				<div class="review-qna-title">리뷰 (454)</div>
				<div class="review-qna-date">
					<a href="/review.do?product_num=${info.product_num }">리뷰 쓰기</a>
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
					<a href="/inquiry.do">문의 쓰기</a>
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
	<!-- 	<script crossorigin="anonymous" -->
	<!-- 		integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5+z0I5t9z5lFf5r5l5u5z5F5w5f5Oj04meM1a7xj" -->
	<!-- 		src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script> -->
	<!-- 	<script crossorigin="anonymous" -->
	<!-- 		integrity="sha384-kQtW33rZJAHjy8F/xzRnt+8DJSsIh2F5r2M5anjzL5F5K/3NS72V8h6Iq5a7LxN8" -->
	<!-- 		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script> -->
	<script src="../resources/js/product/product.js"></script>
	<script>
        function updateSizeOptions() {
            var selectedColor = document.getElementById("colorSelect").value;
            var sizes = colorSizeMapping[selectedColor]; // 사전에 정의된 색상별 사이즈 매핑

            if (sizes != null) {
                var sizeSelect = document.getElementById("sizeSelect");
                sizeSelect.innerHTML = '<option selected="">size</option>';
            }

            sizes.forEach(function(size) {
                var option = document.createElement("option");
                option.value = size.size_num;
                option.text = size.size_name;
                sizeSelect.appendChild(option);
            });
        }

        var colorSizeMapping = {}; // 색상별 사이즈 매핑을 저장할 객체
        window.onload = function() {
            // 색상별 사이즈 매핑 초기화
            <%ProductVO product = (ProductVO) request.getAttribute("product_info");%>
            <%for (ProductColorVO color : product.getColors()) {%>
                colorSizeMapping["<%=color.getColor_num()%>"] = [
                    <%for (ProductSizeVO size : color.getSizes()) {%>
                        { size_num: <%=size.getSize_num()%>, size_name: "<%=size.getSize_name()%>" },
                    <%}%>
                ];
            <%}%>
        };
        
        
        function addToCart() {
            var sizeSelect = document.getElementById("sizeSelect");
            var selectedSize = sizeSelect.options[sizeSelect.selectedIndex].value;

            var quantityInput = document.getElementById("quantityInput");
            var quantity = quantityInput.value;
            
            $.ajax({
                type: "POST",
                url: "/add_to_cart.do",
                data: {
                    size_num: selectedSize,
                    quantity: quantity
                },
                dataType: "text",
                success: function (data) {
                	
                    var userResponse = confirm("장바구니에 추가되었습니다. 장바구니 페이지로 이동하시겠습니까?");
                    if (userResponse) {
                        window.location.href = "/cart.do";                 
                    } else {
                        window.location.reload();
                    }

                },
                error: function (error) {
                	console.error("Error response: ", error);
                	
                }
            });
        }

        function buyNow() {
            var sizeSelect = document.getElementById("sizeSelect");
            var selectedSize = sizeSelect.options[sizeSelect.selectedIndex].value;

            var quantityInput = document.getElementById("quantityInput");
            var quantity = quantityInput.value;
            
            $.ajax({
                type: "POST",
                url: "/buy_now.do", 
                data: {
                    size_num: selectedSize,
                    quantity: quantity
                },
                success: function (data) {
                	
                	if (data === "success") {
                		window.location.href = "/productOrder.do?product_code=" + selectedSize + "&amount=" + quantity;
                	} else {
                		alert("로그인 후 이용 해주세요.")
                		window.location.href = "/sign/login.jsp";
                	}
                },
                error: function (error) {
                	console.error("Error response: ", error);
                }
            });
        }
    
    </script>
	<%@ include file="../footer.jsp"%>
</body>
</html>