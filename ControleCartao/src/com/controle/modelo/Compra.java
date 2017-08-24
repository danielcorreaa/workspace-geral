package com.controle.modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

@Entity
@Table(name = "compra")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "id_estabelecimento")
	private Estabelecimento estabelecimento;
	@Temporal(TemporalType.DATE)
	private Date dataCompra;
	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
	private List<Parcelado> parcelas;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_avista")
	private Avista avista;
	@ManyToOne
	@JoinColumn(name = "id_cartao")
	private Cartao cartao;
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	
	public Compra() {
		super();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public List<Parcelado> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcelado> parcelas) {
		this.parcelas = parcelas;
	}

	public Avista getAvista() {
		return avista;
	}

	public void setAvista(Avista avista) {
		this.avista = avista;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Parcelado> parcelarCompra(int numParcela, double valor, Calendar dataParcela) {
		parcelas = new ArrayList<>();
		valor = valor / numParcela;

		for (int i = 0; i < numParcela; i++) {
			dataParcela.add(Calendar.MONTH, 1);
			Calendar cal = (Calendar) dataParcela.clone();
			parcelas.add(new Parcelado(numParcela, valor, cal, this));
			System.out.println(parcelas.get(i).getDataParcela().getTime());
		}

		return parcelas;
	}

	public Avista pagamentoAvista(int numParcela, double valor, Calendar data) {
		avista = new Avista(valor, data);
		return avista;
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
		Compra other = (Compra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setDataCompra(String parameter) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataCompra = sdf.parse(parameter);
		} catch (ParseException e) {
			dataCompra = new Date();
		}

	}

	// public Date retornarData(String parDate) {
	// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// try {
	// return sdf.parse(parDate);
	// } catch (ParseException e) {
	// return new Date();
	// }
	// }

	public Calendar retornarData() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		if (c.get(Calendar.DAY_OF_MONTH) < 31) {
			c.set(Calendar.DAY_OF_MONTH, 8);
			c.add(Calendar.MONTH, 1);
		}
		return c;
	}

	public double retornarValor(String parVal) {
		return Double.parseDouble(parVal);
	}

	public int retornarParcala(String par) {
		return Integer.parseInt(par);
	}

	public String getTipoPagamento() {
		if (this.avista != null) {
			return "A Vista";
		}		
		return "Parcelado";
	}

	public int getQtdeRestanteParcelas() {
		for (Parcelado parcela : parcelas) {
			if(parcela.getDataParcela().before(new Date())){
				parcelas.remove(parcela);
			}
		}
		return parcelas.size();
	}

}
