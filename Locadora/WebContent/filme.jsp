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
		<script type="text/javascript" src="resources/js/jquery.wallform.js"></script>
		<script type="text/javascript" src="resources/js/layout.js"></script>
		<title>Filmes</title>
		<script type="text/javascript">
			$(document).ready(function() {
		
				$('#imagem').die('click').live('change', function() {
		
					$("#form").ajaxForm({
		
					}).submit();
				});
			});
		
			function inserirValor() {
				var val = document.getElementById("imagem");
				var pos = document.getElementById("poster");
				pos.style.display = (pos.style.display == "block") ? "none" : "block"
				document.getElementById("image").src = 'imagem/'
						+ val.value.split("\\")[2];
		
				var imagem = document.getElementById("caminhoImg");
				imagem.value = val.value.split("\\")[2];
				document.getElementById("caminhoImg").value + val.value.split("\\")[2];
			}
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
			<div id="formulario">

				<form id="form" method="post" action="filme.do"
					enctype='multipart/form-data'>

					<h1 class="GeosansLight" style="text-align: center; color: #fff">Cadastro</h1>

					<div id='imageloadbutton' class="imagem" style="margin: auto;">
						<input type="file" onchange="inserirValor();" name="photos[]"
							id="imagem" class="imagem"  title="Escolha Imagem">


					</div>
				</form>
				<form method="post" action="filme.do">
					<div id="poster">
						<img alt="Imagem falhou" src="imagem/carriers_2.jpg" id="image"
							style="width: 150px; height: 200px;"> 
							<input type="hidden"
							name="caminhoImg" id="caminhoImg" />
					</div>

					<input type="hidden" name="idfil" value="${fil.id}" />


					<div style="height: 10px;"></div>

					<div style="height: 10px;"></div>
					<input name="titulo" type="text" value="${fil.titulo}"
						placeholder="Titulo" style="text-align: center;" /><br>
					<div style="height: 10px;"></div>

					<div style="height: 10px;"></div>
					<input name="preco" type="text" value="${fil.preco}"
						placeholder="Preço" style="text-align: center;" /><br>



					<div style="height: 20px;"></div>
					
					<div align="center">
						<input type="hidden" value="salvar" name="acao"> <input
							type="hidden" value="" name="idD" id="idD"> <input
							name="salvar" value="Salvar" type="submit"
							style="background-color: green; color: #fff; font-weight: bold; width: 100px !important;" />
					</div>

				</form>
			</div>

			<div class="fundoTabela">
				<div style="height: 30px;"></div>
				<h2 style="text-align: center;">Lista de /filmes</h2>
				<div style="height: 30px;"></div>

				<table>

					<thead style="border: 1px solid rgb(069, 118, 149);">
						<tr style="border: 1px solid rgb(069, 118, 149);">
							<td>Titulo</td>
							<td>Preço</td>
							<td>Situação</td>
							<td>Alterar</td>
							<td>Excluir</td>
						</tr>
					</thead>
					<tbody style="border: 1px solid rgb(069, 118, 149);">

						<c:forEach var="fil" items="${listaFilmes}">
							<tr>
								<td>${fil.titulo}</td>
								<td>${fil.preco}</td>
								<td>${fil.status}</td>

								<td><a href="filme.do?acao=alterar&id=${fil.id}"><img
										alt="pencil" src="resources/img/Search.png"
										style="width: 25px; height: 25px;"></a></td>
								<td><a href="filme.do?acao=excluir&id=${fil.id}"
									onclick="return confirm('Deseja realmente excluir')"><img
										alt="trash" src="resources/img/Delete.png"
										style="width: 25px; height: 25px;"></a></td>

							</tr>

						</c:forEach>


					</tbody>

				</table>

			</div>
			<div class="msg">
				<c:if test="${up!=null}">
					<h4
						style="background-color: #556B2F; text-align: center; color: #fff; padding: 5px;">
						${up}</h4>
				</c:if>
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
</body>
</html>