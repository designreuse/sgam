package br.com.setaprox.sgam.DAO;

import java.util.List;

import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.ContasReceber;

public interface ContasReceberDAO {
	
	void persist( ContasReceber contasReceber ) ;
	
	void remove(ContasReceber contasReceber);
	
	void remove(Long id) throws PersistenceException;
	
	void editar( ContasReceber contasReceber );
	
	ContasReceber find( Long id ) ;
	
	List<ContasReceber> findAll();
	
}
