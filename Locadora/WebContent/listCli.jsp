<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="resources/jquery-ui-1.10.4.custom/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="resources/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="resources/demo_page.css">
<link rel="stylesheet" href="resources/demo_table.css">
<link rel="stylesheet"
	href="resources/jquery-ui-1.10.4.custom/css/ui-lightness/jquery-ui-1.10.4.custom.css">

<script type="text/javascript"
	src="resources/jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#tabela")
								.dataTable(
										{
											"oLanguage" : {
												"sProcessing" : "Processando...",
												"sLengthMenu" : "Mostrar _MENU_ registros",
												"sZeroRecords" : "NÃ£o foram encontrados resultados",
												"sInfo" : "Mostrando de _START_ atÃ© _END_ de _TOTAL_ registros",
												"sInfoEmpty" : "Mostrando de 0 atÃ© 0 de 0 registros",
												"sInfoFiltered" : "(filtrado de _MAX_ registros no total)",
												"sInfoPostFix" : "",
												"sSearch" : "Buscar:",
												"sUrl" : "",
												"oPaginate" : {
													"sFirst" : "Primeiro",
													"sPrevious" : "Anterior",
													"sNext" : "Seguinte",
													"sLast" : "Ãšltimo"
												}
											}
										});
					});
</script>
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



			<div class="fundoTabela">
				<div style="height: 30px;"></div>
				<h2 style="text-align: center;">Lista de Clientes</h2>
				<div style="height: 30px;"></div>
				<div align="center">
	
					<a href="cliente.jsp"
						style="background-color: #4682B4; color: #fff; font-weight: bold; width: 100px !important; padding: 5px;">Novo</a>

				</div>
				<div style="height: 30px;"></div>
				<div>
					<c:if test=" ${mensagem !=null}">
						      ${mensagem}
						 </c:if>
				</div>
				<table >

					<thead style="border: 1px solid rgb(069,118,149);" >
						<tr style="border: 1px solid rgb(069,118,149);">
							<td>Nome</td>
							<td>Cpf</td>
							<td>Telefone</td>
							<td>Endereco</td>
							<td>Alterar</td>
							<td>Excluir</td>
						</tr>
					</thead>
					<tbody style="border: 1px solid rgb(069,118,149);">

						<c:forEach var="cli" items="${listaCliente}">
							<tr>
								<td>${cli.nome}</td>
								<td>${cli.cpf}</td>
								<td>${cli.telefone}</td>
								<td>${cli.endereco}</td>
								<td><a href="cliente?acao=alterar&id=${cli.id}"><img alt="pencil"
										src="resources/img/Search.png"
										style="width: 25px; height: 25px;"></a></td>
								<td><a href="cliente?acao=excluir&id=${cli.id}"
									onclick="return confirm('Deseja realmente excluir')"><img
										alt="trash" src="resources/img/Delete.png"
										style="width: 25px; height: 25px;"></a></td>

							</tr>

						</c:forEach>


					</tbody>

				</table>
			</div>

			<div style="height: 20px"></div>

		</div>

		<div id="rodape">

			<jsp:include page="template/rodape.jsp"></jsp:include>

		</div>

	</div>
	
</body>
</html>