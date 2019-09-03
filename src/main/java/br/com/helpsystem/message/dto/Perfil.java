package br.com.helpsystem.message.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Perfil implements GrantedAuthority, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String perfilUsuario;
	
	@ManyToMany(mappedBy = "perfil")
	private List<Usuario> usuario;
	
	public String getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(String perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	@Override
	public String getAuthority() {
		
		return this.perfilUsuario;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((perfilUsuario == null) ? 0 : perfilUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		if (perfilUsuario == null) {
			if (other.perfilUsuario != null)
				return false;
		} else if (!perfilUsuario.equals(other.perfilUsuario))
			return false;
		return true;
	}
}