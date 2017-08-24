<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<h2 style="margin-top: -2px; margin-left: 20px;" class="shadow5">Locadora</h2>

<select id="selecionarCor" onchange="mudarCor.bind(this)();" >
	
	<option value="#0292C0" selected="selected">Azul</option>
	<option value="#6AA63B">Verde</option>
	<option value="#D52100">Vermelho</option>
	<option value="#FBC700">Amarelo</option>
	<option value="#5122B4">Roxo</option>
</select>
 
<div
  
	style="float: right; margin-right: 200px; margin-top: -40px; color: #fff;">
	Usuario:  ${userDetails.username}
	<a href="<c:url value='/j_spring_security_logout' />" style=" margin-left: 50px;">Sair</a> 

</div>