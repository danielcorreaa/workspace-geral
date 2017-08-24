package controle;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;




@ManagedBean
@ViewScoped
public class TesteControle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String replicarNome;

	public TesteControle() {
		
	}

	public String getNome() {
		System.out.println(nome);
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getReplicarNome() {
		return replicarNome;
	}

	public void setReplicarNome(String replicarNome) {
		this.replicarNome = replicarNome;
	}
	 
	
	public void copiar(){
		System.out.println(nome);
		replicarNome = nome;
	}
	

}
