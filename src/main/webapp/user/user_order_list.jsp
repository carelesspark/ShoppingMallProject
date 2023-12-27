<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user_order_list.css" />
<title>user order list</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div id="m">
		<%@ include file="./user_card.jsp"%>

		<div id="mc">
			<%@ include file="./user_menu.jsp"%>
			<main>
				<div>주문 정보 기입 - 테이블 형식</div>
			</main>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>