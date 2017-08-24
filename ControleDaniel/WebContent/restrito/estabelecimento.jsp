<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- meu javascript -->
<script type="text/javascript" src="resources/js/estabelecimento.js"></script>
<script type="text/javascript" src="resources/js/paginacao.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">

<!-- meu icone -->
<link rel="icon" href="./resources/img/logo.png" type="image/x-icon">

<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="materialize/css/materialize.min.css" media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="js/jquery-1.11.3.js" type="text/javascript"></script>

		<script>
			$(document).ready(function() {
		
				//$('.ajax-link').click(function() {
					$('.page-content').hide();
					var category = $('.ajax-link').attr("data-catego");
					// the URL for the request
					$.get('estabelecimento.do', {
						// Parameter to be sent to server side
						category : category
					}, function(jsonResponse) {
						var tabela = "<table border='1'> <thead> <tr> ";
						tabela += "<td> nome </td> <td> cpf </td> </tr> </thead> <tbody>"
						
						var table = "<table border='1'> <thead> <tr> <td> nome </td> <td> cpf </td> </tr> </thead> <tbody></tbody> </table>";
						
						$.each(jsonResponse, function(estabelecimento, value) {							
							
							var i = 0;
								console.log(value);
								//tabela += "<tr> <td>" +value.nome+ "</td>"+
										  //"<td>" +value.cpf+  "</td> </tr>";
							//}
							
						});
							tabela +=" </tbody> </table>"
							
							document.getElementById("resposta").innerHTML = tabela;  
						$('.page-content').show();
					});
				});
			//});
		</script>


<title>Estabelecimento</title>
</head>
<body >
	<a href="#" class="ajax-link" data-catego="serial">Top 5 Serial</a>
	<div class="page-content">
                     <div id="resposta"></div>   
    </div>
	
	<!-- Menu -->
	<jsp:include page="../template/menu.jsp"></jsp:include>


	<!-- form -->
	<div class="container">
	<div class="section">
	<div class="row" id="tabela" style="min-height: 400px">
		<div class="col s12">
			<div class="card  white" style="overflow: auto;">
				<div class="card-content blue-text">
				
					 
					 
					 <h3>Result will be displayed below via Ajax</h3>
					 
                
					<span class="card-title">Estabelecimentos Cadastrados</span>
					<div id="pageNavPosition" style="text-align: center;"></div>
					<div class="responsive-table" id="mytable">

						

						

					</div>
				</div>
				<div class="card-action">
					<a onclick="cadastrarE()" class="novoCadastro">Novo Cadastro</a>
				</div>
			</div>
		</div>
	</div>

	<div class="row" style="display: none; min-height: 400px" id="cadastro">
		<div class="col s6" >
		
			<div class="card white">
		
			
				<div class="card-content black-text">
				
					<span class="card-title">Cadastro Estabelecimentos</span>
					
					<form class="col s12">
					
						<div class="row">
							<input type="hidden" name="id_estabelecimento"
								id="id_estabelecimento" />
							<div class="input-field col s12">
								<input id="name" name="name" type="text" class="validate">
								<label style="color: #039be5;" for="name">Name</label>
							</div>
						</div>
					</form>
					<div style="clear: both;"></div>
				</div>
				<div class="card-action">					
					<a onclick="voltarE()" class="btmVoltar" style="display: inline-block;" >Voltar</a>
					<a onclick="salvarE();" class="btmSalvar" style="float: right; ">Salvar</a>

				</div>
			</div>
		</div>
	</div>
	</div>
	</div>

	<!-- Rodape -->
	<jsp:include page="../template/rodape.jsp"></jsp:include>

	<div id="msg" class="tn-box-color-2">
			
		

	</div>
	

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="materialize/js/materialize.min.js"></script>


	<!-- Paginação -->
	<script type="text/javascript">
        var pager = new Pager('mytable', 5);        
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    </script>
</body>
</body>
</html>