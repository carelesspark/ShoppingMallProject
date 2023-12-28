<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="c">
	<div id="cc">
		<div id="cc-r">
			<div id="cc-rb">${rank_letter}</div>
		</div>
		<div id="cc-u">
			<div id="cc-un">${sessionScope.user_name}님&nbsp;환영합니다.</div>
			<div id="cc-ur">${user_rank}</div>
		</div>
		<div id="cc-d">
			<div id="cc-dn">준비/배송 중</div>
			<div id="cc-dc">
				<div>
					<a href="/user/orderList.do">${delivering_items }</a>건
				</div>
			</div>
		</div>
		<div id="cc-p">
			<div id="cc-pn">포인트</div>
			<div id="cc-pc">
				<div>
					<a href="/user/pointList.do">${user_total_point }</a>원
				</div>
			</div>
		</div>
	</div>
</div>