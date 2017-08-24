package com.hotel.dao;

import java.util.List;

import com.hotel.modelo.Quarto;

public class QuartoDAO extends GenericDAO<Quarto>{

	public QuartoDAO() {
		super();
	}
	
	public List<Quarto> povoarBanco(){
		
		HotelDAO dao = new HotelDAO();
		
		for(int i = 101; i < 161; i++){
			
			Quarto q = new Quarto();
			q.setNumero(i);
			q.setStatus(false);
			q.setHotel(q.selecionarHotel(dao.povoarBanco(), "Hotel JAVA"));
			lista.add(q);
			
		}
		
		return lista;
	}
	
	
}
