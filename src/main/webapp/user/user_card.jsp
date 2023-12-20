<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/user/user_card.css" />

<div id="c">
	<div id="cc">
		<div id="cc-r">
			<div id="cc-rb">$S</div>
		</div>
		<div id="cc-u">
			<div id="cc-un"></div>
			<div id="cc-ur">$Silver</div>
		</div>
		<div id="cc-c">
			<div id="cc-cn">쿠폰</div>
			<div id="cc-cc">
				<a href="">$2</a>장
			</div>
		</div>
		<div id="cc-d">
			<div id="cc-dn">배송중</div>
			<div id="cc-dc">
				<a href="">$0</a>건
			</div>
		</div>
		<div id="cc-p">
			<div id="cc-pn">포인트</div>
			<div id="cc-pc">
				<a href="">$5000</a>원
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
<!--
세션에 저장되어 있는 정보들로 빈칸 채우기
//-->
document.getElementById('cc-un').textContent = '${sessionScope.user_name}님';

</script>