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
		<h1>게시물 작성</h1>
		<hr style="height: 3px; background-color: black;">
		
		<form action="/board/boardWrite.jsp" method="post">
			<div class="title">
				<label>제목</label>
				<input type="text" name="writer">
			</div>
			
			<div class="uploadImg">
				<label>
					파일 올리기<br>
					<input type="file" name="photo">				
				</label>
				
				<div class="preview">
					<div class="each_preview">
						<img alt="미리보기이미지" src="../resources/image/boardIMG/post.jpg">
						<div class="x">x</div>
					</div>
					
					<div class="each_preview">
						<img alt="미리보기이미지" src="../resources/image/boardIMG/post.jpg">
						<div class="x">x</div>
					</div>
					
					<div class="each_preview">
						<img alt="미리보기이미지" src="../resources/image/boardIMG/post.jpg">
						<div class="x">x</div>
					</div>
					
					<div class="each_preview">
						<img alt="미리보기이미지" src="../resources/image/boardIMG/post.jpg">
						<div class="x">x</div>
					</div>
				</div>
			</div>
			
			<div class="category">
				<select name="cate">
					<option>카테고리를 골라주세요</option>
					<option>없음</option>
					<option>오오티디</option>
					<option>트렌드</option>
					<option>스트릿</option>
					<option>캐주얼</option>
					<option>클래식</option>
					<option>빈티지</option>
				</select>
			</div>
			
			
			<div class="select">		
				<input type="text" id="searchWord" list="like" placeholder="태그할 상품 검색">
				<input type="submit" value="확인" id="search">
				<datalist id="like">
					<option value="옷">
					<option value="상의">
					<option value="바지">
					<option value="신발">
					<option value="신발">
					<option value="양말">
					<option value="안경">
					<option value="안경">
				</datalist>
				
				<div class="selected">
					<input type="text" readonly="readonly" name="product_code">
					<button>삭제</button>
				</div>
			</div>
			
			<div class="buttonBox">
				<input type="button" value="미리보기">
				<input type="button" value="취소">
				<input type="submit" value="등록">
			</div>
		</form>
	</div>
</body>
</html>