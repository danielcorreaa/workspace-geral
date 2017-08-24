package com.controle.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.controle.dao.ProdutoDAO;
import com.controle.modelo.Produto;
import com.controle.rn.UtilMensagem;

@ManagedBean
@ViewScoped
public class ProdutoControle implements Serializable {

	private static final long serialVersionUID = 1L;
	private Produto produto;
	private List<Produto> produtos;
	private Boolean editando;

	public ProdutoControle() {
		inicializacao();
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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

	public void inicializacao() {
		produto = new Produto();
		ProdutoDAO dao = new ProdutoDAO();
		produtos = dao.listar();
		editando = false;
	}

	public void salvar() {
		try{
			ProdutoDAO dao = new ProdutoDAO();
			dao.salvar(produto);
			UtilMensagem.msgSucesso("Sucesso!", "Produto Salvo");
		}catch(Exception ex){
			UtilMensagem.msgErro("Falha!", ex.getMessage());
		}finally {
			inicializacao();
		}
	}

	public void excluir(Produto est) {
		try{
			ProdutoDAO dao = new ProdutoDAO();
			Produto e = dao.getPorId(est.getId());
			dao.excluir(e);
			UtilMensagem.msgSucesso("Sucesso!", "Excluído com Sucesso!");
			inicializacao();
		}catch(Exception ex){
			UtilMensagem.msgErro("Falha!", ex.getMessage());
		}
	}

	public void novo(){
	  inicializacao();
	  editando = true;
	}
	
	public void voltar(){
	  inicializacao();
	}

}
