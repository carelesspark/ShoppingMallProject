<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/body.css" type="text/css" />
<link rel="stylesheet"
	href="../resources/css/user/user_order_tracking.css" type="text/css" />
<title>user order tracking</title>
</head>
<body>
	<!--include header-->
	<%@ include file="../header.jsp"%>

	<div id="m">
		<!--include user_card-->
		<%@ include file="./user_card.jsp"%>
		<div id="mc">
			<!--include user_menu-->
			<%@ include file="./user_menu.jsp"%>
			<main></main>
		</div>
	</div>

	<!--include footer-->
	<%@ include file="../footer.jsp"%>
</body>

</html>