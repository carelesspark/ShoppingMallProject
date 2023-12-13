<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/boardCSS/boardWrite.css">
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
				<img alt="검색" src="../resources/image/boardIMG/search.png">
			</div>
			
			<div class="select">
				<img alt="미리보기" src="../resources/image/boardIMG/search.png" style="width: 60px;">
				<textarea rows="" cols="" readonly="readonly">에시 예시</textarea>
			</div>
			
			<div class="button">
				<input type="submit" value="등록">
				<input type="button" value="취소">
			</div>
		</div>
	</div>
</body>
</html>