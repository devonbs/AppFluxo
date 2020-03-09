package br.com.devon.dto;

import java.io.Serializable;

import br.com.devon.entity.Pessoa;
import br.com.devon.entity.Produto;
import br.com.devon.entity.Solicitacao;
import br.com.devon.entity.Status;

public class ProdutosAprovacaoDTO implements Serializable{

	
	private static final long serialVersionUID = -944946272056255618L;
	
	private Integer idSolicitacao;
	private String nomePessoa;
	private Status status;
	private String observacao;
	private String descricaoProduto;
	private Double precoProduto;
	
	public ProdutosAprovacaoDTO() {
		
	}
	
	public ProdutosAprovacaoDTO(Integer idSolicitacao, String nomePessoa, Status status, String observacao, String descricaoProduto,
			Double precoProduto) {
		super();
		this.idSolicitacao = idSolicitacao;
		this.nomePessoa = nomePessoa;
		this.status = status;
		this.observacao = observacao;
		this.descricaoProduto = descricaoProduto;
		this.precoProduto = precoProduto;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
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
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public Double getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}
	public Integer getIdSolicitacao() {
		return idSolicitacao;
	}
	public void setIdSolicitacao(Integer idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}
	
}