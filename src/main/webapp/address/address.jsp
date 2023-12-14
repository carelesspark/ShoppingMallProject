<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dazzle.shop.model.address.*" %>
<%@ page import="java.util.ArrayList" %>
<%
    // AddressVO 객체 리스트 생성
    List<AddressVO> addressList = new ArrayList();
    
    // AddressVO 객체 생성 및 리스트에 추가 (실제로는 데이터베이스나 다른 소스로부터 가져와야 함)
    AddressVO address1 = new AddressVO();
    address1.setAddr_num(1);
    address1.setBase(1);
    address1.setRecipient("홍길동");
    address1.setPostal_num("00001");
    address1.setAddress("주소1");
    address1.setDetail_address("상세주소1");
    address1.setPhone_num("전화번호1");
    address1.setRequest("배송 요청 사항1");
    addressList.add(address1);

    for (int i = 2; i <= 8; i++) {
        AddressVO additionalAddress = new AddressVO();
        
        additionalAddress.setAddr_num(1);
        additionalAddress.setBase(0);
        additionalAddress.setRecipient("이름" + i);
        additionalAddress.setPostal_num("0000" + i);
        additionalAddress.setAddress("주소1");
        additionalAddress.setDetail_address("상세주소" + i);
        additionalAddress.setPhone_num("전화번호" + i);
        additionalAddress.setRequest("배송 요청 사항1111111111111111111111111111111111111"+ i);
        addressList.add(additionalAddress);
    }
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	<link href="../resources/css/address/address.css" rel="stylesheet" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div id="addr-choice">
        <div><h2>배송지 선택</h2></div>
        <hr>
        <div>
            <% int displayLimit = 3; // 한 번에 보여줄 주소의 개수 %>
            <% for (int i = 0; i < Math.min(addressList.size(), displayLimit); i++) { %>
                <div class="addr-list">
                    <div class="addr-info">
                        <div class="recipient">
                            <div class="name"><%= addressList.get(i).getRecipient() %></div>
                            <div class="base"><%= (addressList.get(i).getBase() == 1) ? "기본 배송지" : "" %></div>
                        </div>
                        <div class="postal-code">[<%= addressList.get(i).getPostal_num() %>]</div>
                        <div class="addr"><%= addressList.get(i).getAddress() %></div>
                        <div class="addr-detail"><%= addressList.get(i).getDetail_address() %></div>
                        <div class="phn"><%= addressList.get(i).getPhone_num() %></div>
                        <div class="request"><%= addressList.get(i).getRequest() %></div>
                    </div>
                    <div class="button">
                        <button class="edit">수정하기</button>
                        <button class="delete">삭제하기</button>
                        <button class="choice">선택하기</button>
                    </div>
                </div>
                <hr>
            <% } %>
            <div class="collapse" id="additionalAddresses">
                <% for (int i = displayLimit; i < addressList.size(); i++) { %>
                    <!-- 추가적인 주소 정보 출력 부분 -->
                    <div class="addr-list">
                        <div class="addr-info">
                            <div class="recipient">
                            <div class="name"><%= addressList.get(i).getRecipient() %></div>
                            <div class="base"><%= (addressList.get(i).getBase() == 1) ? "기본 배송지" : "" %></div>
                        </div>
                        <div class="postal-code">[<%= addressList.get(i).getPostal_num() %>]</div>
                        <div class="addr"><%= addressList.get(i).getAddress() %></div>
                        <div class="addr-detail"><%= addressList.get(i).getDetail_address() %></div>
                        <div class="phn"><%= addressList.get(i).getPhone_num() %></div>
                        <div class="request"><%= addressList.get(i).getRequest() %></div>
                        </div>
                        <div class="button">
                           	<button class="edit">수정하기</button>
	                        <button class="delete">삭제하기</button>
	                        <button class="choice">선택하기</button>
                        </div>
                    </div>
                    <hr>
                <% } %>
            </div>
            <% if (addressList.size() > displayLimit) { %>
                <div class="show-more" data-bs-toggle="collapse" data-bs-target="#additionalAddresses" aria-expanded="false" aria-controls="additionalAddresses">▼</div>
            <% } %>
        </div>
        <br>
        <div>
            <button id="add">새 배송지 추가하기</button>
            <button id="close">확인</button>
        </div>
    </div>
</body>
</html>
