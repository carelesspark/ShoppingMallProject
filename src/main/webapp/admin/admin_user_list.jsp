<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin_user_list.css?ver=1.0" />
<title>admin user list</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<%@ include file="./admin_card.jsp"%>
		<div id="mc">
			<%@ include file="./admin_side.jsp"%>
			<main>
				<div id="md">
					<div id="mh">
						<div>번호</div>
						<div>이름</div>
						<div>랭크</div>
						<div>로그인 타입</div>
						<div>블랙리스트</div>
						<div>가입일</div>
						<div>탈퇴일</div>
					</div>
					<c:forEach var="list" items="${userList}">
						<div id="ml">
							<div>${list.list_num}</div>
							<div>${list.user_name}</div>
							<div>${list.user_rank}</div>
							<div>${list.login_type}</div>
							<c:choose>
								<c:when test="${list.is_black_list eq 0}">
									<div>X</div>
								</c:when>
								<c:otherwise>
									<div>O</div>
								</c:otherwise>
							</c:choose>
							<div>${list.user_join_date}</div>
							<c:choose>
								<c:when test="${list.user_delete_date eq null}">
									<div>-</div>
								</c:when>
								<c:otherwise>
									<div>${list.user_delete_date}</div>
								</c:otherwise>
							</c:choose>
						</div>
					</c:forEach>
					<div>${userList[0].page_num}페이지</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>