package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

public class GenericDAO<T> {
	
	protected List<T> lista = new ArrayList<>();

	public GenericDAO() {
		super();
	}

	public List<T> getLista() {
		return lista;
	}

	public void setLista(List<T> lista) {
		this.lista = lista;
	}
	
	@SuppressWarnings("unused")
	private void adicionar(T obj){
		lista.add(obj);
	}
	@SuppressWarnings("unused")
	private void remove(T obj){
		lista.remove(obj);
	}

}
