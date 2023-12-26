function validateForm(form, event) {
	if (form.authNum.value.trim() === "") {
		alert("인증번호를 입력해 주세요.");
		event.preventDefault();

		return false;
	}

	return true;
}