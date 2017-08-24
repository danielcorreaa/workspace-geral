<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css" />
<title>Usuarios</title>
</head>
<body>
	<div id="conteudo">

		<div class="aside">

			<h3>Usuario Logado</h3>
			<h3>${user.nome}</h3>
			<h3>Idade</h3>
			<h3>${user.idade}</h3>

			<jsp:include page="template/menu.jsp"></jsp:include>
			<form method="post" action="logout.do">
				<input type="submit" value="Sair"
					onclick=" return confirm('Deseja Realmente Sair?')" />
			</form>
		</div>

		<div class="corpo">

			<div
				style="display: inline; width: 100%; text-align: center; margin-top: 100px;">

				<a href="#">Próximo</a> <a href="#">Anterior</a>
				<table style="width: 100%">
					<tr>
						<td>Jill</td>
						<td>Smith</td>
						<td>50</td>
					</tr>
					<tr>
						<td>Eve</td>
						<td>Jackson</td>
						<td>94</td>
					</tr>
				</table>

			</div>

		</div>

	</div>


</body>
</html>