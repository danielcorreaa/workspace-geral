package com.dao;

import java.util.List;

import com.modelo.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {

	
	public void salvar(Cliente c) {
		if (getPorId(c.getId()) == null) {
			inserir(c);
		} else {
			alterar(c);
		}
	}

	public Cliente getPorId(Integer id) {
		if (id == null) {
			return null;
		}
		String qry = "Select cli from Cliente cli where cli.id = ?";
		Cliente cli = (Cliente) em.createQuery(qry).setParameter(1, id).getSingleResult();
		return cli;
	}

	public List<Cliente> listar() {
		List<Cliente> lista;
		String qry = "Select cli from Cliente cli";
		lista = em.createQuery(qry).getResultList();
		return lista;
	}

}
