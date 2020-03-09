package br.com.devon.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name= "PESSOA")
@XmlRootElement
public class Pessoa implements Serializable {
	

	private static final long serialVersionUID = 2212667252626410507L;

	@Id
	@Column(name = "idPessoa", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPessoa;
	
	@Column(name = "nome")
	private String nome;	
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private List<Solicitacao> solicitacao;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Solicitacao> getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(List<Solicitacao> solicitacao) {
		this.solicitacao = solicitacao;
	}
	
}
