<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/CSS/board.css?ver=1">
<script src="resources/js/code.jquery.com_jquery-3.7.0.min.js"></script>
<script src="resources/js/board.js"></script>
<link >
</head>
<body>
	<div class="wrapper">
		<div class="board">
			게시판
		</div>
		<hr>
		<div class="tag_container">
			<nav class="tag_btn_container">
				<ul class="tag">
					<li class="tag_tab" onclick="change('all')">
						<img alt="전체 보기" src="./resources/images/all.png">
						<p>전체 보기</p>
					</li>
					
					<li class="tag_tab" onclick="change('ootd')">
						<img alt="오오티디" src="./resources/images/ootd.jpg">
						<p>오오티디</p>
					</li>
					
					<li class="tag_tab" onclick="change('trend')">
						<img alt="트렌드" src="./resources/images/trend.jpg">
						<p>트렌드</p>
					</li>
					
					<li class="tag_tab" onclick="change('street')">
						<img alt="스트릿" src="./resources/images/street.jpg">
						<p>스트릿</p>
					</li>
					
					<li class="tag_tab" onclick="change('casual')">
						<img alt="캐주얼" src="./resources/images/casual.jpg">
						<p>캐주얼</p>
					</li>
					
					<li class="tag_tab" onclick="change('classic')">
						<img alt="클래식" src="./resources/images/classic.jpg">
						<p>클래식</p>
					</li>
					
					<li class="tag_tab" onclick="change('vintage')">
						<img alt="빈티지" src="./resources/images/vintage.jpg">
						<p>빈티지</p>
					</li>
				</ul>
			</nav>
			<hr>
		</div>
		
		<div class="feed_container">
			<div class="feed">
				
			</div>
		</div>
	</div>
</body>
</html>