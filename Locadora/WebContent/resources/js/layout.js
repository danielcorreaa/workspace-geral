function mudarCor() {
	var topo = document.getElementById("topo");
	//var pesquisa = document.getElementById("pesquisa");
	var formulario = document.getElementById("formulario");
	var topoTab = document.querySelectorAll("thead , thead tr:first-child");
	console.log(topoTab);
	// topo.style.backgroundColor = ( topo.style.backgroundColor == "#6AA63B") ?
	// "#0292C0" : "#6AA63B";
	topo.style.backgroundColor = this.value;
	//pesquisa.style.backgroundColor = this.value;
	formulario.style.backgroundColor = this.value;
	for (var i = 0; i < topoTab.length; i++) {
		topoTab[i].style.backgroundColor = this.value;
	}

}

function overlay() {
	el = document.getElementById("overlay");
	el.style.visibility = (el.style.visibility == "visible") ? "hidden"
			: "visible";
	setTimeout(function() {
		el = document.getElementById("overlay");
		el.style.visibility = (el.style.visibility == "hidden") ? "visible"
				: "hidden";
	}, 2000);
}

function newPopup() {
	window.open("/Locadora/usuario.do", "_blank", "toolbar=yes, scrollbars=yes, " +
			"resizable=yes, top=200, left=500, width=400, height=400");
}
