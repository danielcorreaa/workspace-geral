package com.controle.dao;

import java.util.List;

import com.controle.modelo.Cartao;


public class CartaoDAO extends GenericDAO<Cartao>{
	
	public void salvar(Cartao c) {
		if (getPorId(c.getId()) == null) {
			inserir(c);
		} else {
			alterar(c);
		}
	}

	public Cartao getPorId(Integer id) {
		if (id == null) {
			return null;
		}
		String qry = "Select u from Cartao u where u.id = ?";
		Cartao u = (Cartao) em.createQuery(qry).setParameter(1, id).getSingleResult();
		return u;
	}

	@SuppressWarnings("unchecked")
	public List<Cartao> listar() {
		List<Cartao> lista;
		String qry = "Select u from Cartao u";
		lista = em.createQuery(qry).getResultList();
		return lista;
	}
	
	public Cartao buscarPorUsuario(Integer id){
		String qry = "Select c from Cartao c where c.usuario.id =?";
		Cartao card = (Cartao) em.createQuery(qry).setParameter(1,id).getSingleResult();
		return card;
	}
	
}
