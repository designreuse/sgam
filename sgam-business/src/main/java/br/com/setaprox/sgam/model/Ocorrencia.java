/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.setaprox.sgam.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


@Entity
@Table(name = "ocorrencia")
public class Ocorrencia extends AbstractEntity<Ocorrencia> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ocorrencia")
    private Long id;
    
    @NotNull
    @Column(name = "local")
    private String local;
    
    @Column(name = "ponto_referencia")
    private String pontoReferencia;
    
    @NotNull
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    
    @Column(name = "prioridade")
    private String prioridade;
    
    @Column(name = "tipo")
    private String tipo;
    
    @NotNull
    @Column(name = "titulo")
    private String titulo;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "flag_inativo")
    private Boolean flagInativo;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_morador", referencedColumnName = "id_morador")
    private Morador morador;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = true, mappedBy = "ocorrencia")
    private List<Historico> historicoList;

    public Ocorrencia() {
    }

    public Ocorrencia(Long id) {
        this.id = id;
    }

    public Ocorrencia(Long id, String local, Date dataInicio, String titulo) {
        this.id = id;
        this.local = local;
        this.dataInicio = dataInicio;
        this.titulo = titulo;
    }

    @Override
    public Long getId() {
        return id;
    }
    
    
    
    public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getFlagInativo() {
		return flagInativo;
	}

	public void setFlagInativo(Boolean flagInativo) {
		this.flagInativo = flagInativo;
	}

	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
	}

	public List<Historico> getHistoricoList() {
		return historicoList;
	}

	public void setHistoricoList(List<Historico> historicoList) {
		this.historicoList = historicoList;
	}

	public void setId(Long id) {
		this.id = id;
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
