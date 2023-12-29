<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문/결제 페이지</title>
<link
   href="${pageContext.request.contextPath}/resources/css/order/productOrder.css"
   rel="stylesheet" />
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
   function openAddressPopup() {
      window.open('address.do', '주소 변경', 'width=650, height=1000');
   }
</script>

</head>
<body>
   <%@ include file="../header.jsp"%>
   <main>
      <form action="order.do" method="post">
         <input type="hidden" value="${user_num}" name="user_num" />

         <div id="main_container">
            <div id="order_list">
               <div id="order_list_title">
                  <h1>주문 결제</h1>
               </div>
               <div>
                  <h3>주문 내역</h3>
               </div>
               <c:set var="totalPrice" value="0" />

               <div id="order_list_box">
                  <div id="order_list_grid">
                     <c:forEach items="${productOrder}" var="order">
                        <input type="hidden" value="${order.product_code }"
                           name="product_code_list" />
                        <div id="order_list_pic">
                           <img src="${pageContext.request.contextPath}/resources/image/product/${order.product_num}/${order.img_name }"
                              id="order_list_pic1" />
                        </div>
                        <div id="order_list_price">
                           <p><fmt:formatNumber value="${order.amountMultiPrice}" pattern="#,###"/>원</p>
                           <input type="hidden" value="${order.amountMultiPrice }"
                              name="amountMultiPrice_list" />
                           <c:set var="totalPrice"
                              value="${totalPrice + order.amountMultiPrice}" />
                        </div>
                        <div id="order_list_amount">
                           <p>수량 / ${order.amount }개</p>
                           <input type="hidden" value="${order.amount }"
                              name="amount_list" />
                        </div>
                        <div id="order_list_name">
                           <p>${order.product_name}(색상:${order.color_name},사이즈:
                              ${order.size_name})</p>
                        </div>
                     </c:forEach>
                     <hr style="border-bottom: 1px solid #C3C3C3;" />
                  </div>
               </div>


               <div id="order_list_total_price">
                  <p>전체 가격 : <fmt:formatNumber value="${totalPrice}" pattern="#,###"/>원</p>
               </div>
            </div>
            <div id="order_address">
               <div id="order_address_title">
                  <div>
                     <h3>배송지 정보</h3>
                  </div>
                  <div>
                     <button type="button" class="btn btn-dark"
                        id="order_address_button" onclick="openAddressPopup()">배송지
                        주소 변경</button>
                  </div>
               </div>
               <div id="order_address_box">
                  <div id="order_address_grid">
                     <div id="order_address_grid_rows_1">
                        <div id="order_address_name">
                           <p>이름</p>
                        </div>
                        <div id="order_address_address">
                           <p>주소</p>
                        </div>
                        <div id="order_address_phone">
                           <p>전화번호</p>
                        </div>
                        <div id="order_address_request">
                           <p>요청사항</p>
                        </div>
                     </div>
                     <div id="order_address_grid_rows_2">
                        <div id="order_address_name_value">
                           <input class="readonly" readonly="readonly" name="recipient"
                              value="${address.recipient}" />
                        </div>
                        <div id="order_address_address_value">
                           <input class="readonly" readonly="readonly" name="postal_num"
                              value="${address.postal_num}" /> <input class="readonly"
                              readonly="readonly" name="address" value="${address.address}" />
                           <input class="readonly" readonly="readonly"
                              name="detail_address" value="${address.detail_address}" />
                        </div>
                        <div id="order_address_phone_value">
                           <input class="readonly" readonly="readonly" name="phone_num"
                              value="${address.phone_num}" />
                        </div>
                        <div id="order_address_request_value">
                           <select name="request">
                              <c:choose>
                                 <c:when test="${address.request == null}">
                                    <option id="default" value="요청사항 없음">---요청사항을
                                       선택해주세요.---</option>
                                 </c:when>
                                 <c:otherwise>
                                    <option id="default" value="${address.request}">${address.request}</option>
                                 </c:otherwise>
                              </c:choose>
                              <option value="직접 받겠습니다.">직접 받겠습니다.</option>
                              <option value="경비실에 보관해주세요.">경비실에 보관해주세요.</option>
                              <option value="택배함에 보관해주세요.">택배함에 보관해주세요.</option>
                              <option value="문 앞으로 배송해주세요.">문 앞으로 배송해주세요.</option>
                           </select>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <div id="order_payment">
               <div id="order_payment_title">
                  <div>
                     <h3>결제</h3>
                  </div>
               </div>
               <div id="order_payment_box">
                  <div id="order_payment_grid">
                     <div id="order_payment_grid_rows_1">
                        <div id="order_payment_price">
                           <p>전체 상품가격</p>
                        </div>
                        <div id="order_payment_point">
                           <p>포인트</p>
                        </div>
                        <div id="order_payment_delivery">
                           <p>배송비</p>
                        </div>
                        <div id="order_payment_actual_price">
                           <p>전체 결제 금액</p>
                        </div>
                        <div id="order_payment_method">
                           <p>결제 방식</p>
                        </div>
                     </div>
                     <div id="order_payment_grid_rows_2">
                        <div id="order_payment_price_value">
                           <p><fmt:formatNumber value="${totalPrice}" pattern="#,###"/>원</p>
                        </div>
                        <div id="order_payment_point_value">
                           <div id="order_payment_div_css">
                              <input type="number" id="order_payment_point_box"
                                 value="0" readonly />
                              <input type="hidden" id="hidden_use_points" name="points" value="${userPoint}" />
                           </div>
                           <div id="order_payment_label_css">
                              <label>포인트</label>
                           </div>
                           <div id="order_payment_label_css">
                              <label>보유 : </label>
                           </div>
                           <div id="order_payment_label_css">
                              <label id="user_point"><c:out value="${userPoint}" />포인트
                              </label> <input type="hidden" id="hidden_user_point" name="totalPoints"
                                 value="${userPoint }" />
                           </div>
                           <div id="order_payment_div_css">
                              <div>
                                 <button type="button" class="btn btn-dark"
                                    id="order_payment_point_button1">포인트 사용하기</button>
                              </div>
                              <div>
                                 <button type="button" class="btn btn-dark"
                                    id="order_payment_point_button2">포인트 사용 취소</button>
                              </div>
                           </div>
                        </div>
                        <div id="order_payment_delivery_value">
                           <c:set var="delivery_price" value="3000" />
                           <c:if test="${totalPrice >= 30000}">
                              <c:set var="delivery_price" value="0" />
                           </c:if>
                           <p><fmt:formatNumber value="${delivery_price }" pattern="#,###"/>원</p>
                           <input type="hidden" value="${delivery_price}"
                              name="delivery_price" />

                        </div>
                        <div id="order_payment_actual_price_value">
                           <c:set var="totalPrice" value="${totalPrice + delivery_price}" />
                           <p id="total_price"><fmt:formatNumber value="${totalPrice}" pattern="#,###"/>원</p>
                           <input type="hidden" id="hidden_total_price" name="totalPrice"
                              value="${totalPrice }" />
                              <input type="hidden" id="hidden_total_price2" value="${totalPrice}"/>
                        </div>
                        <div id="order_payment_method_value">
                           <div>
                              <input type="radio" id="credit_card" name="payment"
                                 value="신용카드/체크카드"><label>신용카드/체크카드</label>
                           </div>
                           <div>
                              <input type="radio" id="deposit_without_passbook"
                                 name="payment" value="무통장입금"><label>무통장입금</label>
                           </div>
                           <div>
                              <input type="radio" id="transfer" name="payment" value="계좌이체"><label>계좌이체</label>
                           </div>
                           <div>
                              <input type="radio" id="kakaopay" name="payment" value="카카오페이"><label>카카오페이</label>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <div id="order_buttons">
               <div id="order_buttons_div1">
                  <button type="button" class="btn btn-dark" id="return_home_button"
                     onclick="location.href='/main.do'">홈으로 돌아가기</button>
               </div>
               <div id="order_buttons_div2">
                  <button type="submit" class="btn btn-dark" id="order_buy_button" disabled>구매하기</button>
               </div>
            </div>
         </div>
      </form>
   </main>
   <%@ include file="../footer.jsp"%>
   <script>
      $(document).ready(function() {
         $("#order_payment_point_button1").on("click", function() {
            const point = $("#hidden_user_point").val();
            $("#user_point").text("0포인트");
            $("#order_payment_point_box").val(point);
            $("#hidden_use_points").val(point);

            const totalPrice = $("#hidden_total_price").val();
            const totalPrice_point = totalPrice - point;

            $("#total_price").text(totalPrice_point + "원");
            $("#hidden_total_price").val(totalPrice_point);
             $("#order_payment_point_button1").prop("disabled", true);
         });
         
         $("#order_payment_point_button2").on("click", function() {
            const point = $("#hidden_user_point").val();
            $("#order_payment_point_box").val(0);
            $("#hidden_use_points").val(0);
            $("#user_point").text(point + "포인트");
            
            const totalPrice2 = $("#hidden_total_price2").val();
            $("#hidden_total_price").val(totalPrice2);
            const totalPrice = $("#hidden_total_price").val();
            $("#total_price").text(totalPrice + "원");
            $("#order_payment_point_button1").prop("disabled", false);
            
         });   
         
         
         $("#credit_card").on("click", function() {
            $("#order_buy_button").prop("disabled", false);
         });
         $("#deposit_without_passbook").on("click", function() {
            $("#order_buy_button").prop("disabled", false);
         });
         $("#transfer").on("click", function() {
            $("#order_buy_button").prop("disabled", false);
         });
         $("#kakaopay").on("click", function() {
            $("#order_buy_button").prop("disabled", false);
         });

      });
      
      
   </script>
</body>
</html>