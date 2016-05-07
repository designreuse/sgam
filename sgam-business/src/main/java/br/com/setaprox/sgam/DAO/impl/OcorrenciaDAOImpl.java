package br.com.setaprox.sgam.DAO.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.OcorrenciaDAO;
import br.com.setaprox.sgam.model.Ocorrencia;

public class OcorrenciaDAOImpl extends AbstractDAO<Ocorrencia> implements OcorrenciaDAO {
	
	public OcorrenciaDAOImpl() {
		this(null);
	}
	
	@Inject
	public OcorrenciaDAOImpl(EntityManager em){
		super(em);
	}
	
	public List<Ocorrencia> findAll(){
		TypedQuery<Ocorrencia> query = em.createQuery("SELECT o FROM Ocorrencia o", Ocorrencia.class);
		return query.getResultList();	
	}
	
	public Ocorrencia find(Long id){
		return em.find(Ocorrencia.class, id );
	}
	
	public void remove(Long id ) {
		em.remove( em.getReference( Ocorrencia.class, id ));
	}
	
	public void editar(Ocorrencia ocorrencia ) {
		em.merge( ocorrencia );
		em.flush();
	}
}
