<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%

%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="user_menu.css" />
    <style>
        body {
            font-family: Arial, sans-serif;
        }

		#faq {
            width: 800px;
            margin: 0 auto;
            padding: 20px;
            
        }
        
        .buttons {
            width: 100%;
            display: flex;
            flex-direction: row;
            justify-content: flex-end;
            align-items: flex-end;
            margin-top: auto;
        }

		.buttons button{
			margin-left: 10px;
     		margin-right: 10px;
		}

        hr {
            margin: 10px 0;
            border: 1px solid black;
        }

        button {
            height: 30px;
            background-color: white;
            border-color: black;
            cursor: pointer;
        }

        #faq_title {
            font-size: 25px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        #category {
            width: 800px;
            display: grid;
            grid-template-columns: repeat(5, 150px);
            grid-template-rows: repeat(2, 50px);
            gap: 5px;
        }

        .category_outer {
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: gray;
            border-color: black;
            cursor: pointer;
            border-radius: 20px;
        }

        .category_inner {
            width: 80%;
            height: 80%;
            background-color: white;
            border-radius: 30px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            font-size: 18px;
        }

        #sub_category {
            display: flex;
            justify-content: flex-start;
        }

        #sub_category > div {
            margin-right: 50px;
            font-size: 18px;
        }

        .section {
            margin-bottom: 30px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 20px;
            font-size: 18px;
        }

        td {
            text-align: left;
            padding: 8px;
        }

        .Q, .A {
            width: 50px;
            background-color: gray;
            text-align: center;
            cursor: pointer;
        }
        
        .answer {
            display: none;
        }
        .question_content {
            display: flex;
            justify-content: space-between;
            position: relative;
            margin-left: 10px;
            margin-right: 20px;
        }
        
        .show-answer:before {
            content: "▼";
            position: absolute;
            right: 0;
        }
        
        .answer-visible .show-answer:before {
            content: "▲";
        }
        
        .question, .answer{
        	border: 1px solid black;
        }
        
        .answer_content{
        	margin-left: 10px;
            margin-right: 20px;
        	margin-top: 20px;
        	margin-bottom: 25px;
        }
        
        #page{
        	text-align: center;
        }
        
        #search{
        	background-color: gray;
        	height: 60px;
        	display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        
        #search_tab{
        	width: 80%;
            height: 70%;
            background-color: white;
        }
        
         #input_tab{
         	width:90%;
         	height:100%;
         	border: none;
         	font-size: 18px;
         }
         
         .center{
         	display: flex;
         	justify-content: center;
            align-items: center;
         }
         
         .submit-button {
            width: 30px;
            height: 30px;
            border: none;
            background: url('data:image/svg+xml;utf8,<svg width="30" height="30" viewBox="0 0 132 136" fill="none" xmlns="http://www.w3.org/2000/svg"><circle cx="50" cy="50" r="45" stroke="black" stroke-width="10"/><path d="M123.43 134.5C125.363 136.472 128.528 136.504 130.5 134.57C132.472 132.637 132.504 129.472 130.57 127.5L123.43 134.5ZM130.57 127.5L80.5704 76.4996L73.4296 83.5004L123.43 134.5L130.57 127.5Z" fill="black"/></svg>') no-repeat;
            cursor: pointer;
        }
    </style>
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
			        		<input value="질문을 검색하세요" id="input_tab">
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
			    <div class="section">
			        <table>
			            <tr class="question">
			                <td class="Q">Q</td>
			                <td class="question_content">
			                    <div>주문을 취소하려면 어떻게 하나요?</div>
			                    <div class="show-answer"></div>
			                </td>
			            </tr>
			            <tr class="answer">
			                <td class="A">A</td>
			                <td>
			                	<div class="answer_content">주문 취소는 마이페이지 > 주문/배송조회에서 신청하실 수 있습니다. 
			단, 주문 상태에 따라 처리 과정에 다를 수 있습니다. 
			아래 내용을 참고해 주세요.
			
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
			
			※ 배송중 상태에서 취소를 요청하시는 경우 상품 분실의 우려가 있어 상품 수령 후 반품으로 접수해 주세요.</div>
			                	<hr>
			                	<div class="buttons">
			                		<button>수정하기</button>
			                		<button>삭제하기</button>
			                		<button>문의 게시판 가기</button>
			                	</div>	
			                </td>
			            </tr>
			        </table>
			        
			        <table>
			            <tr class="question">
			                <td class="Q">Q</td>
			                <td class="question_content">
			                    <div>질문1</div>
			                    <div class="show-answer"></div>
			                </td>
			            </tr>
			            <tr class="answer">
			                <td class="A">A</td>
			                <td>
			                	<div class="answer_content">답변1</div>
			                	<hr>
			                	<div class="buttons">
			                		<button>수정하기</button>
			                		<button>삭제하기</button>
			                		<button>문의 게시판 가기</button>
			                	</div>	
			                </td>
			            </tr>
			        </table>
			        
			        <table>
			            <tr class="question">
			                <td class="Q">Q</td>
			                <td class="question_content">
			                    <div>질문1</div>
			                    <div class="show-answer"></div>
			                </td>
			            </tr>
			            <tr class="answer">
			                <td class="A">A</td>
			                <td>
			                	<div class="answer_content">답변1</div>
			                	<hr>
			                	<div class="buttons">
			                		<button>수정하기</button>
			                		<button>삭제하기</button>
			                		<button>문의 게시판 가기</button>
			                	</div>	
			                </td>
			            </tr>
			        </table>
			        
			        <table>
			            <tr class="question">
			                <td class="Q">Q</td>
			                <td class="question_content">
			                    <div>질문1</div>
			                    <div class="show-answer"></div>
			                </td>
			            </tr>
			            <tr class="answer">
			                <td class="A">A</td>
			                <td>
			                	<div class="answer_content">답변1</div>
			                	<hr>
			                	<div class="buttons">
			                		<button>수정하기</button>
			                		<button>삭제하기</button>
			                		<button>문의 게시판 가기</button>
			                	</div>	
			                </td>
			            </tr>
			        </table>
			    </div>
			    
			    <div class="buttons">
			    	<button>작성하기</button>
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



