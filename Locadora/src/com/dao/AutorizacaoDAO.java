package com.dao;

import java.util.List;

import com.modelo.Autorizacao;


public class AutorizacaoDAO extends GenericDAO<Autorizacao> {

	

	@SuppressWarnings("unchecked")
	public List<Autorizacao> listar() {
		List<Autorizacao> lista;
		String qry = "Select a from Autorizacao a";
		lista =  em.createQuery(qry).getResultList();
		return lista;
	}

}
