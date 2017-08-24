package com.hotel.dao;

import java.util.List;

import com.hotel.modelo.Empregado;


public class EmpregadoDAO extends GenericDAO<Empregado>{

	public EmpregadoDAO() {
		
	}
	
	public List<Empregado> povoarBanco(){
		
		HotelDAO dao = new HotelDAO();
		
		Empregado e1 = new Empregado();
		e1.setFuncao("Recepcionista");
		e1.setNome("Laura Farias");
		e1.setLogin("laura");
		e1.setSenha("laura123");
		e1.setHotel(e1.selecionarHotel(dao.povoarBanco(), "Hotel JAVA"));
		
		Empregado e2 = new Empregado();
		e2.setFuncao("Poteiro");
		e2.setNome("Carlos Farias");
		e2.setLogin("carlos");
		e2.setSenha("carlos123");
		e2.setHotel(e2.selecionarHotel(dao.povoarBanco(), "Hotel JAVA"));
		
		Empregado e3 = new Empregado();
		e3.setFuncao("Gerente");
		e3.setNome("Pedro Farias");
		e3.setLogin("pedro");
		e3.setSenha("pedro");
		e3.selecionarHotel(dao.povoarBanco(), "Hotel JAVA");
		e3.setHotel(e3.selecionarHotel(dao.povoarBanco(), "Hotel JAVA"));
		
		lista.add(e1);
		lista.add(e2);
		lista.add(e3);
		
		return lista;
	}

}
