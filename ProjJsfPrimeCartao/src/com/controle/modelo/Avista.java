package com.controle.modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="avista")
public class Avista implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private double valor;
	@Temporal(TemporalType.DATE)
	private Calendar mesPagamento;
	@OneToMany(mappedBy="avista")
	private List<Compra> compras;
	
	public Avista(){}
	
	public Avista(double valor, Calendar mesPagamento) {
		super();
		this.valor = valor;
		this.mesPagamento = mesPagamento;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Calendar getMesPagamento() {
		return mesPagamento;
	}
	public void setMesPagamento(Calendar mesPagamento) {
		this.mesPagamento = mesPagamento;
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
		Avista other = (Avista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setMesPagamento(String parameter) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		mesPagamento = Calendar.getInstance();
		try {
			mesPagamento.setTime(sdf.parse(parameter));
		} catch (ParseException e) {
			mesPagamento.setTime(new Date());
		}
		
	}
	
	
	

}
