	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css" />
<title>Informação</title>
</head>
<body>
	<div id="conteudo">

		<div class="aside">
		
			<h3>Usuario Logado</h3>
			<h3>${usuario.nome}</h3>
			<h3>Idade</h3>
			<h3>${usuario.idade}</h3>
			
			<jsp:include page="template/menu.jsp"></jsp:include>
		</div>

		<div class="corpo">
			
			<c:forEach var="user" items="${usuarios}">
			   ${user.nome}
			</c:forEach>
		
		</div>

	</div>
</body>
</html>