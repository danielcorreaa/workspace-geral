package com.hotel.modelo;

import java.util.Date;
import java.util.List;

public class Reserva {
	
	private Date dataEntrada;
	private Date dataSaida;
	private int nPessoas;
	private Servico tipoServico;
	private String nCartaoCredito;
	private Cliente cliente;
	private List<Quarto> quartos;
	private Estadia estadia;
	
	public Reserva() {
		super();
	}
	
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public int getnPessoas() {
		return nPessoas;
	}
	public void setnPessoas(int nPessoas) {
		this.nPessoas = nPessoas;
	}
	public Servico getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(Servico tipoServico) {
		this.tipoServico = tipoServico;
	}
	public String getnCartaoCredito() {
		return nCartaoCredito;
	}
	public void setnCartaoCredito(String nCartaoCredito) {
		this.nCartaoCredito = nCartaoCredito;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Quarto> getQuartos() {
		return quartos;
	}
	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}
	public Estadia getEstadia() {
		return estadia;
	}
	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}
	
	public void verificarQuartoDispo(int num){
		
	}
	
}
