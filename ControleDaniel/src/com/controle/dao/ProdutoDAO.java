package com.controle.dao;

import java.util.List;


import com.controle.modelo.Produto;

public class ProdutoDAO extends GenericDAO<Produto>{
	
	public void salvar(Produto c) {
		if (getPorId(c.getId()) == null) {
			inserir(c);
		} else {
			alterar(c);
		}
	}

	public Produto getPorId(Integer id) {
		if (id == null) {
			return null;
		}
		String qry = "Select prod from Produto prod where prod.id = ?";
		Produto cli = (Produto) em.createQuery(qry).setParameter(1, id).getSingleResult();
		return cli;
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		List<Produto> lista;
		String qry = "Select prod from Produto prod";
		lista = em.createQuery(qry).getResultList();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> buscarTodosPorUsuario(Integer id) {
		List<Produto> lista;
		String qry = "Select p from Produto p where p.usuario.id = ?";
		lista = em.createQuery(qry).setParameter(1, id).getResultList();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> getTabela() {
		List<Produto> lista;
		String qry = "Select nomeProd , preco from Produto";
		lista = em.createQuery(qry).getResultList();
		return lista;
	}
}
