package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Endereco;

public class EnderecoDAO {
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	public EnderecoDAO() {
		
		povoarEnderecos();
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public List<Endereco> povoarEnderecos(){
		
		Endereco endereco = new Endereco();
		endereco.setRua("Rua 1");
		endereco.setNumero("1000");
		enderecos.add(endereco);
		return enderecos;
	}
	public void salvar(Endereco endereco){		
		enderecos.add(endereco);
	}
}
