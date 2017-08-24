package com.servlet.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.servlet.modelo.Hospedagem;


public class HospedagemDAO {
	
	private List<Hospedagem> Hospedagens;

	public HospedagemDAO() {
		super();
		Hospedagens = new ArrayList<>();
		povoarBanco();
	}

	private void povoarBanco() {
		QuartoDAO dao = new QuartoDAO();
		
		Hospedagem  h1 = new Hospedagem();
		h1.setNumeroHospedagem(1234);
		h1.setEntrada(new Date());
		h1.hospedar(101, dao.getQuartos());
		
		Hospedagem  h2 = new Hospedagem();
		h2.setNumeroHospedagem(4533);
		h2.setEntrada(new Date());
		h2.hospedar(102, dao.getQuartos());
		
		Hospedagem  h3 = new Hospedagem();
		h3.setNumeroHospedagem(2987);
		h3.setEntrada(new Date());
		h3.hospedar(103, dao.getQuartos());
		
		Hospedagem  h4 = new Hospedagem();
		h4.setNumeroHospedagem(1234);
		h4.setEntrada(new Date());
		h4.hospedar(101, dao.getQuartos());
		
		Hospedagem  h5 = new Hospedagem();
		h5.setNumeroHospedagem(4533);
		h5.setEntrada(new Date());
		h5.hospedar(102, dao.getQuartos());
		
		Hospedagem  h6 = new Hospedagem();
		h6.setNumeroHospedagem(2987);
		h6.setEntrada(new Date());
		h6.hospedar(103, dao.getQuartos());
		
		Hospedagem  h7 = new Hospedagem();
		h7.setNumeroHospedagem(1234);
		h7.setEntrada(new Date());
		h7.hospedar(101, dao.getQuartos());
		
		Hospedagem  h8 = new Hospedagem();
		h8.setNumeroHospedagem(4533);
		h8.setEntrada(new Date());
		h8.hospedar(102, dao.getQuartos());
		
		Hospedagem  h9 = new Hospedagem();
		h9.setNumeroHospedagem(2987);
		h9.setEntrada(new Date());
		h9.hospedar(103, dao.getQuartos());
		
		Hospedagem  h10 = new Hospedagem();
		h10.setNumeroHospedagem(999);
		h10.setEntrada(new Date());
		h10.hospedar(101, dao.getQuartos());
		
		Hospedagem  h11 = new Hospedagem();
		h11.setNumeroHospedagem(111);
		h11.setEntrada(new Date());
		h11.hospedar(102, dao.getQuartos());
		
		Hospedagem  h12 = new Hospedagem();
		h12.setNumeroHospedagem(2987);
		h12.setEntrada(new Date());
		h12.hospedar(103, dao.getQuartos());
		
		Hospedagem  h13 = new Hospedagem();
		h13.setNumeroHospedagem(1234);
		h13.setEntrada(new Date());
		h13.hospedar(101, dao.getQuartos());
		
		Hospedagem  h14 = new Hospedagem();
		h14.setNumeroHospedagem(4533);
		h14.setEntrada(new Date());
		h14.hospedar(102, dao.getQuartos());
		
		Hospedagem  h15 = new Hospedagem();
		h15.setNumeroHospedagem(2987);
		h15.setEntrada(new Date());
		h15.hospedar(103, dao.getQuartos());
		
		Hospedagem  h16 = new Hospedagem();
		h16.setNumeroHospedagem(1234);
		h16.setEntrada(new Date());
		h16.hospedar(101, dao.getQuartos());
		
		Hospedagem  h17 = new Hospedagem();
		h17.setNumeroHospedagem(4113);
		h17.setEntrada(new Date());
		h17.hospedar(102, dao.getQuartos());
		
		Hospedagem  h18 = new Hospedagem();
		h18.setNumeroHospedagem(2987);
		h18.setEntrada(new Date());
		h18.hospedar(103, dao.getQuartos());
		
		Hospedagens.add(h1);
		Hospedagens.add(h2);
		Hospedagens.add(h3);
		Hospedagens.add(h4);
		Hospedagens.add(h5);
		Hospedagens.add(h6);
		Hospedagens.add(h7);
		Hospedagens.add(h8);
		Hospedagens.add(h9);
		Hospedagens.add(h10);
		Hospedagens.add(h11);
		Hospedagens.add(h12);
		Hospedagens.add(h13);
		Hospedagens.add(h14);
		Hospedagens.add(h15);
		Hospedagens.add(h16);
		Hospedagens.add(h17);
		Hospedagens.add(h18);
	}

	public List<Hospedagem> getHospedagens() {
		return Hospedagens;
	}

	public void setHospedagens(List<Hospedagem> hospedagens) {
		Hospedagens = hospedagens;
	}

	
	

}
