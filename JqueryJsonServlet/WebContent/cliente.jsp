<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cliente</title>

<script src="js/jquery-1.11.3.js" type="text/javascript"></script>

		<script>
			$(document).ready(function() {
		
				//$('.ajax-link').click(function() {
					$('.page-content').hide();
					var category = $('.ajax-link').attr("data-catego");
					// the URL for the request
					$.get('clienteAction', {
						// Parameter to be sent to server side
						category : category
					}, function(jsonResponse) {
						var tabela = "<table border='1'> <thead> <tr> ";
						tabela += "<td> nome </td> <td> cpf </td> </tr> </thead> <tbody>"
						
						var table = "<table border='1'> <thead> <tr> <td> nome </td> <td> cpf </td> </tr> </thead> <tbody></tbody> </table>";
						
						$.each(jsonResponse, function(cliente, value) {							
							
							
								
								console.log(value);
								tabela += "<tr> <td>" +value.nome+ "</td>"+
										  "<td>" +value.cpf+  "</td> </tr>";
						
							
							 
						});
							tabela +=" </tbody> </table>"
							
							document.getElementById("resposta").innerHTML = tabela;  
						$('.page-content').show();
					});
				});
			//});
		</script>

</head>
<body>
		  <div class="main-content">
        <div>
             <h3>Click on the links</h3>
              <ul>
                <li><a href="#" class="ajax-link" data-catego="serial">Top 5 Serial</a></li>
                
              </ul>

                <h3>Result will be displayed below via Ajax</h3>
                <div class="page-content">
                     <div id="resposta"></div>   
                </div>
        </div>                  
      </div>
</body>
</html>