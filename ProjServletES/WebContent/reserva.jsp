<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="frm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css" />
<script type="text/javascript" src="resources/js/layout.js"></script>
<title>Reserva</title>
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

			<div class="informacao">
				<h4>Quantidade de Quartos Ocupados</h4>
				<h4 id="qtdeOculp"></h4>
				<h4>Quantidade de Quartos Livres</h4>
				<h4 id="qtdeLivre"></h4>
			</div>
			<div class="portas">
				<jsp:useBean id="dao" class="com.servlet.dao.QuartoDAO"></jsp:useBean>

				<c:forEach var="quarto" items="${dao.quartos}">
					<img alt="porta" class="img"
						src="resources/img/${quarto.imagemQuarto}.png" />
				</c:forEach>


			</div>
			<table border="1">
				<c:forEach var="q" items="${dao.quartos}" varStatus="id">
					<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
						<td>${id.count}</td>
						<td>${q.numeroPorta}</td>
					</tr>
				</c:forEach>
			</table>

		</div>

	</div>
</body>
</html>