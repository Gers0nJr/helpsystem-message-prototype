var stompClient = null;

function setConnected(connected) {}

function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);  
    stompClient.connect({}, function(frame) {
    setConnected(true);

        var de = $('#username').text();

        stompClient.subscribe('/topic/chat/'+de, function(mensagensOutput) {
        	
         	exibirMensagens(JSON.parse(mensagensOutput.body));
	
        });
        
       /* stompClient.subscribe('/topic/status', function(statusOutput) {
         	exibirStatusLogado(JSON.parse(statusOutput.body));	
        });*/
    }); 
}

connect();

function disconnect() {
	
    if (stompClient != null) {
    	
        stompClient.disconnect();
        
    }
    
    setConnected(false);

}

function sendMessage() {
	
	var dataHora = new Date();
	
	var de = $('#username').text();
	var para = $('#user').text();
	//var status = $('#status').text();
	var status = 'não lida';
	
    var texto = document.getElementById('texto').value;

    stompClient.send("/app/chat/"+de, {de}, 
    	      JSON.stringify({'de': de, 'para': para, 'texto': texto, 'dataHora': dataHora}));
    
    stompClient.send("/app/chat/"+para, {para},
      JSON.stringify({'de': de, 'para': para, 'texto': texto, 'dataHora': dataHora}));

    $.ajax({ 
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        url: 'http://localhost:8080/mensagens', 
        data: JSON.stringify({'de': de, 'para': para, 'texto': texto, 'dataHora': dataHora}),
        success: function (data) {
        	
        	$('#texto').val('');
        	
        }
    });
}

var count = 0;

function exibirMensagens(mensagensOutput) {
	
	var de = $('#username').text();

	if(mensagensOutput.texto != ''){
		
		if(mensagensOutput.de != de){

				$('#areaMessage tbody').append('<tr><td class="col-sm-1"><img src="bootstrap/img/message-icon.png" width="45" height="45" alt="Cliente" class="img-circle"> ' + mensagensOutput.de +'<td class="col-sm-7"><div class="horaDataCliente">' + mensagensOutput.dataHora + '</div><div class="alert alert-success" role="alert">' + mensagensOutput.texto);
				//$("tr:last").get(0).scrollIntoView();

					//exibirNotificacao(mensagensOutput);
				
				$('ul li').each(function(i){
					
					if($(this).text() == mensagensOutput.de){
						
						count = count + 1;			
						$(this).html(count);
						
					}
						
					//});
						//console.log(i);
						
						//$('.status').each(function(j){
							
							//console.log(j);
							
							//if(i == j){

							//console.log(j);
								
							//}
							
	
					//}
					
				});

		}else{
		
			$('#areaMessage tbody').append('<tr><td class="col-sm-1"><img src="bootstrap/img/message-icon.png" width="45" height="45" alt="Cliente" class="img-circle"> ' + mensagensOutput.de + '<td class="col-sm-7"><div class="horaDataCliente">' + mensagensOutput.dataHora + '</div><div class="alert alert-info" role="alert">' + mensagensOutput.texto);
			//$("tr:last").get(0).scrollIntoView();
			
			
		
		}
	}	

}

function exibirNotificacao(notificacaoOutput) {
	
	minhaNotificao(notificacaoOutput);
	
}

//Status Oline ou Offiline

/*function enviandoStatus() {
	
	var de = $('#username').text();
	
	stompClient.send("/app/status", {}, 
      JSON.stringify({'de': de,'status': 'Online'}));
	
}*/

/*function exibirStatusLogado(statusOutput){
	
	$('#teste').append('Usuário logado: ' + statusOutput.de + ' - status ' + statusOutput.status);
	
}*/