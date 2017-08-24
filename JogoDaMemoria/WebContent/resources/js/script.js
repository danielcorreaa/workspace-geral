function abrir(id){
	document.getElementById(id.id).src = "resources/img/cascao.png";
	document.getElementById(id.id).style.height = "120px";
	document.getElementById(id.id).style.width = "161px";
}

function imagens(){
	var imgsrc = ["resources/img/cascao.png","resources/img/cascaoamarelo.png", "resources/img/cebolinhaflor.png",
	               "resources/img/cebolinhaverde.png", "resources/img/chicobento.png" , "resources/img/magaliazul.png",
	               "resources/img/minicavermelhoBranco.png" , "resources/img/monicaroxo.png" , "resources/img/monicavermelha.png"
	               ];
	
	var tagImg = document.querySelectorAll("img");
	var acumulador = [];
	for(var i = 0; i < tagImg.length + tagImg.length; i++){		
		
		acumulador[i] = Math.floor((Math.random() * 8) + 1);
		console.log(acumulador[i]);
		tagImg[i].src = imgsrc[Math.floor((Math.random() * 8) + 1)];		
		
		document.getElementById(tagImg[i].id).style.height = "120px";
		document.getElementById(tagImg[i].id).style.width = "161px";
	}
	
}