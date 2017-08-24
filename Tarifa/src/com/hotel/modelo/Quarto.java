package com.hotel.modelo;

import java.util.List;

public class Quarto {
	
	private int numero;
	private Boolean status;
	private Hotel hotel;
	private List<Reserva> reservas;
	private List<Estadia> estadias;
	
	public Quarto() {
		super();
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
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
