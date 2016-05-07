package br.com.setaprox.sgam.DAO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.setaprox.sgam.dto.PageRequestDTO;
import br.com.setaprox.sgam.dto.PagingResultDTO;
import br.com.setaprox.sgam.model.AbstractEntity;
import br.com.setaprox.sgam.utils.QueryBuilder;

public abstract class AbstractDAO<T extends Serializable> {

	private Class<T> persistentClass;
	protected EntityManager em;

	public AbstractDAO() {
		this(null);
	}
	
	public AbstractDAO(EntityManager em){
		this.em = em;
	}

	public void setEm( EntityManager em ) {

		this.em = em;

	}

	public QueryBuilder createQueryBuilder() {
		return new QueryBuilder( em );
	}

	public T merge( T entity ) {

		if ( entity == null ) { throw new IllegalArgumentException( "entity năo pode ser null" ); }

		T entityMerged = em.merge( entity );

		return entityMerged;

	}

	public T mergeWithFlush( T entity ) {

		T entityMerged = this.merge( entity );

		em.flush();

		return entityMerged;

	}

	public void persist( T entity ) {

		if ( entity == null ) { throw new IllegalArgumentException( "entity năo pode ser null" ); }

		em.persist( entity );

	}

	public T persistWithFlush( T entity ) {

		persist( entity );

		em.flush();

		return entity;

	}

	public T find( Long id ) {

		if ( id == null ) { throw new IllegalArgumentException( "id năo pode ser null" ); }

		return em.find( this.persistentClass, id );

	}

	public T getReference( Long id ) {

		if ( id == null ) { throw new IllegalArgumentException( "id năo pode ser null" ); }

		return em.getReference( this.persistentClass, id );

	}

	public T refresh( Long id ) {

		T t = (T)em.find( persistentClass, id );

		if ( t != null ) {
			em.refresh( t );
		}

		return t;

	}

	public void remove( T entity ) {

		@SuppressWarnings( { "rawtypes" } )
		Long id = ((AbstractEntity)entity).getId();
		entity = getReference( id );
		em.remove( entity );
		
	}

	public Long getId( String sequence ) {

		String sql = " select fnc_proximo_registro_unico('" + sequence + "') from dual ";

		Query query = em.createNativeQuery( sql );

		return ( (BigDecimal)query.getSingleResult() ).longValue();

	}


	@SuppressWarnings( "unchecked" )
	public List<T> findAll() {
		return em.createQuery( "Select t from " + persistentClass.getSimpleName() + " t" ).getResultList();
	}

	@SuppressWarnings( "unchecked" )
	public T update( T entity ) throws Exception {

		Long id = ( (AbstractEntity<T>)entity ).getId();

		AbstractEntity<T> managedEntity = (AbstractEntity<T>)em.find( entity.getClass(), id );

		managedEntity.match( (T)entity );

		return (T)managedEntity;

	}

	
	public T updateWithFlush( T entity ) throws Exception {

		T entityUpdate = this.update( entity );
		em.flush();
		return entityUpdate;

	}
	
	
	public <F> PagingResultDTO<T> createPagingResultDTO(QueryBuilder queryBuilder, PageRequestDTO<F> filterPageRequest) {
		
		Query query = queryBuilder.createQuery(); 
		
		@SuppressWarnings( "unchecked" )
		List<T> list = query.setFirstResult( filterPageRequest.getStart() ).setMaxResults( filterPageRequest.getTotal() ).getResultList();

		query = queryBuilder.createQueryCount();

		Long rowCount = (Long)query.getSingleResult();

		return new PagingResultDTO<T>( list, rowCount.intValue() );
	}


}
