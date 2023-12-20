const ID_I = document.getElementById("mcf-id");
const ID_N = document.getElementById("id-dupl-p");
const ID_B = document.getElementById("id-dupl-btn");
const PWD_I1 = document.getElementById("mcf-p1");
const PWD_N1 = document.getElementById("pwd-check");
const PWD_I2 = document.getElementById("mcf-p2");
const PWD_N2 = document.getElementById("pwd-dupl");
const EM_I = document.getElementById("mcf-e");
const EM_B = document.getElementById("email-dupl-btn");

const CB_D = document.getElementById("mcf-cb");
const CB1 = document.getElementById("cb1");
const CB2 = document.getElementById("cb2");
const CB3 = document.getElementById("cb3");

const idRegex = /^[a-zA-Z][a-zA-Z0-9]{3,}$/;
const pwdRegex = /^(?=.*[a-zA-Z])(?=.*\d).{8,}$/;
const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

// 아이디 실시간 검증
ID_I.addEventListener("input", function() {
	var id = ID_I.value;

	if (idRegex.test(id)) {
		ID_N.style.color = "#4b89dc";
	} else {
		ID_N.style.color = "#e31100";
	}
});

// 아이디 중복 확인
ID_B.addEventListener("click", function(event) {
	var id = ID_I.value;

	if (!idRegex.test(id)) {
		event.preventDefault();
		alert("사용 가능한 아이디를 입력해 주세요.");
	} else {
		$.ajax({
			type : "POST",
			url : "/sign/checkIdDupl.do",
			data : {
				id : id,
			},
			success : function(response) {
				if (response === "None duplicate id") {
					alert("사용 가능한 아이디입니다.");
					document.getElementById("id-dupl-cb").checked = true;
				} else {
					alert("이미 사용중인 아이디입니다.");
					event.preventDefault();
				}
			},
			error : function(error) {
				alert("서버 오류가 발생했습니다.");
				event.preventDefault();
			},
		});
	}
});

// 비밀번호 실시간 검증
PWD_I1.addEventListener("input", function() {
	var pwd = PWD_I1.value;

	if (pwdRegex.test(pwd)) {
		PWD_N1.style.color = "#4b89dc";
	} else {
		PWD_N1.style.color = "#e31100";
	}

});

// 같은 비밀번호 입력했는지 실시간 검증
PWD_I2.addEventListener("input", function() {

	var pwd1 = PWD_I1.value;
	var pwd2 = PWD_I2.value;

	if (pwd1 === pwd2) {
		PWD_I2.style.marginBottom = "30px";
		PWD_N2.style.display = "none";
	} else {
		PWD_I2.style.marginBottom = "5px";
		PWD_N2.style.display = "block";
		PWD_N2.style.color = "#e31100";
	}
});

// 이메일 중복 확인
EM_B.addEventListener("click", function(event) {
	var user_email = EM_I.value;

	if (!emailRegex.test(user_email)) {
		event.preventDefault();
		alert("이메일을 입력해 주세요.");
	} else {
		$.ajax({
			type : "POST",
			url : "/sign/checkEmailDupl.do",
			data : {
				user_email : user_email,
			},
			success : function(response) {
				if (response === "None duplicate email") {
					alert("사용 가능한 이메일입니다.");
					document.getElementById("email-dupl-cb").checked = true;
				} else {
					alert("이미 사용중인 이메일입니다.");
					event.preventDefault();
				}
			},
			error : function(error) {
				alert("서버 오류가 발생했습니다.");
				event.preventDefault();
			},
		});
	}
});

// 체크박스 실시간 검증
CB_D.addEventListener("change", function() {
	var checkDiv = document.getElementById("mcf-cb-check");

	// 모든 체크박스가 체크되지 않은 경우
	if (!CB1.checked || !CB2.checked || !CB3.checked) {
		CB_D.style.marginBottom = "5px";
		checkDiv.style.display = "block"; // 메시지 보이기
	} else {
		document.getElementById("mcf-cb").style.marginBottom = "40px";
		checkDiv.style.display = "none"; // 메시지 감추기
	}

});

function validateForm(form, event) {
	var id = form.id.value;
	var pwd1 = form.pwd.value;
	var pwd2 = form.pwd2.value;
	var name = form.user_name.value;
	var email = form.user_email.value;

	var cbi = document.getElementById("id-dupl-cb");
	var cbe = document.getElementById("email-dupl-cb");
	var cb1 = document.getElementById("cb1");
	var cb2 = document.getElementById("cb2");
	var cb3 = document.getElementById("cb3");

	// 빈칸 있는지 확인
	if (id === "" || pwd1 === "" || pwd2 === "" || name === "" || email === "") {
		alert("모든 정보를 기입해 주세요.");

		event.preventDefault();
		return false;
	}

	// 체크박스 확인
	if (!(cbi.checked && cbe.checked && cb1.checked && cb2.checked && cb3.checked)) {
		alert("모든 체크박스가 체크되어 있어야 합니다.");

		event.preventDefault();
		return false;
	}

	// 아이디 확인
	if (!idRegex.test(id)) {
		alert("아이디를 다시 입력해 주세요.");

		event.preventDefault();
		return false;
	}

	// 비밀번호 확인
	if (!pwdRegex.test(pwd1)) {
		alert("비밀번호를 다시 입력해 주세요.");

		event.preventDefault();
		return false;
	}

	// 비밀번호 같은지 확인
	if (pwd1 !== pwd2) {
		alert("같은 비밀번호를 입력해 주세요.");

		event.preventDefault();
		return false;
	}

	// 이메일 확인
	if (!emailRegex.test(email)) {
		alert("이메일을 다시 입력해 주세요.");

		event.preventDefault();
		return false;
	}

};
