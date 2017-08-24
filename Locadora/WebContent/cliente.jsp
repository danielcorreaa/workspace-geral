<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript" src="resources/js/layout.js"></script>
<script type="text/javascript" src="resources/js/tabela.js"></script>
<script type="text/javascript" src="resources/js/ajax.js"></script>
<script type="text/javascript">
	function formulario() {
		el = document.getElementById("formulario");
		el.style.display = (el.style.display == "block") ? "none" : "block";
		ell = document.getElementById("fundoTabela");
		ell.style.display = (el.style.display == "none") ? "block" : "none";
	}

	function voltar() {
		el = document.getElementById("formulario");
		el.style.display = (el.style.display == "none") ? "block" : "none";
		ell = document.getElementById("fundoTabela");
		ell.style.display = (el.style.display == "block") ? "none" : "block";
	}
</script>
	
	<style type="text/css">
	.pg-normal {
		color: black;
		font-weight: normal;
		text-decoration: none;
		cursor: pointer;
	}
	
	.pg-selected {
		color: black;
		font-weight: bold;
		text-decoration: underline;
		cursor: pointer;
	}
	</style>
<title>Cadastro Cliente</title>


</head>
<body>
	<div id="conteudo">

		<div id="topo">
			<jsp:include page="template/topo.jsp"></jsp:include>
		</div>
		<div id="menu">
			<jsp:include page="template/menu.jsp"></jsp:include>
			<jsp:include page="template/growl.jsp"></jsp:include>
		</div>
		<div id="corpo">

			<div id="formulario">
				<h1 class="GeosansLight" style="text-align: center; color: #fff;">Cadastro
					Cliente</h1>

				<form method="post" action="cliente">

					<div class="espaco15"></div>
					<input type="hidden" name="idcli" value="${clie.id}" />

					<div style="height: 10px;"></div>

					<div style="height: 10px;"></div>
					<input name="nome" type="text" value="${clie.nome}"
						placeholder="Nome" style="text-align: center;" /><br>
					<div style="height: 10px;"></div>


					<div style="height: 10px;"></div>
					<input name="cpf" type="text" value="${clie.cpf}" placeholder="Cpf"
						style="text-align: center;" /><br>
					<div style="height: 10px;"></div>


					<div style="height: 10px;"></div>
					<input name="telefone" type="text" value="${clie.telefone}"
						placeholder="Telefone" style="text-align: center;" /><br>
					<div style="height: 10px;"></div>


					<div style="height: 10px;"></div>
					<input name="endereco" type="text" value="${clie.endereco}"
						placeholder="Endereço" style="text-align: center;" /><br>

					<div style="height: 20px;"></div>
					<div align="center">
						<input name="salvar" onkeypress="overlay();" value="Salvar"
							type="submit" onclick='voltar()'
							style="background-color: #6AA63B; color: #fff; font-weight: bold; width: 100px !important;" />

					</div>
				</form>
			</div>

			<div id="fundoTabela">



				<div style="height: 20px;"></div>
				<h2 style="text-align: center;">Lista de Clientes</h2>



				<div style="height: 20px;"></div>

				<div>
					<c:if test=" ${mensagem !=null}">
						      ${mensagem}
						 </c:if>
				</div>
				<form action="" method="get" enctype="application/x-www-form-urlencoded">
				
				<table id="tabCliente">

					
						<tr style="border: 1px solid rgb(069, 118, 149);">
							
							<td>Nome</td>
							<td>Cpf</td>
							<td>Telefone</td>
							<td>Endereco</td>
							<td>Situacao</td>
							<td>Alterar</td>
							<td>Excluir</td>
						</tr>
					
					

						<c:forEach var="cli" items="${listaCliente}" varStatus="cont">
							<tr bgcolor="#${cont.count % 2 == 0 ? 'B0C4DE':'fff'}">
								
								<td>${cli.nome}</td>
								<td>${cli.cpf}</td>
								<td>${cli.telefone}</td>
								<td>${cli.endereco}</td>
								<td>${cli.ativoFormat}</td>
								<td><a id="idAlt" onclick="alterar(${cli.id})"><img
										alt="pencil" src="resources/img/Search.png"
										style="width: 25px; height: 25px;"></a></td>
								<td><a id="idCli" onclick="excluir(${cli.id},this)"><img
										alt="trash" src="resources/img/Delete.png"
										style="width: 25px; height: 25px;"></a></td>

							</tr>

						</c:forEach>
					

				</table>
					<div id="pageNavPosition"></div>
					
				</form>
			</div>
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

			<div id="rodape">

				<jsp:include page="template/rodape.jsp"></jsp:include>
				
			</div>

		</div>
	</div>
	<script type="text/javascript">
        var pager = new Pager('tabCliente', 10); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    </script>
</body>
</html>