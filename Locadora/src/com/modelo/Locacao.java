package com.modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="locacoes")
public class Locacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="CLIENTE_ID")
	private Cliente cliente;
	@OneToMany(mappedBy="locacao", cascade = CascadeType.ALL)
	private List<AlugarFilme> alugueis;
	@Temporal(TemporalType.TIMESTAMP)
	private Date saida;
	@Temporal(TemporalType.TIMESTAMP)
	private Date devolucaoPrev;
	@Temporal(TemporalType.TIMESTAMP)
	private Date devolucaoReal;
	@Transient
	private double valorTotal;
	
	public Locacao() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<AlugarFilme> getAlugueis() {
		return alugueis;
	}
	public void setAlugueis(List<AlugarFilme> alugueis) {
		this.alugueis = alugueis;
	}
	public Date getSaida() {
		return saida;
	}
	
	public String getSaidaFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(saida);
	}
	
	public void setSaida(String saida) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.saida = sdf.parse(saida);
		} catch (ParseException e) {
			this.saida = new Date();
		}
	}
	
	public void setSaida(Date saida) {
		this.saida = saida;
	}
	
	public Date getDevolucaoPrev() {
		return devolucaoPrev;
	}
	
	public void setDevolucaoPrev(Date devolucaoPrev) {
		this.devolucaoPrev = devolucaoPrev;
	}
	
	//data devolucao prevista formatada
	
	public String getDevolucaoPrevFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(devolucaoPrev);
	}
	
	public void setDevolucaoPrev(String devolucaoPrev) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.devolucaoPrev = sdf.parse(devolucaoPrev);
		} catch (ParseException e) {
			this.devolucaoPrev = new Date();
		}
	}
	
	
	public Date getDevolucaoReal() {
		return devolucaoReal;
	}
	public void setDevolucaoReal(Date devolucaoReal) {
		this.devolucaoReal = devolucaoReal;
	}
	
	public String getDevolucaoRealFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		return sdf.format(devolucaoReal);
	}
	public void setDevolucaoReal(String devolucaoReal) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.devolucaoReal = sdf.parse(devolucaoReal);
		} catch (ParseException e) {
			this.devolucaoReal = new Date();
		}
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
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
		Locacao other = (Locacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public void alugar(List<Filme> filmes){
		alugueis = new ArrayList<>();
		for(Filme filme : filmes){			
			AlugarFilme af = new AlugarFilme(filme, this);			
			alugueis.add(af);
		}
	}
	public void devolver(){
		
	}
	
	
	
}
