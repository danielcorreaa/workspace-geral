package com.servlet.modelo;

import java.util.List;

public class Cidade {
	
	private String nome;
	private Estado estado;
	
	public Cidade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Estado buscarEstado(List<Estado> estados, String nome){
		for(Estado estado : estados){
			if(estado.getNome().equalsIgnoreCase(nome)){
				return estado;
			}
		}
		return null;
	}
	
	
	
}
