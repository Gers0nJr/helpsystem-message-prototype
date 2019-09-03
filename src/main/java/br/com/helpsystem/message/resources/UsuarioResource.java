package br.com.helpsystem.message.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpsystem.message.dto.Usuario;
import br.com.helpsystem.message.repository.Usuarios;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	@Autowired
	private Usuarios usuarios;
	
	@GetMapping
	public List<Usuario> listarUsuarios(){
		
		return usuarios.listarUsuario();
		
	}

}
