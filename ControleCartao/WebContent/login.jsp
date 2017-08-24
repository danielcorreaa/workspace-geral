<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta  charset="UTF-8">
<!-- meu css -->
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="materialize/css/materialize.min.css" media="screen,projection" />
	
<!-- meu icone -->
<link rel="icon" href="./resources/img/logo.png" type="image/x-icon">
	
<!-- meu javascript -->
	<script type="text/javascript" src="resources/js/login.js"></script>
	<script type="text/javascript" src="resources/js/usuario.js"></script>
	
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<style type="text/css">
a {
	cursor: pointer;
}
</style>

<title>Login</title>
</head>
<body>
	

			<div id="fundo" style="width: 100%">
				<!-- tela login -->
				<div id="login"
					style="min-width: 300px; width: 30%; margin-top: 50px !important; margin: auto;">

					<div class="row">
					
						<div class="col s12 m12" align="center">
						
							<div class="card white" >
							
								<form class="col s12" method="post" action="login" id="myForm">
									
									<div class="card-content blue-text">
									
										<span class="card-title blue-text">Acesso</span>
										<br>
										<br>										
										
									    <img id="imgLogin" src="resources/img/logo.png" alt="logo" title="Logo Sistema"/>		
									    
										<!-- form -->

										<div class="row">
											<div class="input-field col s12">
												<input id="user" name="user" type="text" class="validate">
												<label for="user" style="color: #039be5;">Usuário</label>
											</div>
											<div class="input-field col s12">
												<input id="senha" name="senha" type="password"
													class="validate"> <label for="senha"
													style="color: #039be5;">Senha</label>
											</div>
											
										</div>
										
										<div style="clear: both;"></div>

									</div>
									<div class="card-action">
										<a onclick="login()" class="btmAcessar">Acessar</a> 
										<a onclick="cadastrar()" class="btmNovaConta">Nova
											Conta</a>
									</div>
									<br>
									<br>
									<br>
								</form>
								
							</div>
							
						</div>
					</div>

				</div>

				<!-- Cadastro novos Usuários -->
				<div id="cadUser"
					style="min-width: 300px; width: 30%; margin-top: 50px !important; margin: auto; display: none;">

					<div class="row">
						<div class="col s12 m12" align="center">
							<div class="card white">
								<div class="card-content blue-text">
									<span class="card-title">Cadastro Usuário</span>

									<!-- form -->
									<form class="col s12">
										<input type="hidden" name="id_usuario" id="id_usuario">
										<div class="row">
											<div class="input-field col s12">
												<input id="nome" name="nome" type="text" class="validate">
												<label for="nome" style="color: #039be5">Nome</label>
											</div>
											<div class="input-field col s12">
												   <input id="loginCad" name="loginCad" type="text" class="validate" onblur="virificarDuplicidade()"> 
												   <label for="loginCad" style="color: #039be5">Login</label>
											</div>
											<div class="input-field col s12">
												<input id="senhaCad" name="senhaCad" type="password"
													class="validate"> <label for="senhaCad"
													style="color: #039be5">Senha</label>
											</div>
											<div class="input-field col s12">
												<input id="confirmarSenha" name="confirmarSenha"
													type="password" class="validate"> <label
													for="confirmarSenha" style="color: #039be5">Confirmar
													Senha</label>
											</div>
										</div>
									</form>
									
									<div style="clear: both;"></div>

								</div>
								<div class="card-action">
									<a onclick="salvar()" class="btmSalvar">Salvar</a> 
									<a onclick="voltar()" class="btmVoltar">Voltar</a>
								</div>
								<br>
								<br>
							</div>
						</div>
					</div>

				</div>
				
			</div>
		
		<div id="msgLogin" style="background-color: #ff8a80; text-align: center; color: #fff">				
					<c:if test="${msg!=null}">
						${msg}
					</c:if>
		</div>
	
	

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="materialize/js/materialize.min.js"></script>


</body>
</html>