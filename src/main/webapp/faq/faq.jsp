<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.dazzle.shop.model.faq.*" %>
<%
	List<FaqCtgrVO> categoryList = new ArrayList();

	FaqCtgrVO category1 = new FaqCtgrVO();
	category1.setCtgr_num(1);
	category1.setCtgr_name("취소/반품");
	categoryList.add(category1);

	FaqCtgrVO category2 = new FaqCtgrVO();
	category2.setCtgr_num(2);
	category2.setCtgr_name("회원");
	categoryList.add(category2);
	
	FaqCtgrVO category3 = new FaqCtgrVO();
	category3.setCtgr_num(3);
	category3.setCtgr_name("주문/결제");
	categoryList.add(category3);
	
	FaqCtgrVO category4 = new FaqCtgrVO();
	category4.setCtgr_num(4);
	category4.setCtgr_name("교환 A/S");
	categoryList.add(category4);
	
	FaqCtgrVO category5 = new FaqCtgrVO();
	category5.setCtgr_num(5);
	category5.setCtgr_name("이벤트");
	categoryList.add(category5);
	
	FaqCtgrVO category6 = new FaqCtgrVO();
	category6.setCtgr_num(6);
	category6.setCtgr_name("배송");
	categoryList.add(category6);
	
	FaqCtgrVO category7 = new FaqCtgrVO();
	category7.setCtgr_num(7);
	category7.setCtgr_name("혜택");
	categoryList.add(category7);
	
	FaqCtgrVO category8 = new FaqCtgrVO();
	category8.setCtgr_num(8);
	category8.setCtgr_name("영수증");
	categoryList.add(category8);
	
	FaqCtgrVO category9 = new FaqCtgrVO();
	category9.setCtgr_num(9);
	category9.setCtgr_name("쿠폰/상품권");
	categoryList.add(category9);

	List<FaqSubCtgrVO> subCategoryList = new ArrayList<>();

    FaqSubCtgrVO subCategory1 = new FaqSubCtgrVO();
    subCategory1.setSub_ctgr_num(1);
    subCategory1.setSub_ctgr_name("취소신청/철회");
    subCategoryList.add(subCategory1);

    FaqSubCtgrVO subCategory2 = new FaqSubCtgrVO();
    subCategory2.setSub_ctgr_num(2);
    subCategory2.setSub_ctgr_name("반품신청/철회");
    subCategoryList.add(subCategory2);

    FaqSubCtgrVO subCategory3 = new FaqSubCtgrVO();
    subCategory3.setSub_ctgr_num(3);
    subCategory3.setSub_ctgr_name("환불정보");
    subCategoryList.add(subCategory3);
	
    
    List<FaqVO> faqList = new ArrayList<>();

    FaqVO faq1 = new FaqVO();
    faq1.setFaq_num(1);
    faq1.setQuestion("주문을 취소하려면 어떻게 하나요?");
    faq1.setAnswer("주문 취소는 마이페이지 > 주문/배송조회에서 신청하실 수 있습니다. ... (이하 생략)");
    faqList.add(faq1);

    FaqVO faq2 = new FaqVO();
    faq2.setFaq_num(2);
    faq2.setQuestion("상품 반품은 어떻게 신청하나요?");
    faq2.setAnswer("반품은 ... (이하 생략)");
    faqList.add(faq2);

    FaqVO faq3 = new FaqVO();
    faq3.setFaq_num(3);
    faq3.setQuestion("환불 절차는 어떻게 되나요?");
    faq3.setAnswer("환불은 ... (이하 생략)");
    faqList.add(faq3);

    FaqVO faq4 = new FaqVO();
    faq4.setFaq_num(4);
    faq4.setQuestion("회원 정보를 수정하는 방법은?");
    faq4.setAnswer("회원 정보 수정은 ... (이하 생략)");
    faqList.add(faq4);

    FaqVO faq5 = new FaqVO();
    faq5.setFaq_num(5);
    faq5.setQuestion("주문한 상품의 배송 조회는 어디서 할 수 있나요?");
    faq5.setAnswer("배송 조회는 ... (이하 생략)");
    faqList.add(faq5);
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../resources/css/faq/faq.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

	<script>
	$(document).ready(function() {
	    // 카테고리가 클릭되었을 때의 처리
	    $('.category_inner').on('click', function() {
	        $('.category_outer').css('background-color', '');
	
	        $(this).parent('.category_outer').css('background-color', 'black');
	    });
	    $('#sub_category div').on('click', function() {
	        $('#sub_category div').css('background-color', '');
	
	        $(this).css('background-color', 'black');
	    });
	});
	</script>
	
    
</head>
  <body>
    <header>임시 헤더</header>
    <div id="main-container">
      <div id="user-explanation">
        <div id="user-explanation-grid">
          <div>
            <div id="user-explanation-rank-container">
              <p>M</p>
            </div>
          </div>
          <div id="user-explanation-1-container">
            <div id="user-explanation-name-container">
              <p>주인장</p>
            </div>
            <div id="user-explanation-name-rank-container">
              <p>Manager</p>
            </div>
          </div>
          <div id="user-explanation-2-container">
            <div><p>월매출</p></div>
            <div><p>1일~현재 매출 합}원</p></div>
          </div>
          <div id="user-explanation-3-container">
            <div><p>주문 현황</p></div>
            <div>
              <a href=""><p>클릭</p></a>
            </div>
          </div>
          <div id="user-explanation-4-container">
            <div><p>상품 현황</p></div>
            <div>
              <a href=""><p>클릭</p></a>
            </div>
          </div>
        </div>
      </div>
      <div id="menu-container">
        <section>
          <div id="menu-user-container" class="menu-section">
            <p class="menu-section-name">회원 관리</p>
            <a href="" class="menu-section-anchor"
              ><p class="menu-section-name-detail">회원 목록</p></a
            >
            <a href="" class="menu-section-anchor"
              ><p class="menu-section-name-detail">블랙리스트 목록</p></a
            >
          </div>
          <div id="menu-product-container" class="menu-section">
            <p class="menu-section-name">상품 관리</p>
            <a href="" class="menu-section-anchor"
              ><p class="menu-section-name-detail">상품 목록</p></a
            >
            <a href="" class="menu-section-anchor"
              ><p class="menu-section-name-detail">상품 추가</p></a
            >
            <a href="" class="menu-section-anchor"
              ><p class="menu-section-name-detail">상품 수정</p></a
            >
            <a href="" class="menu-section-anchor"
              ><p class="menu-section-name-detail">상품 삭제</p></a
            >
          </div>
          <div id="menu-order-container" class="menu-section">
            <p class="menu-section-name">주문 관리</p>
            <a href="" class="menu-section-anchor"
              ><p class="menu-section-name-detail">주문 목록</p></a
            >
            <a href="" class="menu-section-anchor"
              ><p class="menu-section-name-detail">반품 및 환불 목록</p></a
            >
            <a href="" class="menu-section-anchor"
              ><p class="menu-section-name-detail">Q&A 목록</p></a
            >
          </div>
          <div id="menu-myinfo-container" class="menu-section">
            <p class="menu-section-name">나의 정보</p>
            <a href="" class="menu-section-anchor"
              ><p class="menu-section-name-detail">정보 변경</p></a
            >
          </div>
        </section>
        <main>
			<div id ="faq">
			    <div class="section">
			        <div id="search">
			        	<div id="search_tab" >
			        		<input placeholder="질문을 검색하세요" id="input_tab">
				       		<input type="submit" value=" " class="submit-button">
				       	</div>
			        </div>
			    </div>
			
			    <div class="section">
			        <hr>
			        <div id="faq_title">자주 묻는 질문</div>
			        <div class="center">
			        <div id="category">
			            <div class="category_outer"><div class="category_inner">전체</div></div>
			            <c:forEach var="category" items="<%= categoryList %>">
		                    <div class="category_outer">
		                        <div class="category_inner"><c:out value="${category.getCtgr_name()}" /></div>
		                    </div>
		                </c:forEach>     
					</div>
			        </div>
			    </div>
			    <div class="section">
			        <hr>
			        <div id="sub_category">
			        	<div>전체</div>
				        <c:forEach var="subCategory" items="<%= subCategoryList %>">
						    <div>
						        <c:out value="${subCategory.getSub_ctgr_name()}" />
						    </div>
						</c:forEach>
			        </div>
			        
			    </div>
			   <div id="qna">
			        <c:forEach var="faq" items="<%= faqList %>">
			            <div class="card">
			                <div class="card-header">
			                    <a class="btn" data-bs-toggle="collapse" href="#collapse${faq.getFaq_num()}" id="question">
			                        <c:out value="${faq.getQuestion()}" />
			                    </a>
			                </div>
			                <div id="collapse${faq.getFaq_num()}" class="collapse" data-bs-parent="#qna">
			                    <div class="card-body" id="answer">
			                        <c:out value="${faq.getAnswer()}" />
			                        <div id="buttons">
			                            <div>
			                                <button type="button" class="btn btn-dark">수정하기</button>
			                            </div>
			                            <div>
			                                <button type="button" class="btn btn-dark">삭제하기</button>
			                            </div>
			                            <div>
			                                <button type="button" class="btn btn-dark">문의 게시판 가기</button>
			                            </div>
			                        </div>
			                    </div>
			                </div>
			            </div>
			        </c:forEach>
			    </div>

			   
			    
			    
			    <div id="buttons">
			    	<button type="button" class="btn btn-dark">작성하기</button>
			    </div>
			    <div>
			    	<hr>
			    	<div id="page">1 2 3 4 5</div>
			    </div>
			</div>
        </main>
      </div>
    </div>
    <footer>임시 푸터</footer>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
  </body>
</html>



