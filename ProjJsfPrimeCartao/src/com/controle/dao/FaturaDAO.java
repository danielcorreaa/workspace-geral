package com.controle.dao;

import java.util.List;

import com.controle.modelo.Fatura;

public class FaturaDAO extends GenericDAO<Fatura>{
	
	public void salvar(Fatura c) {
		if (getPorId(c.getId()) == null) {
			inserir(c);
		} else {
			alterar(c);
		}
	}

	public Fatura getPorId(Integer id) {
		if (id == null) {
			return null;
		}
		String qry = "Select cli from Fatura cli where cli.id = ?";
		Fatura cli = (Fatura) em.createQuery(qry).setParameter(1, id).getSingleResult();
		return cli;
	}

	@SuppressWarnings("unchecked")
	public List<Fatura> listar() {
		List<Fatura> lista;
		String qry = "Select cli from Fatura cli";
		lista = em.createQuery(qry).getResultList();
		return lista;
	}
}
