function cadastrar(){
	var tabelaCss = document.getElementById("tabela");
	var cadastroCss = document.getElementById("cadastro");
	tabelaCss.style.display = "none";
	cadastroCss.style.display = "block";
}

function voltar(){
	var tabelaCss = document.getElementById("tabela");
	var cadastroCss = document.getElementById("cadastro");
	tabelaCss.style.display = "block";
	cadastroCss.style.display = "none";
}

function selecionarPagamentoAvista(selecionado){
	var avista = document.getElementById("avista");
	var parcelado = document.getElementById("parcelado");
	if(selecionado){		
		avista.style.display = "block";
		parcelado.style.display = "none";
	}else{
		avista.style.display = "none";
		parcelado.style.display = "block";
	}
}
function selecionarPagamentoParcelado(selecionado){
	var avista = document.getElementById("avista");
	var parcelado = document.getElementById("parcelado");	
	if(selecionado){		
		parcelado.style.display = "block";
		avista.style.display = "none";
	}else{
		parcelado.style.display = "none";
		avista.style.display = "block";
	}
}

var req;
function salvar(){
	var id_compra = document.getElementById("id_compra");
	var estabelecimento = document.getElementById("estabelecimento");
	var produto = document.getElementById("produto");
	var data = document.getElementById("data");
	
	var adicional = "";
	var group1 = document.querySelector("input[name=group1]:checked").value;
	
	if(group1 != null){
		if(group1=='avista'){
			var valorAvista = document.getElementById("valorAvista");
			//var dataPagamentoAvista = document.getElementById("dataPagamentoAvista")+"&"+"dataPagamentoAvista="+escape(dataPagamentoAvista.value;
			adicional = "valorAvista="+escape(valorAvista.value);
		}else{
			var qtdeParcela = document.getElementById("qtdeParcela");
			var valorpar = document.getElementById("valorpar");
			//var dataPagamentopar = document.getElementById("dataPagamentopar");+"&"+"dataPagamentopar="+escape(dataPagamentopar.value)
			adicional = "qtdeParcela="+escape(qtdeParcela.value)+"&"+"valorpar="+escape(valorpar.value);
		}
	}
	
	
    req = new XMLHttpRequest();
    req.open("POST", "compra.do", true);   
    req.onreadystatechange = resposta;
    req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    var enviar = "id_compra=" + escape(id_compra.value)+"&"+"estabelecimento="+ escape(estabelecimento.value)
    +"&"+"produto=" + escape(produto.value)+"&"+"data="+escape(data.value);
    req.send(enviar+"&"+adicional+"&group1="+escape(group1));
    
    clear();
   // voltar();
   
}
function clear(){
	document.getElementById("id_compra").value = "";
	//document.getElementById("estabelecimento").value="";
	//document.getElementById("produto").value="";

	$('#estabelecimento').val("");     
    $('#estabelecimento').material_select();       
	        
    $('#produto').val("");     
    $('#produto').material_select();  
    
	document.getElementById("data").value = "";
	document.getElementById("valorAvista").value = "";
	document.getElementById("dataPagamentoAvista").value = "";
	document.getElementById("qtdeParcela").value = "";
	document.getElementById("valorpar").value = "";
	document.getElementById("dataPagamentopar").value = "";
}

function resposta(){
	if(req.readyState == 4){
		if(req.status == 200){
			document.getElementById("msg").innerHTML=req.responseText; 			
		}else{
			alert("Ajax calling error");
		}
	}
}

function alterar(id, nome,preco){
	cadastrar();
	var caminho = document.getElementsByClassName("alterar").href = "compra.do?acao=alterar&id="+escape(id);
	var url = "/cartao/"+caminho;
	req = new XMLHttpRequest();
	req.open("Get", url, true);
	//req.onreadystatechange = povoarCampos;
	req.send(null);
	document.getElementById("id_compra").value = id;
//	document.getElementById("nome_prod").value = nome;
//	document.getElementById("preco").value = preco;
	
}

function deletar(id, obj){
	var conf = confirm('Deseja realmente excluir');
	if (conf == true) {
		var caminho = document.getElementsByClassName("deletar").href = "compra.do?acao=excluir&id="+escape(id);
		var url = "/cartao/"+caminho;
		req = new XMLHttpRequest();
		req.open("Get", url, true);
		// req.onreadystatechange = resposta;
		req.send(null);
		//removerLinha(obj);		
	}
}
