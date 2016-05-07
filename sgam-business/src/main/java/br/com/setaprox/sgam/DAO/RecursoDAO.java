package br.com.setaprox.sgam.DAO;

import java.util.List;

import br.com.setaprox.sgam.model.Recurso;

public interface RecursoDAO {
	void persist( Recurso recurso ) ;
	
	void remove(Recurso recurso);
	
	void remove(Long id);
	
	void editar( Recurso recurso );
	
	Recurso find( Long id ) ;
	
	List<Recurso> findAll();
}
