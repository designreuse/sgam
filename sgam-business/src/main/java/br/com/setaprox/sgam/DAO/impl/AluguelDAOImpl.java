package br.com.setaprox.sgam.DAO.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.AluguelDAO;
import br.com.setaprox.sgam.model.Aluguel;

public class AluguelDAOImpl extends AbstractDAO<Aluguel> implements AluguelDAO {

	public AluguelDAOImpl(){
		
	}
	
	@Inject
	public AluguelDAOImpl(EntityManager em){
		super(em);
	}

	@Override
	public void remove(Long id) {
		em.remove( em.getReference( Aluguel.class, id ));
	}

	@Override
	public void editar(Aluguel aluguel) {
		em.merge( aluguel );
		em.flush();
	}

	@Override
	public Aluguel find(Long id) {
		return em.find(Aluguel.class, id );
	}

	@Override
	public List<Aluguel> findAll() {
		TypedQuery<Aluguel> query = em.createQuery("SELECT a FROM Aluguel a", Aluguel.class);
		return query.getResultList();
	}

}
