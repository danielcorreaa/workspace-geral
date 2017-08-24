package com.hotel.dao;

import java.util.List;

import com.hotel.modelo.Hotel;

public class HotelDAO extends GenericDAO<Hotel>{

	public HotelDAO() {
		super();		
	}
	
	public List<Hotel> povoarBanco(){
		Hotel h = new Hotel();
		h.setNome("Hotel JAVA");
		h.setEndereco("RUA A. Vargas, Nº 1453, Lapa");
		h.setEmail("java@outlook.com");
		
		lista.add(h);
		
		return lista;
	}
	
}
