if (document.readyState !== "loading") {
	onReady();
} else {
	document.addEventListener("DOMContentLoaded", onReady);
}

function onReady() {
	var loginDiv = document.getElementById('login');
	var loginTextInput = loginDiv.lastElementChild.lastElementChild;
	var $loginParagraph = $("<p>");

	var emailDiv = document.getElementById('email');
	var emailTextInput = emailDiv.lastElementChild.lastElementChild;
	var $emailParagraph = $("<p>");

	var confirmButton = document.querySelector('[type=submit]');
		
	loginTextInput.onkeyup = function(){ 
		validate('/userNameValidate', loginTextInput, $loginParagraph, loginDiv)
	}
	
	emailTextInput.onkeyup = function(){
		validate('/emailValidate', emailTextInput, $emailParagraph, emailDiv) 
	}
	
	function validate(path, textInput, $paragraph, div){
		var timeout = null;
		clearTimeout(timeout);
		timeout = setTimeout(function() {
			$(div).append($paragraph);
			$.post(path, {
				variable : textInput.value
			}, function(text) {			
				$paragraph.text(text);
				if($loginParagraph.text() == "dobrze" && $emailParagraph.text() == "dobrze"){
					confirmButton.disabled = false;
				}else{
					confirmButton.disabled = true;
				}
			})
		}, 500);	
	}
}