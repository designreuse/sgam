package br.com.setaprox.sgam.DAO;

import java.util.List;

import br.com.setaprox.sgam.model.Historico;

public interface HistoricoDAO {
	
	void persist(Historico historico);
	
	void remove(Historico historico);
	
	Historico getById(Long id);
	
	List<Historico> getAll();
}
