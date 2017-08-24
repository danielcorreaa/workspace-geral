package com.servlet.modelo;

public class Usuario {

	private String nome;
	private String login;
	private String senha;
	private int idade;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean logar(String digSenha) {		
		if (digSenha.equalsIgnoreCase(senha)) {
			return true;
		}
		return false;
	}

}
