package com.controle.dao;

import java.util.List;

import com.controle.modelo.Parcelado;

public class ParceladoDAO extends GenericDAO<Parcelado>{
	
	public void salvar(Parcelado c) {
		if (getPorId(c.getId()) == null) {
			inserir(c);
		} else {
			alterar(c);
		}
	}

	public Parcelado getPorId(Integer id) {
		if (id == null) {
			return null;
		}
		String qry = "Select cli from Parcelado cli where cli.id = ?";
		Parcelado cli = (Parcelado) em.createQuery(qry).setParameter(1, id).getSingleResult();
		return cli;
	}

	@SuppressWarnings("unchecked")
	public List<Parcelado> listar() {
		List<Parcelado> lista;
		String qry = "Select cli from Parcelado cli";
		lista = em.createQuery(qry).getResultList();
		return lista;
	}
}
