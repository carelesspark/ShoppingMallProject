<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin_user_list.css?ver=1.3" />
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
					<div id="mt">
						<div id="mtd">회원 목록</div>
					</div>
					<div id="mh">
						<div>이름</div>
						<div>랭크</div>
						<div>가입방식</div>
						<div>블랙리스트</div>
						<div>가입일</div>
						<div>탈퇴일</div>
					</div>
					<div id="ml">
						<c:choose>
							<c:when test="${not empty userList}">
								<c:forEach var="list" items="${userList}">
									<div class="clb">
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
							</c:when>
							<c:otherwise>
								<div id="noList">
									<div>내역이 없습니다.</div>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<div id="mp">
						<div id="pBtn">
							<div id="prevbb">
								<button type="button" id="prevb"
									<c:if test="${currentPage > 1}">onclick="window.location.href='/admin/changeUserList.do?currentPage=${currentPage - 1}&itemsPerPage=${itemsPerPage}'"</c:if>>&lt;</button>
							</div>
							<div id="pShow">
								<div>${currentPage}</div>
								<div>&nbsp/&nbsp</div>
								<div>
									<c:choose>
										<c:when test="${totalPage == 0}">1</c:when>
										<c:otherwise>${totalPage}</c:otherwise>
									</c:choose>
								</div>
								<div>페이지</div>
							</div>
							<div id="nextbb">
								<button type="button" id="nextb"
									<c:if test="${currentPage < totalPage}">onclick="window.location.href='/admin/changeUserList.do?currentPage=${currentPage + 1}&itemsPerPage=${itemsPerPage}'"</c:if>>&gt;</button>
							</div>
						</div>
						<div id="pSize">
							<div id="pSizeShow">현재 페이지 표시 개수: ${itemsPerPage}</div>
							<div id="psbb">
								<div>변경&nbsp</div>
								<div id="psbb1">
									<button type="button"
										onclick="window.location.href='/admin/changeUserList.do?currentPage=1&itemsPerPage=10'">10</button>
								</div>
								<div id="psbb2">
									<button type="button"
										onclick="window.location.href='/admin/changeUserList.do?currentPage=1&itemsPerPage=20'">20</button>
								</div>
								<div id="psbb3">
									<button type="button"
										onclick="window.location.href='/admin/changeUserList.do?currentPage=1&itemsPerPage=30'">30</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>