package br.com.locadora.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING) @DiscriminatorValue("P")
public abstract class Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id	
    private Integer id;
	@Column(length = 50)
    private String nome;
	@Column(length = 20)
    private String cpf;
	@Column(length = 50)
    private String endereco;
	@Column(length = 15)
    private String telefone;
	@Column(length = 30)
    private String email;

    /**
     * Construtor
     * 
     * @param
     */
    public Pessoa() {
        super();
    }

    /**
     * @return o valor do id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id seta o novo valor para o campo id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return o valor do nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome seta o novo valor para o campo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return o valor do cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf seta o novo valor para o campo cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return o valor do endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco seta o novo valor para o campo endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return o valor do telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone seta o novo valor para o campo telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return o valor do email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email seta o novo valor para o campo email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
        return result;
    }

    /** (non-Javadoc)
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
        Pessoa other = (Pessoa) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (endereco == null) {
            if (other.endereco != null)
                return false;
        } else if (!endereco.equals(other.endereco))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (telefone == null) {
            if (other.telefone != null)
                return false;
        } else if (!telefone.equals(other.telefone))
            return false;
        return true;
    }
    
    

}
