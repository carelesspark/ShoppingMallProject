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
        function closePage() {
        	 window.close();
        }
        
        function selectAddress(recipient, postal_num, address, detail_address,phone_num,request) {
            var parentDocument = window.opener.document;
			console.log(recipient, postal_num, address, detail_address,phone_num,request);
			
            // 이름 변경
            var nameInput = parentDocument.getElementById('order_address_name_value').querySelector('input[name="recipient"]');
            nameInput.value = recipient;

            // 우편번호 변경
            var postalNumInput = parentDocument.getElementById('order_address_address_value').querySelector('input[name="postal_num"]');
            postalNumInput.value = postal_num;

            // 주소 변경
            var addressInput = parentDocument.getElementById('order_address_address_value').querySelector('input[name="address"]');
            addressInput.value = address;

            // 상세 주소 변경
            var detailAddressInput = parentDocument.getElementById('order_address_address_value').querySelector('input[name="detail_address"]');
            detailAddressInput.value = detail_address;

            // 전화번호 변경
            var phoneNumInput = parentDocument.getElementById('order_address_phone_value').querySelector('input[name="phone_num"]');
            phoneNumInput.value = phone_num;

            var requestSelect = parentDocument.getElementById('order_address_request_value').querySelector('select[name="request"]');
            var defaultOption = requestSelect.querySelector('#default');

            // 새로운 값으로 변경
            defaultOption.value = request;
            defaultOption.innerText = request;

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
                        <button class="edit" onclick="location.href='addressEdit.do?addr_num=${address.addr_num}'">수정하기</button>
                        <button class="delete"onclick="location.href='addressDelete.do?addr_num=${address.addr_num}'">삭제하기</button>
                     	<button class="choice" onclick="selectAddress('${address.recipient}', '${address.postal_num}',
                     	'${address.address}', '${address.detail_address}', '${address.phone_num}', '${address.request}')">
                     		선택하기
						</button>
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
                        <button class="edit" onclick="location.href='addressEdit.do?addr_num=${address.addr_num}'">수정하기</button>
                        <button class="delete"onclick="location.href='addressDelete.do?addr_num=${address.addr_num}'">삭제하기</button>
                     	<button class="choice" onclick="selectAddress('${address.recipient}', '${address.postal_num}',
                     	'${address.address}', '${address.detail_address}', '${address.phone_num}', '${address.request}')">
                     		선택하기
						</button>
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
            <button id="add" onclick="location.href='addressAdd.do'">새 배송지 추가하기</button>
            <button id="close" onclick="closePage()">확인</button>
        </div>
    </div>
</body>
</html>
