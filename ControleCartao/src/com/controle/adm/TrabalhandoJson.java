package com.controle.adm;

import java.util.ArrayList;
import java.util.List;

import com.controle.dao.EstabelecimentoDAO;
import com.controle.modelo.Estabelecimento;
import com.google.gson.Gson;



public class TrabalhandoJson {
	
	public static void main(String[] args) {
		
		List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();
		
		EstabelecimentoDAO dao = null;
		
		
			 dao = new EstabelecimentoDAO();
			 for(Estabelecimento e : dao.listar()){
				 System.out.println(e);
				 estabelecimentos.add(e);
			 }
			 			
		
		 
		 String json = new Gson().toJson(estabelecimentos);
		 System.out.println(json);
		
		
	}
	
}
