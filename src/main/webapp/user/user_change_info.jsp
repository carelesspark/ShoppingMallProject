<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user/user_change_info.css?v=1.3" />

<title>user change info</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div id="m">
		<div id="c">
			<div id="cc">
				<div id="cc-r">
					<div id="cc-rb">
						<c:out value="${rank_letter}" />
					</div>
				</div>
				<div id="cc-u">
					<div id="cc-un">${sessionScope.user_name}님&nbsp;환영합니다.</div>
					<div id="cc-ur">
						<c:out value="${user_rank}" />
					</div>
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
		<div id="mc">
			<%@ include file="./user_side.jsp"%>
			<main>
				<div id="md">
					<div id="mt">
						<div id="mtd">회원정보 변경</div>
					</div>
					<div id="mainDiv">
						<!-- 회원정보 변경 부분 -->
						<!-- 아이디 패스워드 전화번호 이메일을 보여주는데 변경 가능한 변수는 비번, 이메일과 비밀번호  -->
						<div id="infoDiv">
							<div id="idDiv">
								<div class="oValueDiv">
									<div class="oName">아이디</div>
									<div class="oValue">${id}</div>
									<div class="cBtnHidden"></div>
								</div>
							</div>
							<div id="pwdDiv">
								<div class="oValueDiv">
									<div class="oName">비밀번호</div>
									<div class="oValue" id="starPwd"></div>
									<div class="cBtn">
										<button onclick="showHDivPwd()">변경</button>
									</div>
								</div>
								<form method="post" onsubmit="valPwd(this, event);"
									class="nValueDiv" id="pwdHD">
									<label class="nName">변경할 비밀번호</label> <input class="nValue"
										name="pwd" id="ipwd">
									<button type="button" onclick="canclePwd();">취소</button>
									<button type="submit">결정</button>
								</form>
							</div>
							<div id="phoneDiv">
								<div class="oValueDiv">
									<div class="oName">전화번호</div>
									<div class="oValue" id="oPNum">${user_phone}</div>
									<div class="cBtn">
										<button onclick="showHDivPhone()">변경</button>
									</div>
								</div>
								<form method="post" onsubmit="valPhone(this, event);"
									class="nValueDiv" id="phoneHD">
									<label class="nName">변경할 전화번호</label> <input class="nValue"
										name="user_phone" id="iphone">
									<button type="button" onclick="canclePhone();">취소</button>
									<button type="submit">결정</button>
								</form>
							</div>
							<div id="emailDiv">
								<div class="oValueDiv">
									<div class="oName">이메일</div>
									<div class="oValue">${user_email}</div>
									<div class="cBtn">
										<button onclick="showHDivEmail()">변경</button>
									</div>
								</div>
								<form method="post" onsubmit="valEmail(this, event);"
									class="nValueDiv" id="emailHD">
									<label class="nName">변경할 이메일</label> <input class="nValue"
										name="user_email" id="iemail">
									<button type="button" onclick="cancleEmail();">취소</button>
									<button type="submit">결정</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>

	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script type="text/javascript">
		var pwd = '${pwd }';
		var divForStar = document.getElementById('starPwd');
		var stars = '*'.repeat(pwd.length);
		divForStar.innerText = stars;

		function valPwd(form, event) {
			const pwdRegex = /^(?=.*[a-zA-Z])(?=.*\d).{8,}$/;
			const passwordInput = document.getElementById('ipwd');
			const password = passwordInput.value;

			if (password === '${pwd}') {
				alert("같은 비밀번호를 입력했습니다.");
				event.preventDefault();
				return false;
			}
			if (!pwdRegex.test(password)) {
				alert("유효한 비밀번호를 입력해 주세요.");
				event.preventDefault();
				return false;
			}

			$.ajax({
				type : "POST",
				url : "/user/updatePwd.do",
				data : {
					pwd : password,
				},
				success : function(response) {
					if (response === "update failed") {
						alert("비밀번호 변경에 실패했습니다.");
					} else {
						alert("비밀번호 변경에 성공했습니다.");

						var pwd = '${pwd }';
						var stars = '*'.repeat(pwd.length);
						document.getElementById('starPwd').innerText = stars;
					}
				},
				error : function(error) {
					alert("비밀번호 변경에 실패했습니다.");
				}
			});

		}

		function valPhone(form, event) {
			const phoneRegex = /^\d{3}-\d{4}-\d{4}$/;
			const phoneInput = document.getElementById('iphone');
			const phone = phoneInput.value;

			if (phone === '${user_phone}') {
				alert("같은 전화번호를 입력했습니다.");
				event.preventDefault();
				return false;
			}
			if (!phoneRegex.test(phone)) {
				alert("유효한 전화번호를 입력해 주세요.");
				event.preventDefault();
				return false;
			}

			$.ajax({
				type : "POST",
				url : "/user/updatePhone.do",
				data : {
					user_phone : phone,
				},
				success : function(response) {
					if (response === "update failed") {
						alert("전화번호 변경에 실패했습니다.");

						event.preventDefault();
						return false;
					} else {
						alert("전화번호 변경에 성공했습니다.");

						var pNum = '${user_phone}';
						document.getElementById('oPNum').innerText = pNum;
					}
				},
				error : function(error) {
					alert("전화번호 변경에 실패했습니다.");
				}
			});
		}
		function valEmail(form, event) {
			const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
			const emailInput = document.getElementById('iemail');
			const email = emailInput.value;

			if (email === '${user_email}') {
				alert("같은 이메일을 입력했습니다.");
				event.preventDefault();
				return false;
			}
			if (!emailRegex.test(email)) {
				alert("유효한 이메일을 입력해 주세요.");
				event.preventDefault();
				return false;
			}

			return true;
		}
	</script>

	<script type="text/javascript">
		function showHDivPwd() {
			var hiddenDiv = document.getElementById('pwdHD');

			if (hiddenDiv.style.display == "grid") {
				hiddenDiv.style.display = "none";
			} else {
				hiddenDiv.style.display = "grid";
			}
		}
		function showHDivPhone() {
			var hiddenDiv = document.getElementById('phoneHD');

			if (hiddenDiv.style.display == "grid") {
				hiddenDiv.style.display = "none";
			} else {
				hiddenDiv.style.display = "grid";
			}
		}
		function showHDivEmail() {
			var hiddenDiv = document.getElementById('emailHD');

			if (hiddenDiv.style.display == "grid") {
				hiddenDiv.style.display = "none";
			} else {
				hiddenDiv.style.display = "grid";
			}
		}

		function canclePwd() {
			document.getElementById('pwdHD').style.display = "none";
			document.getElementById('ipwd').value = "";
		}
		function canclePhone() {
			document.getElementById('phoneHD').style.display = "none";
			document.getElementById('iphone').value = "";
		}
		function cancleEmail() {
			document.getElementById('emailHD').style.display = "none";
			document.getElementById('iemail').value = "";
		}

		var rank = '${user_rank}';
		var rankBadge = document.getElementById('cc-rb');

		if ('${user_rank}' === 'BRONZE') {
			rankBadge.innerText = 'B';
			rankBadge.style.color = '#B87333';
		} else if (rank === 'SILVER') {
			rankBadge.innerText = 'S';
			rankBadge.style.color = '#CCCCCC';
		} else if (rank === 'GOLD') {
			rankBadge.innerText = 'G';
			rankBadge.style.color = '#FFD700';
		} else if (rank === 'DIAMOND') {
			rankBadge.innerText = 'D';
			rankBadge.style.color = '#EEEEEE';
		} else if (rank === 'VIP') {
			rankBadge.innerText = 'V';
			rankBadge.style.color = '#8A2BE2';
		} else if (rank === 'ADMIN') {
			rankBadge.innerText = 'A';
			rankBadge.style.color = '#DD2476';
		}
	</script>
</body>
</html>