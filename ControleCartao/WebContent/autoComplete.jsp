<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="autocomplete" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="resources/jquery/jquery-1.11.3.min.js"></script>
<title>Auto Complete</title>



</head>
<body>
     <input type="text" name="nome" id="nome" size="50" maxlength="50" />
  
	 <autocomplete:campoAutoComplete complete="mvc?logica=AjaxCompleterClienteLogic" target="nome" minLenght="2"></autocomplete:campoAutoComplete>	
	
</body>
</html>