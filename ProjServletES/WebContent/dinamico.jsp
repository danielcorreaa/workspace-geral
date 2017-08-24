<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="resources/js/layout.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css" />
<title>Dim</title>
</head>
<body>
	<div id="conteudo">

		<div class="aside">

			<h3>Usuario Logado</h3>
			<h3>${user.nome}</h3>
			<h3>Idade</h3>
			<h3>${user.idade}</h3>

			<jsp:include page="template/menu.jsp"></jsp:include>

		</div>

		<div class="corpo">
		  <div class="bloco">
		  </div>		
		</div>

	</div>

</body>
</html>