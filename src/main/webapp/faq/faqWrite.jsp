<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/resources/css/faq/faqAddEdit.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user.css" />
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script>
    $(document).ready(function () {
        // 다시쓰기 버튼 클릭 시 초기화
        $('#buttons .btn-dark:eq(1)').click(function () {
            // input과 textarea 초기화
            $('input[name="question"]').val('');
            $('textarea[name="answer"]').val('');
        });
    });
    </script>
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
  
			<div id ="faq">
			    <div id="faq_title">
			       	<h2>FAQ 추가하기</h2>
			    </div>
				<form action="faqWrite.do" method="post">
			    <div class="section">
			        <table id="faq_table">
			            <tr>
			                <td class="left">카테고리</td>
			                <td class="right">
							    <select class="category_select" name="sub_ctgr_num">
							        <c:forEach var="category" items="${detailCtgr}">
							            <option value="${category.sub_ctgr_num}">
							            ${category.ctgr_name} > ${category.sub_ctgr_name}
							            </option>
							        </c:forEach>
							    </select>
							</td>
			            </tr>
			           
			            <tr>
			                <td class="left">질문</td>
			                <td class="right">
			                    <input class="input" name="question">
			                </td>
			            </tr>
			            <tr>
			                <td class="left2">답변</td>
			                <td class="right2">
			                    <textarea rows="16" id="textarea" name="answer"></textarea>
			                </td>
			            </tr>
			        </table>
			       
			    </div>
			    <div id="buttons">
			    	<button type="button" class="btn btn-dark" onclick="location.href='faq.do'">돌아가기</button>
					<button type="button" class="btn btn-dark">다시쓰기</button>
					<button type="submit" class="btn btn-dark">추가하기</button>
	
				</div>
				</form>
			</div>
			
    </main>
    </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
  	<%@ include file="../footer.jsp"%>
  </body>
</html>
