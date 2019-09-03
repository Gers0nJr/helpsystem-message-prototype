package br.com.helpsystem.message.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.helpsystem.message.dto.Usuario;

public class UsuarioSistema extends User{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Usuario usuario;
	
	/**************************************************************************************/

	public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getNome(), usuario.getSenha(), usuario.getAuthorities());
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
}
