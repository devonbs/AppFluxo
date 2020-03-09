package br.com.devon.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.devon.bo.FluxoBO;
import br.com.devon.dto.ProdutoPessoaSolicitacaoDTO;
import br.com.devon.dto.ProdutosAprovacaoDTO;

@Path("/")
public class AppFluxoService {
	
	private FluxoBO fluxoBo = new FluxoBO();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/novaSolicitacao")
	public Response novaSolicitacao(ProdutoPessoaSolicitacaoDTO produtoPessoaSolic) {
		try {
			return Response.ok(fluxoBo.novaSolicitacao(produtoPessoaSolic.getNomePessoa(), produtoPessoaSolic.getDescricaoProduto(), produtoPessoaSolic.getPrecoProduto()))
					.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/buscarProdutosParaAprovacao")
	public Response buscarProdutosParaAprovacao() {
		try {
			return Response.ok(fluxoBo.buscarProdutosParaAprovacao()).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/aprovarSolicitacao")
	public Response aprovarSolicitacao(ProdutosAprovacaoDTO produtosAprovacao) {
		try {
			return Response.ok(fluxoBo.aprovarSolicitacao(produtosAprovacao.getIdSolicitacao())).build();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/reprovarSolicitacao")
	public Response reprovarSolicitacao(ProdutosAprovacaoDTO produtosAprovacao) {
		try {
			return Response.ok(fluxoBo.reprovarSolicitacao(produtosAprovacao)).build();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/filtrarLista")
	public Response filtrarLista(ProdutosAprovacaoDTO produtoFiltro) {
		try {
			return Response.ok(fluxoBo.buscarProdutosFiltro(produtoFiltro)).build();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarTodos/")
	public Response buscarHospedes() {
		return Response.ok(fluxoBo.buscarTodos()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarHospedesResidentes/")
	public Response buscarHospedesResidentes() {
		return Response.ok(fluxoBo.buscarHospedesResidentes()).build();
	}*/
	
	
	/*
	@POST
	@Produces("application/json;odata=verbose")
	@Consumes("application/json;odata=verbose")
	@Path("/novaHospedagem")
	public String novaHospedagem(ProdutosAprovacaoDTO hospedagem) {
		try {
			fluxoBo.novaHospedagem(hospedagem.getHospede(), hospedagem.getDataEntrada(), hospedagem.getDataSaida(), hospedagem.isAdicionalVeiculo());
		} catch (Exception e) {
			return e.getMessage();
		}
		return "";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarGastosHospedes")
	public Response buscarGastosHospedes() {
		return Response.ok(fluxoBo.buscarGastosHospedes()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarGastoTotalHospede/{nome}")
	public Response buscarGastoTotalHospede(@PathParam("nome") String nome) {
		return Response.ok(fluxoBo.buscarGastoTotalHospede(nome)).build();
	}*/
	
}
