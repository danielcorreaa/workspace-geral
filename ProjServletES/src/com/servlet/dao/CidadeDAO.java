package com.servlet.dao;

import java.util.ArrayList;
import java.util.List;

import com.servlet.modelo.Cidade;


public class CidadeDAO {

	private List<Cidade> cidades;

	public CidadeDAO() {
		super();
		cidades = new ArrayList<>();
		povoarEstados();
	}

	private void povoarEstados() {
	   EstadoDAO dao = new EstadoDAO();	
		
	   Cidade c1 = new Cidade();
	   c1.setNome("Lins");
	   c1.setEstado(c1.buscarEstado(dao.getEstados(), "São Paulo"));
	   
	   Cidade c2 = new Cidade();
	   c2.setNome("Bauru");
	   c2.setEstado(c2.buscarEstado(dao.getEstados(), "São Paulo"));
	   
	   cidades.add(c1);
	   cidades.add(c2);
		
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	
	
}
