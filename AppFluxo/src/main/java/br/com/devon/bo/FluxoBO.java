package br.com.devon.bo;

import java.util.List;

import org.hibernate.Session;

import br.com.devon.conexao.HibernateUtil;
import br.com.devon.dao.FluxoDAO;
import br.com.devon.dto.ProdutosAprovacaoDTO;

public class FluxoBO {
	
	private FluxoDAO fluxoDao = new FluxoDAO();
	
	private static Session sessao = HibernateUtil.getSessionFactory().openSession();
	
	public String novaSolicitacao(String nomePessoa, String descricaoProduto, double precoProduto) throws Exception {
		try {
			sessao.beginTransaction();
			fluxoDao.novaSolicitacao(sessao, nomePessoa, descricaoProduto, precoProduto);
			sessao.getTransaction().commit();
		} catch (Exception e) {
			sessao.getTransaction().rollback();
			throw new Exception(e.getMessage());
		} 
		return "Inserido com Sucesso";
	}
	
	public List<ProdutosAprovacaoDTO> buscarProdutosParaAprovacao() throws Exception {
		List<ProdutosAprovacaoDTO> produtosAprovacao = null;
		try {
			sessao.beginTransaction();
			produtosAprovacao = fluxoDao.buscarProdutosParaAprovacao(sessao);
			sessao.getTransaction().rollback();
		} catch (Exception e) {
			sessao.getTransaction().rollback();
			throw new Exception(e.getMessage());
		} 
		return produtosAprovacao;
	}
	
	public String aprovarSolicitacao(Integer idSolic) throws Exception {
		try {
			sessao.beginTransaction();
			fluxoDao.aprovarSolicitacao(sessao, idSolic);
			sessao.getTransaction().commit();
		} catch (Exception e) {
			sessao.getTransaction().rollback();
			throw new Exception(e.getMessage());
		}
		return "Produto aprovado";
	}
	
	public String reprovarSolicitacao(ProdutosAprovacaoDTO produtoReprovacao) throws Exception {
		try {
			sessao.beginTransaction();
			fluxoDao.reprovarSolicitacao(sessao, produtoReprovacao);
			sessao.getTransaction().commit();
		} catch (Exception e) {
			sessao.getTransaction().rollback();
			throw new Exception(e.getMessage());
		}
		return "Produto Reprovado";
	}
	
	public List<ProdutosAprovacaoDTO> buscarProdutosFiltro(ProdutosAprovacaoDTO filtro) throws Exception {
		 List<ProdutosAprovacaoDTO> produtos = null;
		try {
			sessao.beginTransaction();
			produtos = fluxoDao.buscarProdutosFiltro(sessao, filtro);
			sessao.getTransaction().commit();
		} catch (Exception e) {
			sessao.getTransaction().rollback();
			throw new Exception(e.getMessage());
		}
		return produtos;
	}

}
