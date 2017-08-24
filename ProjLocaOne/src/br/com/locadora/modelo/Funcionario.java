package br.com.locadora.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue(value = "F")
public class Funcionario extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(length = 20)
    private String login;
	@Column(length = 20)
    private String senha;
    
    @OneToMany(mappedBy="funcionario")
    private List<Locacao> locacoes = new ArrayList<Locacao>();

    /**
     * Construtor
     * 
     * @param
     */
    public Funcionario() {
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
        Funcionario other = (Funcionario) obj;
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
