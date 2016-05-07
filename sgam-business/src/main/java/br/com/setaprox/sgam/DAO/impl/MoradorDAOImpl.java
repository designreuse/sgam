package br.com.setaprox.sgam.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.MoradorDAO;
import br.com.setaprox.sgam.dto.MoradorDTO;
import br.com.setaprox.sgam.model.Morador;

public class MoradorDAOImpl extends AbstractDAO<Morador> implements MoradorDAO {
	
	public MoradorDAOImpl() {
		this(null);
	}
	
	@Inject
	public MoradorDAOImpl(EntityManager em){
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Morador> findMoradores(MoradorDTO moradorDTO) {
		
		StringBuilder strQuery = new StringBuilder();
		strQuery.append("select m from morador m where 1 = 1");
		
		if(moradorDTO != null) {
			
			if(!moradorDTO.getNome().isEmpty()) {
				
				strQuery.append(" and m.nome like " + "%" + moradorDTO.getNome() + "%");
				
			}
			
		}
		
		Query query = super.em.createQuery(strQuery.toString());
		
		
		try {
		
			return query.getResultList();
			
		} catch (NoResultException no) {
			
			return new ArrayList<Morador>();
			
		}

	}
	
	public List<Morador> findAll(){
		TypedQuery<Morador> query = em.createQuery("SELECT m FROM Morador m", Morador.class);
		return query.getResultList();	
	}
	
	public Morador find(Long id){
		return em.find(Morador.class, id );
	}
	
	public void remove(Long id ) {
		em.remove( em.getReference( Morador.class, id ));
	}
	
	public void editar(Morador morador ) {
		em.merge( morador );
		em.flush();
	}

}
