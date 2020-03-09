package br.com.devon.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.com.devon.dto.ProdutosAprovacaoDTO;
import br.com.devon.entity.Pessoa;
import br.com.devon.entity.Produto;
import br.com.devon.entity.Solicitacao;
import br.com.devon.entity.Status;

public class FluxoDAO {
	
	public void novaSolicitacao(Session sessao, String nomePessoa, String descricaoProduto, double precoProduto) {
		Pessoa pessoa = inserePessoa(sessao, nomePessoa);
		Solicitacao solic = insereSolicitacao(sessao, pessoa);
		Produto prod = insereProduto(sessao, descricaoProduto, precoProduto, solic);
	}
	
	private Pessoa inserePessoa(Session sessao, String nomePessoa) {
		Pessoa p = new Pessoa(nomePessoa);
		StringBuilder hql = new StringBuilder();
		p.setIdPessoa((Integer) sessao.save(p));
		return p;
	}
	
	private Produto insereProduto(Session sessao, String descricao, Double preco, Solicitacao solicitacao) {
		Produto prod = new Produto(descricao, preco, solicitacao);
		prod.setSolicitacao(solicitacao);
		prod.setIdProduto((Integer) sessao.save(prod));		
		return prod;
	}
	
	private Solicitacao insereSolicitacao(Session sessao, Pessoa pessoa) {
		Solicitacao solicitacao = new Solicitacao(Status.AGUARDANDO);
		solicitacao.setPessoa(pessoa);
		solicitacao.setIdSolicitacao((Integer) sessao.save(solicitacao));
		return solicitacao;
	}

	@SuppressWarnings("unchecked")
	public List<ProdutosAprovacaoDTO> buscarProdutosParaAprovacao(Session sessao) {
		StringBuilder hql = new StringBuilder();
		hql.append(" select new br.com.devon.dto.ProdutosAprovacaoDTO(solic.idSolicitacao, pes.nome, solic.status, solic.observacao, prod.descricao, prod.preco) ");
		hql.append(" from Pessoa pes ");
		hql.append(" inner join pes.solicitacao solic ");
		hql.append(" inner join solic.produto prod ");
		hql.append(" where solic.status = :status ");
		
		Query query = sessao.createQuery(hql.toString());
		query.setParameter("status", Status.AGUARDANDO);
		return query.getResultList();
	}
	
	public void aprovarSolicitacao(Session sessao, Integer idSolicitacao) {
		StringBuilder hql = new StringBuilder();
		hql.append(" update Solicitacao set status = " + Status.APROVADO.ordinal());
		hql.append(" where idSolicitacao = :idSolicitacao ");
		Query query = sessao.createQuery(hql.toString());
		query.setParameter("idSolicitacao", idSolicitacao);
		query.executeUpdate();
	}
	
	public void reprovarSolicitacao(Session sessao, ProdutosAprovacaoDTO produtoAprovacao) {
		StringBuilder hql = new StringBuilder();
		hql.append(" update Solicitacao set status = " + Status.APROVADO.ordinal());
		hql.append(" , observacao = :observacao ");
		hql.append(" where idSolicitacao = :idSolicitacao ");
		Query query = sessao.createQuery(hql.toString());
		query.setParameter("idSolicitacao", produtoAprovacao.getIdSolicitacao());
		query.setParameter("observacao", produtoAprovacao.getObservacao());
		query.executeUpdate();
	}
	
	public List<ProdutosAprovacaoDTO> buscarProdutosFiltro(Session sessao, ProdutosAprovacaoDTO filtro) {
		StringBuilder hql = new StringBuilder();
		hql.append(" select new br.com.devon.dto.ProdutosAprovacaoDTO(solic.idSolicitacao, pes.nome, solic.status, solic.observacao, prod.descricao, prod.preco) ");
		hql.append(" from Pessoa pes ");
		hql.append(" inner join pes.solicitacao solic ");
		hql.append(" inner join solic.produto prod ");
		hql.append(" where 1=1 ");
		if(filtro != null) {
			if(filtro.getIdSolicitacao() != null) {
				hql.append(" and solic.idSolicitacao = :idSolicitacao ");
			}
			if(filtro.getStatus() != null) {
				hql.append(" and solic.status = :status ");
			}
			if(filtro.getNomePessoa() != null) {
				hql.append(" and pes.nome = :nome ");
			}
			if(filtro.getDescricaoProduto() != null) {
				hql.append(" and prod.descricao = :descricao ");
			}
		}
		Query query = sessao.createQuery(hql.toString());
		if(filtro != null) {
			if(filtro.getIdSolicitacao() != null) {
				query.setParameter("idSolicitacao", filtro.getIdSolicitacao());
			}
			if(filtro.getStatus() != null) {
				query.setParameter("status", filtro.getStatus().ordinal());
			}
			if(filtro.getNomePessoa() != null) {
				query.setParameter("nome", filtro.getNomePessoa());
			}
			if(filtro.getDescricaoProduto() != null) {
				query.setParameter("descricao", filtro.getDescricaoProduto());
			}
		}
		
		return query.getResultList();
	}
	
	

}
