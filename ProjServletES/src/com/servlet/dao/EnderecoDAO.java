package com.servlet.dao;

import java.util.ArrayList;
import java.util.List;

import com.servlet.modelo.Cidade;
import com.servlet.modelo.Endereco;
import com.sun.org.apache.regexp.internal.recompile;


public class EnderecoDAO {

	private List<Endereco> enderecos;

	public EnderecoDAO() {
		super();
		enderecos = new ArrayList<>();
		povoarEstados();
	}

	private void povoarEstados() {
	   CidadeDAO dao = new CidadeDAO();	
		
	   Endereco e = new Endereco();
	   e.setBairro("Ribeiro");
	   e.setCep("16401400");
	   e.setCidade(e.buscarCidade(dao.getCidades(), "Lins") );
	   e.setNumero("151");
	   e.setRua("Pedro Ferreira");
	   
	   Endereco e2 = new Endereco();
	   e2.setBairro("Juqueria");
	   e2.setCep("16401402");
	   e2.setCidade(e.buscarCidade(dao.getCidades(), "Lins") );
	   e2.setNumero("1512");
	   e2.setRua("13 de Maio");
	   
	   
	   Endereco e3 = new Endereco();
	   e3.setBairro("Centro");
	   e3.setCep("14407645");
	   e3.setCidade(e.buscarCidade(dao.getCidades(), "Bauru") );
	   e3.setNumero("341");
	   e3.setRua("Vidente Ancina");
	   
	   enderecos.add(e);
	   enderecos.add(e2);
	   enderecos.add(e3);
		
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco buscarPorCep(String cep){
		for(Endereco endereco: enderecos){
			if(endereco.getCep().equalsIgnoreCase(cep)){
				return endereco;
			}
		}
		return null;
	}

	
	
}
