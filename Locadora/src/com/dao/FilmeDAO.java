package com.dao;

import java.util.List;

import org.hibernate.Criteria;

import com.modelo.Cliente;
import com.modelo.Filme;

public class FilmeDAO extends GenericDAO<Filme> {

	public void salvar(Filme f) {
		if (getPorId(f.getId()) == null) {
			inserir(f);
		} else {
			alterar(f);
		}
	}

	public Filme getPorId(Integer id) {
		if (id == null) {
			return null;
		}
		String qry = "Select f from Filme f where f.id = ?";
		Filme f = (Filme) em.createQuery(qry).setParameter(1, id).getSingleResult();
		return f;
	}

	public List<Filme> listar() {
		List<Filme> lista;
		String qry = "Select f from Filme f";
		lista = em.createQuery(qry).getResultList();
		return lista;
	}
	
	public List<Filme> pesquisar(String nome) {
		
		List<Filme> lista;
		String qry = "Select f from Filme f where f.titulo like :par";
		lista = (List<Filme>) em.createQuery(qry).setParameter( "par", "%"+nome+"%").getResultList();
		return lista;
		
	}

}
