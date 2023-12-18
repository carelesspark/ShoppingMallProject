<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button onclick="openPopup()">팝업 창 열기</button>
	<a href="address.do?user_num=1">주소</a>
</body>
<script>
function openPopup() {
    // 여기에 주소와 창 크기 등을 설정합니다.
    var url = "address.do?user_num=1";
    var width = 650;
    var height = 1000;

    // 팝업 창을 엽니다.
    window.open(url, 'AddressPopup', 'width=' + width + ',height=' + height);
}
</script>
</html>