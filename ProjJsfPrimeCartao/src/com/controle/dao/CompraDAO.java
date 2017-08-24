package com.controle.dao;

import java.util.Date;
import java.util.List;

import com.controle.modelo.Compra;

public class CompraDAO extends GenericDAO<Compra>{
	
	public void salvar(Compra c) {
		if (getPorId(c.getId()) == null) {
			inserir(c);
		} else {
			alterar(c);
		}
	}

	public Compra getPorId(Integer id) {
		if (id == null) {
			return null;
		}
		String qry = "Select cli from Compra cli where cli.id = ?";
		Compra cli = (Compra) em.createQuery(qry).setParameter(1, id).getSingleResult();
		return cli;
	}

	@SuppressWarnings("unchecked")
	public List<Compra> listar() {
		List<Compra> lista;
		String qry = "Select cli from Compra cli";
		lista = em.createQuery(qry).getResultList();
		return lista;
	}
	
	public List<Compra> buscarComprasMes(Date inicioMes, Date fimMes){
		String qry = "Select com from Compra com where com.dataCompra BETWEEN ? AND ?";
		@SuppressWarnings("unchecked")
		List<Compra> compras = em.createQuery(qry).setParameter(1, inicioMes).setParameter(2, fimMes).getResultList();
		return compras ;
	}
}
