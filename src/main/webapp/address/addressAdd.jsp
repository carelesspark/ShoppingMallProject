<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
    	*{
    		margin-top:2px;
    		margin-bottom: 2px;
    		
    	}
        body {
            font-family: Arial, sans-serif;
        }

		
		hr {
            margin: 10px 0;
            border: 1px solid black;
        }
        
        #addr-add {
            width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid black;
            border-radius: 40px;
        }
        

        #addr-add h2 {
            text-align: center;
        }
        
        #search{
        	border: 1px solid black;
        }
 
        button {
            margin-top: 10px;
            background-color: white;
            border-color: black;
            height: 30px;
            cursor: pointer;
        }
        
        #search{
        	cursor: pointer;
        }
        
        #base{
        	height: auto;
        }
        
        input{
        	height: 30px;
        }
        button#add,
        button#close,
        .full{
            width: 100%;
        }
        
        #postalCode {
		    display: flex;
		    flex-direction: row;
		    justify-content: space-between; /* 변경된 부분 */
		    align-items: center;
		}
		
		#postal {
		    width: 385px; 
		    }
		    
		.marg{
			margin-bottom: 8px;
			margin-top: 8px;
		}


       
        
        
    </style>
</head>
<body>
    <div id="addr-add">
        <div><h2>배송지 추가</h2></div>
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
        <div id="bottom">
            <button id="add">추가하기</button>
            <button id="close">닫기</button>
        </div>
    </div>
	<script>

	</script>
</body>
</html>
