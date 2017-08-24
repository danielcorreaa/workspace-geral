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
	
   public Usuario buscarLogin(String login){
	   String qry = "select u from Usuario u where login = ?";
	   Usuario user = null;
	    try{
	    	 user = (Usuario) em.createQuery(qry).setParameter(1, login).getSingleResult();
	    }catch(Exception ex){
	    	System.out.println(ex.getMessage());
	    	return null;
	    }
	  
	   return user;
   }
   
   @SuppressWarnings("unchecked")
   public List<Usuario> buscarLoginNome(String login){
	   String qry = "select u from Usuario u where login = ?";
	   List<Usuario> user = null;
	    try{
	    	 user = (List<Usuario>) em.createQuery(qry).setParameter(1, login).getResultList();
	    }catch(Exception ex){
	    	System.out.println(ex.getMessage());
	    	return null;
	    }
	  
	   return user;
   }
	
	
	
}
