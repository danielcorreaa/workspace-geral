package com.controle.dao;

import java.util.List;

import com.controle.modelo.Avista;



public class AvistaDAO extends GenericDAO<Avista> {

	@SuppressWarnings("unchecked")
	public List<Avista> listar() {
		List<Avista> lista;
		String qry = "Select a from Autorizacao a";
		lista =  em.createQuery(qry).getResultList();
		return lista;
	}

}
