<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dazzle.shop.address.*" %>
<%@ page import="java.util.ArrayList" %>
<%
    // AddressVO 객체 리스트 생성
    List<AddressVO> addressList = new ArrayList();
    
    // AddressVO 객체 생성 및 리스트에 추가 (실제로는 데이터베이스나 다른 소스로부터 가져와야 함)
    AddressVO address1 = new AddressVO();
    address1.setBase(1);
    address1.setName("홍길동");
    address1.setPostalCode("[우편번호1]");
    address1.setAddr("주소1");
    address1.setDetailAddr("상세주소1");
    address1.setPhoneNumber("전화번호1");
    address1.setRequest("배송 요청 사항1");
    addressList.add(address1);

    for (int i = 2; i <= 8; i++) {
        AddressVO additionalAddress = new AddressVO();
        additionalAddress.setBase(0);
        additionalAddress.setName("추가주소" + i);
        additionalAddress.setPostalCode("[우편번호" + i + "]");
        additionalAddress.setAddr("주소" + i);
        additionalAddress.setDetailAddr("상세주소" + i);
        additionalAddress.setPhoneNumber("전화번호" + i);
        additionalAddress.setRequest("배송 요청 사항" + i);
        addressList.add(additionalAddress);
    }
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        #addr-choice {
            width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid black;
            border-radius: 40px;
        }

        #addr-choice h2 {
            text-align: center;
        }

        .addr-list {
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
            margin-bottom: 20px;
        }

        .addr-info {
            width: 70%;
        }

        .recipient {
            display: flex;
            align-items: center;
        }

        .name {
            font-size: 1.2em;
            margin-right: 2px;
            font-weight: bold;
        }

        .base {
            color: green;
            font-size: 0.9em;
            margin-left: 5px;
        }

        .button {
            width: 400px;
            display: flex;
            flex-direction: row;
            justify-content: flex-end;
            align-items: flex-end;
            margin-top: auto; 
        }

        .button button {
            margin-left: 5px;
            margin-top: 5px; 
        }

        .show-more {
            cursor: pointer;
            display: block;
            text-align: center;
        }


        hr {
            margin: 10px 0;
            border: 1px solid black;
        }

        button {
        	height: 30px;
            margin-top: 10px;
            background-color: white;
            border-color: black;
            cursor: pointer;
        }
        button#add,
        button#close {
            width: 100%;
        }

        
    </style>
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
                            <div class="name"><%= addressList.get(i).getName() %></div>
                            <div class="base"><%= (addressList.get(i).getBase() == 1) ? "기본 배송지" : "" %></div>
                        </div>
                        <div class="postal-code"><%= addressList.get(i).getPostalCode() %></div>
                        <div class="addr"><%= addressList.get(i).getAddr() %></div>
                        <div class="addr-detail"><%= addressList.get(i).getDetailAddr() %></div>
                        <div class="phn"><%= addressList.get(i).getPhoneNumber() %></div>
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
            <% if (addressList.size() > displayLimit) { %>
                <div class="show-more" onclick="toggleAddrList()">▼</div>
            <% } %>
        </div>
        <div>
            <button id="add">새 배송지 추가하기</button>
            <br>
            <button id="close">확인</button>
        </div>
    </div>
	<script>

	</script>
</body>
</html>
