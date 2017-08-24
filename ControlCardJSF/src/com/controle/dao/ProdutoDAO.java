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
}
