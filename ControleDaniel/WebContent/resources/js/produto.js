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

var req;
function salvar(){
	var id = document.getElementById("id_produto");	
	var txtNome = document.getElementById("nome_prod");	
	var preco = document.getElementById("preco");	
    req = new XMLHttpRequest();
    req.open("POST", "produto.do", true);   
    req.onreadystatechange = resposta;
    req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    req.send("id_produto=" + escape(id.value) + "&"+ "nome_prod=" + escape(txtNome.value)+ "&" +"preco="+escape(preco.value));
    voltar();
   
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
	var caminho = document.getElementsByClassName("alterar").href = "produto.do?acao=alterar&id="+escape(id);
	var url = "/cartao/"+caminho;
	req = new XMLHttpRequest();
	req.open("Get", url, true);
	//req.onreadystatechange = povoarCampos;
	req.send(null);
	document.getElementById("id_produto").value = id;
	document.getElementById("nome_prod").value = nome;
	document.getElementById("preco").value = preco;
	
}

function deletar(id, obj){
	var conf = confirm('Deseja realmente excluir');
	if (conf == true) {
		var caminho = document.getElementsByClassName("deletar").href = "produto.do?acao=excluir&id="+escape(id);
		var url = "/cartao/"+caminho;
		req = new XMLHttpRequest();
		req.open("Get", url, true);
		// req.onreadystatechange = resposta;
		req.send(null);
		removerLinha(obj);		
	}
}

function removerLinha(r) {	 
	 var row = r.parentNode.parentNode.rowIndex;
	 document.getElementById("table").deleteRow(row);
}