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
	
	function validate(){
		var timeout = null;
		clearTimeout(timeout);
		timeout = setTimeout(function() {
			$(div).append($paragraph);
			$.post('/heroValidate', {
				variable : textInput.value
			}, function(text) {			
				$paragraph.text(text);
				if($paragraph.text() == "OK" ){
					confirmButton.disabled = false;
				}else{
					confirmButton.disabled = true;
				}
			})
		}, 500);
	}
}