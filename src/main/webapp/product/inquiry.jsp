<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="../resources/css/product/inquiry.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container-fluid">
		<div class="container col-md-8">
			<form>
				<div class="mb-3">
					<label for="title" class="form-label">제목</label> <input type="text"
						class="form-control" id="title" placeholder="" />
				</div>
				<div class="mb-3">
					<label for="content" class="form-label">내용</label>
					<textarea class="form-control" id="content" rows="15"
						placeholder="상세한 내용을 작성해주세요"></textarea>
				</div>

				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-primary">문의 등록</button>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>


</html>