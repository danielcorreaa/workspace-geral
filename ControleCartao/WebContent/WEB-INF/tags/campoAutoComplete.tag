<%@ attribute name="target" required="true" description="id do input text onde o autocomplete ser� feito"%>
<%@ attribute name="complete" required="true" description="servlet respons�vel por processar os dados enviados"%>
<%@ attribute name="minLenght" required="true" description="N�mero m�nimo de itens que o usuario deve digitar para que a pesquisa seja feita"%>
<%@ attribute name="formSubmit" required="false" description="Recebe o id do formulario e o submete caso o usu�rio clique no item da lista"%>
 
 
<script type="text/javascript">
$("#${target}").autocomplete({          
            delay: 100, /*O atraso em milissegundos entre o momento em que a tecla � pressionada e a pesquisa � feita.*/
            minLength: ${minLenght}, /*N�mero m�nimo de itens que o usuario deve digitar para que a pesquisa seja feita*/
            autoFocus: true, /*Se true, o primeiro item da lista receber� automaticamente o focus*/        
            source: function(request, response) {
                $.ajax({
                    url: "${complete}",
                    dataType: "json",
                    data: request,
                    success: function(data) {                       
                         console.log(data);
                         var items = data;                       
                         response(items);
                    },
                    error: function(jqXHR, textStatus, errorThrown){
                         console.log( textStatus);
                    }
                });
            },
            select: function(event, ui) {
                var form = "${formSubmit}";             
                if((ui.item) && (form.length)){                                 
                    $('#${target}').val(ui.item.value);
                    $('#${formSubmit}').submit();
                }              
            }
      
        });
</script>     