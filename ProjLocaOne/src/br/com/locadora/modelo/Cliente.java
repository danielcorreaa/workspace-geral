package br.com.locadora.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue(value = "C")
public class Cliente extends Pessoa{
  
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    private Double debito;
    @OneToMany(mappedBy="cliente")
    private List<Locacao> locacoes = new ArrayList<Locacao>();

    /**
     * Construtor
     * 
     * @param
     */
    public Cliente() {
        super();
    }

    /**
     * @return o valor do dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento seta o novo valor para o campo dataNascimento
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return o valor do debito
     */
    public Double getDebito() {
        return debito;
    }

    /**
     * @param debito seta o novo valor para o campo debito
     */
    public void setDebito(Double debito) {
        this.debito = debito;
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
        result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
        result = prime * result + ((debito == null) ? 0 : debito.hashCode());
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
        Cliente other = (Cliente) obj;
        if (dataNascimento == null) {
            if (other.dataNascimento != null)
                return false;
        } else if (!dataNascimento.equals(other.dataNascimento))
            return false;
        if (debito == null) {
            if (other.debito != null)
                return false;
        } else if (!debito.equals(other.debito))
            return false;
        return true;
    }

}
