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

<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
<script type="text/javascript" src="resources/js/fatura.js"></script>
<title>Home</title>
</head>
<body>


	<!-- Menu -->
	<jsp:include page="../template/menu.jsp"></jsp:include>



	<!-- form -->
	
	<div class="container">
		<div class="section">

			<!--   Icon Section   -->
			<div class="row">
				<div class="col s12 m12">
					<div class="card-panel white" style="min-height: 400px; overflow: auto !important; ">
						
						<div class="card-content pink-text" style="padding: 20px">
							<span class="card-title blue-text">Início</span>
							<p>Bem-Vindo: ${user.nome}</p>
						</div>
						
						<!-- 
						<h5 class="pink-text" style="margin-left: 30px;">Pesquisar Fatura</h5>
						
						<div style="height: 10px;"></div>
						
						<div class="input-field col s4" style="width: 200px !important; margin-left: 20px;">
						
							<select id="mes" name="mes" onchange="pesquisarFatura()">
								<option value="" disabled selected>Escolha sua Opção</option>
								<option value="Janeiro">Janeiro</option>
								<option value="Fevereiro">Fevereiro</option>
								<option value="Março">Março</option>
								<option value="Abril">Abril</option>
								<option value="Maio">Maio</option>
								<option value="Junho">Junho</option>
								<option value="Julho">Julho</option>
								<option value="Agosto">Agosto</option>
								<option value="Setembro">Setembro</option>
								<option value="Outubro">Outubro</option>
								<option value="Novembro">Novembro</option>
								<option value="Dezembro">Dezembro</option>
							</select> <label>Selecionar Mês</label>
							
						</div>
						<div id="direito">
						<div style="height: 10px;"></div>
						<h5 class="white-text" style="margin-left: 30px;">Resultado Pesquisa</h5>
						  <table style="margin-left: 30px; color: #fff">
						        <thead>
						          <tr>
						          	  <th>Loja</th>
						              <th>Produto</th>
						              <th>Data Compra</th>
						              <th>Valor</th>
						              <th>Parcela</th>
						              <th>N Parcelas Restantes</th>
						          </tr>
						        </thead>
								<tbody>
								<c:if test="${compras!=null }">
									<c:forEach var="compra" items="${compras}">
										<tr>
											<td>${compra.estabelecimento.nomeEstabelecimento}</td>
											<td>${compra.produto.nomeProd}</td>
											<td>${compra.dataCompra}</td>
											<td>${compra.produto.preco}</td>
											<td>${compra.tipoPagamento}</td>	
											<td>${compra.qtdeRestanteParcelas}</td>										
										</tr>
									</c:forEach>
								</c:if>
								</tbody>
						      
						          
				      </table>
				      <div class="clear"></div>
					</div>	
				</div>	
						 -->
					</div>
				</div>

				<div class="col s12 m8" style="display: none">
					<div class="card-panel white"></div>
				</div>

				
			</div>

		</div>
	</div>



	<!-- Rodape -->
	<jsp:include page="../template/rodape.jsp"></jsp:include>



	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="materialize/js/materialize.min.js"></script>


</body>
</html>