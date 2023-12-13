<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.dazzle.shop.address.*" %>
<%@ page import="com.dazzle.shop.order.*" %>
<%@ page import="java.util.ArrayList" %>
<%
	List<OrderedProductVO> productList = new ArrayList();
	
	// ProductVO 객체 생성 및 값 설정
	
	OrderedProductVO product1 = new OrderedProductVO();
	product1.setProduct_id(1);
	product1.setProduct_info("반팔 티셔츠");
	product1.setProduct_price(50000);
	product1.setSalesVolume(3);	
	product1.setImage("image1.jpg");
	productList.add(product1);
	
	for (int i = 2; i <= 8; i++) {
		OrderedProductVO additionalproduct = new OrderedProductVO();
		additionalproduct.setProduct_id(i);
		additionalproduct.setProduct_info("반팔 티셔츠");
		additionalproduct.setProduct_price(50000);
		additionalproduct.setSalesVolume(i);	
		additionalproduct.setImage("image1.jpg");
		productList.add(additionalproduct);
    }
	
	
	int totalOrderAmount = 0;
    for (OrderedProductVO product : productList) {
        totalOrderAmount += product.getProduct_price() * product.getSalesVolume();
    }

    // Shipping cost
    int shippingCost = 0; // You can set your shipping cost here

    // Total payment amount
    int totalPaymentAmount = totalOrderAmount + shippingCost;
    
    // Format numbers with commas
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
    String formattedTotalOrderAmount = numberFormat.format(totalOrderAmount);
    String formattedShippingCost = numberFormat.format(shippingCost);
    String formattedTotalPaymentAmount = numberFormat.format(totalPaymentAmount);
    
    AddressVO address = new AddressVO();
    address.setBase(1);
    address.setName("홍길동");
    address.setPostalCode("[우편번호1]");
    address.setAddr("주소1");
    address.setDetailAddr("상세주소1");
    address.setPhoneNumber("전화번호1");
    address.setRequest("배송 요청 사항1");
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="../css/productOrderSucc.css" rel="stylesheet" />
    <title>Document</title>

  </head>
  <body>
    <header>임시 헤더</header>
        <main>
          <div id="order-info">
        <div id="order-success">
        	<div>
        		<svg width="100" height="100" viewBox="0 0 200 200" fill="none" xmlns="http://www.w3.org/2000/svg">
				<circle cx="100" cy="100" r="98.5" fill="white" stroke="black" stroke-width="3"/>
				<path d="M82.5 130L46.5 86.5L41 92L82.5 142.5L159.5 64L154.5 58L82.5 130Z" fill="black" stroke="black"/>
				</svg>
        	</div>
        	<div>
        		<div style="font-size: 20px; font-weight: bold;">주문 성공</div>
        		<div>주문하신 상품은 주문내역조회에서 확인 가능합니다.</div>
        		<br>
        		<div>주문번호 : 00000000</div>
        		<div>주문날짜 : 2000-00-00 00:00:00</div>
        	</div>
        </div>
        <br>
        <hr>
        <div>
            <div style="text-align: center"><h3>주문내역</h3></div>
            <hr>
            
            <%
            	for (OrderedProductVO product : productList) {
            %>
                <div class="product-list">
                	<div class="image">
                        <!-- 예: <img src="<%= product.getImage() %>" alt="Product Image"> -->
                        <svg width="197" height="163" viewBox="0 0 197 163" fill="none" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
						<rect width="197" height="163" fill="url(#pattern0)"/>
						<defs>
						<pattern id="pattern0" patternContentUnits="objectBoundingBox" width="1" height="1">
						<use xlink:href="#image0_92_171" transform="matrix(0.00861887 0 0 0.0104167 0.0862944 0)"/>
						</pattern>
						<image id="image0_92_171" width="96" height="96" xlink:href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGAAAABgCAYAAADimHc4AAAACXBIWXMAAAsTAAALEwEAmpwYAAADnElEQVR4nO2dO2gVURCGP02MoIKCEEFUbETRwgcoAe1ip/hCSzW9XkRBawttfIRgm84HRGwsVJAg2hhBfIEKASHaaIQgPqKFMWRkYYTlFjG7e+6e2c188JeHM/PPzjln926y4DiO4ziO4ziOE4eVwAngGbC9hfPsAN4CZ4E1zHKWAQ1gCJgCRDXYwjkfpOaZ0rkbGsusYAnQA9wHJlNmNOtwC+bumWa+SY2pR2OsFXOB3cA9YGIaEySln8DGgDFsAn7NcO7fwF1gl8ZeaXYCr2aYuDRpVI0rymbgc84YXmoOlWMB0J8zaUnpG3CgQBwHge8B4ujXnCrBUt3cJKDuAGszxLBOl5GQMQxpbqZZDQwHTlxSp5bkFHNSj6qdwHxVpx4xTwEPm05VITWsOZpkkZ6xpeYaBhZjjDnALQPmSEm6rTmb4ZgBU6RkJTmboA0YMWCIlKwPQDsGOGTADImk5JgbndBHTqmQHsc2f6sBEySyumIW4KYBAySyBmKZvyLDw7U66w+wKkYBLhpIXozoQtnmLwS+GEhcjOirPgkojYaBpMWYjpdlfvIjxTsDCYsxjehNacvZayBZMao9ZRTgkYFExaiSR+EtZYuBJMW4kpvTlnHNQIJiXFdbZf5yfWMgdoJiXBN6kxqc8waSk4roXGjzk99dxwwkJhXRmHoWjP0GkpLZfCQdMJCQVEw3Qpnfri9I5X27TSqu0QLPh4LcGXcVfD4iFVejwNhtIQpwJufk74EOAwZKQXVoLnnGng5RgOs5Jz+i46XiSjga86bsRY6J36TWvzoUoE1zyjr2eYgCfMox8b7U+DoUIO9R/CMBmOkfNvzT06bX9upSgIQnGccmf2hSmKwBdxccL8aUprvg+FIKUHS8GFNoP7wAeAGiX9XiHRDfWPEliOjm+h6AffkmjBeg1CtGjMk7AC+Ad0CKoh2UmbJbVowptB9eALwA0a9q8Q6Ib6z4EkR0c30PwL58E8YLUOoVI8bkHYAXwDsgRdEOykzZLSvGFNoPLwBegOhXtXgHxDdWfAkiurm+B2Bf0TfhsjdxMabKE9tA8QLEN1G8A+IbKb4EVVOVJ7aB4gWIb6J4B8Q3UmbrEvTDgImSU8nnTypPlT/q8Joa0GvASMmpS9SADf/5aJsYVRLzemrCFQOGSkb1USPm6TcipSIa1JhrRYd2wqTx/4TeV0fzm/eEXj1hjBswfVxjuVynNd9xHMdxHMdxHMzyFw+8LtRVgoloAAAAAElFTkSuQmCC"/>
						</defs>
						</svg>
                    </div>
                    <div class="product">
                        <div class="product-name"><%= product.getProduct_info() %></div>
                        <br>
                        <div class="product-info">
                            <div class="column">상품정보</div>
                            <div><%= product.getProduct_info() %></div>
                        </div>
                        <div class="product-price">
	                    <div class="column">판매가격</div>
		                    <div><%= numberFormat.format(product.getProduct_price()) %> 원</div>
		                </div>
                        <div class="sales-volume">
                            <div class="column">판매수량</div>
                            <div><%= product.getSalesVolume() %></div>
                        </div>
                        <div class="sum">
                            <div class="column">합계</div>
                            <div><%= numberFormat.format(product.getProduct_price() * product.getSalesVolume()) %> 원</div>
                        </div>
                    </div>
                </div>
                <hr>
            <%
                }
            %>
        </div>
        <div style="text-align: center"><h3>총 주문 금액</h3></div>
            <hr>
        <div id="order-fee">
	        <div>
	            <div>총 주문 금액</div>
	            <div><%= formattedTotalOrderAmount %> 원</div>
	        </div>
	        <div>
	            <svg width="49" height="47" viewBox="0 0 49 47" fill="none" xmlns="http://www.w3.org/2000/svg">
	                <path d="M17.8718 18.027V1H23.8974H29.9231V18.027H48V28.973H29.9231V46H17.8718V44.7838V36.8784V28.973H1V18.027H17.8718Z" fill="black" stroke="black"/>
	            </svg>
	        </div>
	        <div>
	            <div>배송비</div>
	            <div><%= formattedShippingCost %> 원</div>
	        </div>
	        <div>
	            <svg width="50" height="30" viewBox="0 0 50 30" fill="none" xmlns="http://www.w3.org/2000/svg">
	                <path d="M49 10H1V1H49V10Z" fill="black" stroke="black"/>
	                <path d="M49 29H1V20H49V29Z" fill="black" stroke="black"/>
	            </svg>
	        </div>
	        <div>
	            <div>총 결재 금액</div>
	            <div><%= formattedTotalPaymentAmount %> 원</div>
	        </div>
    	</div>
        <hr>
        <div style="text-align: center"><h3>배송 정보</h3></div>
            <hr>
        <div class="addr-list">
		    <div class="addr-info">
		        <div class="recipient">
		            <div class="name"><%= address.getName() %></div>
		        </div>
		        <div class="postal-code"><%= address.getPostalCode() %></div>
		        <div class="addr"><%= address.getAddr() %></div>
		        <div class="addr-detail"><%= address.getDetailAddr() %></div>
		        <div class="phn"><%= address.getPhoneNumber() %></div>
		        <div class="request"><%= address.getRequest() %></div>
		    </div>
		</div>
        <hr>
        <div id="buttons">
            <button id="continue">쇼핑 계속 하기</button>
            <button id="order-list">주문 내역 조회</button>
        </div>
        
    </div>
        </main>
    <footer>임시 푸터</footer>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    <script src="user_menu.js"></script>
  </body>
</html>

