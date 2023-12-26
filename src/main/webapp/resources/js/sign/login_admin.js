function validateForm(form, event) {
	var errorMsg = document.getElementById('em');

	if (form.id.value === "") {
		errorMsg.innerHTML = "아이디를 입력해 주세요.";
		event.preventDefault();

		return false;
	}
	if (form.pwd.value === "") {
		errorMsg.innerHTML = "비밀번호를 입력해 주세요.";
		event.preventDefault();

		return false;
	}

	return true;
}