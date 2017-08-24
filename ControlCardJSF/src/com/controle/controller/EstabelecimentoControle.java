package com.controle.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.controle.dao.EstabelecimentoDAO;
import com.controle.modelo.Estabelecimento;
import com.controle.rn.UtilMensagem;

@ManagedBean
@ViewScoped
public class EstabelecimentoControle implements Serializable {

	private static final long serialVersionUID = 1L;
	private Estabelecimento estabelecimento;
	private List<Estabelecimento> estabelecimentos;
	private Boolean editando;

	public EstabelecimentoControle() {
		inicializacao();
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public void inicializacao() {
		estabelecimento = new Estabelecimento();
		EstabelecimentoDAO dao = new EstabelecimentoDAO();
		estabelecimentos = dao.listar();
		editando = false;
	}

	public void salvar() {
		try{
			EstabelecimentoDAO dao = new EstabelecimentoDAO();
			dao.salvar(estabelecimento);
			UtilMensagem.msgSucesso("Sucesso!", "Estabelecimento Salvo");
		}catch(Exception ex){
			UtilMensagem.msgErro("Falha!", ex.getMessage());
		}finally {
			inicializacao();
		}
	}

	public void excluir(Estabelecimento est) {
		try{
			EstabelecimentoDAO dao = new EstabelecimentoDAO();
			Estabelecimento e = dao.getPorId(est.getId());
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
