package br.com.setaprox.sgam.DAO.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.ContasReceberDAO;
import br.com.setaprox.sgam.model.ContasReceber;

public class ContasReceberDAOImpl extends AbstractDAO<ContasReceber> implements ContasReceberDAO {
	
	public ContasReceberDAOImpl() {
		this(null);
	}
	
	@Inject
	public ContasReceberDAOImpl(EntityManager em){
		super(em);
	}

	public List<ContasReceber> findAll(){
		TypedQuery<ContasReceber> query = em.createQuery("SELECT m FROM ContasReceber m", ContasReceber.class);
		return query.getResultList();	
	}
	
	public ContasReceber find(Long id){
		return em.find(ContasReceber.class, id );
	}
	
	public void remove(Long id ) throws PersistenceException {
		em.remove( em.getReference( ContasReceber.class, id ));
		em.getTransaction().commit();	

	}
	
	public void editar(ContasReceber contasReceber ) {
		em.merge( contasReceber );
		em.flush();
	}

}
