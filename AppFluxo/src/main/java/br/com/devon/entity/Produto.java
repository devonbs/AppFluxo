package br.com.devon.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "produto")
@XmlRootElement
public class Produto implements Serializable {
	
	private static final long serialVersionUID = -7635945204936536065L;
	
	@Id
	@Column(name = "idProduto", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduto;

	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "preco")
	private Double preco;	
	
	@ManyToOne
	@JoinColumn(name = "solicitacao_id")
	private Solicitacao solicitacao;
	
	public Produto(String descricao, Double preco, Solicitacao solicitacao) {
		this.descricao = descricao;
		this.preco = preco;
		this.solicitacao = solicitacao;
	}

	public Produto() {
		
	}
	
	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
		

}
