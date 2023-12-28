<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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


	<div class="container my-5">
		<div class="row">
			<div class="col-md-6">
				<div class="carousel slide" data-bs-ride="carousel"
					id="productCarousel">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img alt="Placeholder image for product" class="d-block w-100"
								height="600" width="600"
								src="${pageContext.request.contextPath}/resources/image/product/${img.product_num}/${img.img_name}" />
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
				height="100%" src="https://placehold.co/300x200" width="100%" />
		</div>
		<table class="table">
			<tbody>
				<tr>
					<th>제품 명</th>
					<td class="score">${info.product_name }</td>
				</tr>
				<tr>
					<th>색상 및 사이즈</th>
					<td class="score"><c:forEach items="${colors }" var="c">
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
				<div class="review-qna-title">리뷰 (${count.count})</div>
				<div class="review-qna-date"></div>
			</div>
			<!-- Repeat for each review item -->
			<c:forEach var="review" items="${review}">
				<div class="review-qna-item">
					<div>
						<div class="review-qna-rating">
							<c:forEach var="i" begin="1" end="${review.review_ratings}">
								<span style="color: #FFD700;">★</span>
							</c:forEach>
						</div>
						<c:set var="maskedId" value="${fn:substring(review.id, 0, 2)}" />
						<c:forEach begin="1" end="${fn:length(review.id)-2}" var="i">
							<c:set var="maskedId" value="${maskedId}*" />
						</c:forEach>
						<div class="review-qna-rating">${maskedId}</div>

						<div class="review-qna-author">사이즈 : ${review.size_name} 색상:
							${review.color_name}</div>
						<div class="review-qna-content">${review.review_content}</div>
						<div class="review-qna-date">${review.review_date}</div>
					</div>
					<div>
						<c:if test="${not empty review.review_img}">
							<img height="200px" alt="${img_name}"
								src="${pageContext.request.contextPath}/resources/image/review/${review.product_code}/${review.review_img}">
						</c:if>
					</div>
				</div>
			</c:forEach>

			<div id="pageButtons" class="text-center mt-3">
				<c:forEach begin="1" end="${totalPages}" varStatus="loop">
					<c:url value="" var="url">
						<c:param name="curr_page" value="${loop.index}" />
						<c:param name="product_num" value="${info.product_num }" />
					</c:url>
					<a href="${url}"
						class="btn ${loop.index == curr_page ? 'active' : ''}">
						${loop.index} </a>
				</c:forEach>
			</div>
			<br>

		</div>

		<div class="review-qna-container" id="product-inquiry">
			<div class="review-qna-header">
				<div class="review-qna-title">상품문의
					(${inquiryCount.total_inquiry})</div>
				<div class="review-qna-date">
					<a href="/inquiry.do?product_num=${info.product_num }">문의 쓰기</a>
				</div>
			</div>
			<!-- Repeat for each review item -->
			<c:choose>
				<c:when test="${not empty inquiryList}">
					<c:forEach items="${inquiryList}" var="inquiryList">
						<div class="review-qna-item">
							<div class="review-qna-rating">*******</div>
							<div class="review-qna-author">문의사항 :
								${inquiryList.inquiry_title}</div>
							<div class="review-qna-content">${inquiryList.inquiry_content}</div>
							<div class="review-qna-date">${inquiryList.inquiry_date}</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="review-qna-item">
						<div class="review-qna-content">작성된 문의 내역이 없습니다.</div>
					</div>
				</c:otherwise>
			</c:choose>
			<!-- ... other review items ... -->
			<div id="pageButtons" class="text-center mt-3">
				<c:forEach begin="1" end="${totalInquiryPages}" varStatus="loop">
					<c:url value="" var="url">
						<c:param name="curr_inq_page" value="${loop.index}" />
						<c:param name="product_num" value="${info.product_num }" />
					</c:url>
					<a href="${url}"
						class="btn ${loop.index == curr_inq_page ? 'active' : ''}">
						${loop.index} </a>
				</c:forEach>
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
                if(data == "success"){
                    var userResponse = confirm("장바구니에 추가되었습니다. 장바구니 페이지로 이동하시겠습니까?");
                    if (userResponse) {
                        window.location.href = "/cart.do";                 
                    } else {
                        window.location.reload();
                    }
                	} else{
                		 var userResponse = confirm("동일한 상품이 장바구니에 존재합니다.");
                     
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
                dataType: "text",
                success: function (data) {
                	
                	if (data === "error") {
                		alert("로그인 후 이용 해주세요.")
                		window.location.href = "/sign/login.jsp";
                	} else {
                		window.location.href = "/productOrder.do?product_code=" + parseInt(data) + "&amount=" + quantity;
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