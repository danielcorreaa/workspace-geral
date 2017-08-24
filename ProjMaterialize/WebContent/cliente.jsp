<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="materialize/css/materialize.min.css" media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cliente</title>
</head>
<body>
	<!-- Menu -->
	<jsp:include page="template/menu.jsp"></jsp:include>



	<div class="section no-pad-bot" id="index-banner">
		<div class="container">
			<br> <br> <br> <br>
			<div class="row">
				<div class="col s12 ">
					<ul class="tabs ">
						<li class="tab col s3"><a class="active" href="#test1">Clientes
								Cadastrados</a></li>
						<li class="tab col s3"><a href="#test2">Novo Cadastro</a></li>
						<li class="tab col s3"><a href="#test3">Pesquisar</a></li>

					</ul>
				</div>
				<br> <br> <br> <br>
				<div id="test1" class="col s12">

					<table class="striped">
						<thead>
							<tr>
								<td>Nome</td>
								<td>Cpf</td>
								<td>Telefone</td>
								<td>Endereco</td>
								<td>Situacao</td>
								<td>Alterar</td>
								<td>Excluir</td>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>Alvin</td>
								<td>Eclair</td>
								<td>$0.87</td>
								<td>Alvin</td>
								<td>Eclair</td>
								<td><a id="idAlt" onclick="alterar(${cli.id})"><img
										alt="pencil" src="materialize/img/Search.png"
										style="width: 25px; height: 25px;"></a></td>
								<td><a id="idCli" onclick="excluir(${cli.id},this)"><img
										alt="trash" src="materialize/img/Delete.png"
										style="width: 25px; height: 25px;"></a></td>
							</tr>

						</tbody>
					</table>

				</div>

				<div id="test2" class="col s12">
					<div class="row">
						<form class="col s12">
							<input type="hidden" name="idcli" />
							<div class="row">

								<div class="input-field col s6">
									<input id="first_name" type="text" class="validate"> <label
										for="first_name">Nome</label>
								</div>

								<div class="input-field col s6">
									<input id="last_name" type="text" class="validate"> <label
										for="last_name">Cpf</label>
								</div>

							</div>
							<div class="row">
								<div class="input-field col s12">
									<input type="text" class="validate" id="telefone"> <label
										for="telefone">Telefone</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<input id="endereco" type="text" class="validate"> <label
										for="endereco">Endereço</label>
								</div>
							</div>
							<br>
							<br>
							<button class="btn waves-effect waves-light" type="submit"
								name="action">
								Salvar <i class="material-icons right">send</i>
							</button>

						</form>
					</div>

				</div>
				<div id="test3" class="col s12">Test 3</div>

			</div>
			<br> <br>
		</div>
	</div>


	<jsp:include page="template/rodape.jsp"></jsp:include>

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="materialize/js/materialize.min.js"></script>
</body>
</html>