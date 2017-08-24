function cadastrar() {
	
	var login = document.getElementById("login");
	var cadUser = document.getElementById("cadUser");
	login.style.display = "none";
	cadUser.style.display = "block";
	
}

function login() {
	
	var login = document.getElementById("login");
	var senha = document.getElementById("senha");
	
	if(login.value == "" || senha.value == ""){
		
		var msgLogin = document.getElementById("msgLogin");
		msgLogin.innerHTML = "Preecha todos os campos para acessar o sistema";
		msgLogin.style.backgroundColor = "#ff8a80";
		msgLogin.style.color = "white";
		msgLogin.style.textAlign = "center";
		
	}else{
		
		document.getElementById("myForm").submit();
		
	}
}

function sair() {
	
	var out = confirm("Deseja realmente sair do sistema");
	
	if (out) {
		
		document.getElementById("formSair").submit();
		
	}
}

