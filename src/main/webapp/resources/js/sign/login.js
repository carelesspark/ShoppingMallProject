function validateForm(form, event) {
	var errorMsg = document.getElementById('em');
	document.querySelector('#mcf input[type="password"]').style.marginBottom = '5px';
	document.getElementById('em').style.display = 'block';

	if (form.id.value.trim() === "") {
		errorMsg.innerHTML = "아이디를 입력해 주세요.";
		event.preventDefault();

		return false;
	}
	if (form.pwd.value.trim() === "") {
		errorMsg.innerHTML = "비밀번호를 입력해 주세요.";
		event.preventDefault();

		return false;
	}

	return true;
}

function setSavedId() {
	var savedIdCookie = getCookie('savedId');

	if (savedIdCookie !== null && savedIdCookie !== '') {
		document.querySelector('#mcf input[name="id"]').value = savedIdCookie;
	}
}

function getCookie(cookieName) {
	var name = cookieName + '=';
	var decodedCookie = decodeURIComponent(document.cookie);
	var cookieArray = decodedCookie.split(';');
	for (var i = 0; i < cookieArray.length; i++) {
		var cookie = cookieArray[i].trim();
		if (cookie.indexOf(name) === 0) {
			return cookie.substring(name.length, cookie.length);
		}
	}
	return null;
}

// Call setSavedId when the DOM is ready
document.addEventListener('DOMContentLoaded', function() {
	setSavedId();
});