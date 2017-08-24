package com.servlet.dao;

import java.util.ArrayList;
import java.util.List;

import com.servlet.modelo.Estado;

public class EstadoDAO {

	private List<Estado> estados;

	public EstadoDAO() {
		super();
		estados = new ArrayList<>();
		povoarEstados();
	}

	private void povoarEstados() {
	   Estado e1 = new Estado();
	   e1.setNome("São Paulo");
	   e1.setSigla("SP");
	   
	   Estado e2 = new Estado();
	   e2.setNome("Rio de Janeiro");
	   e2.setSigla("RJ");
	   
	   estados.add(e1);
	   estados.add(e2);
		
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	
}
