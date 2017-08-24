var req;
function salvar(){
	var id_cartao = document.getElementById("id_cartao");
	var bandeira = document.getElementById("bandeira");
	var limite = document.getElementById("limite");
	req = new XMLHttpRequest();
	req.open("POST", "cartao.do", true);
	req.onreadystatechange = resposta;
	req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	req.send("id_cartao="+escape(id_cartao.value)+"&"+"bandeira="+escape(bandeira.value)+"&"+"limite="+escape(limite.value))
	
	clear();
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

function clear(){
	var id_cartao = document.getElementById("id_cartao").value ="";
	var bandeira = document.getElementById("bandeira").value ="";;
	var limite = document.getElementById("limite").value ="";;
	fecharTelaCadastr();
}

function fecharTelaCadastr(){	
	var cadUser = document.getElementById("cadUser");
	var acesso = document.getElementById("acesso");
	cadUser.style.display = "none";
	acesso.style.display = "block";
}
