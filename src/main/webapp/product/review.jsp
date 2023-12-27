<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/product/review.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
<%-- 					<input value="${user_num }" name="user_num" type="hidden"> --%>
	<div class="container py-5">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="content-box">
					<form action="/submit_review.do"  method="post" enctype="multipart/form-data">
						<input type="hidden" name="product_code" value="${product_code}">
						<div class="mb-3">
							<label class="form-label">평점을 남겨주세요</label>
							<div id="ratingStars">
								<select style=" color: #FFD700;" name="review_ratings">
			                   		<option value="1">★</option>
			                   		<option value="2">★★</option>
			                   		<option value="3">★★★</option>
			                   		<option value="4">★★★★</option>
			                   		<option value="5">★★★★★</option>
			                   	</select>
							</div>
						</div>
						<div class="mb-3">
							<label class="form-label">사진 첨부</label>
							<div class="row">
								<div class="col-4">
									<div class="image-placeholder" id="imagePreview">
										<i class="far fa-image"></i>
									</div>
								</div>
								<div class="col-8">
									<input type="file" accept="image/*" id="imageInput" name="review_img2"
										style="display: none" onchange="previewImage()" />
									<button type="button" class="btn btn-primary"
										onclick="document.getElementById('imageInput').click();">
										이미지 선택</button>
								</div>
							</div>
						</div>
						<div class="mb-3">
							<label for="contentTextarea" class="form-label">내용</label>
							<textarea class="form-control" id="contentTextarea" rows="5" name="review_content"
								placeholder="리뷰 내용을 작성해주세요"></textarea>
						</div>
						<div class="checkbox-group">
							<input class="form-check-input" type="checkbox" value=""
								id="agreeCheck1" /> <label
								class="form-check-label" for="agreeCheck1">전체
								동의</label>
						</div>
						<div class="checkbox-group">
							<input class="form-check-input" type="checkbox" value=""
								id="agreeCheck2" /> <label
								class="form-check-label" for="agreeCheck2">정보제공에
								관한 DAZZLE 정책 동의 (필수)</label>
						</div>
						<div class="checkbox-group">
							<input class="form-check-input" type="checkbox" value=""
								id="agreeCheck3" /> <label
								class="form-check-label" for="agreeCheck3">보내는
								내용이 사실과 다를 경우 불이익을 받을 수 있음을 이해합니다. (필수)</label>
						</div>
						<button type="submit" class="btn btn-submit mt-3"
							onclick="checkAgreement()">리뷰 등록</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
	<script src="../resources/js/product/review.js"></script>
</body>


</html>