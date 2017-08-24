<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    
	<div class="titulo">Enviar Foto</div>
	<div id="formulario">
		<form method="post" action="FileUploadServlet"
			enctype="multipart/form-data" name="form1">
		
			<table>
				<tr>

					<th>imagem</th>
					<td><input type="file" name="imagem" value=""></td>
					
					
				</tr>
				<tr>
					<td>
						<button type="submit">::Salvar::</button>
					</td>

				</tr>

			</table>
		</form>
	</div>


</body>
</html>