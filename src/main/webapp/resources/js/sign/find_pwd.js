function validateForm(form, event) {
	if (form.id.value === "") {
		alert("아이디를 입력해 주세요.");
		event.preventDefault();

		return false;
	}
	if (form.user_email.value === "") {
		alert("이메일을 입력해 주세요.");
		event.preventDefault();

		return false;
	}

	return true;
}