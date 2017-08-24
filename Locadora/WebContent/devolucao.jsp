<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css"/>
    <link rel="stylesheet" href="template/animated-menu.css"/>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js?ver=3.2.1" type="text/javascript"></script>
	<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
	<script src="template/animated-menu.js" type="text/javascript"></script>
<title>Devolução</title>
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
		<div id="formDev">
				<div style="height: 40px"></div>
	 			<h1 style="text-align: center;">Devolução</h1>
			 	<form method="post" action="devolucao.do">
			 	</form>
			
	 	</div>
	 	<div id="fundoTabela"></div>
	</div>
	
	<div id="rodape">
	 
	   <jsp:include page="template/rodape.jsp"></jsp:include>
	 
	 </div>
	
	</div>
</body>
</html>