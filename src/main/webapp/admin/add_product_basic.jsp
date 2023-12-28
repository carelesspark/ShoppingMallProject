<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/add_product_basic.css?v=1" />
<title>add product</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<%@ include file="./admin_card.jsp"%>
		<div id="mc">
			<%@ include file="./admin_side.jsp"%>
			<main>
				<div id="md">
					<div id="mt">
						<div id="mtd">상품 추가 2/3단계 - 기본 설정</div>
					</div>
					<div id="formDiv">
						<form name="productForm" action="/admin/addProductBasicInfo.do"
							method="post" enctype="multipart/form-data"
							onsubmit="validateForm(this, event)" id="form">
							<div>
								<input type="hidden" name="product_num" value="${product_num }">
							</div>
							<div id="iDiv1">
								<label for="ipn">상품명</label><input type="text"
									name="product_name" value="" placeholder="" id="ipn">
							</div>
							<div id="iDiv2">
								<label for="ipi">상품 정보</label>
								<textarea name="product_info" placeholder="" id="ipi"></textarea>
							</div>
							<div id="iDiv3">
								<label for="ipp">상품 가격</label><input type="number"
									name="product_price" value="" placeholder="" id="ipp">
							</div>
							<div id="iDiv4">
								<label for="imi">메인 이미지</label><input type="file"
									multiple="multiple" name="mainImage" accept=".jpg, .jpeg, .png"
									id="imi">
							</div>
							<div id="iDiv5">
								<label for="itni">썸네일</label><input type="file"
									name="thumbnailImage" accept=".jpg, .jpeg, .png" id="itni">
							</div>
							<div id="iDiv6">
								<button type="submit">색상 설정 이동</button>
							</div>
						</form>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>

	<script
		src="https://cdn.ckeditor.com/ckeditor5/40.2.0/classic/ckeditor.js"></script>
	<script type="text/javascript">
		ClassicEditor.create(document.querySelector("#ipi"));
	</script>
</body>
</html>