<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="frm"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<title>Produto</title>
</head>
<body>
	
	<!-- Menu -->
	<jsp:include page="../template/menu.jsp"></jsp:include>
	
	<!-- form -->
	<div class="container">
	<div class="section">
	<div class="row" id="tabela" style="min-height: 400px">
		<div class="col s12">
			<div class="card  white">
				<div class="card-content blue-text">
					<span class="card-title">Produtos Cadastrados</span>
					<div id="pageNavPosition" style="text-align: center;"></div>
					
					<table class="bordered" id="table">
						<thead>
							<tr>
								<th>Produto</th>
								<th>Preço</th>
								<th>Alterar</th>
								<th>Excluir</th>
							</tr>
						</thead>
	
						<tbody>
						
						<c:if test="${produtos!=null }">
							<c:forEach var="produto" items="${produtos}">
								<tr>
									<td>${produto.nomeProd}</td>
									<td> <frm:formatNumber var="i" type="currency"  value="${produto.preco}" />${i} </td>
									<td><a class="alterar"  style="color: #fff" onclick="alterar(${produto.id} , '${produto.nomeProd}', '${produto.preco}');"><img src="resources/img/Modify.png" alt="alterar"/></a></td>
									<td><a class="deletar" style="color: #fff" onclick="deletar(${produto.id} , this);"><img src="resources/img/Delete.png" alt="excluir"/></a></td>
								</tr>
							</c:forEach>	
						</c:if>
													
						</tbody>
					</table>
					
				</div>
				<div class="card-action">
					<a onclick="cadastrar()" class="btmAcessar">Novo Cadastro</a>
				</div>
				<br>
			</div>
		</div>
	</div>

	<div class="row" style="display: none; min-height: 400px" id="cadastro">
		<div class="col s6">
			<div class="card  white">
				<div class="card-content blue-text">
					<span class="card-title center">Cadastro Produto</span>
					<form class="col s12">
						<input type="hidden" name="id_produto" id="id_produto"/>
						<div class="row">
							<div class="input-field col s12">
								<input id="nome_prod" type="text" name="nome_prod"
									class="validate"> <label style="color: #039be5;" for="nome_prod">Nome</label>
							</div>
							<div class="input-field col s12">
								<input id="preco" type="text" name="preco"
									class="validate"> <label style="color: #039be5;" for="preco">Preço</label>
							</div>							
						</div>						
					</form>
					<div style="clear: both;"></div>
				</div>
				<div class="card-action">
				
					<a onclick="voltar();" class="btmVoltar" style="display: inline-block;">Voltar</a>
					<a onclick="salvar();" class="btmSalvar" style="float: right;">Salvar</a>
					
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
	<script type="text/javascript" src="resources/js/produto.js"></script>

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
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