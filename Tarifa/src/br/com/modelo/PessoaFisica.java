package br.com.modelo;

import java.util.List;

public class PessoaFisica extends Pessoa{
	
	private String cpf;
	private List<PessoaFisica> acompanhantes;
	
	public PessoaFisica() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public List<PessoaFisica> getAcompanhantes() {
		return acompanhantes;
	}
	
	public void setAcompanhantes(List<PessoaFisica> acompanhantes) {
		this.acompanhantes = acompanhantes;
	}
	
	
	
}
