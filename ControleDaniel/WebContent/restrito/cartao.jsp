<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="materialize/css/materialize.min.css" media="screen,projection" />

<!-- meu css -->
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">

<!-- meu icone -->
<link rel="icon" href="./resources/img/logo.png" type="image/x-icon">	

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
a {
	cursor: pointer;
}
</style>
<title>Cartão</title>
</head>
<body>
	

		<div id="fundo" style="width: 100%">

			<!-- Cadastro novos Usuários -->
			<div id="cadUser"
				style="min-width: 300px; width: 30%; margin-top: 100px !important; margin: auto;">

				<div class="row">
					<div class="col s12 m12" align="center">
						<div class="card-panel white" >
							<div class="card-content blue-text">
								<span class="card-title blue-text">Cadastrar Cartão</span>

								<!-- form -->
								<form class="col s12">
									<input type="hidden" name="id_cartao" id="id_cartao">
									<div class="row">
										<div class="input-field col s12">
											<input id="bandeira" name="bandeira" type="text"
												class="validate"> <label for="bandeira"
												style="color: #039be5">Bandeira</label>
										</div>
										<div class="input-field col s12">
											<input id="limite" name="limite" type="text" class="limite">
											<label for="limite" style="color: #039be5">Limite</label>
										</div>
									</div>
								</form>
								<div style="clear: both;"></div>

							</div>
							<div class="card-action">
								<a onclick="salvar()" class="btmSalvar">Salvar</a>
							</div>
						</div>
					</div>
				</div>

			</div>

			<div id="acesso"
				style="min-width: 300px; width: 30%; margin-top: 100px !important; margin: auto; display: none;">

				<div class="row">
					<div class="col s12 m12" align="center">
						<div class="card white">
							<div class="card-content blue-text">
								<span class="card-title">Acessar</span>
							</div>
							<a href="home.do">Clique Aqui</a>
						</div>
					</div>
				</div>
			</div>

		</div>

	<div id="msg"></div>
	<!-- meu javascript -->
	<script type="text/javascript" src="resources/js/cartao.js"></script>

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="materialize/js/materialize.min.js"></script>
	<script type="text/javascript" src="materialize/js/teste.js"></script>
</body>
</html>