/**
 * 
 */ 
 window.onload = function(){
	document.getElementById("ins").onsubmit = check;	
}
 
 function check() {
	let name = document.getElementById('name');
	let age = document.getElementById('age');
	
	if (name.value.length == 0) {
		alert('이름을 입력하세요.');
		return false;
	}
	if (age.value.length == 0) {
		alert('나이를 입력하세요.');
		return false;
	}
	return true;
}