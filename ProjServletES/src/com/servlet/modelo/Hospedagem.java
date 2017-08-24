package com.servlet.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Hospedagem {

	private Integer numeroHospedagem;
	private Quarto quarto;
	private Date entrada;
	private Date saida;

	public Hospedagem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getNumeroHospedagem() {
		return numeroHospedagem;
	}

	public void setNumeroHospedagem(Integer numeroHospedagem) {
		this.numeroHospedagem = numeroHospedagem;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public void hospedar(int numeroQuarto, List<Quarto> quartos) {
		for (Quarto q : quartos) {
			if (numeroQuarto == q.getNumeroPorta() && q.isLivre()) {
				quarto = q;
				quarto.setLivre(false);
			}
		}

	}

	public Quarto buscarQuarto(int numeroQuarto, List<Quarto> quartos) {
		for (Quarto q : quartos) {
			if (numeroQuarto == q.getNumeroPorta()) {
				return q;
			}
		}
		return null;
	}

	public Date retornarData(String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date formatDate = null;
		try {
			formatDate = sdf.parse(data);
		} catch (ParseException e) {
			formatDate = new Date();
		}
		return formatDate;
	}

}
