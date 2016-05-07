package br.com.setaprox.sgam.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

public class QueryBuilder {

	private EntityManager em;

	private StringBuilder selectColumns;
	private StringBuilder fromClauses;
	private StringBuilder whereClauses;
	private Map<Integer, Object> parameters;
	private int i;

	public QueryBuilder( EntityManager em ) {
		selectColumns = new StringBuilder();
		fromClauses = new StringBuilder();
		whereClauses = new StringBuilder();
		parameters = new HashMap<Integer, Object>();

		this.em = em;
	}

	public void resetSelectColumns() {
		selectColumns = new StringBuilder();
	}

	private void validateCallSelectColumns() {
		if ( selectColumns.length() == 0 ) { throw new IllegalStateException( "Nenhuma coluna foi adicionada no select, não é possével adicionar cláusulas where." ); }
	}

	private void validateCallFromClauses() {
		if ( fromClauses.length() == 0 ) { throw new IllegalStateException( "Nenhuma cláusula where foi adicionada, não é possével adicionar cláusulas where." ); }
	}

	public void addSelectColumn( String selectColum ) {

		if ( selectColumns.length() == 0 ) {

			selectColumns.append( "select " );

		}

		selectColumns.append( selectColum );
		selectColumns.append( ", " );

	}

	public void addFromClause( String fromClause ) {

		validateCallSelectColumns();

		if ( fromClauses.length() == 0 ) {
			fromClauses.append( "from " );
		}

		fromClauses.append( fromClause );
		fromClauses.append( " " );
	}

	public void addWhereClauseParam( String whereClause, Object param ) {

		validateCallFromClauses();

		if ( whereClauses.length() == 0 ) {
			whereClauses.append( "where 1=1 " );
		}

		whereClauses.append( "and " );
		whereClauses.append( whereClause );
		whereClauses.append( " " );

		if ( param != null ) {

			parameters.put( ++i, param );

		}

	}

	public void addWhereClause( String whereClause ) {

		addWhereClauseParam( whereClause, null );

	}

	public void addQueryLast( String query ) {

		validateCallSelectColumns();
		validateCallFromClauses();

		whereClauses.append( query );

	}

	public String getSQlQuery() throws IllegalStateException {

		validateCallSelectColumns();
		validateCallFromClauses();

		int lastIndexComma = selectColumns.lastIndexOf( "," );
		String selectColum = selectColumns.replace( lastIndexComma, lastIndexComma + 1, "" ).toString();

		return selectColum + fromClauses.toString() + whereClauses.toString();

	}

	public String getSQlQueryCount() throws IllegalStateException {

		resetSelectColumns();
		addSelectColumn( "count(*)" );

		return getSQlQuery().replace( "fetch", "" );

	}

	private void bindQueryParameters( Query query ) {

		if ( !parameters.isEmpty() ) {

			for ( Map.Entry<Integer, Object> parameter : parameters.entrySet() ) {

				if ( parameter.getValue() instanceof Date ) {
					query.setParameter( parameter.getKey(), (Date)parameter.getValue(), TemporalType.DATE );
				} else {
					query.setParameter( parameter.getKey(), parameter.getValue() );
				}

			}

		}

	}

	private Query createQuery( String sql, Class<?> classType ) {
		Query query = classType == null ? em.createQuery( sql ) : em.createNativeQuery( sql, classType );
		bindQueryParameters( query );

		return query;
	}

	public Query createQueryCount() {
		return createQueryCount( false );
	}

	public Query createQueryCountNative() {
		return createQueryCount( true );
	}

	private Query createQueryCount( boolean nativeQuery ) {

		String sqlCount = getSQlQueryCount();

		Query query = nativeQuery ? em.createNativeQuery( sqlCount ) : em.createQuery( sqlCount );
		bindQueryParameters( query );

		return query;
	}

	public Query createQuery() {
		return createQuery( getSQlQuery(), null );
	}

	public Query createNativeQuery( Class<?> classType ) {
		return createQuery( getSQlQuery(), classType );
	}

}
