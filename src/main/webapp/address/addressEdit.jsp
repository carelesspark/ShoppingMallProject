<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../resources/css/address/addressAdd.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div id="addr-add">
        <div><h2>배송지 수정</h2></div>
        <hr>
        <div>
           <div class="marg">
	           	받는사람<br>
	           	<div id="name"><input class="full"></div>
           </div>
           <div class="marg">
	           	휴대전화 번호<br>
	           	<div id="phoneNumber"><input class="full"></div>
           </div>
           <div class="marg">
	           	주소
	           	<div id="postalCode">
	           		<div><input id="postal"></div>
	           		<div><input type="button" id="search" value="우편 번호 찾기"></div>
	           	</div>
	           	<div id="addr"><input class="full"></div>
	           	<div id="detailAddr"><input class="full"></div>
           </div>
           <div class="marg">
	           	배송 메시지
	           	<div id="request"><input class="full"></div>
           </div>
           <div class="marg">
           		<input type="checkbox" id="base" name="address">
           		기본 배송지로 설정
           </div>         
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div id="button">
            <button id="edit">수정하기</button>
            <button id="close">닫기</button>
        </div>
    </div>
	<script>

	</script>
</body>
</html>
