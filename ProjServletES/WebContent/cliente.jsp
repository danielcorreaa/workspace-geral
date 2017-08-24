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
<title>Cliente</title>
</head>
<body onload="focus();">

	<input type="text"/>
	
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
			<div class="subcorpo">
				<h1>Cadastro Cliente</h1>
				<form id="form" method="post" action="cliente.do">
					<table>
						<tr>

							<td><input type="text" name="nome" id="nome"
								onblur="validarNome();" placeholder="Nome" /></td>
							<td><div id="valNome"></div></td>
						</tr>
						<tr>
							<td><input type="text" name="telefone" id="telefone"
								placeholder="Telefone" /></td>

						</tr>
						<tr>
							<td><input type="text" name="cpf" id="cpf"
								onkeyup="validarCPF();" placeholder="Cpf" /></td>
							<td>
								<div id="valCpf"></div>
							</td>
						</tr>
						<tr>
							<td><input type="text" name="cep" id="cep" placeholder="Cep"
								onblur="buscarPorCep();"></td>
						</tr>
						<tr>
							<td><input type="text" name="rua" id="rua" placeholder="Rua"></td>
						</tr>
						<tr>
							<td><input type="text" name="bairro" id="bairro"
								placeholder="Bairro"></td>
						</tr>
						<tr>
							<td><input type="text" name="numero" id="numero"
								placeholder="Numero"></td>
						</tr>
						<tr>
							<td><input type="text" name="cidade" id="cidade"
								placeholder="Cidade"></td>
						</tr>
						<tr>
							<td><input type="text" name="estado" id="estado"
								placeholder="Estado"></td>
						</tr>
					</table>

					<input type="submit" value="Salvar"
						style="width: 120px !important; background-color: green; color: #fff; text-align: center;" />
				</form>
				<div class="espaco10"></div>

			</div>
			<table border="1" id="tabela" style="padding: 5px;">
				<thead>
					<tr>
						<td>Nome</td>
						<td>Telefone</td>
						<td>Cpf</td>
						<td>Cep</td>
						<td>Rua</td>
						<td>Bairro</td>
						<td>Numero</td>
						<td>Cidade</td>
						<td>Estado</td>
					</tr>
				</thead>
				 <tbody>
					<c:forEach var="cliente" items="${clientes}">
						<tr>


							<td>${cliente.nome}</td>
							<td>${cliente.telefone}</td>
							<td>${cliente.cpf}</td>
							<td>${cliente.endereco.cep}</td>
							<td>${cliente.endereco.rua}</td>
							<td>${cliente.endereco.bairro}</td>
							<td>${cliente.endereco.numero}</td>
							<td>${cliente.endereco.cidade.nome}</td>
							<td>${cliente.endereco.cidade.estado.nome}</td>
							<td><img src="resources/img/Modify.png"  /></td>
							<td><a class="end" onclick="deletar( '${cliente.nome}' );"><img src="resources/img/Delete.png"/></a></td>


						</tr>
					</c:forEach>
				</tbody> 
			</table>
		</div>

	</div>

</body>
</html>