package com.controle.dao;

import java.util.List;
import com.controle.modelo.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {
	
	public void salvar(Usuario c) {
		if (getPorId(c.getId()) == null) {
			inserir(c);
		} else {
			alterar(c);
		}
	}

	public Usuario getPorId(Integer id) {
		if (id == null) {
			return null;
		}
		String qry = "Select u from Usuario u where u.id = ?";
		Usuario u = (Usuario) em.createQuery(qry).setParameter(1, id).getSingleResult();
		return u;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		List<Usuario> lista;
		String qry = "Select u from Usuario u";
		lista = em.createQuery(qry).getResultList();
		return lista;
	}
	
	public Usuario buscarUsuario(String login, String senha){
		for (Usuario usu : listar()) {
			if(usu.getLogin().equalsIgnoreCase(login) && 
					usu.getSenha().equalsIgnoreCase(senha)){
				return usu;
			}
		}
		return null;
   }
	
	
	
}
