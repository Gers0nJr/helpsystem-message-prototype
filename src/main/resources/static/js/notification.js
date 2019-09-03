//Verifica e solicita se o usuario tem permissao para utilizar as notificações do Chrome
document.addEventListener('DOMContentLoaded', function () {
    if (!Notification) {
        alert('Seu browser não é compatível com notificações');
        return;
    }

    if (Notification.permission !== "granted")
        Notification.requestPermission();
});

function minhaNotificao(notificacaoOutput) {
   
	if (Notification.permission !== "granted") {
		
        Notification.requestPermission();
        
    }
	
    else {
    	
        var notificacao = new Notification(notificacaoOutput.de, {
        	
            icon: 'bootstrap/img/notification.png',
            body: notificacaoOutput.texto
            
        });

        notificacao.onclick = function adicionarChat(){
  
        		$('#textMensages').children().remove();
        		
        		$('#textMensages').append(
        				'<div class="container-fluid">'  
        					+'<div class="panel panel-default">'
        					+'<div class="panel-heading">'
        						+'<h1 class="panel-title">'
        						+'<img src="bootstrap/img/icon-user.png" width="45" height="45" alt="Cliente" class="img-circle"> <span id="user">' + $(this).text() + '</span>'
        						+'</h1>'
        					+'</div>'
        					+'<div class="panel-body">'
        					
        						+'<table class="table table-fixed" id="areaMessage">'
        							+'<tbody>'
        								+ '<tr>'
        								
        								
        								
        								+ '</tr>'
        							+'</tbody>'
        						+'</table>'
        						
        						+'<div class="col-sm-12">'
        							+'<div class="input-group">'
        								+'<input type="text" id="texto" class="form-control" placeholder="Escreva..."/>'
        								+'<span class="input-group-btn">'
        									+'<button class="btn btn-default glyphicon glyphicon-send btn-aln" id="enviar" onclick="sendMessage();" type="button"></button>'
        								+'</span>'
        							+'</div>'
        						+'</div>'
        					+'</div>'	
        				+'</div>'
        			+'</div>'
        			);
        };
    }
}

//minhaNotificao();