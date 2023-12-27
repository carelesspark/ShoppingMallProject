<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
					<div id="rowNum">
						<div>현재 페이지 표시 개수: ${itemsPerPage}</div>
						<div id="rNumChange">
							<div>변경:</div>
							<div>
								<button type="button"
									onclick="window.location.href='/admin/changeUserList.do?itemsPerPage=20&currentPage=1'">20</button>
							</div>
							<div>
								<button type="button"
									onclick="window.location.href='/admin/changeUserList.do?itemsPerPage=50&currentPage=1'">50</button>
							</div>
							<div>
								<button type="button"
									onclick="window.location.href='/admin/changeUserList.do?itemsPerPage=100&currentPage=1'">100</button>
							</div>
						</div>
					</div>
					<div id="mh">
						<div>번호</div>
						<div>이름</div>
						<div>랭크</div>
						<div>가입방식</div>
						<div>블랙리스트</div>
						<div>가입일</div>
						<div>탈퇴일</div>
					</div>
					<div id="ml">
						<c:forEach var="num" begin="${realItemsStartNum}"
							end="${realItemsStartNum - realItemsPerPage + 1}" step="-1">
							<div>${num }</div>
						</c:forEach>
						<c:forEach var="list" items="${userList}">
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
						</c:forEach>
					</div>
					<div id="pageBtn">
						<div>
							<button type="button" id="prevPageBtn"
								<c:if test="${currentPage > 1}">onclick="window.location.href='/admin/changeUserList.do?itemsPerPage=${itemsPerPage}&currentPage=${currentPage - 1}'"</c:if>>&lt;</button>
						</div>
						<div>${currentPage}/${totalPage}페이지</div>
						<div>
							<button type="button" id="nextPageBtn"
								<c:if test="${pageNum < totalPage}">onclick="window.location.href='/admin/changeUserList.do?itemsPerPage=${itemsPerPage}&currentPage=${currentPage + 1}'"</c:if>>&gt;</button>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>