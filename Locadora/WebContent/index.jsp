<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
    <link rel="stylesheet" type="text/css" href="resources/css/estilo.css"/>
    <link rel="stylesheet" href="template/animated-menu.css"/>
	<link rel="icon" href="resources/img/Bar Chart.png" type="image/x-icon">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js?ver=3.2.1" type="text/javascript"></script>
	<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
	<script src="template/animated-menu.js" type="text/javascript"></script>
	<script type="text/javascript" src="resources/js/layout.js"></script>
	
	
	
</head>
<body>
	<div id="conteudo">
	
	<div id="topo">
	
	   <jsp:include page="template/topo.jsp"></jsp:include>
	  

	</div>
	<div id="menu">
	   <jsp:include page="template/menu.jsp"></jsp:include>
	</div>
	<div id="corpo">
		  
		<div style="height: 20px"></div>
		
		<div id="pesquisa">
		    
			<h1 style="color: #fff; border-bottom: 1px solid #fff">Pesquisar</h1>
		
			  <form id="cadpes" action="pesquisar.do" method="post">
			       
			 
			  		<input type="text" name="titulo" placeholder="Pesquisar Filme" style="width: 400px; height: 30px; text-align: center; float: left;"/>
					  
					<input type="submit" value="Pesquisar" style="height: 36px; cursor: pointer;" />  
			   		<div style="height: 30px;"></div>
					<c:forEach var="filme" items="${list}">
						<div style="height: 30px;"></div>
					 	<div class="imgFil">
							<img alt="poster" src="imagem/${filme.img}" style="width: 150px; height: 200px;">
						
						     <div class="clear"></div>
						</div>
						
						<div class="desc">
						
						  <h4>Titulo: ${filme.titulo}</h4>
						  <h4>Situação: ${filme.status}</h4>
						   <div class="clear"></div>
						   
						</div>
						
					</c:forEach>
			 
			  </form>	
		
		</div>
	 
	</div>
	
	<div id="rodape">
	 
	   <jsp:include page="template/rodape.jsp"></jsp:include>
	 
	 </div>
	
	</div>
</body>
</html>