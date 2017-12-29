if (document.readyState !== "loading") {
	onReady();
} else {
	document.addEventListener("DOMContentLoaded", onReady);
}

function onReady() {
	var loginDiv = document.getElementById('login');
	var loginTextInput = loginDiv.lastElementChild.lastElementChild;
	var $loginParagraph = $("<p>");
	var timeout1 = null;

	var emailDiv = document.getElementById('email');
	var emailTextInput = emailDiv.lastElementChild.lastElementChild;
	var $emailParagraph = $("<p>");
	var timeout2 = null;

	loginTextInput.onkeyup = function() {
		clearTimeout(timeout1);
		timeout1 = setTimeout(function() {
			$(loginDiv).append($loginParagraph);
			$loginParagraph.text(validate('/userNameValidate', loginTextInput, $loginParagraph));
		}, 500);
	}

	emailTextInput.onkeyup = function() {
		clearTimeout(timeout1);
		timeout1 = setTimeout(function() {
			$(emailDiv).append($emailParagraph);
			$emailParagraph.text(validate('/emailValidate', emailTextInput,	$emailParagraph));
		}, 500);
	}
}

function validate(path, textInput, $p) {
	$.post(path, {
		variable : textInput.value
	}, function(text) {
		$p.text(text);
	})
}