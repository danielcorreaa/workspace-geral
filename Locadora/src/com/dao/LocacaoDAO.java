package com.dao;

import java.util.List;


import com.modelo.Locacao;

public class LocacaoDAO extends GenericDAO<Locacao>{

	public void salvar(Locacao f) {
		if (getPorId(f.getId()) == null) {
			inserir(f);
		} else {
			alterar(f);
		}
	}

	public Locacao getPorId(Integer id) {
		if (id == null) {
			return null;
		}
		String qry = "Select loc from Locacao loc where loc.id = ?";
		Locacao f = (Locacao) em.createQuery(qry).setParameter(1, id).getSingleResult();
		return f;
	}

	public List<Locacao> listar() {
		List<Locacao> lista;
		String qry = "Select f from Locacao f";
		lista = em.createQuery(qry).getResultList();
		return lista;
	}

}
