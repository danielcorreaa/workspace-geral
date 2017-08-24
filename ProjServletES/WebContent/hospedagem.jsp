<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css" />
<script type="text/javascript" src="resources/js/layout.js"></script>
<title>Hospedagens</title>
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
			<div class="portas">

				<table border="1">
					<c:set var="begin" value="0"></c:set>
					<c:set var="end" value="9"></c:set>
				
					
					<c:forEach var="h" items="${hospedagens}" varStatus="id" begin="${begin}" end="${end}" step="2">
						<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
							<td>${id.count}</td>
							<td>${h.numeroHospedagem}</td>
							<td>${h.quarto.numeroPorta}</td>
							<td><frm:formatDate value="${h.entrada}"
									pattern="dd/MM/yyyy" /></td>
							<c:if test="${not empty h.saida}">
								<td>${h.saida}</td>
							</c:if>
							<c:if test="${empty h.saida}">
								<td>Data não informada</td>
							</c:if>
						</tr>
					</c:forEach>
				</table>


			</div>
		</div>

	</div>

</body>
</html>