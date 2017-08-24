package com.hotel.modelo;

import java.util.List;

public class Empregado {
	
	private String nome;
	private String login;
	private String senha;
	private String funcao;
	private Hotel hotel;
	
	public Empregado() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public Hotel selecionarHotel(List<Hotel> hoteis , String nomeHotel){
		for (Hotel h : hoteis) {
			if(h.getNome().equalsIgnoreCase(nomeHotel)){
				return h;
			}
		}
		return null;
	}
	
}
