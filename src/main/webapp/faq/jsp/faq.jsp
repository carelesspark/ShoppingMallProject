<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%

%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../css/faq.css" rel="stylesheet" />
    <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            var questions = document.querySelectorAll(".question");

            questions.forEach(function (question) {
                question.addEventListener("click", function () {
                    var answer = question.nextElementSibling;

                    if (answer.classList.contains("answer")) {
                        // 토글 기능
                        if (answer.style.display === "table-row") {
                            answer.style.display = "none";
                            question.classList.remove("answer-visible");
                        } else {
                            answer.style.display = "table-row";
                            question.classList.add("answer-visible");
                        }
                    }
                });
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
			            <div class="category_outer"><div class="category_inner">취소/반품</div></div>
			            <div class="category_outer"><div class="category_inner">회원</div></div>
			            <div class="category_outer"><div class="category_inner">주문/결제</div></div>
			            <div class="category_outer"><div class="category_inner">교환 A/S</div></div>
			            <div class="category_outer"><div class="category_inner">이벤트</div></div>
			            <div class="category_outer"><div class="category_inner">배송</div></div>
			            <div class="category_outer"><div class="category_inner">혜택</div></div>
			            <div class="category_outer"><div class="category_inner">영수증</div></div>
			            <div class="category_outer"><div class="category_inner">쿠폰/상품권</div></div>
					</div>
			        </div>
			    </div>
			    <div class="section">
			        <hr>
			        <div id="sub_category">
			            <div>전체</div>
			            <div>취소신청/철회</div>
			            <div>반품신청/철회</div>
			            <div>환불정보</div>
			        </div>
			    </div>
			   <div id="qna">
				    <c:forEach var="i" begin="1" end="3">
				        <div class="card">
				            <div class="card-header">
				                <a class="btn" data-bs-toggle="collapse" href="#collapse${i}" id="question">
				                    주문을 취소하려면 어떻게 하나요?</a>
				            </div>
				            <div id="collapse${i}" class="collapse" data-bs-parent="#qna">
				                <div class="card-body" id="answer">
				                    주문 취소는 마이페이지 > 주문/배송조회에서 신청하실 수 있습니다.
				                    단, 주문 상태에 따라 처리 과정에 다를 수 있습니다.
				
				                    1. 입금대기중/결제완료
				                    주문서가 판매자에게 넘어가기 이전 단계입니다. 취소 신청 즉시 취소 완료됩니다.
				                    단, 일부 주문/제작 상품 등의 경우 즉시 취소가 어려울 수 있습니다.
				
				                    2. 배송준비중
				                    주문서가 판매자에게 넘어간 단계입니다.
				                    판매자가 상품을 발송하기 전 단계라면 취소 완료 처리되고, 상품 발송이 진행된 경우 취소 거부될 수 있습니다.
				
				                    3. 배송중/배송완료
				                    상품 발송 작업(운송장 등록)이 완료된 단계입니다.
				                    취소 신청이 제한되며, 반품으로 신청하실 수 있습니다.
				                    반품 신청 시에는 귀책 사유에 따라 배송비가 부과될 수 있습니다.
				
				                    ※ 배송중 상태에서 취소를 요청하시는 경우 상품 분실의 우려가 있어 상품 수령 후 반품으로 접수해 주세요.

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



