<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!--Import materialize.css-->
	<link type="text/css" rel="stylesheet"
	href="../materialize/css/materialize.min.css" media="screen,projection" />
	
	<!-- meu icone -->
	<link rel="icon" href="./resources/img/logo.png" type="image/x-icon">

	<!--Let browser know website is optimized for mobile-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compra</title>
</head>
<body>
	<!-- Menu -->
	<jsp:include page="../template/menu.jsp"></jsp:include>
	
	<!-- form -->
	<div class="row">
        <div class="col s12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Card Title</span>
              <p>I am a very simple card. I am good at containing small bits of information.
              I am convenient because I require little markup to use effectively.</p>
            </div>
            <div class="card-action">
              <a href="#">This is a link</a>
              <a href="#">This is a link</a>
            </div>
          </div>
        </div>
      </div>
	
	<!-- Rodape -->
	<jsp:include page="../template/rodape.jsp"></jsp:include>

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="../materialize/js/materialize.min.js"></script>
	
</body>
</html>