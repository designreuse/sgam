package br.com.setaprox.sgam.model;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<T extends Serializable> implements Cloneable{

	//@Version
	@Column( name = "version" )
	private int version;
	
	public abstract Long getId();

	/**
	 * Copia o valor dos campos do objeto recebido para os campos correspondentes na referência atual. O objeto recebido deve ser do mesmo tipo do objeto atual.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void match( T entity ) throws Exception {

		if ( !this.getClass().equals( entity.getClass() ) ) { throw new IllegalArgumentException( "Objeto recebido é diferente do objeto atual!" ); }

		Field[] fieldsP1 = entity.getClass().getDeclaredFields();
		Field[] fieldsP2 = this.getClass().getDeclaredFields();

		for ( Field fieldP1 : fieldsP1 ) {

			fieldP1.setAccessible( true );

			if ( fieldP1.getName().equals( "serialVersionUID" ) ) {
				continue;
			}

			for ( Field fieldP2 : fieldsP2 ) {

				fieldP2.setAccessible( true );

				if ( fieldP1.equals( fieldP2 ) ) {

					fieldP2.set( this, fieldP1.get( entity ) );

				}

			}

		}

	}

}
