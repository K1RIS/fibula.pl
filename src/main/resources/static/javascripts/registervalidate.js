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
		
	loginTextInput.addEventListener("keyup", validateLogin);	
	loginTextInput.addEventListener("focusout", validateLogin);
	
	emailTextInput.addEventListener("keyup", validateEmail);	
	emailTextInput.addEventListener("focusout", validateEmail);
	
	var loginRE = /^[a-zA-Z0-9]*$/;
	var emailRE = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	
	var lastInput;
	
	var timeout = null;
		
	function validateLogin(){
		$(loginDiv).append($loginParagraph);
		if(!loginRE.test(loginTextInput.value)){
			changeParagraphText($loginParagraph, "Your account name may only consist of numbers 0-9 and letters A-Z!")
		}else if(loginTextInput.value.length < 5 || loginTextInput.value.length > 15){
			changeParagraphText($loginParagraph, "Login must have at least 5 and less than 15 letters!");
		}else if(loginTextInput.value != lastInput){
			lastInput = loginTextInput.value;
			clearTimeout(timeout);
			timeout = setTimeout(function() {
				checkIfAlreadyUsed('/userNameValidate', loginTextInput, $loginParagraph, "Login already taken");
			}, 500);
		}
	}
	
	
	function validateEmail(){			
		$(emailDiv).append($emailParagraph);
		if(!emailRE.test(emailTextInput.value)){
			changeParagraphText($emailParagraph, "This email address has an invalid format.")
		}else if(emailTextInput.value != lastInput){	
			lastInput = emailTextInput.value;
			clearTimeout(timeout);
			timeout = setTimeout(function() {
				checkIfAlreadyUsed('/emailValidate', emailTextInput, $emailParagraph, "Email already used.")
			}, 500);					
		}	
	}
		
	function changeParagraphText(paragraph, text){
		paragraph.text(text);
	}
		
	function checkIfAlreadyUsed(path, textInput, paragraph, text){
		$.post(path, {variable : textInput.value})		
		.done(function(data) {			
			if(data == "true"){
				changeParagraphText(paragraph, text);
			}else{
				changeParagraphText(paragraph, "OK")
			}	
		})
	}
}