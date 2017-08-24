package com.hotel.dao;

import java.util.List;

import com.hotel.modelo.Servico;

public class ServicoDAO extends GenericDAO<Servico>{

	public ServicoDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Servico> povoarBanco(){
		
		HotelDAO dao = new HotelDAO();
		
		Servico servico1 = new Servico();
		servico1.setTipoDiaria("Pernoite");
		servico1.setPreco(100.00);
		servico1.setHotel(servico1.selecionarHotel(dao.povoarBanco(), "Hotel JAVA"));
		
		Servico servico2 = new Servico();
		servico2.setTipoDiaria("Fim de Semana");
		servico2.setPreco(300.00);
		servico2.setHotel(servico2.selecionarHotel(dao.povoarBanco(), "Hotel JAVA"));
		
		Servico servico3 = new Servico();
		servico3.setTipoDiaria("Promoção");
		servico3.setPreco(80.00);
		servico3.setHotel(servico2.selecionarHotel(dao.povoarBanco(), "Hotel JAVA"));
		
		lista.add(servico1);
		lista.add(servico2);
		lista.add(servico3);
		
		return lista;
	}
}
