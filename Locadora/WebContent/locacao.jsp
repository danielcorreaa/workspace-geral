<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css" />
<link rel="stylesheet" href="template/animated-menu.css" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js?ver=3.2.1"
	type="text/javascript"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="template/animated-menu.js" type="text/javascript"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="resources/js/layout.js"></script>
	

<script>
	$(document).ready(function() {
		$('#submit').click(function(event) {
			var filme = $('#fi').val();
			$.post('locacao.do', {
				fi : filme
			}, function(responseText) {
				$('#welcometext').text(responseText);

			});
		});
	});
</script>
<title>Insert title here</title>

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
			<div id="formulario">
				<form method="post" action="locacao.do">

					<div style="height: 10px"></div>
					<h3 style="border-bottom: 1px solid gray;"
						class="GeosansLight !important;">Realizar Locação</h3>

					<input type="hidden" name="idloc" value="${locacao.id}" />

					<div class="label">Cliente:</div>
					<div style="height: 5px"></div>
					<select name="Cliente" id="cli">
						<option>Selecione</option>
						<c:forEach var="cli" items="${listaCliente}">
							<option value="${cli.id}">${cli.nome}</option>
						</c:forEach>
					</select>

					<div style="height: 10px"></div>
					<div class="label">Filme:</div>
					<div style="height: 5px"></div>
					<select name="filmes" id="fi">
						<option>Selecione</option>
						<c:forEach var="fil" items="${listaFilmes}">
							<option value="${fil.id}">${fil.titulo }</option>
						</c:forEach>
					</select> 
					<div style="height: 10px"></div>
					<input type="button" value="Adicionar" id="submit" name="submit" />


					<div style="height: 10px"></div>
					<div class="label">Filmes Selecionados:</div>
					<div style="height: 5px"></div>
					<div id="welcometext"
						style="overflow: auto; background-color: #fff; border: 1px solid black; width: 370px; height: 120px; white-space: pre; padding: 15px;"></div>

					<div style="height: 10px"></div>
					<div class="label">Saída:</div>
					<div style="height: 5px"></div>
					<input type="date" name="saida" value="${locacao.saidaFormat}" />
					<div style="height: 10px"></div>

					<div class="label">Devolução:</div>
					<div style="height: 5px"></div>
					<input type="date" name="devoprev" value="${locacao.devolucaoPrev}" />

					<div style="height: 10px"></div>

					<input type="hidden" value="salvar" name="acao"> <input
						type="hidden" value="" name="idD" id="idD"> <input
						name="idD" id="idD" value="Iniciar Locação" type="submit"
						style="background-color: green; color: #fff; font-weight: bold; width: 130px !important; padding: 5px;" />
					<div class="msg">
						<c:if test="${msg!=null}">
							<h4
								style="background-color: #556B2F; text-align: center; color: #fff; padding: 5px;">
								${msg}</h4>
						</c:if>
					</div>
					<div class="msg">
						<c:if test="${msgex!=null}">
							<h4
								style="background-color: #FF6347; text-align: center; color: #fff; padding: 5px;">
								${msgex}</h4>
						</c:if>
					</div>
				</form>
			</div>
			<div id="fundoTabela">
				<div class="internoTab">
					<div style="height: 10px"></div>
					<h3 style="text-align: center; border-bottom: 1px solid gray;"
						class="GeosansLight !important;">Locações</h3>

					<table>
						<thead>
							<tr>
								<td>Numero Locação</td>
								<td>Cliente</td>
								<td>Filmes</td>
								<td>Data Saída</td>
								<td>Data Devolução</td>
								<td>Alterar</td>
								<td>Excluir</td>
							</tr>

						</thead>

						<tbody>
							<c:forEach var="locacao" items="${locacoes}">
								<tr>
									<td>${locacao.id}</td>
									<td>${locacao.cliente.nome}</td>
									<td>
										<table>

											<c:forEach var="fil" items="${locacao.alugueis}">
												<tr>
													<td>${fil.filme.titulo}</td>
												</tr>
											</c:forEach>


										</table>
									</td>
									<td>${locacao.saidaFormat}</td>
									<td>${locacao.devolucaoPrevFormat}</td>
									<td><a href="locacao.do?acao=alterar&id=${locacao.id}"><img
											alt="pencil" src="resources/img/Search.png"
											style="width: 25px; height: 25px;"></a></td>
									<td><a href="locacao.do?acao=excluir&id=${locacao.id}"
										onclick="return confirm('Deseja realmente excluir')"><img
											alt="trash" src="resources/img/Delete.png"
											style="width: 25px; height: 25px;"></a></td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
				<div style="height: 10px"></div>
			</div>
		</div>



	</div>
</body>
</html>