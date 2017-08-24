package br.com.locadora.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class Video implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoVideo;
	@Column(length = 40)
    private String titulo;
	@Enumerated(EnumType.STRING)
    private Genero genero;
	@Column(length = 500)
    private String informacoes;
	@Type(type="yes_no")
    private Boolean disponivel;
	@OneToMany(mappedBy = "video")
	private List<Locacao> locacoes = new ArrayList<Locacao>();
	
    private int quantidadeEstoque;

    /**
     * Construtor
     * 
     * @param
     */
    public Video() {
        super();
    }

    /**
     * @return o valor do codigoVideo
     */
    public Integer getCodigoVideo() {
        return codigoVideo;
    }

    /**
     * @param codigoVideo seta o novo valor para o campo codigoVideo
     */
    public void setCodigoVideo(Integer codigoVideo) {
        this.codigoVideo = codigoVideo;
    }

    /**
     * @return o valor do titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo seta o novo valor para o campo titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return o valor do genero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * @param genero seta o novo valor para o campo genero
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * @return o valor do informacoes
     */
    public String getInformacoes() {
        return informacoes;
    }

    /**
     * @param informacoes seta o novo valor para o campo informacoes
     */
    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    /**
     * @return o valor do disponivel
     */
    public Boolean getDisponivel() {
        return disponivel;
    }

    /**
     * @param disponivel seta o novo valor para o campo disponivel
     */
    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * @return o valor do quantidadeEstoque
     */
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * @param quantidadeEstoque seta o novo valor para o campo quantidadeEstoque
     */
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
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
        result = prime * result + ((codigoVideo == null) ? 0 : codigoVideo.hashCode());
        result = prime * result + ((disponivel == null) ? 0 : disponivel.hashCode());
        result = prime * result + ((genero == null) ? 0 : genero.hashCode());
        result = prime * result + ((informacoes == null) ? 0 : informacoes.hashCode());
        result = prime * result + quantidadeEstoque;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
        Video other = (Video) obj;
        if (codigoVideo == null) {
            if (other.codigoVideo != null)
                return false;
        } else if (!codigoVideo.equals(other.codigoVideo))
            return false;
        if (disponivel == null) {
            if (other.disponivel != null)
                return false;
        } else if (!disponivel.equals(other.disponivel))
            return false;
        if (genero != other.genero)
            return false;
        if (informacoes == null) {
            if (other.informacoes != null)
                return false;
        } else if (!informacoes.equals(other.informacoes))
            return false;
        if (quantidadeEstoque != other.quantidadeEstoque)
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }

}
