<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.dazzle.shop.model.address.*" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="${pageContext.request.contextPath}/resources/css/address/addressAdd.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div id="addr-add">
        <div><h2>배송지 수정</h2></div>
        <hr>
        <form action="addressEdit.do" method="post">
        	<input type="hidden" name="user_num" value="<c:out value='${address.user_num}'/>">
        	<input type="hidden" name="addr_num" value="<c:out value='${address.addr_num}'/>">
		    <div>
		        <div class="marg">
		            받는사람<br>
		            <div id="name"><input class="full" name="recipient" value="<c:out value='${address.recipient}'/>"></div>
		        </div>
		        <div class="marg">
		            휴대전화 번호<br>
		            <div id="phoneNumber"><input class="full" name="phone_num" value="<c:out value='${address.phone_num}'/>"></div>
		        </div>
		        <div class="marg">
		            주소
		            <div id="postalCode">
		                <div><input id="postal" name="postal_num" value="<c:out value='${address.postal_num}'/>"></div>
		                <div><input type="button" id="search" value="우편 번호 찾기"></div>
		            </div>
		            <div id="addr"><input class="full" name="address" value="<c:out value='${address.address}'/>"></div>
		            <div id="detailAddr"><input class="full" name="detail_address" value="<c:out value='${address.detail_address}'/>"></div>
		        </div>
		        <div class="marg">
		            배송 메시지
		            <div id="request"><input class="full" name="request" value="<c:out value='${address.request}'/>"></div>
		        </div>
		       <div class="marg">
				    <input type="checkbox" id="base" name="base" value="1" <c:if test="${address.base == 1}">checked</c:if>>
				    기본 배송지로 설정
				</div>

		    </div>
		    <br>
		    <br>
		    <br>
		    <br>
		    <br>
		    <div id="button">
		        <button type="submit" id="edit">수정하기</button>
		        <button id="return" onclick="location.href='address.do?user_num=${address.user_num}'">돌아가기</button>
		    </div>
		</form>
        
    </div>
</body>
</html>
