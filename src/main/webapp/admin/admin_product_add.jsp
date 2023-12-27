<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin_product_add.css?ver=1.0" />
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
					<div>1단계: 사진 및 기본 정보 입력</div>
					<div>
						<form action="" method="post" enctype="multipart/form-data">
							<div>
								<label for="cn">카테고리</label><select id="cn"
									onchange="changeSubCategories()">
									<option>top</option>
									<option>bottom</option>
									<option>outer</option>
									<option>shoes</option>
									<option>etc</option>
								</select>
							</div>
							<div>
								<label for="scn">세부 카테고리</label><select name="sub_category_num"
									id="scn">
									<option value="1">longSleeve</option>
									<option value="2">shortSleeve</option>
									<option value="3">hoodie</option>
									<option value="4">zip</option>
									<option value="5">collar</option>
								</select>
							</div>
							<div>
								<label>상품명</label><input type="text" name="product_name"
									placeholder="상품명">
							</div>
							<div>
								<label>메인 이미지</label> <input type="file" name=""
									accept="image/*">
							</div>
							<div>
								<label>썸네일</label> <input type="file" name="" accept="image/*">
							</div>
							<div>
								<label for="product_info">상품 정보</label>
								<textarea name="product_info" placeholder="상품 정보" id="pi"></textarea>
							</div>
							<div>
								<label>상품 가격</label><input type="number" placeholder="상품 가격">
							</div>
							<div>
								<input type="submit" value="전송" />
							</div>
						</form>
					</div>
					<div>2단계: 색상 입력</div>
					<div></div>

					<div>3단계: 사이즈 및 재고 입력</div>
					<div></div>

				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>

	<script
		src="https://cdn.ckeditor.com/ckeditor5/40.2.0/classic/ckeditor.js"></script>
	<script>
		document.addEventListener('DOMContentLoaded', ()=>{
			ClassicEditor.create(document.querySelector("#pi"),{
				ckfinder:{
					uploadUrl: '/file/putInfoImage.do',
				}
			});
		});
	
		function changeSubCategories() {
			var categorySelect = document.getElementById('cn');
			var subcategorySelect = document.getElementById('scn');

			// Clear existing options
			subcategorySelect.innerHTML = '';

			// Get the selected category
			var selectedCategory = categorySelect.value;

			// Populate subcategories based on the selected category
			if (selectedCategory === 'top') {
				addOption(subcategorySelect, '1', 'longSleeve');
				addOption(subcategorySelect, '2', 'shortSleeve');
				addOption(subcategorySelect, '3', 'hoodie');
				addOption(subcategorySelect, '4', 'zip');
				addOption(subcategorySelect, '5', 'collar');
			} else if (selectedCategory === 'bottom') {
				addOption(subcategorySelect, '6', 'denim');
				addOption(subcategorySelect, '7', 'training');
				addOption(subcategorySelect, '8', 'wide');
				addOption(subcategorySelect, '9', 'short');
				addOption(subcategorySelect, '10', 'cotton');
			} else if (selectedCategory === 'outer') {
				addOption(subcategorySelect, '11', 'jackets');
				addOption(subcategorySelect, '12', 'coats');
				addOption(subcategorySelect, '13', 'vests');
				addOption(subcategorySelect, '14', 'parkas');
				addOption(subcategorySelect, '15', 'blazers');
			} else if (selectedCategory === 'shoes') {
				addOption(subcategorySelect, '16', 'sneakers');
				addOption(subcategorySelect, '17', 'boots');
				addOption(subcategorySelect, '18', 'sandals');
				addOption(subcategorySelect, '19', 'Slippers');
				addOption(subcategorySelect, '20', 'loafers');
			} else if (selectedCategory === 'etc') {
				addOption(subcategorySelect, '21', 'hats');
				addOption(subcategorySelect, '22', 'belts');
				addOption(subcategorySelect, '23', 'Sunglasses');
				addOption(subcategorySelect, '24', 'gloves');
				addOption(subcategorySelect, '25', 'accessories');
			}
		}

		function addOption(selectElement, value, text) {
			var option = document.createElement('option');
			option.value = value;
			option.text = text;
			selectElement.add(option);
		}
	</script>
</body>
</html>