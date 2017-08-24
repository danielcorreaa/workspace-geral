<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="resources/css/loginEstilo.css" />
<title>Login</title>
</head>
<body>
	<div class="espaco30"></div>
	<div class="espaco30"></div>
	<div class="espaco30"></div>
	<c:if test="${ok!=null}">
		<div id="resposta">${ok}</div>
	</c:if>
	<div class="espaco15"></div>
	<div id="loginCont">
		<div id="cabecalho">Acessar o Sistema</div>
		<form method="post" action="login.do">

			<div style="height: 20px;"></div>

			<div style="height: 5px;"></div>
			<input type="text" name="login" placeholder="Login" />
			<div style="height: 5px;"></div>

			<div style="height: 5px;"></div>
			<input type="password" name="senha" placeholder="Senha" />
			<div style="height: 5px;"></div>
			<div class="espaco10"></div>
			<input type="submit" value="Entrar"
				style="width: 100px !important; background-color: #8B4513; color: #fff;" />

			<div class="espaco30"></div>
		</form>

	</div>
	<div class="espaco30"></div>
	<div style="text-align: center;">
		<a href="/ProjServletES/enviarEmail.jsp">Esqueci a Senha</a>
	</div>

</body>
</html>