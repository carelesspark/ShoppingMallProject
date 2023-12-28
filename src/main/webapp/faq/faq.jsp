<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/resources/css/faq/faq.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user.css" />
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin/admin_product_detail.css?ver=1.0" />
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    
</head>
  <body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<c:choose>
		    <c:when test="${sessionScope.is_admin == 1}">
		        <%@ include file="../admin/admin_card.jsp"%>
				<div id="mc">
					<%@ include file="../admin/admin_side.jsp"%>
		    </c:when>
		    <c:otherwise>
		        <%@ include file="../user/user_card.jsp"%>
		        <div id="mc">
		            <%@ include file="../user/user_side.jsp"%>
		    </c:otherwise>
		</c:choose>

	<main>
    <div id="main-container">
			<div id ="faq">			   	   
			    <div class="section">
			   
			        <div id="faq_title">자주 묻는 질문</div>
			        <div>
			     		<ul class="nav nav-tabs">
			     			<li class="nav-item dropdown">
			     			<div class="nav-link">
						       <a href="faq.do">전체</a>
						       </div>
			     			</li>
						    <c:forEach var="category" items="${faqCtgr}">
						        <li class="nav-item dropdown">
						            <div class="nav-link dropdown-toggle" data-toggle="dropdown">
						                <c:out value="${category.ctgr_name}" />
						            </div>
						            <div class="dropdown-menu">
						                <c:forEach var="subCategory" items="${faqSubCtgr}">
						                    <c:if test="${subCategory.ctgr_num eq category.ctgr_num}">
						                        <div class="dropdown-item">
						                        	<a href="faq.do?sub_ctgr_num=${subCategory.sub_ctgr_num}">
					                                    <c:out value="${subCategory.sub_ctgr_name}" />
					                                </a>
											                        	
						                        </div>
						                    </c:if>
						                </c:forEach>
						            </div>
						        </li>
						    </c:forEach>
						</ul>
					</div>
			     		   
			        </div>
			    </div>
			  	
			  	<div class="section">
			  		<c:choose>
					    <c:when test="${currCtgr == null}">
					        전체
					    </c:when>
					    <c:otherwise>
					        ${currCtgr.ctgr_name} > ${currCtgr.sub_ctgr_name}
					    </c:otherwise>
					</c:choose>
			  	</div>
			    
			   <div id="qna">
			        <c:forEach var="faq" items="${ faq}">
			            <div class="card">
			                <div class="card-header">
			                    <a class="btn" type="button" data-bs-toggle="collapse" 
			                    data-bs-target="#collapse${faq.faq_num}" id="question">
			                        <c:out value="${faq.question}" />
			                    </a>
			                </div>
			                <div class="collapse" id="collapse${faq.faq_num}"
			                	 data-bs-parent="#qna">
			                    <div class="card-body" id="answer">
			                        <c:out value="${faq.answer}" />
			                        <div id="buttons">
			                            <c:if test="${sessionScope.is_admin eq '1'}">
				                        <div>
				                            <button type="button" class="btn btn-dark"
				                                onclick="location.href='faqEdit.do?faq_num=${faq.faq_num}'">
				                                	수정하기
				                            </button>
				                        </div>
				                        <div>
				                            <button type="button" class="btn btn-dark"
				                                onclick="location.href='faqDelete.do?faq_num=${faq.faq_num}'">
				                                	삭제하기
				                            </button>
				                        </div>
				                    </c:if>
			                            <div>
			                                <button type="button" class="btn btn-dark"
			                                onclick="location.href='/questionMain.do'">
			                                	문의 게시판 가기
			                                </button>
			                            </div>
			                        </div>
			                    </div>
			                </div>
			            </div>
			        </c:forEach>
			    </div>

			   
			   <c:if test="${sessionScope.is_admin eq '1'}">
			    <div id="buttons">
			    	<button type="button" class="btn btn-dark" onclick="location.href='faqWrite.do'">작성하기</button>
			    </div>
			    </c:if>
			    <div id="pageButtons" class="text-center mt-3">
			        <c:forEach begin="1" end="${totalPages}" varStatus="loop">
			            <c:url value="" var="url">
			                <c:param name="curr_page" value="${loop.index}" />
			                <c:param name="sub_ctgr_num" value="${sub_ctgr_num}" />
			            </c:url>
			            <a href="${url}" class="btn ${loop.index == curr_page ? 'active' : ''}">
			                ${loop.index}
			            </a>
			        </c:forEach>
			    </div>
			    
			</div>
			</main>
			</div>
			</div>
			
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
  	<%@ include file="../footer.jsp"%>
  </body>
</html>



