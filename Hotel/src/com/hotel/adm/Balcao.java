package com.hotel.adm;


import com.hotel.dao.QuartoDAO;

import com.hotel.modelo.Quarto;


public class Balcao {
	
	public static void main(String[] args) {
		
		
		QuartoDAO dao = new QuartoDAO();
		
		for (Quarto q : dao.povoarBanco()){
			System.out.println(q.getNumero());
		}
		
	}
}
