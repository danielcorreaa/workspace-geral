package br.com.locadora.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Locacao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoLocacao;
	@ManyToOne
	@JoinColumn(name="cliente_id")	
    private Cliente cliente;
	@ManyToOne
	@JoinColumn(name="video_id")	
    private Video video;
	@ManyToOne
	@JoinColumn(name="funcionario_id")	
    private Funcionario funcionario;
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataLocacao;
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataDevolucao;

    /**
     * Construtor
     * 
     * @param
     */
    public Locacao() {
        super();
    }

    /**
     * @return o valor do codigoLocacao
     */
    public Integer getCodigoLocacao() {
        return codigoLocacao;
    }

    /**
     * @param codigoLocacao seta o novo valor para o campo codigoLocacao
     */
    public void setCodigoLocacao(Integer codigoLocacao) {
        this.codigoLocacao = codigoLocacao;
    }

    /**
     * @return o valor do cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente seta o novo valor para o campo cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return o valor do video
     */
    public Video getVideo() {
        return video;
    }

    /**
     * @param video seta o novo valor para o campo video
     */
    public void setVideo(Video video) {
        this.video = video;
    }

    /**
     * @return o valor do funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario seta o novo valor para o campo funcionario
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return o valor do dataLocacao
     */
    public Date getDataLocacao() {
        return dataLocacao;
    }

    /**
     * @param dataLocacao seta o novo valor para o campo dataLocacao
     */
    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    /**
     * @return o valor do dataDevolucao
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao seta o novo valor para o campo dataDevolucao
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((codigoLocacao == null) ? 0 : codigoLocacao.hashCode());
        result = prime * result + ((dataDevolucao == null) ? 0 : dataDevolucao.hashCode());
        result = prime * result + ((dataLocacao == null) ? 0 : dataLocacao.hashCode());
        result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
        result = prime * result + ((video == null) ? 0 : video.hashCode());
        return result;
    }

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Locacao other = (Locacao) obj;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (codigoLocacao == null) {
            if (other.codigoLocacao != null)
                return false;
        } else if (!codigoLocacao.equals(other.codigoLocacao))
            return false;
        if (dataDevolucao == null) {
            if (other.dataDevolucao != null)
                return false;
        } else if (!dataDevolucao.equals(other.dataDevolucao))
            return false;
        if (dataLocacao == null) {
            if (other.dataLocacao != null)
                return false;
        } else if (!dataLocacao.equals(other.dataLocacao))
            return false;
        if (funcionario == null) {
            if (other.funcionario != null)
                return false;
        } else if (!funcionario.equals(other.funcionario))
            return false;
        if (video == null) {
            if (other.video != null)
                return false;
        } else if (!video.equals(other.video))
            return false;
        return true;
    }

}
