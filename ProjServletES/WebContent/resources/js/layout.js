function focus() {
	document.getElementById("nome").focus();
}
var req;
function validarNome() {
	var nome = document.getElementById("nome");
	var url = "/ProjServletES/validacao.do?nome=" + escape(nome.value);
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

function outoComplete() {
	var nome = document.getElementById("nome");
	var url = "/ProjServletES/validacao.do?nome=" + escape(nome.value);
	req = new XMLHttpRequest();

	req.open("Get", url, true);
	req.onreadystatechange = responder;
	req.send(null);
}

function clear() {
	var nome = document.getElementById("nome");
	nome.value = "";
}

function validarCPF() {
	var cpf = document.getElementById("cpf").value;
	var valCpf = document.getElementById("valCpf");
	var aculmA = 0;
	var aculmB = 0;
	var y = 8;
	for (var i = 0; i < 9; i++) {
		aculmA += (i + 1) * cpf.charAt(i);
	}
	for (var i = 0; i < 9; i++) {
		aculmB += (i + 1) * cpf.charAt(y);
		y--;
	}
	
	if (cpf.length == 11) {
		if (aculmA % 11 == cpf.charAt(9) && aculmB % 11 == cpf.charAt(10)) {
			valCpf.style.backgroundColor = "green";
		} else {
			valCpf.style.backgroundColor = "red";
			
		}
	}

}

function buscarPorCep(){
	var cep = document.getElementById("cep");
	var url = "/ProjServletES/pesquisarCep.do?cep="+escape(cep.value);
	req = new XMLHttpRequest();
	req.open("Get", url, true);
	req.onreadystatechange = buscar;
	req.send(null);
}

function buscar(){
	if (req.status == 200) {
		var rua = document.getElementById("rua");
		var bairro = document.getElementById("bairro");
		var cidade = document.getElementById("cidade");
		var estado = document.getElementById("estado");
		var texto = req.responseText;
		
		rua.value = texto.split("-")[0];
		bairro.value = texto.split("-")[1];
		cidade.value = texto.split("-")[2];
		estado.value = texto.split("-")[3];
	}
}
function salvar(){
	var nome = document.getElementById("nome");
	var telefone = document.getElementById("telefone");
	var cpf = document.getElementById("cpf");
	var cep = document.getElementById("cep");
	var rua = document.getElementById("rua");
	var bairro = document.getElementById("bairro");
	var cidade = document.getElementById("cidade");
	var estado = document.getElementById("estado");
	
	var url = "/ProjServletES/cliente.do";	
	
	var parametros = "nome="+escape(nome.value) + "&telefone="+escape(telefone.value) + 
	"&cpf="+escape(cpf.value);
	
	req = new XMLHttpRequest();
	req.open("Post", url, true);
	req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	req.send(parametros);
	clear();
	
	
}
function clear(){
	var nome = document.getElementById("nome");
	var telefone = document.getElementById("telefone");
	var cpf = document.getElementById("cpf");
	var cep = document.getElementById("cep");
	var rua = document.getElementById("rua");
	var bairro = document.getElementById("bairro");
	var cidade = document.getElementById("cidade");
	var estado = document.getElementById("estado");
	
	nome.value="";
	telefone.value="";
	cpf.value="";
	cep.value="";
	rua.value="";
	bairro.value="";
	cidade.value="";
	estado.value="";	
}

function povoarTabela(){	
	var url = "/ProjServletES/cliente.do";
	req = new XMLHttpRequest();
	req.open("Get", url, true);
	req.onreadystatechange = novosDados;
	req.send(null);
	
}

function novosDados(){
	if(req.readyState==4){
	  document.getElementById("tabela").innerHTML = req.responseText;
	}
}
function deletar(nome){
	
	console.log(nome);
	var url = "/ProjServletES/remover.do?nome="+ escape(nome);
	req = new XMLHttpRequest();
	req.open("Get", url, true);
	req.send(null);
}