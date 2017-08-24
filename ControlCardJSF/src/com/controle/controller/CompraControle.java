package com.controle.controller;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.controle.dao.CompraDAO;
import com.controle.dao.EstabelecimentoDAO;
import com.controle.dao.ProdutoDAO;
import com.controle.modelo.Compra;
import com.controle.modelo.Estabelecimento;
import com.controle.modelo.Produto;
import com.controle.rn.UtilMensagem;

@ManagedBean
@ViewScoped
public class CompraControle implements Serializable {

	private static final long serialVersionUID = 1L;
	private Compra compra;
	private List<Compra> compras;
	private List<Estabelecimento> estabelecimentos;
	private List<Produto> produtos;
	private Boolean editando;
	private Boolean renderizar;
	
	
	public CompraControle() {
		inicializacao();
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}
	

	public Boolean getRenderizar() {
		return renderizar;
	}

	public void setRenderizar(Boolean renderizar) {
		this.renderizar = renderizar;
	}

	public void inicializacao() {
		compra = new Compra();
		
		CompraDAO dao = new CompraDAO();
		compras = dao.listar();

		EstabelecimentoDAO daoEst = new EstabelecimentoDAO();
		estabelecimentos = daoEst.listar();

		ProdutoDAO daoProd = new ProdutoDAO();
		produtos = daoProd.listar();

		editando = false;
		renderizar = false;
	}

	public void salvar() {
		try {
			CompraDAO dao = new CompraDAO();
			dao.salvar(compra);
			UtilMensagem.msgSucesso("Sucesso!", "Compra Salvo");
		} catch (Exception ex) {
			UtilMensagem.msgErro("Falha!", ex.getMessage());
		} finally {
			inicializacao();
		}
	}

	public void excluir(Compra est) {
		try {
			CompraDAO dao = new CompraDAO();
			Compra e = dao.getPorId(est.getId());
			dao.excluir(e);
			UtilMensagem.msgSucesso("Sucesso!", "Excluído com Sucesso!");
			inicializacao();
		} catch (Exception ex) {
			UtilMensagem.msgErro("Falha!", ex.getMessage());
		}
	}

	public void novo() {
		inicializacao();
		editando = true;
	}

	public void voltar() {
		inicializacao();
	}

	public List<Estabelecimento> buscarEstabelecimento(String qry) {
		List<Estabelecimento> sugestoes = new ArrayList<Estabelecimento>();
		for (Estabelecimento e : estabelecimentos){
		   if(e.getNomeEstabelecimento().toUpperCase().startsWith(qry.toUpperCase())){
			   sugestoes.add(e);
		   }
		}
		return sugestoes;
	}

	public List<Produto> buscarProduto(String qry) {
		List<Produto> sugestoes = new ArrayList<Produto>();
		for (Produto e : produtos){
		   if(e.getNomeProd().toUpperCase().startsWith(qry.toUpperCase())){
			   sugestoes.add(e);
		   }
		}
		return sugestoes;
	}
	
	
	
	public void tipoPagamento(){
		renderizar = true;
	}
	
}
