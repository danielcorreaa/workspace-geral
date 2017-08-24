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
	//retornar proc
//	@SuppressWarnings("unchecked")
//	public List<Estabelecimento> listar() {
//		char par = 10;
//		List<Estabelecimento> lista;
//		//String qry = "Select cli from Estabelecimento cli";
//		String qry = "marotoPrcedure2(10)";
//		StoredProcedureQuery nq = em.createStoredProcedureQuery("marotoPrcedure2");		
//		  nq.registerStoredProcedureParameter("cont", Character.class, ParameterMode.IN);
//		  nq.setParameter("cont", par);
//		  nq.execute();
//		//lista = em.createStoredProcedureQuery(qry).getResultList();
//		  lista = nq.setParameter("cont", par).getResultList();
//		return lista;
//	}
}
