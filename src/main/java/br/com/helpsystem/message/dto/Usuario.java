package br.com.helpsystem.message.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long codigo;
	private String nome;
	private String senha;
	
	@ManyToMany
	@JoinTable(name = "usuario_perfil", joinColumns = 
	@JoinColumn(name = "usuario_codigo")
	, inverseJoinColumns = @JoinColumn(name = "perfil_codigo"))
	private List<Perfil> perfil;
	
	///Getters and Setters

	public String getNome() {
		return nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Perfil> getPerfil() {
		return perfil;
	}

	public void setPerfil(List<Perfil> perfil) {
		this.perfil = perfil;
	}

	
	//GrantedAuthority
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.perfil;
		
	}
	
	@Override
	public String getPassword() {
		
		return this.senha;
		
	}
	
	@Override
	public String getUsername() {
		
		return this.nome;
		
	}
	
	@Override
	public boolean isAccountNonExpired() {
		
	return true;
	
	}
	
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
		
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
		
	}
	
	@Override
	public boolean isEnabled() {
		
		return true;
		
	}
	
	public boolean isPresent() {

		return false;
		
	}
}