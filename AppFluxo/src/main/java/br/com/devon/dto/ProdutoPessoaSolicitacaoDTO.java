package br.com.devon.dto;

import java.io.Serializable;

public class ProdutoPessoaSolicitacaoDTO implements Serializable {
	
	private static final long serialVersionUID = 5698616596058885828L;

	private Integer idSolicitacao;
	
	private String nomePessoa;
	
	private String descricaoProduto;
	
	private Double precoProduto;
	
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
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
