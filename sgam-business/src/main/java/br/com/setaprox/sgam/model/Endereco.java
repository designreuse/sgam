package br.com.setaprox.sgam.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table( name = "endereco" )
public class Endereco extends AbstractEntity<Endereco> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "id_endereco" )
	private Long id;

	@NotNull
	@Size( max = 45 )
	@Column( name = "cidade" )
	private String cidade;

	@NotNull
	@Size( max = 45 )
	@Column( name = "bairro" )
	private String bairro;
	
	
	@NotNull
	@Size( max = 45 )
	@Column( name = "rua" )
	private String rua;
	
	@Column( name = "numero" )
	private int numero;
	
	@Size( max = 9 )
	@Column( name = "cep" )
	private String cep;

	@Column( name = "flag_inativo" )
	private boolean flagInativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public boolean isFlagInativo() {
		return flagInativo;
	}

	public void setFlagInativo(boolean flagInativo) {
		this.flagInativo = flagInativo;
	}
	
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
