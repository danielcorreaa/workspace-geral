function cadastrar(){
	var tabela = document.getElementById("tabela");
	var cadastro = document.getElementById("cadastro");
	tabela.style.display = "none";
	cadastro.style.display = "block";
}

function voltar(){
	var tabela = document.getElementById("tabela");
	var cadastro = document.getElementById("cadastro");
	tabela.style.display = "block";
	cadastro.style.display = "none";
}

var req;

function salvar(){
	var url = "/ProjServletES/hospedagem.do";
	var numeroHospedagem = document.getElementById("numeroHospedagem");
	var quarto = document.getElementById("quarto");
	var entrada = document.getElementById("entrada");
	//var saida = document.getElementById("saida");
	
	var parametros = "numeroHospedagem="+escape(numeroHospedagem.value)+
	"&quarto="+escape(quarto.value) + "&entrada="+escape(entrada.value);
	
	console.log(parametros);
	
	req = new XMLHttpRequest();
	req.open("Post", url, true);
	req.setRequestHeader("Content-type","application/x-www-form-urlencoded");	
	req.send(parametros);
	
}
