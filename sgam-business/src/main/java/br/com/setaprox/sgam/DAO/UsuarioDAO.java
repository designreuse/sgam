package br.com.setaprox.sgam.DAO;

import java.util.List;

import br.com.setaprox.sgam.model.Usuario;

public interface UsuarioDAO {
	void persist( Usuario usuario ) ;
	
	void remove(Usuario usuario);
	
	void remove(Long id);
	
	void editar( Usuario usuario );
	
	Usuario find( Long id ) ;
	
	Usuario findByLogin(String login);
	
	List<Usuario> findAll();
}
