package br.com.locadora.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "A")
public class Administracao extends Pessoa{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(length = 20)
    private String login;
	@Column(length = 20)
    private String senha;

    /**
     * Construtor
     * 
     * @param
     */
    public Administracao() {
        super();
    }

    /**
     * @return o valor do login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login seta o novo valor para o campo login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return o valor do senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha seta o novo valor para o campo senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
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
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
        Administracao other = (Administracao) obj;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        return true;
    }

}
