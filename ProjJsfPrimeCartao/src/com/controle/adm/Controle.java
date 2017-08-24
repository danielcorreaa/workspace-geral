package com.controle.adm;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.controle.dao.EstabelecimentoDAO;
import com.controle.modelo.Estabelecimento;



public class Controle {

	public static void main(String[] args) {
		//Persistence.createEntityManagerFactory("cartao");
		
		EstabelecimentoDAO dao = new EstabelecimentoDAO();
		List<Estabelecimento> estabe = dao.listar();
		
		for (Estabelecimento est : estabe){
			
		 System.out.println(est.getNomeEstabelecimento());
			
		}
		
		try{
			
			dao.excluir(estabe.get(2));
			System.out.println("Excluido com sucesso");
		}catch(Exception ex){
			System.out.println("falha");
		}
		
	}
	
	
	//Persistence.createEntityManagerFactory("cartao");
	public static Date setData(String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data1;
		try {
			data1 = sdf.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			data1 = new Date();
		}
		return data1;
	}

	public static String getData(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}

}
