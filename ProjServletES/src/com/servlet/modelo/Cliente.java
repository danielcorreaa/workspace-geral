package com.servlet.modelo;

import java.util.List;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String telefone;
	private Endereco endereco;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Endereco buscarEndereco(List<Endereco> enderecos, String cep){
		for(Endereco endereco:enderecos){
			if(endereco.getCep().equalsIgnoreCase(cep)){
				return endereco;
			}
		}
		return null;
	}
	
	
}
