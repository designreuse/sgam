package br.com.setaprox.sgam.DAO;

import java.util.List;

import br.com.setaprox.sgam.model.Fornecedor;

public interface FornecedorDAO {
	
	void persist( Fornecedor fornecedor ) ;
	
	void remove(Fornecedor fornecedor);
	
	void remove(Long id);
	
	void editar( Fornecedor fornecedor );
	
	Fornecedor find( Long id ) ;	
	
	List<Fornecedor> findAll();
	
}
