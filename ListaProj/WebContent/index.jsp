<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="dao.EnderecoDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Endereco"%>

<html>
<head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Projeto Servlet</title>
      <link rel="stylesheet" type="text/css" href="css/estilo.css"/>
      
      
</head>
<body>
 <form id="endForm" method="post" action="endereco">
 
 	<div id=header>
 	
 		Testando JSP/Servelt
 	
 	</div>
 	
 	
 	<div class="fundomensagem">
	    <div class="mensagem">
	     <c:if test="${mensagem!=null}">
	       ${mensagem}
	     </c:if>
	    </div>
	</div>
	
		
        
 	<div id="formulario">
 	
 	<h1>Cadastro</h1>
 	<div class="espaco30"></div>
 	<input value="${endereco.id}" type="hidden" name="id"/> 
 	<div style="height: 10px;"></div> 	
 	Rua:
 	<div style="height: 10px;"></div> 	
	<input name="rua" type="text" value="${endereco.rua}"/><br>
	<div style="height: 10px;"></div> 	
 	Numero:
 	<div style="height: 10px;"></div> 	
	<input name="numero" type="text" value="${endereco.numero}" /><br>
	<div style="height: 20px;"></div> 	
	<input name="salvar" value="Salvar" type="submit" style="background-color: green; color:#fff; font-weight: bold;"/>
	
	</div>
	<div style="height: 30px;"></div>


	<div id="tabela">
	
	<table>
	
	 <thead style="background-color: #FFFAFA; color: black; border-bottom: 1px solid blue;" >
	  <tr style="border: 1px solid black;">
	     <td>Rua</td>
	     <td>Numero</td>
	  </tr>
	 </thead>
	 <tbody>
	 	
	     <c:forEach var="end" items="${enderecos}">
	        <tr>
	            <td>${end.rua}</td>
	            <td>${end.numero}</td>
	            <td><a href="endereco?acao=alterar&id=${end.id}"  name="alterar" ><img alt="pencil" src="img/pencil.png" style="width: 25px; height: 25px;"></a></td>
	            <td><a href="endereco?acao=excluir&id=${end.id}"  name="excluir" ><img alt="trash" src="img/trash.png" style="width: 25px; height: 25px;"></a></td>
	            
	        </tr>
	        
	     </c:forEach> 
	  
	  
	 </tbody>
	</table>
	</div>
	
	<div id="rodape">
	</div>
	</form>
</body>
</html>