var req;
function excluir(idCli, obj) {
	var conf = confirm('Deseja realmente excluir');
	if (conf == true) {
		var caminho = document.getElementById("idCli").href = "cliente?acao=excluir&id="
				+ idCli;
		var url = "/Locadora/" + caminho;
		req = new XMLHttpRequest();
		req.open("Get", url, true);
		// req.onreadystatechange = responder;
		req.send(null)
		removerLinha(obj);
	}
}
function responder() {
	if (req.status == 200) {
		var resposta = document.getElementById("valNome");
		resposta.innerText = req.responseText;
	}

}

function removerLinha(obj) {
	var objTR = obj.parentNode.parentNode;
	var objTable = objTR.parentNode;
	var indexTR = objTR.rowIndex;
	objTable.deleteRow(indexTR);
}

function alterar(idAlt){
	var caminho = document.getElementById("idAlt").href = "cliente?acao=alterar&id="+idAlt;
	var url = "/Locadora/"+ caminho;
	req = new XMLHttpRequest();
	req.open("Get", url, true);
	req.send(null);
}