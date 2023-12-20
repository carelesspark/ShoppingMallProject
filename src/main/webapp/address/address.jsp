<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="com.dazzle.shop.model.address.*" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="${pageContext.request.contextPath}/resources/css/address/address.css" rel="stylesheet" />

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        function editAddress(addrNum) {
            location.href = 'addressEdit.do?addr_num=' + addrNum;
        }

        function deleteAddress(addrNum, userNum) {
            location.href = 'addressDelete.do?addr_num=' + addrNum + '&user_num=' + userNum;
        }

        function closePage() {
        	 window.close();
        }
        
        function selectAddress() {
            var parentDocument = window.opener.document;

            // 이름 변경
            var nameInput = parentDocument.getElementById('order_address_name_value').querySelector('input[name="recipient"]');
            nameInput.value = "11111111";

            // 우편번호 변경
            var postalNumInput = parentDocument.getElementById('order_address_address_value').querySelector('input[name="postal_num"]');
            postalNumInput.value = "11111111";

            // 주소 변경
            var addressInput = parentDocument.getElementById('order_address_address_value').querySelector('input[name="address"]');
            addressInput.value = "11111111";

            // 상세 주소 변경
            var detailAddressInput = parentDocument.getElementById('order_address_address_value').querySelector('input[name="detail_address"]');
            detailAddressInput.value = "11111111";

            // 전화번호 변경
            var phoneNumInput = parentDocument.getElementById('order_address_phone_value').querySelector('input[name="phone_num"]');
            phoneNumInput.value = "11111111";

            var requestSelect = parentDocument.getElementById('order_address_request_value').querySelector('select[name="request"]');
            var defaultOption = requestSelect.querySelector('#default');

            // 새로운 값으로 변경
            defaultOption.value = "11111111"; // 변경할 값
            defaultOption.innerText = "새로운 텍스트"; // 변경할 텍스트

            // 창 닫기
            window.close();
        }

    </script>
</head>
<body>
    <div id="addr-choice">
        <div><h2>배송지 선택</h2></div>
        <hr>
        
        <div>
            <c:set var="displayLimit" value="3" />
		    <c:forEach var="address" items="${addressList}" varStatus="loop">
		    <c:if test="${loop.index < displayLimit}">
		        <div class="addr-list">
		            <div class="addr-info">
		                <div class="recipient">
		                    <div class="name">${address.recipient}</div>
		                    <div class="base">${(address.base == 1) ? "기본 배송지" : ""}</div>
		                </div>
		                <div class="postal-code">[${address.postal_num}]</div>
		                <div class="addr">${address.address}</div>
		                <div class="addr-detail">${address.detail_address}</div>
		                <div class="phn">${address.phone_num}</div>
		                <div class="request">${address.request}</div>
		            </div>
		             <div class="button">
                        <button class="edit" onclick="editAddress(${address.addr_num})">수정하기</button>
                        <button class="delete" onclick="deleteAddress(${address.addr_num},${address.user_num})">삭제하기</button>
                     	<button class="choice" onclick="selectAddress()">선택하기</button>
                     </div>
		        </div>
		        <hr>
		    </c:if>
		</c:forEach>
		
		<div class="collapse" id="additionalAddresses">
		    <c:forEach var="address" begin="${displayLimit}" items="${addressList}" varStatus="loop">
		        <div class="addr-list">
		            <div class="addr-info">
		                <div class="recipient">
		                    <div class="name">${address.recipient}</div>
		                    <div class="base">${(address.base == 1) ? "기본 배송지" : ""}</div>
		                </div>
		                <div class="postal-code">[${address.postal_num}]</div>
		                <div class="addr">${address.address}</div>
		                <div class="addr-detail">${address.detail_address}</div>
		                <div class="phn">${address.phone_num}</div>
		                <div class="request">${address.request}</div>
		            </div>
		             <div class="button">
                        <button class="edit" onclick="editAddress(${address.addr_num})">수정하기</button>
                        <button class="delete" onclick="deleteAddress(${address.addr_num},${address.user_num})">삭제하기</button>
                     	<button class="choice" onclick="selectAddress()">선택하기</button>
                     </div>
		        </div>
		        <hr>
		    </c:forEach>
		</div>
		
		<c:if test="${addressList.size() > displayLimit}">
		    <div class="show-more" data-bs-toggle="collapse" data-bs-target="#additionalAddresses" aria-expanded="false" aria-controls="additionalAddresses">▼</div>
		</c:if>


        </div>
        <br>
		<div id="buttons">
            <button id="add" onclick="location.href='addressAdd.do?user_num=${addressList[0].user_num}'">새 배송지 추가하기</button>
            <button id="close" onclick="closePage()">확인</button>
        </div>
    </div>
</body>
</html>
