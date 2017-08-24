package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.modelo.Cliente;



public class ClienteDAO {
	
	private List<Cliente> clientes;

	public ClienteDAO() {
		clientes = new ArrayList<>();
		povoarClientes();
	}
	
	
	
	public List<Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}



	public List<Cliente> povoarClientes(){
		Cliente cliente1 = new Cliente("Daniel", "234.234.234-34");
		Cliente cliente2 = new Cliente("Homer", "245.114.233-34");
		Cliente cliente3 = new Cliente("Doug Funny", "212.276.999-23");
		Cliente cliente4 = new Cliente("Tim Tim", "224.234.234-11");
		Cliente cliente5 = new Cliente("Zé Comeia", "244.264.234-23");
		Cliente cliente6 = new Cliente("Catatau", "214.566.111-88");
		
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);
		clientes.add(cliente6);
	
		return clientes;
	
	}
	
}
