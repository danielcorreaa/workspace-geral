<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="resources/css/login.css"/>
<title>Login</title>
</head>
<body>
	<div id="login">
	     <form  action="<c:url value='j_spring_security_check'/>" method="POST">
	     	<h1 class="headerLogin">Acessar o Sistema</h1>
	        <input type="text" name="j_username" placeholder="Login" />
	        <div style="height: 10px"></div>
	        <input type="password" name="j_password" placeholder="Senha"/>
	     	<div style="height: 20px"></div>
	        <input type="submit" name="submit" value="Entrar" style="width: 100px !important; display: inline;"/>
	     </form>
	</div>
</body>
</html>