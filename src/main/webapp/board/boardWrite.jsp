<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/boardCSS/boardWrite.css">
<script src="../resources/js/boardJS/code.jquery.com_jquery-3.7.0.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<h1>게시물 작성</h1>
		<hr style="height: 3px; background-color: black;">
		
		<form action="boardWrite.do" method="post" enctype="multipart/form-data">
			<div class="title">
				<label>제목</label>
				<input type="text" name="title">
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
			
			<div class="select">		
				<input type="text" id="searchWord" list="like" placeholder="태그할 상품 검색" name="select">
				<input type="button" value="확인" id="search" onclick="input()">
				<datalist id="like">
					<c:forEach items="${product }" var="product">
						<option value="${product.product_num }" label="${product.product_name }">
					</c:forEach>
				</datalist>
				
				<div class="selected">
				
				</div>
			</div>
			
			<div class="buttonBox">
				<input type="button" value="취소" onclick="location.href='/boardMain.do'">
				<input type="submit" value="등록">
			</div>
		</form>
	</div>
	<script type="text/javascript">
		var input = function() {
			if($('input').length >= 17) {
				alert('태그는 5개까지 입니다.');
				return;
			}
			
			$('.selected').append('<input type="text" readonly="readonly" name="product_num[]" value=' + document.getElementById('searchWord').value + ' class="box"><br>');
		
		}
	</script>
</body>
</html>