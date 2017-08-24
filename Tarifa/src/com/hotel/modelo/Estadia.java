package com.hotel.modelo;

import java.util.Date;
import java.util.List;

public class Estadia {
	
	private Integer chechin;
	private int nDePessoas;
	private int nDeQuartos;
	private Date dataSaida;
	private Servico servicoFornecido;
	private String nCartaoCredito;
	private double valor;
	private Reserva reserva;
	private List<Quarto> quartos;
	private Cliente cliente;
	
	public Estadia() {
		super();
	}
	
	public Integer getChechin() {
		return chechin;
	}
	public void setChechin(Integer chechin) {
		this.chechin = chechin;
	}
	public int getnDePessoas() {
		return nDePessoas;
	}
	public void setnDePessoas(int nDePessoas) {
		this.nDePessoas = nDePessoas;
	}
	public int getnDeQuartos() {
		return nDeQuartos;
	}
	public void setnDeQuartos(int nDeQuartos) {
		this.nDeQuartos = nDeQuartos;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Servico getServicoFornecido() {
		return servicoFornecido;
	}
	public void setServicoFornecido(Servico servicoFornecido) {
		this.servicoFornecido = servicoFornecido;
	}
	public String getnCartaoCredito() {
		return nCartaoCredito;
	}
	public void setnCartaoCredito(String nCartaoCredito) {
		this.nCartaoCredito = nCartaoCredito;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	

}
