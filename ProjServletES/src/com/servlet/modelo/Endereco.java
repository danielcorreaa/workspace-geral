package com.servlet.modelo;

import java.util.List;

public class Endereco {
	
	private Cidade cidade;
	private String cep;
	private String bairro;
	private String rua;
	private String numero;
	
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Cidade buscarCidade(List<Cidade> cidades, String nome){
		for(Cidade cidade: cidades){
			if(cidade.getNome().equalsIgnoreCase(nome)){
				return cidade;
			}
		}
		return null;
	}
	
	
}
