<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/estiloHtml.css" />
<script type="text/javascript" src="resources/js/render.js"></script>
<title>Cadastro</title>
</head>
<body>
	<div id="conteudo">

		<div id="cadastro">
			<div align="center">
				<input type="button" id="botao" onclick="voltar();" value="Voltar">
			</div>
	

				<input type="text" id="numeroHospedagem" name="numeroHospedagem" placeholder="Numero">
				<div style="height: 10px"></div>
				<input type="text" id="quarto" name="quarto" placeholder="Quarto">
				<div style="height: 10px"></div>
				<input type="text" name="entrada" id="entrada" placeholder="Entrada">
				<div style="height: 10px"></div>
				<div align="center">
					<input type="text" name="saida" placeholder="Prev. Saída">
					<input id="botao" onclick="salvar();" type="button" value="Salvar">
				</div>
		



		</div>

		<div id="tabela">


			<table>
				<div id="topTabela" align="center">
					<input id="botao" type="button" onclick="cadastrar();"
						value="Cadastrar">
				</div>
				<thead>

					<tr>
						<td width="60">Numero Hospedagem</td>
						<td>Quarto</td>
						<td>Data Entrada</td>
						<td>Data Saída</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="hospedagem" items="${hospedagens}">
						<tr>

							<td>${hospedagem.numeroHospedagem}</td>
							<td>${hospedagem.quarto.numeroPorta}</td>
							<td><frm:formatDate pattern="dd/MM/yyyy"
									value="${hospedagem.entrada}"></frm:formatDate></td>
							<td><frm:formatDate pattern="dd/MM/yyyy"
									value="${hospedagem.saida}"></frm:formatDate></td>
							<td><a href="#"> <img src="resources/img/Modify.png" /></a></td>
							<td><a href="#"> <img src="resources/img/Delete.png" /></a></td>

						</tr>
					</c:forEach>
				</tbody>

			</table>

		</div>

	</div>
</body>
</html>