package br.com.setaprox.sgam.DAO.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.EnderecoDAO;
import br.com.setaprox.sgam.model.Endereco;


public class EnderecoDAOImpl extends AbstractDAO<Endereco> implements EnderecoDAO {
	
	public EnderecoDAOImpl() {
		this(null);
	}
	
	@Inject
	public EnderecoDAOImpl(EntityManager em){
		super(em);
	}
	
	public Endereco find(Long id){
		return em.find(Endereco.class, id );
	}
}
