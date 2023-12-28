<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/boardCSS/boardWrite.css">
<script src="../resources/js/boardJS/code.jquery.com_jquery-3.7.0.min.js"></script>
</head>
<body>
<%@ include file="../header.jsp"%>
	<div class="wrapper">
		<h1>게시물 작성</h1>
		<hr style="height: 3px; background-color: black;">
		
		<form action="editBoard.do?pno=${board.pno }" method="post" enctype="multipart/form-data">
			<div class="title">
				<label>제목</label>
				<input type="text" name="title" value="${board.title }">
			</div>
			
			<div class="uploadImg">
				<input type="file" name="file" accept="image/*" multiple="multiple">
			</div>
			
			<div class="category">
				<select name="ctgr_num">
					<option value="0">카테고리를 골라주세요</option>
					<option value="0">없음</option>
					<option value="1">오오티디</option>
					<option value="2">트렌드</option>
					<option value="3">스트릿</option>
					<option value="4">캐주얼</option>
					<option value="5">클래식</option>
					<option value="6">빈티지</option>
				</select>
			</div>
			
			<div class="buttonBox">
				<input type="button" value="취소" onclick="location.href='/boardGet.do?pno=${board.pno}'">
				<input type="submit" value="수정">
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
		var count = 1;
		var input = function() {
			if($('input').length >= 17) {
				alert('태그는 5개까지 입니다.');
				return;
			}
			
			$('.selected').append('<input type="text" readonly="readonly" name="product_code' + count + '"  value=' + document.getElementById('searchWord').value + ' class="box"><br>');
			
			count++;
		}
	</script>
	<%@ include file="../footer.jsp"%>
</body>
</html>