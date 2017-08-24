package com.servlet.modelo;

public class Quarto {

	public int numeroPorta;
	public boolean livre;

	public Quarto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNumeroPorta() {
		return numeroPorta;
	}

	public void setNumeroPorta(int numeroPorta) {
		this.numeroPorta = numeroPorta;
	}

	public boolean isLivre() {
		return livre;
	}

	public void setLivre(boolean livre) {
		this.livre = livre;
	}

	public String taLivre() {
		if (livre) {
			return "Livre";
		}
		return "Ocupado";
	}

	public String getImagemQuarto() {
		if (livre) {
			return "dooropen";
		}
		return "doorclose";
	}
	

}
