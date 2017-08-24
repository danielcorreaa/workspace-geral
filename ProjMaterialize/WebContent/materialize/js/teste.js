var req;
function autoComplete() {
	var nome = document.getElementById("nome");
	var url = "/materialize/completar.do?nome=" + escape(nome.value);
	req = new XMLHttpRequest();

	req.open("Get", url, true);
	req.onreadystatechange = responder;
	req.send(null);
}

function responder() {
	if (req.status == 200) {
		var resposta = document.getElementById("valNome");
		resposta.innerText = req.responseText;
	}

}