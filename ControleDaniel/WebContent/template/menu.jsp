<script type="text/javascript" src="resources/js/login.js"></script>

<style>
 a{
   cursor: pointer;
   color: #039be5 !important;
 }
</style>
<form method="post" action="logout.do" id="formSair">
<nav>
	<div class="nav-wrapper  white">
		<img src="resources/img/logo.png" alt="logo" title="Logo Sistema" style="width: 60px; height: 60px;"/>	
		<a href="home.do" class="brand-logo" style="padding-left: 10px;">Controle Cartão</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down  white">
			<li><a href="home.do">Home</a></li>
			<li><a href="estabelecimento.do">Estabelecimeno</a></li>
			<li><a href="produto.do">Produto</a></li>
			<li><a href="compra.do">Compra</a></li>
			<!-- <li><a href="fatura.jsp">Fatura</a></li> -->
			<li><a onclick="sair()" >Sair</a></li>
		</ul>
		
	</div>
</nav>
</form>
<br>

