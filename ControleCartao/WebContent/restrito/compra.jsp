<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="materialize/css/materialize.min.css" media="screen,projection" />

<!-- meu icone -->
<link rel="icon" href="./resources/img/logo.png" type="image/x-icon">

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="resources/js/paginacao.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
<title>Compra</title>
</head>
<body>
	

	<!-- Menu -->
	<jsp:include page="../template/menu.jsp"></jsp:include>

	<!-- form -->
	<div class="container">
	<div class="section">
	<div id="introduction" class="section scrollspy">
		<div class="row" id="tabela" >
			<div class="col s12">
				<div class="card white" style="min-height: 400px; overflow: auto !important;" >
					<div class="card-content blue-text">
						<span class="card-title">Compras</span>
						<div id="pageNavPosition" style="text-align: center;"></div>
						
						<table class="responsive-table bordered" id="table">
						
							<thead>
							
								<tr>
								
									<th>Produto</th>
									<th>Estabelecimento</th>
									<th>Data Compra</th>
									<th>Tipo Pagamento</th>
									<th>Alterar</th>
									<th>Deletar</th>
									
								</tr>
								
							</thead>

							<tbody>
							
								<c:if test="${compras != null}">
									<c:forEach var="compra" items="${compras}">
									
										<tr>
										
											<td>${compra.produto.nomeProd }</td>
											<td>${compra.estabelecimento.nomeEstabelecimento }</td>
											<td><frm:formatDate value="${compra.dataCompra }"
													pattern="dd/MM/yyyy" /></td>
											<td>${compra.tipoPagamento}</td>
											<td><a class="alterar" style="color: blue"
												onclick="alterar(${compra.id});">Alterar</a></td>
											<td><a class="deletar" style="color: blue"
												onclick="deletar(${compra.id} , this);">Deletar</a></td>

										</tr>
										
									</c:forEach>
								</c:if>
							</tbody>
						</table>
						
					</div>
					<div class="card-action">
						<a onclick="cadastrar()">Novo Cadastro</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row" style="display: none; min-height: 350px" id="cadastro">
		<div class="col s12">
			<div class="card  white">
				<div class="card-content blue-text">
					<span class="card-title">Cadastro Compra</span>
					<form>
						<input type="hidden" id="id_compra" name="id_compra" />
						<div class="input-field col s12">
							<select id="estabelecimento" name="estabelecimento">
								<option value="" disabled selected>Escolha uma Opção</option>
								<c:if test="${estabelecimentos != null}">
									<c:forEach var="estabelecimento" items="${estabelecimentos}">
										<option value="${estabelecimento.id}">${estabelecimento.nomeEstabelecimento}</option>
									</c:forEach>
								</c:if>

							</select> <label>Selecione o Produto</label>
						</div>

						<div class="input-field col s12">
							<select id="produto" name="produto">
								<option value="" disabled selected>Escolha uma Opção</option>
								<c:if test="${produtos != null}">
									<c:forEach var="produto" items="${produtos}">
										<option value="${produto.id}">${produto.nomeProd}</option>
									</c:forEach>
								</c:if>
							</select> <label>Selecione o Estabelecimento</label>
						</div>

						<label for="test1">Data Compra</label> <input type="date"
							name="data" id="data" class="datepicker"> <input
							name="group1" value="avista" type="radio"
							onchange="selecionarPagamentoAvista(this);" id="test1" /> <label
							for="test1">A vista</label> <input name="group1"
							value="parcelado" type="radio"
							onchange="selecionarPagamentoParcelado(this);" id="test2" /> <label
							for="test2">Parcelado</label>
						<!-- A vista -->
						<div id="avista" style="display: none;">
							<br> <label for="valor">Valor</label> <input
								id="valorAvista" name="valorAvista" type="text" class="validate">

							

						</div>

						<!-- Parcelado -->
						<div id="parcelado" style="display: none;">
							<br> <label for="qtdeParcela">Quantidade Parcelas</label> <input
								id="qtdeParcela" name="qtdeParcela" type="text" class="validate">

							<label for="valorpar">Valor</label> 
							<input id="valorpar" name="valorpar" type="text" class="validate"> 
							
						</div>

					</form>
					<div style="clear: both;"></div>
				</div>
				<div class="card-action">
					<a onclick="salvar();">Salvar</a><a onclick="voltar()">Voltar</a>
					<div id="msg"></div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<!-- Rodape -->
	<jsp:include page="../template/rodape.jsp"></jsp:include>

	<!-- meu javascript -->
	<script type="text/javascript" src="resources/js/compra.js"></script>

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="materialize/js/materialize.min.js"></script>
	
	
	<!-- Paginação -->	
	<script type="text/javascript">
        var pager = new Pager('table', 5);
        console.log(pager.tableName)
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    </script>
</body>
</html>