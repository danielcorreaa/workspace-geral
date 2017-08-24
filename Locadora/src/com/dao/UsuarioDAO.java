package com.dao;

import java.util.List;

import com.modelo.Cliente;
import com.modelo.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {

	
	public List<Usuario> listar() {
		List<Usuario> lista;
		String qry = "Select user from Usuario user";
		lista = em.createQuery(qry).getResultList();
		return lista;
	}

}
