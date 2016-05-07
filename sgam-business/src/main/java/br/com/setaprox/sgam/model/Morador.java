package br.com.setaprox.sgam.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.setaprox.sgam.listeners.MoradorFonetizadoListener;


@Entity
@Table( name = "morador" )
@EntityListeners({MoradorFonetizadoListener.class})
public class Morador extends AbstractEntity<Morador> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "id_morador" )
	private Long id;

	@NotNull
	@Size( max = 100 )
	@Column( name = "nome" )
	private String nome;
	
	@NotNull
	@Size( max = 100 )
	@Column( name = "nome_fonetizado" )
	private String nomeFonetizado;

	@NotNull
	@Column( name = "data_nascimento" )
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@NotNull
	@Column( name = "anos_bairro" )
	private int inicioMoradia;
	
	@Size( max = 14 )
	@Column( name = "cpf" )
	private String cpf;
	
	@Column( name = "telefone_residencial" )
	private String telefoneResidencial;
	
	@NotNull
	@Column( name = "telefone_celular" )
	private String telefoneCelular;	
	
	@Column( name = "email" )
	private String email;
	
	@NotNull
	@Column( name = "associado" )
	private String associado;
	
	@Column( name = "dia_pagamento" )
	private int diaPagamento;
	
	@Column( name = "flag_inativo" )
	private boolean flagInativo;

	//alterado pra eager momentaneamente até acertar o controle de transação
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE}/*, orphanRemoval = true*/ )
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
	private Endereco endereco;
	
	public Morador() {
		
		if(endereco == null) {
			endereco = new Endereco();
		}
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getInicioMoradia() {
		return inicioMoradia;
	}

	public void setInicioMoradia(int inicioMoradia) {
		this.inicioMoradia = inicioMoradia;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAssociado() {
		return associado;
	}

	public void setAssociado(String associado) {
		this.associado = associado;
	}

	public int getDiaPagamento() {
		return diaPagamento;
	}

	public void setDiaPagamento(int diaPagamento) {
		this.diaPagamento = diaPagamento;
	}

	public boolean isFlagInativo() {
		return flagInativo;
	}

	public void setFlagInativo(boolean flagInativo) {
		this.flagInativo = flagInativo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getNomeFonetizado() {
		return nomeFonetizado;
	}

	public void setNomeFonetizado(String nomeFonetizado) {
		this.nomeFonetizado = nomeFonetizado;
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
