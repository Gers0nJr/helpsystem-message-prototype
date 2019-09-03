package br.com.helpsystem.message.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.helpsystem.message.dto.Usuario;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long>{
	
	Usuario findByNome(String nome);
	
	@Query("select u.nome from Usuario u")
	List<Usuario> listarUsuario();

}
