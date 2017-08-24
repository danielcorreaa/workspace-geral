function cadastrarE() {
	var tabelaCss = document.getElementById("tabela");
	var cadastroCss = document.getElementById("cadastro");
	tabelaCss.style.display = "none";
	cadastroCss.style.display = "block";
}

function voltarE() {
	var tabelaCss = document.getElementById("tabela");
	var cadastroCss = document.getElementById("cadastro");
	tabelaCss.style.display = "block";
	cadastroCss.style.display = "none";
}

var req;
function salvarE() {
	var txtNome = document.getElementById("name");
	var id = document.getElementById("id_estabelecimento");
	req = new XMLHttpRequest();
	req.open("POST", "estabelecimento.do", true);
	req.onreadystatechange = resposta;
	req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	req.send("name=" + escape(txtNome.value) + "&" + "id_estabelecimento="
			+ escape(id.value));
	clearE();
	voltarE();
	mensagem();
}

function resposta() {
	if (req.readyState == 4) {
		if (req.status == 200) {
			document.getElementById("msg").innerHTML = req.responseText;
		} else {
			alert("Ajax calling error");
		}
	}
}

function alterarE(id, nome) {
	cadastrarE();
	var caminho = document.getElementsByClassName("alterar").href = "estabelecimento.do?acao=alterar&id="
			+ escape(id);
	var url = "/cartao/" + caminho;
	req = new XMLHttpRequest();
	req.open("Get", url, true);
	// req.onreadystatechange = povoarCampos;
	req.send(null);
	document.getElementById("id_estabelecimento").value = id;
	document.getElementById("name").value = nome;

}

function deletarE(id, r) {
	var conf = confirm('Deseja realmente excluir');
	if (conf == true) {
		var caminho = document.getElementsByClassName("deletar").href = "estabelecimento.do?acao=excluir&id="
				+ escape(id);
		var url = "/cartao/" + caminho;
		req = new XMLHttpRequest();
		req.open("Get", url, true);
		req.onreadystatechange = resposta;
		req.send(null);

		console.log(req.responseText);

		removerLinha(r);

		mensagem();
	}
}

function removerLinha(r) {
	var row = r.parentNode.parentNode.rowIndex;
	document.getElementById("mytable").deleteRow(row);
}

function clearE() {
	document.getElementById("id_estabelecimento").value = "";
	document.getElementById("name").value = "";
}

function mensagem() {
	var msg = document.getElementById("msg");
	msg.style.animation = "fadeOut 3s linear forwards";
}

