<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/add_product_remain.css?v=1.2" />
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
						<div id="mtd">상품 추가 3/3단계 - 기타 설정</div>
					</div>
					<div id="formDiv">
						<form action="/admin/addProductRemainInfo.do"
							onsubmit="validateForm(this, event)" id="form">
							<div>
								<input type="hidden" name="product_num" value="${product_num}">
							</div>
							<div id="cDivName">색상 선택</div>
							<div id="colorList">
								<div>
									<input type="checkbox" name="color_name[]" value="Black"><label>Black</label>
								</div>
								<div>
									<input type="checkbox" name="color_name[]" value="White"><label>White</label>
								</div>
								<div>
									<input type="checkbox" name="color_name[]" value="khaki"><label>khaki</label>
								</div>
								<div>
									<input type="checkbox" name="color_name[]" value="Ivory"><label>Ivory</label>
								</div>
								<div>
									<input type="checkbox" name="color_name[]" value="Pink"><label>Pink</label>
								</div>
								<div>
									<input type="checkbox" name="color_name[]" value="Red"><label>Red</label>
								</div>
								<div>
									<input type="checkbox" name="color_name[]" value="Orange"><label>Orange</label>
								</div>
								<div>
									<input type="checkbox" name="color_name[]" value="Yellow"><label>Yellow</label>
								</div>
								<div>
									<input type="checkbox" name="color_name[]" value="Green"><label>Green</label>
								</div>
								<div>
									<input type="checkbox" name="color_name[]" value="Blue"><label>Blue</label>
								</div>
								<div>
									<input type="checkbox" name="color_name[]" value="Purple"><label>Purple</label>
								</div>
							</div>
							<div id="addColorBtnDiv">
								<button type="button" onclick="addColor()">색상 추가</button>
							</div>
							<div id="sDivName">사이즈 선택</div>
							<div id="sizeList">
								<div>
									<input type="checkbox" name="size_name[]" value="XS"><label>XS</label>
								</div>
								<div>
									<input type="checkbox" name="size_name[]" value="S"><label>S</label>
								</div>
								<div>
									<input type="checkbox" name="size_name[]" value="M"><label>M</label>
								</div>
								<div>
									<input type="checkbox" name="size_name[]" value="L"><label>L</label>
								</div>
								<div>
									<input type="checkbox" name="size_name[]" value="XL"><label>XL</label>
								</div>
							</div>
							<div id="addSizeBtnDiv">
								<button type="button" onclick="addSize()">사이즈 추가</button>
							</div>
							<div id="stockDiv">
								<label> 재고 설정 </label for="ipstock"><input type="number" name="product_stock"
									value="" id="ipstock">
							</div>
							<div id="subBtnDiv">
								<button type="submit">결정</button>
							</div>
						</form>
					</div>
					<div></div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>

	<script type="text/javascript">
		function addColor() {
			var colorInput = prompt('추가할 색상을 입력하세요');

			if (!colorInput) {
				// 사용자가 입력을 취소하거나 공백을 입력한 경우 추가하지 않음
				return;
			}

			// 추가할 색상을 표시할 div를 가져오기
			var colorListDiv = document.getElementById('colorList');

			// 새로운 checkbox 요소 생성
			var newCheckbox = document.createElement('input');
			newCheckbox.type = 'checkbox';
			newCheckbox.name = 'color_name[]';
			newCheckbox.value = colorInput;
			// 레이블 요소 생성
			var label = document.createElement('label');
			label.innerHTML = colorInput;

			// 새로운 checkbox와 레이블을 추가할 div 생성
			var newDiv = document.createElement('div');

			// 생성한 checkbox와 레이블을 div에 추가
			newDiv.appendChild(newCheckbox);
			newDiv.appendChild(label);

			// div를 colorListDiv에 추가
			colorListDiv.appendChild(newDiv);
		}

		function addSize() {
			var sizeInput = prompt('추가할 색상을 입력하세요');

			if (!sizeInput) {
				// 사용자가 입력을 취소하거나 공백을 입력한 경우 추가하지 않음
				return;
			}

			// 추가할 색상을 표시할 div를 가져오기
			var sizeListDiv = document.getElementById('sizeList');

			// 새로운 checkbox 요소 생성
			var newCheckbox = document.createElement('input');
			newCheckbox.type = 'checkbox';
			newCheckbox.name = 'size_name[]';
			newCheckbox.value = sizeInput;
			// 레이블 요소 생성
			var label = document.createElement('label');
			label.innerHTML = sizeInput;

			// 새로운 checkbox와 레이블을 추가할 div 생성
			var newDiv = document.createElement('div');

			// 생성한 checkbox와 레이블을 div에 추가
			newDiv.appendChild(newCheckbox);
			newDiv.appendChild(label);

			// div를 colorListDiv에 추가
			sizeListDiv.appendChild(newDiv);
		}
	</script>
</body>
</html>