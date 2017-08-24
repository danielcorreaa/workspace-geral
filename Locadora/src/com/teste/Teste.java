package com.teste;

import javax.persistence.Persistence;

import com.dao.ClienteDAO;
import com.modelo.Cliente;

public class Teste {

	public static void main(String[] args) {
		
		//Persistence.createEntityManagerFactory("loca");
		
		ClienteDAO dao = new ClienteDAO();
		Cliente c = dao.getPorId(10);
		
		try{
			dao.excluir(c);
			System.out.println("Excluido");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}

	}

}
