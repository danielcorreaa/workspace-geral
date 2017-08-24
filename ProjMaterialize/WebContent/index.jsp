<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="materialize/css/materialize.min.css" media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>


	<!-- Menu -->
	<jsp:include page="template/menu.jsp"></jsp:include>

	<br>
	<br>
	<br>
	<!-- <form action="#">
		
			<input name="group1" type="radio" id="test1" /> <label for="test1">Red</label>
		
			<input name="group1" type="radio" id="test2" /> <label for="test2">Yellow</label>
		
			<input class="with-gap" name="group1" type="radio" id="test3" /> <label
				for="test3">Green</label>
		
			<input name="group1" type="radio" id="test4"  />
			<label for="test4">Brown</label>
		
	</form> -->
	<br>
	<br>

	

	<div class="section no-pad-bot" id="index-banner">
		<div class="container">
			<br> <br>
			<h1 class="header center blue-text">Página Inicial</h1>
			<div class="row center">
				<h5 class="header col s12 light">Escolha uma das Opções abaixo</h5>
			</div>

			<br> <br>

		</div>
	</div>


	<div class="container">
		<div class="section">

			<!--   Icon Section   -->
			<div class="row">

				<div class="col s12 m4">
					<div class="card">
						<div class="card-image">
							<img src="images/sample-1.jpeg"> <span
								class="card-title orange-text"></span>
						</div>
						<div class="card-content">
							<p>Controle de cadastro de Clientes.</p>
						</div>
						<div class="card-action">
							<a href="cliente.html">Cadastro Cliente</a>
						</div>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="card">
						<div class="card-image">
							<img src="images/sample-2.jpg"> <span class="card-title"></span>
						</div>
						<div class="card-content">
							<p>Controle do Estoque de Filmes.</p>
						</div>
						<div class="card-action">
							<a href="#">Cadastro Filme</a>
						</div>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="card">
						<div class="card-image">
							<img src="images/sample-3.png"> <span class="card-title"></span>
						</div>
						<div class="card-content">
							<p>Locações.</p>
						</div>
						<div class="card-action">
							<a href="#">Realizar Locação</a>
						</div>
					</div>
				</div>

			</div>

		</div>
		<br> <br>

		<div class="section"></div>
	</div>

	<jsp:include page="template/rodape.jsp"></jsp:include>

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="materialize/js/materialize.min.js"></script>
	<script type="text/javascript" src="materialize/js/teste.js"></script>
</body>
</html>