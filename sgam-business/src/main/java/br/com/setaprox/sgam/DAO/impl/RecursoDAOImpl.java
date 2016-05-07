package br.com.setaprox.sgam.DAO.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.RecursoDAO;
import br.com.setaprox.sgam.model.Recurso;

public class RecursoDAOImpl extends AbstractDAO<Recurso> implements RecursoDAO {

	public RecursoDAOImpl(){
		this(null);
	}
	
	@Inject
	public RecursoDAOImpl(EntityManager em){
		super(em);
	}

	@Override
	public void remove(Long id) {
		em.remove( em.getReference( Recurso.class, id ));
	}

	@Override
	public void editar(Recurso recurso) {
		em.merge( recurso );
		em.flush();
	}

	@Override
	public Recurso find(Long id) {
		return em.find(Recurso.class, id );
	}

	@Override
	public List<Recurso> findAll() {
		TypedQuery<Recurso> query = em.createQuery("SELECT r FROM Recurso r", Recurso.class);
		return query.getResultList();
	}

}
