package br.com.helpsystem.message.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import br.com.helpsystem.message.dto.Mensagen;
import br.com.helpsystem.message.dto.OutputMensagens;

@Controller
public class MessageController {

	@MessageMapping("/chat/{id}")
    public OutputMensagens send(Mensagen mensagens, @DestinationVariable("id") String id) {
		String dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		return new OutputMensagens(mensagens.getTexto(), mensagens.getDe(), id, dataHora);   
    }
	
	@MessageMapping("/status")
    public Mensagen sendStatus(Mensagen mensagens) {
		
		return mensagens;   
    }
	
}