<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css"/>
<script type="text/javascript" src="resources/js/ajax.js"></script>
<title>Ajax</title>
</head>
<body onload="focusIn();">
   <h1>DECODIFICADOR DE CARACTERES DO AJAX</h1>
   <H2>Pressione uma tecla para encontrar seu valor. </H2>
   <table>
   	<tr>
   	   <td>
   	       Entrar com a Tecla Aqui
   	       <input type="text" id="key"  name="key" onkeyup="convertToDecimal();"/> 	   
   	   </td>
   	</tr>
   </table>
   <br />
   
   <table>
      <tr>
	      <td colspan="5" style="border-bottom: solid black 1px;">
	      		Tecla Pressionada:
	      		<input type="text" readonly id="keypressed"/> 
	      </td>
      </tr>
      <tr>
      	  <td>Decimal</td>
      </tr>
      <tr>
      	  <td><input type="text" readonly="readonly" id="decimal"></td>	
      </tr>
   </table>
</body>
</html>