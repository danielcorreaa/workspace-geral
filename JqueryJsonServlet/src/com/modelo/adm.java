package com.modelo;

import java.util.ArrayList;

import java.util.List;

import com.dao.ClienteDAO;
import com.google.gson.Gson;

public class adm {
	public static void main(String[] args) {
		 ClienteDAO dao = new ClienteDAO();
		 List<Cliente> lista = new ArrayList<>();
		 
		 for (Cliente c: dao.povoarClientes()) {
			System.out.println(c.getNome());
			lista.add(c);
		 }
		 
		 String json = new Gson().toJson(lista);
		 
		 System.out.println(json);
		
		
		
	}
}
