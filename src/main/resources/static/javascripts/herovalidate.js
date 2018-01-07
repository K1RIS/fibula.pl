if (document.readyState !== "loading") {
	onReady();
} else {
	document.addEventListener("DOMContentLoaded", onReady);
}

function onReady() {
	var textInput = document.querySelector('[type=text]');
	var div = document.querySelector('div');
	var $paragraph = $("<p>");

	var confirmButton = document.querySelector('[type=submit]');
			
	textInput.addEventListener("keyup", validate);	
	textInput.addEventListener("focusout", validate);
	
	var namenRE = /^[a-zA-Z0-9]*$/;
	
	var lastInput;
	
	var timeout = null;
	
	function validate(){
		$(div).append($paragraph);
		if(!namenRE.test(textInput.value)){
			$paragraph.text("Character name may only consist of numbers 0-9 and letters A-Z!");
			confirmButton.disabled = true;
		}else if(textInput.value.length < 5 || textInput.value.length > 15){
			$paragraph.text("Login must have at least 5 and less than 15 letters!");
			confirmButton.disabled = true;
		}else if(textInput.value != lastInput){
			lastInput = textInput.value;
			clearTimeout(timeout);
			timeout = setTimeout(function() {
				checkIfAlreadyUsed();
			}, 500);
		}
	}
	
	function  checkIfAlreadyUsed(){
		$.post('/heroValidate', {
			variable : textInput.value
		}, function(data) {			
			if(data == "true"){
				$paragraph.text("Charcter name already taken;");
				confirmButton.disabled = true;					
			}else{
				$paragraph.text("OK");
				confirmButton.disabled = false;
			}	
		})
	}
}