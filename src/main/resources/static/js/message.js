$(document).ready(function(){
	
	/*document.addEventListener("visibilitychange", function() {
		
		if(document.hidden == true){
			
			console.log('janela aberta')
			
		}else if(document.hidden == false){
			
			console.log('janela fechada')
			
		}
		
		//console.log(document.hidden, document.visibilityState);
		
	}, false);

	$(window).focus(function() {
		
		console.log('voltou para janela atual');
		
	});

	$(window).blur(function() {
		
		console.log('abriu outra janela');
		
	});*/
	
	$.ajax({ 
        type: 'GET',
        contentType: 'application/json; charset=utf-8',
        url: 'http://localhost:8080/usuarios', 
        dataType: 'json',
        success: function (data) { 

        	// var listaDeUsuarios = [{'id': 1, 'nome': 'gerson', 'status': 'online'}, {'id': 3, 'nome': 'gilberto', 'status': 'online'}];
        	
			$.each(data, function(index, value){

				var username = $('#username').text();

				if (value != username){

					//if(value.status == 'online'){

						$('#lista').append('<li class="list-group-item">'
										+ '<span class="badge badge-success status"></span>'
										+ '<a class="teste">' + value);

					//}else if(value.status == 'offline'){
						
						//$('#lista').append('<li class="list-group-item">'
										// + '<span class="badge badge-error" id="status">' + value.status + '</span>'
										// + '<a class="teste">' + value.nome);
						
					//}

				}
				
		
			});

			$('li a').on('click', function(e){
				
				var de = $('#username').text();
				
				$.ajax({ 
			        type: 'GET',
			        contentType: 'application/json; charset=utf-8',
			        url: 'http://localhost:8080/mensagens?de='+de+'&para='+$(this).text(), 
			        dataType: 'json',
			        success: function (data) { 
			        	
			        	$.each(data, function(index, value){
			        		
			        		var dataHoraConvertidos = new Date(value.dataHora);
	
			        		if(value.de != de){
	
			        			//if(value.status == 'não lida'){
				        			
				        			//$('#areaMessage tbody').append('<tr><td class="col-sm-1"><img src="bootstrap/img/message-icon.png" width="45" height="45" alt="Cliente" class="img-circle"> ' + value.de + '<td class="col-sm-7"><div class="horaDataCliente">' + dataHoraConvertidos.toLocaleString() + '</div><div class="alert alert-success" role="alert"> <b>' + value.texto);
				        			
				        		//}else{
				        			
				        			$('#areaMessage tbody').append('<tr><td class="col-sm-1"><img src="bootstrap/img/message-icon.png" width="45" height="45" alt="Cliente" class="img-circle"> ' + value.de + '<td class="col-sm-7"><div class="horaDataCliente">' + dataHoraConvertidos.toLocaleString() + '</div><div class="alert alert-success" role="alert">' + value.texto);
				        		
				        		//}

			        		}else{
			        		
			        			$('#areaMessage tbody').append('<tr><td class="col-sm-1"><img src="bootstrap/img/message-icon.png" width="45" height="45" alt="Cliente" class="img-circle"> ' + value.de + '<td class="col-sm-7"><div class="horaDataCliente">' + dataHoraConvertidos.toLocaleString() + '</div><div class="alert alert-info" role="alert">' + value.texto);
			        	
			        		}

			        	});

			        	$("tr:last").get(0).scrollIntoView();
	
			        }
				});
	
				//$('#textMensages').children().remove();

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

				/*$('#enviar').click(function(){
					$('#texto').val('');
				});*/
			
				$(document).keypress(function(e) {
				  if(e.which == 13) {
			
					sendMessage();
					/*$('#texto').val('');*/
				  }
				});
			});
        }
	});	
});