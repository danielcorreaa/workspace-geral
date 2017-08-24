var req;
function salvar() {
	
	var id_usuario = document.getElementById("id_usuario");	
	var nome = document.getElementById("nome");
	var loginCad = document.getElementById("loginCad");
	var senhaCad = document.getElementById("senhaCad");
	var confirSenha = document.getElementById("confirmarSenha");
	
	console.log(id_usuario.value);
	console.log(nome.value);
	console.log(loginCad.value);
	console.log(senhaCad.value);
	console.log(confirSenha.value);
	
	if(!validarSenha(senhaCad, confirSenha)){
		
		senhaCad.value = "";
		confirSenha.value = "";
		document.getElementById("msgLogin").innerHTML = "Confirma&ccedil;&atilde;o de senha n&atilde;o confere com a senha";
		
	}else{
		
		if(nome.value == "" || loginCad.value == "" || senhaCad.value == "" || confirSenha.value ==""){
			
			var login = document.getElementById("msgLogin");
			login.innerHTML = "Preencha todos os campos";
			veriricarCampoVazio(nome, loginCad, senhaCad, confirSenha);
			
			}else{
					
			req = new XMLHttpRequest();
			req.open("POST", "usuario", true);
			req.onreadystatechange = respostaSU;
			req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			var enviar = "id_usuario=" + escape(id_usuario.value) + "&" + "nome="
							+ escape(nome.value) + "&" + "loginCad=" + escape(loginCad.value)
							+ "&" + "senhaCad=" + escape(senhaCad.value)+"&"+"confirmarSenha=" + escape(confirSenha.value);
			req.send(enviar);
					
			clearSU();
		 }
	}
}

function clearSU() {
	document.getElementById("id_usuario").value = "";
	document.getElementById("nome").value = "";
	document.getElementById("loginCad").value = "";
	document.getElementById("senhaCad").value = "";
	document.getElementById("confirmarSenha").value = "";

}

function respostaSU() {
	
	if (req.readyState == 4) {
		
		if (req.status == 200) {
			var msgUser = document.getElementById("msgLogin");
			msgUser.innerText = req.responseText;
			msgUser.style.backgroundColor = "#81c784";
			msgUser.style.color = "white";
			msgUser.style.textAlign = "center";
			
		} else {
			
			alert("Ajax calling error");
			
		}
	}
}

function voltar() {
	
	var login = document.getElementById("login");
	var cadUser = document.getElementById("cadUser");
	login.style.display = "block";
	cadUser.style.display = "none";
	
}

function veriricarCampoVazio(nome, login, senha, confirmSenha){
	if(nome.value==""){
		nome.style.backgroundColor = "#ff8a80";
	}else{
		nome.style.backgroundColor = "#fff";
	}
	
	if(login.value==""){
		login.style.backgroundColor = "#ff8a80";
	}else{
		login.style.backgroundColor = "#fff";
	}
	
	if(senha.value==""){
		senha.style.backgroundColor = "#ff8a80";
	}else{
		senha.style.backgroundColor = "#fff";
	}
	
	if(confirmSenha.value==""){
		confirmSenha.style.backgroundColor = "#ff8a80";
	}else{
		confirmSenha.style.backgroundColor = "#fff";
	}
	
	
}

function validarSenha(senha, contraSenha){
	if(senha.value == contraSenha.value){
		return true;
	}
	return false;
}
var reqq;
function virificarDuplicidade(){
	  var login = document.getElementById("loginCad");
	  console.log(login.value);
	  var url = "/cartao/usuario?loginCad="+escape(login.value);
	  reqq = new XMLHttpRequest();
	  reqq.open("Get", url, true);
	  reqq.onreadystatechange = respostaLogin;
	  reqq.send(null);
	  
}

function clear(){
	 document.getElementById("loginCad").value = "";	
}

function respostaLogin() {
	
	if (reqq.readyState == 4) {
		
		if (reqq.status == 200) {
			var msgUser = document.getElementById("msgLogin");
			msgUser.innerText = reqq.responseText;
			
				msgUser.style.backgroundColor = "#ff8a80";
				msgUser.style.color = "white";
				msgUser.style.textAlign = "center";
				clear();
			
			
		} else {
			
			alert("Ajax calling error");
			
		}
	}
}