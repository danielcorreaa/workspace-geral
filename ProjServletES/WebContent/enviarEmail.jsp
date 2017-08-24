<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="resources/css/loginEstilo.css" />
<title>Enviar Email</title>
</head>
<body>

	<div class="espaco30"></div>
	<div class="espaco30"></div>
	<div class="espaco30"></div>
	
	<div class="espaco15"></div>
	<div id="loginCont">
		<div id="cabecalho">Enviar email</div>
		<form method="post" action="email.do">
			<div class="espaco15"></div>
			<input type="text" placeholder="Email" />
			<div class="espaco15"></div>
			<input type="submit" value="Enviar"
				style="width: 100px !important; background-color: #8B4513; color: #fff;" />
			<div class="espaco15"></div>	
		</form>
	</div>
	<div class="espaco30"></div>
	<div style="text-align: center;">
		<a href="/ProjServletES/loginl.jsp">Voltar</a>
	</div>

</body>
</html>