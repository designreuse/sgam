package br.com.setaprox.sgam.DAO;

import java.util.List;

import br.com.setaprox.sgam.model.Aluguel;

public interface AluguelDAO {
	void persist(Aluguel aluguel ) ;
	
	void remove(Aluguel aluguel);
	
	void remove(Long id);
	
	void editar(Aluguel aluguel );
	
	Aluguel find( Long id ) ;

	List<Aluguel> findAll();
}
