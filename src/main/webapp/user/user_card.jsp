<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="c">
	<div id="cc">
		<div id="cc-r">
			<div id="cc-rb"></div>
		</div>
		<div id="cc-u">
			<div id="cc-un">${sessionScope.user_name}님</div>
			<div id="cc-ur">${user_rank }</div>
		</div>
		<div id="cc-d">
			<div id="cc-dn">배송중</div>
			<div id="cc-dc">
				<a href="/user/orderList.do">$0</a>건
			</div>
		</div>
		<div id="cc-p">
			<div id="cc-pn">포인트</div>
			<div id="cc-pc">
				<a href="/user/pointList.do">${user_point }</a>원
			</div>
		</div>
	</div>
</div>