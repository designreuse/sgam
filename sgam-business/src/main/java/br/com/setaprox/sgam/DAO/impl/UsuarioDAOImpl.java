package br.com.setaprox.sgam.DAO.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.UsuarioDAO;
import br.com.setaprox.sgam.model.Usuario;


public class UsuarioDAOImpl extends AbstractDAO<Usuario> implements UsuarioDAO {

	public UsuarioDAOImpl() {
		this(null);
	}
	
	@Inject
	public UsuarioDAOImpl(EntityManager em){
		super(em);
	}
	
	public List<Usuario> findAll(){
		TypedQuery<Usuario> query = em.createQuery("SELECT m FROM Usuario m", Usuario.class);
		return query.getResultList();	
	}
	
	public Usuario find(Long id){
		return em.find(Usuario.class, id );
	}
	
	public void remove(Long id ) {
		em.remove( em.getReference( Usuario.class, id ));
	}
	
	public void editar(Usuario usuario ) {
		em.merge( usuario );
		em.flush();
	}

	@Override
	public Usuario findByLogin(String login) {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login", Usuario.class).setParameter("login", login);
		return query.getSingleResult();
	}

}
