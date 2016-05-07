package br.com.setaprox.sgam.DAO;

import br.com.setaprox.sgam.model.Endereco;

public interface EnderecoDAO {
	
	void persist( Endereco endereco);
	
	Endereco find(Long id);
}
