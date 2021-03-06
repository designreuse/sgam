package br.com.setaprox.sgam.service;

import java.util.List;

import br.com.setaprox.sgam.dto.MoradorDTO;
import br.com.setaprox.sgam.model.Morador;

public interface MoradorService {
	void persist( Morador morador ) ;
	
	void remove(Morador morador);
	
	void remove(Long id);
	
	void editar( Morador morador );
	
	Morador find( Long id ) ;
	
	List<Morador> findMoradores( MoradorDTO moradorDTO ) ;
	
	List<Morador> findAll();
}
