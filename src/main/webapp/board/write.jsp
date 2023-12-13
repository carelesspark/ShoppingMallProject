<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* * {
	border: 1px solid black;
} */

html, body {
	height: 100%;
}

.wrapper {
	padding: 10px 0 0 15%;
	height: 100%;
	display: flex;
}

.img_box {
	width: 60%;
	display: flex;
	flex-wrap: wrap;
	height: 80%;
}

.each_img {
	margin: 10px 10px;
	width: 40%;
}

.file_upload {
	display: flex;
	justify-content: center;
	background-color: #f1f1f1;
	height: 100%;
	align-items: center;
}

.file {
	visibility: hidden;
}

.content {
	width: 40%;
	height: 80%;
}

.title {
	width: 100%;
	margin-bottom: 20px;
}

.title input {
	width: 80%;
}

.cate {
	margin-bottom: 20px;
}

.cate select {
	width: 80%;
}

.search input {
	width: 80%;
}

.search {
	margin-bottom: 20px;
}

.button {
	display: flex;
	justify-content: flex-end;
}

.button input {
	background-color: white;
	width: 100px;
	height: 50px;
	border: 1px solid;
	margin-right: 10px;
}

.select {
	height: 70%;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="wrapper">
		<div class="img_box">
			<div class="each_img">
				<div class="file_upload">
					<label>+</label>
				</div>
				<input type="file" class="file">
			</div>
			
			<div class="each_img">
				<div class="file_upload">
					<label>+</label>
				</div>
				<input type="file" class="file">
			</div>
			
			<div class="each_img">
				<div class="file_upload">
					<label>+</label>
				</div>
				<input type="file" class="file">
			</div>
			
			<div class="each_img">
				<div class="file_upload">
					<label>+</label>
				</div>
				<input type="file" class="file">
			</div>
		</div>
		
		<div class="content">
			<div class="title">
				<label>제목 </label>
				<input type="text">
			</div>
			
			<div class="cate">
				<label>태그</label>
				<select>
					<option></option>
					<option>오오티디</option>
					<option>트렌드</option>
					<option>스트릿</option>
					<option>캐주얼</option>					
					<option>클래식</option>					
					<option>빈티지</option>					
				</select>
			</div>
			
			<div class="search">
				<input type="text" placeholder="착용 상품 검색">
				<img alt="검색" src="./resources/images/search.png" style="width: 10px; height: 10px;">
			</div>
			
			<div class="select">
				<img alt="미리보기" src="./resources/images/search.png" style="width: 60px;">
				<textarea rows="" cols="" readonly="readonly" style="resize: none; width: 70%; height: 60px; border: none;">에시 예시</textarea>
			</div>
			
			<div class="button">
				<input type="submit" value="등록">
				<input type="button" value="취소">
			</div>
		</div>
	</div>
</body>
</html>