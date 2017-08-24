package com.servlet.dao;

import java.util.ArrayList;
import java.util.List;

import com.servlet.modelo.Quarto;


public class QuartoDAO {
	
	private List<Quarto> quartos;

	public QuartoDAO() {
		super();
		quartos = new ArrayList<>();
		povoarBanco();
	}

	private void povoarBanco() {
		Quarto q1 = new Quarto();
		q1.setNumeroPorta(101);
		q1.setLivre(true);
		
		Quarto q2 = new Quarto();
		q2.setNumeroPorta(102);
		q2.setLivre(true);
		
		Quarto q3 = new Quarto();
		q3.setNumeroPorta(103);
		q3.setLivre(true);
		
		Quarto q4 = new Quarto();
		q4.setNumeroPorta(104);
		q4.setLivre(true);
		
		Quarto q5 = new Quarto();
		q5.setNumeroPorta(105);
		q5.setLivre(false);
		
		Quarto q6 = new Quarto();
		q6.setNumeroPorta(106);
		q6.setLivre(true);
		
		Quarto q7 = new Quarto();
		q7.setNumeroPorta(107);
		q7.setLivre(true);
		
		Quarto q8 = new Quarto();
		q8.setNumeroPorta(108);
		q8.setLivre(true);
		
		Quarto q9 = new Quarto();
		q9.setNumeroPorta(109);
		q9.setLivre(true);
		
		Quarto q10 = new Quarto();
		q10.setNumeroPorta(110);
		q10.setLivre(true);
		
		Quarto q11 = new Quarto();
		q11.setNumeroPorta(111);
		q11.setLivre(true);
		
		Quarto q12 = new Quarto();
		q12.setNumeroPorta(112);
		q12.setLivre(true);
		
		Quarto q13 = new Quarto();
		q13.setNumeroPorta(113);
		q13.setLivre(true);
		
		Quarto q14 = new Quarto();
		q14.setNumeroPorta(114);
		q14.setLivre(true);
		
		Quarto q15 = new Quarto();
		q15.setNumeroPorta(115);
		q15.setLivre(true);
		
		Quarto q16 = new Quarto();
		q16.setNumeroPorta(116);
		q16.setLivre(true);
		
		quartos.add(q1);
		quartos.add(q2);
		quartos.add(q3);
		quartos.add(q4);
		quartos.add(q5);
		quartos.add(q6);
		quartos.add(q7);
		quartos.add(q8);
		quartos.add(q9);
		quartos.add(q10);
		quartos.add(q11);
		quartos.add(q12);
		quartos.add(q13);
		quartos.add(q14);
		quartos.add(q15);
		quartos.add(q16);
	}

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	public void buscarQuarto(int numeroPorta){
		
	}
	

}
