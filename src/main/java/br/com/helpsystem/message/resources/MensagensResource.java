package br.com.helpsystem.message.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpsystem.message.dto.Mensagen;
import br.com.helpsystem.message.repository.MessagesRepository;

@RestController
@RequestMapping("/mensagens")
public class MensagensResource {
	
	@Autowired
	private MessagesRepository messagesRepository;
	
	@GetMapping
	public List<Mensagen> listarMensagens(@RequestParam(value="de") String de, @RequestParam(value="para") String para){
		
		//return messagesRepository.findAll();
		
		return messagesRepository.listaMensagem(de, para);
		
	}
	
	/*@GetMapping("/nlidas")
	public List<Mensagen> msgNaoLidas(){
		
		//return messagesRepository.findAll();
		
		return messagesRepository.listaMensagensNaoLidas();
		
	}*/
	
	@PostMapping
	public ResponseEntity<Mensagen> salvar(@RequestBody Mensagen mensagen) {
		
		//messagesRepository.save(mensagen);
		return new ResponseEntity<Mensagen>(mensagen, HttpStatus.OK);
	}
}
