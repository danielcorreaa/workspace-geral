document.addEventListener("DOMContentLoaded", function() {
	var botao = document.querySelectorAll("input[type=button]");
	var tela = document.querySelector("#tela");
	var numero;
	for (var i = 0; i < botao.length; i++) {

		botao[i].addEventListener("click", function() {
			if (this.value != "/" && this.value != "*" && this.value != "+"
					&& this.value != "-" && this.value != "=") {
				tela.innerText += this.value;
			}
		});

	}

});

var operacao;
function operador(op) {
	var tela = document.querySelector("#tela").innerText;
	document.querySelector("#subtela").innerText = tela;
	document.querySelector("#tela").innerText = "";

	operacao = op.getAttribute("value");
}

function calculadora() {

	var tela = document.querySelector("#tela").innerText;
	var subTela = document.querySelector("#subtela").innerText

	var divisao = document.querySelector("#btm4").value;
	var soma = document.querySelector("#btm16").value;
	var subtracao = document.querySelector("#btm12").value;
	var multiplicacao = document.querySelector("#btm8").value;
	var result;
	if (operacao == "/") {
		result = new Number(subTela) / new Number(tela);
	} else if (operacao == "*") {
		result = new Number(subTela) * new Number(tela);
	} else if (operacao == "+") {
		result = new Number(subTela) + new Number(tela);
	} else if (operacao == "-") {
		result = new Number(subTela) - new Number(tela);
	}

	document.querySelector("#subtela").innerText = "";
	document.querySelector("#tela").innerText = result;
}


function verificar(){
	var digito = document.getElementById("cpf").value;    //alert(digito.value);
	console.log(digito.value);
	if(new Number(digito.value) > 11){
		digito.style.backgroundColor = "#0292C0";
	}
    //document.getElementById("resposta").value = digito;	
}


