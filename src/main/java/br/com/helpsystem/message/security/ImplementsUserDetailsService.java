package br.com.helpsystem.message.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.helpsystem.message.dto.Usuario;
import br.com.helpsystem.message.repository.Usuarios;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
	private Usuarios usuarios;
	
	/**************************************************************************************/
	
	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		
		Usuario usuario = usuarios.findByNome(nome);
		
		if(usuario == null){
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		return new UsuarioSistema(usuario, usuario.getAuthorities());
		
	}

}