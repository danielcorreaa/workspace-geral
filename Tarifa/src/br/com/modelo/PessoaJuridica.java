package br.com.modelo;

import java.util.List;

public class PessoaJuridica extends Pessoa {
	
	private String cnpj;
	private List<PessoaFisica> listPf;
	
	public PessoaJuridica() {
		
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public List<PessoaFisica> getListPf() {
		return listPf;
	}
	
	public void setListPf(List<PessoaFisica> listPf) {
		this.listPf = listPf;
	}
	
	
	
}
