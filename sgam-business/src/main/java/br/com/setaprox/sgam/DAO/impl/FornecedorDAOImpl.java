package br.com.setaprox.sgam.DAO.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.FornecedorDAO;
import br.com.setaprox.sgam.model.Fornecedor;

public class FornecedorDAOImpl extends AbstractDAO<Fornecedor> implements FornecedorDAO {
	
	public FornecedorDAOImpl() {
		this(null);
	}
	
	@Inject
	public FornecedorDAOImpl(EntityManager em){
		super(em);
	}
	
	public List<Fornecedor> findAll(){
		TypedQuery<Fornecedor> query = em.createQuery("SELECT m FROM Fornecedor m", Fornecedor.class);
		return query.getResultList();	
	}
	
	public Fornecedor find(Long id){
		return em.find(Fornecedor.class, id );
	}
	
	public void remove(Long id ) {
		em.remove( em.getReference( Fornecedor.class, id ));
	}
	
	public void editar(Fornecedor fornecedor ) {
		em.merge( fornecedor );
		em.flush();
	}

}
