<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user_change_info.css" />

<title>user change info</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<%@ include file="./user_card.jsp"%>
		<div id="mc">
			<%@ include file="./user_side.jsp"%>
			<main>
				개인정보 변경 폼
				<div id="md"></div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>

	<script type="text/javascript">
		var rank = '${user_rank}';
		var rankBadge = document.getElementById('cc-rb');

		if ('${user_rank}' === 'BRONZE') {
			rankBadge.innerText = 'B';
			rankBadge.style.color = '#B87333';
		} else if (rank === 'SILVER') {
			rankBadge.innerText = 'S';
			rankBadge.style.color = '#CCCCCC';
		} else if (rank === 'GOLD') {
			rankBadge.innerText = 'G';
			rankBadge.style.color = '#FFD700';
		} else if (rank === 'DIAMOND') {
			rankBadge.innerText = 'D';
			rankBadge.style.color = '#EEEEEE';
		} else if (rank === 'VIP') {
			rankBadge.innerText = 'V';
			rankBadge.style.color = '#8A2BE2';
		} else if (rank === 'ADMIN') {
			rankBadge.innerText = 'A';
			rankBadge.style.color = '#DD2476';
		}
	</script>
</body>
</html>