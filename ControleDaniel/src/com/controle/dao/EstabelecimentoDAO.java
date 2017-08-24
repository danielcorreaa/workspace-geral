package com.controle.dao;

import java.util.List;

import com.controle.modelo.Estabelecimento;

public class EstabelecimentoDAO extends GenericDAO<Estabelecimento>{
	
	public void salvar(Estabelecimento c) {
		if (getPorId(c.getId()) == null) {
			inserir(c);
		} else {
			alterar(c);
		}
	}

	public Estabelecimento getPorId(Integer id) {
		if (id == null) {
			return null;
		}
		String qry = "Select est from Estabelecimento est where est.id = ?";
		Estabelecimento est = (Estabelecimento) em.createQuery(qry).setParameter(1, id).getSingleResult();
		return est;
	}

	@SuppressWarnings("unchecked")
	public List<Estabelecimento> listar() {
		List<Estabelecimento> lista;
		String qry = "Select cli from Estabelecimento cli";
		lista = em.createQuery(qry).getResultList();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Estabelecimento> buscarTodosPorUsuario(Integer id) {
		List<Estabelecimento> lista;
		String qry = "Select est from Estabelecimento est where est.usuario.id = ?";
		lista = em.createQuery(qry).setParameter(1, id).getResultList();
		return lista;
	}
}
