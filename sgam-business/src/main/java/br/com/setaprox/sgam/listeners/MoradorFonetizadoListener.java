package br.com.setaprox.sgam.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.setaprox.sgam.model.Morador;
import br.com.setaprox.sgam.utils.Fonetica;

public class MoradorFonetizadoListener {
	@PrePersist
	@PreUpdate
	public void prePersist(Object entity) {
		
		Morador morador;
		
		if ((entity instanceof Morador)) {
			morador = (Morador) entity;
			String nomeFonetizado = Fonetica.fonetizar(morador.getNome());
			morador.setNomeFonetizado(nomeFonetizado);
			
		}
	}
}
