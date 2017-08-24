<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="materialize/css/materialize.min.css" media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body style="background-color: #4a148c !important;">
	<div class="col center">
		<div class="login-formulario z-depth-3">

			<form>
				<div class="input-field col s6">
					<input id="first_name" type="text" class="validate"> <label
						for="first_name">Login</label>
				</div>
				<div class="input-field col s6">
					<input id="last_name" type="password" class="validate"> <label
						for="last_name">Senha</label>
				</div>
				<button class="btn waves-effect waves-light" type="submit"
					name="action">Entrar</button>
				<button class="btn waves-effect waves-light" type="submit"
					name="action">Esqueci a Senha</button>
			</form>

		</div>
	</div>
	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="materialize/js/materialize.min.js"></script>
	<script type="text/javascript" src="materialize/js/teste.js"></script>
</body>
</html>