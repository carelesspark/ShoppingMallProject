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
            margin-bottom: 10px;
           	text-align: center;
           	
        }

        .section {
            margin-bottom: 30px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 15px;
            font-size: 15px;
        }

        td {
            text-align: left;
            padding: 8px;
        }

         .column{
            width: 150px;
            background-color: gray;
            text-align: right;
            cursor: pointer;
            font-weight: bold;
        }
        

       	table tr{
        	border: 1px solid black;
        }

        #faq_header{
        	background-color: gray;
        	height: 60px;
        	display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        
        #faq_write{
        	width: 80%;
            height: 70%;
            background-color: white;
        }
        
        .category_select{
        	width: 100%;
        	font-size: 15px;
        	border: none;
        }
        
        .input, #textarea{
        	width: 100%;
        	font-size: 15px;
        	border: none;
        	resize: none;
        }
    </style>
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
			        <div id="faq_header">
			        	<div id="faq_write" >
			        		<div id="faq_title">FAQ 추가하기</div>
				       	</div>
			        </div>
			    </div>
			
			    <div class="section">
			        <table>
			            <tr>
			                <td class="column">카테고리</td>
			                <td>
			                    <select class="category_select" name="category">
						            <option value="취소/반품">취소/반품</option>
						            <option value="회원">회원</option>
						            <option value="주문/결제">주문/결제</option>
						            <option value="교환 A/S">교환 A/S</option>
						            <option value="이벤트">이벤트</option>
						            <option value="배송">배송</option>
						            <option value="혜택">혜택</option>
						            <option value="영수증">영수증</option>
						            <option value="쿠폰/상품권">쿠폰/상품권</option>
							    </select>
			                </td>
			            </tr>
			            <tr>
			                <td class="column">세부 카테고리</td>
			                <td>
			                    <select class="category_select" name="category">
						            <option value="전체">취소신청/철회</option>
						            <option value="전체">반품신청/철회</option>
						            <option value="전체">환불정보</option>
							    </select>
			                </td>
			            </tr>
			            <tr>
			                <td class="column">질문</td>
			                <td>
			                    <input class="input">
			                </td>
			            </tr>
			            <tr>
			                <td class="column">답변</td>
			                <td>
			                    <textarea rows="20" id="textarea"></textarea>
			                </td>
			            </tr>
			        </table>
			       
			    </div>
			    
			    <div class="buttons">
			    	<button>다시쓰기</button>
			    	<button>작성하기</button>
			    </div>
			</div>
        </main>
      </div>
    </div>
    <footer>임시 푸터</footer>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
  </body>

</html>
