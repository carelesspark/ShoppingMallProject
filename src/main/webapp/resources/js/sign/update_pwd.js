function validateForm(form, event) {
	var pwd1 = form.pwd.value;
	var pwd2 = form.pwd2.value;
	var notice = document.querySelector("#mcf p");

	var letterRegex = /[a-zA-Z]/;
	var numberRegex = /\d/;

	if (!(pwd1.length >= 8 && letterRegex.test(pwd1) && numberRegex.test(pwd1))) {
		notice.style.color = "#e31100";
		notice.innerHTML = "비밀번호는 영문자, 숫자를 포함해 8 글자 이상을 입력해야합니다.";
		event.preventDefault();

		return false;
	}

	if (pwd1 !== pwd2) {
		notice.style.color = "#e31100";
		notice.innerHTML = "같은 비밀번호를 입력해주세요.";
		event.preventDefault();

		return false;
	}

	return true;
}