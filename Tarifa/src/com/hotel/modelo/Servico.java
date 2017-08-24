package com.hotel.modelo;

import java.util.List;

public class Servico {
	
	private double preco;
	private String tipoDiaria;
	private Hotel hotel;
	private List<Reserva> reservas;
	private List<Estadia> estadias;
	
	public Servico() {
		super();
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getTipoDiaria() {
		return tipoDiaria;
	}
	public void setTipoDiaria(String tipoDiaria) {
		this.tipoDiaria = tipoDiaria;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<Estadia> getEstadias() {
		return estadias;
	}

	public void setEstadias(List<Estadia> estadias) {
		this.estadias = estadias;
	}
	
	
}
