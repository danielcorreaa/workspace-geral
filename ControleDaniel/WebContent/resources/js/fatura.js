var req;
function pesquisarFatura(){
	var form = document.getElementById("form");
	form.submit();
}

function respostaPes(){
	if(req.readyState == 2){
		if(req.status == 200){
		//var obj = JSON.parse(req.responseText);
		console.log(req.responseText);
		//console.dir(obj);
		}
	}
}