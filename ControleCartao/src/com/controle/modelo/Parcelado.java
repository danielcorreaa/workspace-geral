package com.controle.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="parcelado")
public class Parcelado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private int numPrcelas;
	private double valor;
	@Temporal(TemporalType.DATE)
	private Calendar dataParcela;
	@ManyToOne
	@JoinColumn(name="id_compra")
	private Compra compra;
	
	public Parcelado(){}
	
	
	
	public Parcelado(int numPrcelas, double valor, Calendar dataParcela, Compra compra) {
		super();
		this.numPrcelas = numPrcelas;
		this.valor = valor;
		this.dataParcela = dataParcela;
		this.compra = compra;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumPrcelas() {
		return numPrcelas;
	}
	public void setNumPrcelas(int numPrcelas) {
		this.numPrcelas = numPrcelas;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataParcela() {
		return dataParcela;
	}

	public void setDataParcela(Calendar dataParcela) {
		this.dataParcela = dataParcela;
	}
	

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parcelado other = (Parcelado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
