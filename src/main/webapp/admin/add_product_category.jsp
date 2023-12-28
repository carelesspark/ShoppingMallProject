<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/add_product_category.css?v=1.2" />
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
						<div id="mtd">상품 추가 1/3단계 - 카테고리 설정</div>
					</div>
					<div id="formDiv">
						<form action="/admin/addProduct.do"
							onsubmit="validateForm(this, event)" id="form">
							<div id="iDiv1">
								<label for="cn">카테고리</label> <select id="cn"
									onchange="changeSubCategories()">
									<option>top</option>
									<option>bottom</option>
									<option>outer</option>
									<option>shoes</option>
									<option>etc</option>
								</select>
							</div>
							<div id="iDiv2">
								<label for="scn">세부 카테고리</label><select name="sub_category_num"
									id="scn">
									<option value="1">longSleeve</option>
									<option value="2">shortSleeve</option>
									<option value="3">hoodie</option>
									<option value="4">zip</option>
									<option value="5">collar</option>
								</select>
							</div>
							<div id="iDiv3">
								<button type="submit">기본 설정 이동</button>
							</div>
						</form>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>

	<script type="text/javascript">
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