function sortear(){
	 var x1 = Math.floor((Math.random() * 60) + 1);
	 document.getElementById("numero1").innerHTML = x1;
	 
	 var x2 = Math.floor((Math.random() * 60) + 1);
	 document.getElementById("numero2").innerHTML = x2;
	 
	 var x3 = Math.floor((Math.random() * 60) + 1);
	 document.getElementById("numero3").innerHTML = x3;
	 
	 var x4 = Math.floor((Math.random() * 60) + 1);
	 document.getElementById("numero4").innerHTML = x4;
	 
	 var x5 = Math.floor((Math.random() * 60) + 1);
	 document.getElementById("numero5").innerHTML = x5;
	 
	 var x6 = Math.floor((Math.random() * 60) + 1);
	 document.getElementById("numero6").innerHTML = x6;
	 
	 var y1 = document.getElementById("campo1").value;
	 var y2 = document.getElementById("campo2").value;
	 var y3 = document.getElementById("campo3").value;
	 var y4 = document.getElementById("campo4").value;
	 var y5 = document.getElementById("campo5").value;
	 var y6 = document.getElementById("campo6").value;
	 
	 if(x1 == y1){
		 document.getElementById("numero1").style.backgroundColor = "#98FB98";
	 }else{
		 document.getElementById("numero1").style.backgroundColor = "#FFA07A";
	 }
	 
	 if(x2 == y1){
		 document.getElementById("numero2").style.backgroundColor = "#98FB98";
	 }else{
		 document.getElementById("numero2").style.backgroundColor = "#FFA07A";
	 }
	 
	 if(x3 == y1){
		 document.getElementById("numero3").style.backgroundColor = "#98FB98";
	 }else{
		 document.getElementById("numero3").style.backgroundColor = "#FFA07A";
	 }
	 
	 if(x4 == y1){
		 console.log(y4);
		 document.getElementById("numero4").style.backgroundColor = "#98FB98";
	 }else{
		 document.getElementById("numero4").style.backgroundColor = "#FFA07A";
	 }
	 
	 if(x5 == y1){
		 document.getElementById("numero5").style.backgroundColor = "#98FB98";
	 }else{
		 document.getElementById("numero5").style.backgroundColor = "#FFA07A";
	 }
	 
	 if(x6 == y1){
		 document.getElementById("numero6").style.backgroundColor = "#98FB98";
	 }else{
		 document.getElementById("numero6").style.backgroundColor = "#FFA07A";
	 }
}