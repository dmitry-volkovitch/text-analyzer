function top10words() {
	var request = new XMLHttpRequest();
	request.open("GET", "http://localhost:8080/top-10-words", false);
	request.send();
	document.write(request.responseText);
}

function bracketsValidation(){
	var request = new XMLHttpRequest();
	request.open("GET", "http://localhost:8080/brackets-validation", false);
	request.send();
	document.write(request.responseText);
}


/*
 * var status = request.status; if (status == 200) document.write("Текст ответа: " +
 * request.responseText) else if (status == 404) document.write("Ресурс не
 * найден") else document.write(request.statusText)
 */