package com.servlet.dao;

import java.util.ArrayList;
import java.util.List;

import com.servlet.modelo.Cidade;
import com.servlet.modelo.Cliente;

public class ClienteDAO {

	private List<Cliente> clientes = new ArrayList<>();;

	public ClienteDAO() {
		super();
		povoarCliente();
	}

	public List<Cliente> povoarCliente() {
		EnderecoDAO dao = new EnderecoDAO();

		Cliente c1 = new Cliente();
		c1.setCpf("887.118.190-57");
		c1.setEndereco(c1.buscarEndereco(dao.getEnderecos(), "16401400"));
		c1.setNome("Kelly Leblock");
		c1.setTelefone("23-2323-2323");
		
		Cliente c2 = new Cliente();
		c2.setCpf("887.118.190-57");
		c2.setEndereco(c2.buscarEndereco(dao.getEnderecos(), "16401400"));
		c2.setNome("Daniel Correa");
		c2.setTelefone("23-2323-2323");
		
		Cliente c3 = new Cliente();
		c3.setCpf("887.118.190-57");
		c3.setEndereco(c3.buscarEndereco(dao.getEnderecos(), "16401400"));
		c3.setNome("Homer S.");
		c3.setTelefone("23-2323-2323");

		Cliente c4 = new Cliente();
		c4.setCpf("887.118.190-57");
		c4.setEndereco(c4.buscarEndereco(dao.getEnderecos(), "16401400"));
		c4.setNome("Renkse");
		c4.setTelefone("23-2323-2323");
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
		
		return clientes;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean buscarPorNome(String nome) {
		for (Cliente c : getClientes()) {
			if (c.getNome().equalsIgnoreCase(nome)) {
				return true;
			}
		}

		return false;
	}

	public void salvar(Cliente cli) {
		povoarCliente().add(cli);
	}

	public Cliente buscarCliente(String nome) {
		for (Cliente c : povoarCliente()) {
			if (c.getNome().equalsIgnoreCase(nome)) {
				return c;
			}
		}
		return null;
	}

}
