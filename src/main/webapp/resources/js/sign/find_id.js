function validateForm(form, event) {
	if (form.user_name.value.trim() === "") {
		alert("이름을 입력해 주세요.");
		event.preventDefault();

		return false;
	}
	if (form.user_email.value.trim() === "") {
		alert("이메일을 입력해 주세요.");
		event.preventDefault();

		return false;
	}

	return true;
}