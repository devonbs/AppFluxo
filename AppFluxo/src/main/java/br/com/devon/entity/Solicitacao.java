package br.com.devon.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "solicitacao")
@XmlRootElement
public class Solicitacao implements Serializable {
	
	private static final long serialVersionUID = 2891965966710303184L;
	
	@Id
	@Column(name = "idSolicitacao", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSolicitacao;

	@Column(name = "status")
	private Status status;
	
	@Column(name = "observacao")
	private String observacao;
	
	@OneToMany(mappedBy = "solicitacao", fetch = FetchType.LAZY)
	private List<Produto> produto;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	public Solicitacao() {
		
	}
	
	public Solicitacao(Status status) {
		this.status = status;
	}

	public Integer getIdSolicitacao() {
		return idSolicitacao;
	}

	public void setIdSolicitacao(Integer idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Produto> getProdutos() {
		return produto;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produto = produtos;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	
}
