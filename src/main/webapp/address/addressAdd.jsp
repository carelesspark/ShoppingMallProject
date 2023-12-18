<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    
        <div><h2>배송지 추가</h2></div>
        <hr>
        <form action="addressAdd.do" method="post">
	        <input type="hidden" name="user_num" value="${user_num}">
	        <div>
	           <div class="marg">
		           	받는사람<br>
		           	<div id="name"><input class="full" name="recipient"></div>
	           </div>
	           <div class="marg">
		           	휴대전화 번호<br>
		           	<div id="phoneNumber"><input class="full" name="phone_num"></div>
	           </div>
	           <div class="marg">
		           	주소
		           	<div id="postalCode">
		           		<div><input id="postal" name="postal_num"></div>
		           		<div><input type="button" id="search" value="우편 번호 찾기"></div>
		           	</div>
		           	<div id="addr"><input class="full" name="address"></div>
		           	<div id="detailAddr"><input class="full" name="detail_address"></div>
	           </div>
	           <div class="marg">
		            배송 메시지
		            <div id="request"><input class="full" name="request"></div>
		        </div>
	           <div class="marg">
				    <input type="checkbox" id="base" name="base" value="1">
			      	기본 배송지로 설정
			   </div>   
	        </div>
	        <br>
	        <br>
	        <br>
	        <br>
	        <br>
	        <div id="button">
	            <button type="submit" id="add">추가하기</button>
	            <button id="return" onclick="location.href='address.do?user_num=${user_num}'">돌아가기</button>
	        </div>
    	 </form>    
    </div>
    
	<script>

	</script>
</body>
</html>
