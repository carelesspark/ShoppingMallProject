function validateForm(form, event) {

	if (form.id.value === "" || form.pwd.value === "") {
		alert("모든 정보를 기입해 주세요.");
		event.preventDefault();

		return false;
	}

	return true;
}